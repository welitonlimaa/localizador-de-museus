package com.betrybe.museumfinder.exception;

/**
 * Exceção personalizada para representar um erro quando as coordenadas fornecidas são inválidas.
 */
public class InvalidCoordinateException extends RuntimeException {

  /**
   * Construtor da exceção InvalidCoordinateException.
   *
   * @param message A mensagem de erro associada à exceção.
   */
  public InvalidCoordinateException(String message) {
    super(message);
  }
}
