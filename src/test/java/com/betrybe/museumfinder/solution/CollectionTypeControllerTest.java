package com.betrybe.museumfinder.solution;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.betrybe.museumfinder.controller.CollectionTypeController;
import com.betrybe.museumfinder.dto.CollectionTypeCount;
import com.betrybe.museumfinder.service.CollectionTypeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(CollectionTypeController.class)
class CollectionTypeControllerTest {

  @MockBean
  private CollectionTypeService serviceMock;

  @Autowired
  private MockMvc mockMvc;

  @Test
  void testGetCollectionTypesCount() throws Exception {
    String typesList = "history,image";
    CollectionTypeCount result = new CollectionTypeCount(new String[]{"history", "image"}, 42L);
    when(serviceMock.countByCollectionTypes(typesList)).thenReturn(result);

    mockMvc.perform(get("/collections/count/history,image"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.collectionTypes.length()", is(2)));
  }
}
