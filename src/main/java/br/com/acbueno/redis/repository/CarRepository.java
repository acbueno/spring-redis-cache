package br.com.acbueno.redis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.acbueno.redis.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

}
