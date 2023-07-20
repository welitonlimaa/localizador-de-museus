package com.betrybe.museumfinder.solution;

import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.exception.MuseumNotFoundException;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class MuseumServiceTest {

  @Mock
  private MuseumFakeDatabase museumFakeDatabase;

  @InjectMocks
  private MuseumService museumService;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testGetMuseum_Success() {
    Long museumId = 1L;
    Coordinate coordinate = new Coordinate(40.7128, -74.0060);
    Museum expectedMuseum = new Museum();
    expectedMuseum.setId(museumId);
    expectedMuseum.setName("Museum of Modern History");
    expectedMuseum.setDescription("History museum");
    expectedMuseum.setAddress("London, UK");
    expectedMuseum.setCollectionType("history");
    expectedMuseum.setCoordinate(coordinate);
    when(museumFakeDatabase.getMuseum(museumId)).thenReturn(Optional.of(expectedMuseum));

    Museum actualMuseum = museumService.getMuseum(museumId);

    assertEquals(expectedMuseum, actualMuseum);
  }

  @Test
  public void testGetMuseum_NotFound() {
    Long museumId = 1L;
    when(museumFakeDatabase.getMuseum(museumId)).thenReturn(Optional.empty());

    assertThrows(MuseumNotFoundException.class, () -> museumService.getMuseum(museumId));
  }
}
