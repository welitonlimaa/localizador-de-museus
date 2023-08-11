package com.museumfinder.service;

import com.museumfinder.model.Coordinate;
import com.museumfinder.model.Museum;

/**
 * Interface for Museum service class.
 */
public interface MuseumServiceInterface {

  Museum getClosestMuseum(Coordinate coordinate, Double maxDistance);

  Museum createMuseum(Museum museum);

  Museum getMuseum(Long id);
}
