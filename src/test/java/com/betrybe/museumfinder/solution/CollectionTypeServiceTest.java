package com.betrybe.museumfinder.solution;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.dto.CollectionTypeCount;
import com.betrybe.museumfinder.service.CollectionTypeService;
import org.junit.jupiter.api.Test;

class CollectionTypeServiceTest {

  @Test
  void testCountByCollectionTypes() {
    MuseumFakeDatabase databaseMock = mock(MuseumFakeDatabase.class);
    CollectionTypeService service = new CollectionTypeService(databaseMock);

    String typesList = "history,image";
    when(databaseMock.countByCollectionType("history")).thenReturn(42L);

    CollectionTypeCount result = service.countByCollectionTypes(typesList);

    assertEquals(2, result.collectionTypes().length);
    assertEquals(42L, result.count());
  }
}
