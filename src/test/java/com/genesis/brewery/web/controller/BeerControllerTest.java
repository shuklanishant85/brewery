package com.genesis.brewery.web.controller;

import com.genesis.brewery.services.BeerService;
import com.genesis.brewery.web.model.BeerDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BeerController.class)
public class BeerControllerTest {

    @MockBean
    private BeerService beerService;

    @Autowired
    private MockMvc mockMvc;

    private BeerDTO validBear;

    @Before
    public void setUp() {
        validBear = BeerDTO.builder()
                .uuid(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle("Pale Ale")
                .build();
    }

    @Test
    public void getBeer() throws Exception {
        given(beerService.getBeerById(any(UUID.class))).willReturn(validBear);

        mockMvc.perform(get("/api/v1/beer/" + validBear
                        .getUuid()
                        .toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.uuid").value(validBear.getUuid().toString()));

    }

}
