package br.com.acbueno.redis.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CarRequestDTO {

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


}
