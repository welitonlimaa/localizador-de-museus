package com.museumfinder.dto;

import com.museumfinder.model.Coordinate;

/**
 * Esta classe representa um DTO para um museu.
 */
public record MuseumDto(
    Long id,
    String name,
    String description,
    String address,
    String collectionType,
    String subject,
    String url,
    Coordinate coordinate
) {

}
