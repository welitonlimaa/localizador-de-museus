package com.betrybe.museumfinder.solution;

import com.betrybe.museumfinder.controller.MuseumController;
import com.betrybe.museumfinder.exception.MuseumNotFoundException;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumServiceInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class MuseumControllerTest {

  @Mock
  private MuseumServiceInterface museumService;

  @InjectMocks
  private MuseumController museumController;

  private MockMvc mockMvc;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    mockMvc = MockMvcBuilders.standaloneSetup(museumController).build();
  }

  @Test
  public void testGetMuseum_Success() throws Exception {
    Long museumId = 1L;
    Coordinate coordinate = new Coordinate(40.7128, -74.0060);
    Museum expectedMuseum = new Museum();
    expectedMuseum.setId(museumId);
    expectedMuseum.setName("Museum of Modern History");
    expectedMuseum.setDescription("History museum");
    expectedMuseum.setAddress("London, UK");
    expectedMuseum.setCollectionType("history");
    expectedMuseum.setCoordinate(coordinate);
    when(museumService.getMuseum(museumId)).thenReturn(expectedMuseum);

    mockMvc.perform(get("/museums/{id}", museumId))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.id").value(expectedMuseum.getId()))
        .andExpect(jsonPath("$.name").value(expectedMuseum.getName()))
        .andExpect(jsonPath("$.description").value(expectedMuseum.getDescription()))
        .andExpect(jsonPath("$.address").value(expectedMuseum.getAddress()))
        .andExpect(jsonPath("$.collectionType").value(expectedMuseum.getCollectionType()))
        .andExpect(jsonPath("$.coordinate.latitude").value(expectedMuseum.getCoordinate().latitude()))
        .andExpect(jsonPath("$.coordinate.longitude").value(expectedMuseum.getCoordinate().longitude()));
  }

  @Test
  public void testGetMuseum_NotFound() throws Exception {
    Long museumId = 1L;
    when(museumService.getMuseum(museumId)).thenThrow(new MuseumNotFoundException());

    mockMvc.perform(get("/museums/{id}", museumId))
        .andExpect(status().isNotFound());
  }

}
