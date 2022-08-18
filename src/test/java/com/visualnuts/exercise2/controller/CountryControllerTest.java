package com.visualnuts.exercise2.controller;


import com.visualnuts.exercise2.util.BaseControllerTest;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

class CountryControllerTest extends BaseControllerTest {

    @Test
    void shouldCountCountries() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .request(HttpMethod.POST, URI.create("/country/count"))
                        .content(fromFile("/stubs/country_entry.json"))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.jsonPath("$").value("5"));
    }

    @Test
    void shouldReturnBEWhenSearchingForTheMostGermanSpeakerCountry() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .request(HttpMethod.POST, URI.create("/country/mostGermanSpeaker"))
                        .content(fromFile("/stubs/country_entry.json"))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.jsonPath("$.country").value("BE"));
    }

    @Test
    void shouldReturnBEWhenSearchingForTheCountryThatSpeakMoreLanguages() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .request(HttpMethod.POST, URI.create("/country/mostLanguagesSpoke"))
                        .content(fromFile("/stubs/country_entry.json"))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.jsonPath("$.country").value("BE"));
    }

    @Test
    void shouldCountTotalOfLanguagesSpoken() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .request(HttpMethod.POST, URI.create("/country/totalOfLanguagesSpoken"))
                        .content(fromFile("/stubs/country_entry.json"))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.jsonPath("$").value("8"));
    }

    @Test
    void shouldReturnMostSpekeadLanguage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .request(HttpMethod.POST, URI.create("/country/mostSpeakedLanguage"))
                        .content(fromFile("/stubs/country_entry.json"))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.jsonPath("$").value("nl"));
    }

    @SneakyThrows
    private byte[] fromFile(String path) {
        return new ClassPathResource(path).getInputStream().readAllBytes();
    }

}