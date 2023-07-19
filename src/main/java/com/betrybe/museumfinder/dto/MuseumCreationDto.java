package com.betrybe.museumfinder.dto;

import com.betrybe.museumfinder.model.Coordinate;

/**
 * Esta classe representa um DTO para criar um novo museu. É usado para
 * transportar dados entre camadas da aplicação ao criar um museu.
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
