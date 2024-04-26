package br.com.acbueno.redis.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.acbueno.redis.dto.CarRequestDTO;
import br.com.acbueno.redis.dto.CarResponseDTO;
import br.com.acbueno.redis.service.CarService;
import io.swagger.v3.oas.annotations.Operation;

@RestController("/car")
public class CarController {

  @Autowired
  private CarService service;


  @GetMapping("/{id}")
  @Operation(summary = "Obtém um carro pelo ID")
  public ResponseEntity<CarResponseDTO> getCar(@PathVariable Long id) {
    return ResponseEntity.ok(service.getCar(id));
  }

  @PostMapping("/clear-cache")
  @Operation(summary = "Limpa o cache")
  public ResponseEntity<Void> clearCache() {
    service.clearCache();
    return ResponseEntity.ok().build();
  }

  @PostMapping
  @Operation(summary = "Salva um novo carro")
  public ResponseEntity<Void> save(@RequestBody CarRequestDTO dto) {
    service.save(dto);
    return ResponseEntity.ok().build();
  }

  @GetMapping
  @Operation(summary = "Obtém todos os carros")
  public ResponseEntity<List<CarResponseDTO>> getAllCars() {
    return ResponseEntity.ok(service.getAllCars());
  }

  @DeleteMapping("/{id}")
  @Operation(summary = "Deleta um carro pelo ID")
  public ResponseEntity<Void> deleteCarById(@PathVariable("id") Long id) {
    service.deleteCarById(id);
    return ResponseEntity.ok().build();
  }

}
