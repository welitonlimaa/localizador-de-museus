package com.betrybe.museumfinder.controller;

import static com.betrybe.museumfinder.util.ModelDtoConverter.dtoToModel;
import static com.betrybe.museumfinder.util.ModelDtoConverter.modelToDto;

import com.betrybe.museumfinder.dto.MuseumCreationDto;
import com.betrybe.museumfinder.dto.MuseumDto;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador responsável por manipular requisições relacionadas a museus. Mapeia endpoints e
 * gerencia a interação com o serviço MuseumService.
 */
@RestController
@RequestMapping("/museums")
public class MuseumController {

  private final MuseumServiceInterface museumService;

  /**
   * Construtor do MuseumController.
   *
   * @param museumService O serviço MuseumServiceInterface a ser utilizado pelo controlador.
   */
  @Autowired
  public MuseumController(MuseumServiceInterface museumService) {
    this.museumService = museumService;
  }

  /**
   * Cria um novo museu com base nos dados fornecidos no corpo da requisição.
   *
   * @param newMuseum O DTO MuseumCreationDto contendo os detalhes do museu a ser criado.
   * @return Uma resposta do museu criado e o status HTTP 201 (Created).
   */
  @PostMapping
  public ResponseEntity<MuseumDto> createMuseum(@RequestBody MuseumCreationDto newMuseum) {
    Museum createdMuseum = museumService.createMuseum(dtoToModel(newMuseum));

    return ResponseEntity.status(HttpStatus.CREATED).body(modelToDto(createdMuseum));
  }

  /**
   * Obtém o museu mais próximo com base nas coordenadas fornecidas e na distância máxima.
   *
   * @param latitude    A latitude da coordenada.
   * @param longitude   A longitude da coordenada.
   * @param maxDistance A distância máxima permitida para a busca do museu mais próximo.
   * @return Uma resposta museu mais próximo encontrado.
   */
  @GetMapping("/closest")
  public ResponseEntity<MuseumDto> getClosestMuseum(
      @RequestParam(name = "lat") Double latitude,
      @RequestParam(name = "lng") Double longitude,
      @RequestParam(name = "max_dist_km") Double maxDistance) {
    Coordinate coordinate = new Coordinate(latitude, longitude);
    Museum closestMuseum = museumService.getClosestMuseum(coordinate, maxDistance);

    return ResponseEntity.ok(modelToDto(closestMuseum));
  }
}