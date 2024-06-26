package com.munte.section3.business;

import com.munte.section3.models.Item;
import com.munte.section3.repositories.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ItemBusinessServiceTest {

    @InjectMocks
    ItemBusinessService businessService;

    @Mock
    ItemRepository itemRepository;

    @Test
    public void idk() {
        when(itemRepository.findAll()).thenReturn(List.of(
                new Item(1, "Test", 10, 10)
        ));

        assertEquals(100 , businessService.retrieveAllItems().get(0).getValue());
    }

}