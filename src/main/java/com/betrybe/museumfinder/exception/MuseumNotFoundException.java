package com.betrybe.museumfinder.exception;

/**
 * Exceção personalizada para representar um erro quando um museu não é encontrado.
 */
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
