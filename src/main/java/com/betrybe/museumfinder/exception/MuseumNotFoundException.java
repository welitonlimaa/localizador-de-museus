package com.betrybe.museumfinder.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exceção erro quando um museu não é encontrado.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class MuseumNotFoundException extends RuntimeException {

  /**
   * Construtor da exceção MuseumNotFoundException.
   */
  public MuseumNotFoundException() {
    super("Museu não encontrado!");
  }
}
