package com.betrybe.museumfinder.controller;

import com.betrybe.museumfinder.exception.InvalidCoordinateException;
import com.betrybe.museumfinder.exception.MuseumNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Controlador exceções para lidar com exceções que podem
 * ocorrer durante as execução da aplicação.
 */
@RestControllerAdvice
public class ExceptionController {

  /**
   * Trata a exceção InvalidCoordinateException, quando as coordenadas fornecidas são inválidas.
   *
   * @param exception A exceção InvalidCoordinateException lançada na aplicação.
   * @return Uma resposta com a mensagem de erro e o status HTTP 400 (Bad Request).
   */
  @ExceptionHandler(InvalidCoordinateException.class)
  public ResponseEntity<String> handleInvalidCoordinateException(RuntimeException exception) {
    return ResponseEntity.badRequest().body(exception.getMessage());
  }

  /**
   * Trata a exceção MuseumNotFoundException,quando um museu não é encontrado.
   *
   * @param exception A exceção MuseumNotFoundException lançada na aplicação.
   * @return Uma resposta com o status HTTP 404 (Not Found) sem corpo de resposta.
   */
  @ExceptionHandler(MuseumNotFoundException.class)
  public ResponseEntity<Object> handleMuseumNotFoundException(RuntimeException exception) {
    return ResponseEntity.notFound().build();
  }

  /**
   * Trata exceções genéricas Internal Server Error.
   *
   * @param exception A exceção Exception genérica lançada na aplicação.
   * @return Uma resposta com a mensagem de erro e o status HTTP 500.
   */
  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> handleException(Exception exception) {
    return ResponseEntity
        .status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(exception.getMessage());
  }
}
