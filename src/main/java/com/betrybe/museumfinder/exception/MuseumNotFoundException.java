package com.betrybe.museumfinder.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exceção personalizada para representar um erro quando um museu não é encontrado.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class MuseumNotFoundException extends RuntimeException {

  /**
   * Construtor da exceção MuseumNotFoundException.
   *
   * @param message A mensagem de erro associada à exceção.
   */
  public MuseumNotFoundException(String message) {
    super(message);
  }
}
