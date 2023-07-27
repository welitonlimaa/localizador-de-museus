package com.betrybe.museumfinder.service;

import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.exception.InvalidCoordinateException;
import com.betrybe.museumfinder.exception.MuseumNotFoundException;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.util.CoordinateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Esta classe é responsável por fornecer os services relacionados a museus.
 * Implementa a interface MuseumServiceInterface.
 */
@Service
public class MuseumService implements MuseumServiceInterface {

  private final MuseumFakeDatabase museumFakeDatabase;

  /**
   * Construtor da classe MuseumService.
   *
   * @param museumFakeDatabase O banco de dados fake.
   */
  @Autowired
  public MuseumService(MuseumFakeDatabase museumFakeDatabase) {
    this.museumFakeDatabase = museumFakeDatabase;
  }

  /**
   * Busca o museu mais próximo da coordenada fornecida.
   *
   * @param coordinate  As coordenadas da localização.
   * @param maxDistance A distância máxima permitida para a busca do museu.
   * @return O museu mais próximo da coordenada.
   * @throws InvalidCoordinateException Se as coordenadas fornecidas forem inválidas.
   * @throws MuseumNotFoundException   Se não for encontrado um museu dentro da distância máxima.
   */
  @Override
  public Museum getClosestMuseum(Coordinate coordinate, Double maxDistance) {
    if (!CoordinateUtil.isCoordinateValid(coordinate)) {
      throw new InvalidCoordinateException();
    }

    Museum closestMuseum = museumFakeDatabase.getClosestMuseum(coordinate, maxDistance)
        .orElseThrow(() -> new MuseumNotFoundException());

    return closestMuseum;
  }

  /**
   * Cria um novo museu.
   *
   * @param museum O objeto Museum contendo os detalhes do museu a ser criado.
   * @return O museu criado.
   * @throws InvalidCoordinateException Se as coordenadas fornecidas forem inválidas.
   */
  @Override
  public Museum createMuseum(Museum museum) {
    if (!CoordinateUtil.isCoordinateValid(museum.getCoordinate())) {
      throw new InvalidCoordinateException();
    }

    return museumFakeDatabase.saveMuseum(museum);
  }

  /**
   * Busca um museu pelo seu ID.
   *
   * @param id O ID do museu a ser encontrado.
   * @return O museu com o ID fornecido
   * @throws MuseumNotFoundException Se não for encontrado um museu com o ID fornecido.
   */
  @Override
  public Museum getMuseum(Long id) {
    Museum museum = museumFakeDatabase.getMuseum(id)
        .orElseThrow(() -> new MuseumNotFoundException());

    return museum;
  }
}
