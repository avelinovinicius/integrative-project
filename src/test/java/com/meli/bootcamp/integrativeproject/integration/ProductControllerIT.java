package com.meli.bootcamp.integrativeproject.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import javax.transaction.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class ProductControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void findAllPagedShouldReturnSortedPageWhenSortByName() throws Exception
    {
        ResultActions result = mockMvc.perform(get("/fresh-products/list/page?page=0&size=6&sort=name,asc").accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isOk());
        result.andExpect(jsonPath("$.content").exists());
        result.andExpect(jsonPath("$.content[0].name").value("MANTEIGA"));
        result.andExpect(jsonPath("$.content[1].name").value("MANTEIGA"));
        result.andExpect(jsonPath("$.content[2].name").value("MANTEIGA"));
    }
}
