package com.museumfinder.dto;

import com.museumfinder.model.Coordinate;

/**
 * Esta classe representa um DTO para criar um novo museu.
 */
public record MuseumCreationDto(
    String name,
    String description,
    String address,
    String collectionType,
    String subject,
    String url,
    Coordinate coordinate
) {

}
