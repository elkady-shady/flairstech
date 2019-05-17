package com.flairstech.world.controller;

import com.flairstech.world.exception.DatabaseServerDown;
import com.flairstech.world.exception.InvalidCountryCodeException;
import com.flairstech.world.service.CountryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.NoSuchElementException;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CountryController.class)
public class CountryControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ModelMapper modelMapper;

    @MockBean
    private CountryService service;


    @Test()
    public void testGetCountryWithInvalidCode() throws Exception {
        when(service.getCountry(anyString()))
                .thenThrow(new InvalidCountryCodeException("INVALID_COUNTRY_CODE"));
        mvc.perform(get("/v1/countries/SSS")).andExpect(status().is5xxServerError()).
                                                        andExpect(status().reason(("INVALID_COUNTRY_CODE")));
    }

    @Test()
    public void testDatabseServerDown() throws Exception {
        when(service.getCountry(anyString()))
                .thenThrow(new DatabaseServerDown("INTERNAL_ERROR"));
        mvc.perform(get("/v1/countries/SSS")).andExpect(status().is5xxServerError()).
                andExpect(status().reason(("INTERNAL_ERROR")));
    }
}
