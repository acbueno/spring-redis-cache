package br.com.acbueno.redis.dto;

import org.modelmapper.ModelMapper;
import com.fasterxml.jackson.annotation.JsonProperty;
import br.com.acbueno.redis.entity.Car;
import lombok.Data;

@Data
public class CarResponseDTO {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("model-name")
  private String modelName;

  @JsonProperty("brand-name")
  private String brandName;

  @JsonProperty("color")
  private String color;

  @JsonProperty("factory-year")
  private int factoryYear;

  @JsonProperty("model-year")
  private int modelYear;

  public static CarResponseDTO convert(Car entity) {
    ModelMapper mapper = new ModelMapper();
    return mapper.map(entity, CarResponseDTO.class);
  }

}
