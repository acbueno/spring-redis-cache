package br.com.acbueno.redis.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import br.com.acbueno.redis.dto.CarRequestDTO;
import br.com.acbueno.redis.dto.CarResponseDTO;
import br.com.acbueno.redis.entity.Car;
import br.com.acbueno.redis.repository.CarRepository;

@Service
public class CarService {

  @Autowired
  private CarRepository repository;

  @Autowired
  private RedisTemplate<String, Car> redisTemplate;

  @CachePut(value = "cars", key = "#result.id")
  public Car saveAndPutCache(CarRequestDTO request) {
    try {
      return repository.save(Car.convert(request));
    } catch (Exception e) {
      throw new RuntimeException();
    }
  }

  public void save(CarRequestDTO requestDTO) {
    saveAndPutCache(requestDTO);
  }

  @Cacheable(value = "cars")
  protected List<Car> getAllCarsEntity() {
    return repository.findAll();
  }

  public List<CarResponseDTO> getAllCars() {
    List<CarResponseDTO> list = new ArrayList<>();
    getAllCarsEntity().forEach(it -> {
      list.add(CarResponseDTO.convert(it));
    });
    return list;
  }

  @Cacheable(value = "cars", key = "#id")
  public CarResponseDTO getCar(Long id) {
    Car entity = repository.findById(id).orElse(null);
    return CarResponseDTO.convert(entity);
  }

  @CacheEvict(value = "cars", allEntries = true)
  public void clearCache() {

  }

  @CacheEvict(value = "car", key = "#id")
  public void deleteCarById(Long id) {
    repository.deleteById(id);
  }

}
