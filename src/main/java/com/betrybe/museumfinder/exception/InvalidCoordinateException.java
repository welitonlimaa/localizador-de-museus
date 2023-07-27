package com.betrybe.museumfinder.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exceção representa um erro quando as coordenadas fornecidas são inválidas.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidCoordinateException extends RuntimeException {

  /**
   * Construtor da exceção InvalidCoordinateException.
   */
  public InvalidCoordinateException() {
    super("Coordenada inválida!");
  }
}
