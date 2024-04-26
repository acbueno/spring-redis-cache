package br.com.acbueno.redis.entity;

import org.modelmapper.ModelMapper;
import br.com.acbueno.redis.dto.CarRequestDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "car")
@Data
public class Car {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "model_name")
  private String modelName;

  @Column(name = "brand_name")
  private String brandName;

  @Column(name = "color")
  private String color;

  @Column(name = "factory_year")
  private int factoryYear;

  @Column(name = "model_year")
  private int modelYear;


  public static Car convert(CarRequestDTO dto) {
    ModelMapper mapper = new ModelMapper();
    return mapper.map(dto, Car.class);
  }

}
