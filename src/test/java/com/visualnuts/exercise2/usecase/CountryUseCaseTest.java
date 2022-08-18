package com.visualnuts.exercise2.usecase;

import com.visualnuts.exercise2.entity.Country;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountryUseCaseTest {

    public CountryUseCase countryUseCase = new CountryUseCase();

    @Test
    void shouldCountCountries(){
        assertEquals(3, countryUseCase.countCountries(mockCountries()));
    }

    @Test
    void shouldReturnGermanLanguageCountry(){
        assertEquals(getGermanCountry(), countryUseCase.findMostSpokenGermanCountry(mockCountries()));
    }

    @Test
    void shouldReturnMostSpokenLanguageCountry(){
        assertEquals(getBrasilCountry(), countryUseCase.findMostLanguagesSpokenCountry(mockCountries()));
    }

    @Test
    void shouldCountLanguagesSpoken(){
        assertEquals(6L, countryUseCase.totalOfLanguagesSpoken(mockCountries()));
    }

    @Test
    void shouldCountLanguagesSpokenWithoutDuplicate(){
        assertEquals(4L, countryUseCase.totalOfLanguagesSpokenWithoutDuplicates(mockCountries()));
    }

    @Test
    void shouldReturnMostSpeakedLanguage(){
        assertEquals("en", countryUseCase.findMostSpeakedLanguage(mockCountries()));
    }

    private List<Country> mockCountries(){
        return List.of(getUSACountry(), getBrasilCountry(),getGermanCountry());
    }

    private Country getUSACountry() {
        return Country.builder()
                .country("US")
                .languages(List.of("en"))
                .build();
    }

    private Country getBrasilCountry() {
        return Country.builder()
                .country("BR")
                .languages(List.of("pt-br", "en", "es"))
                .build();
    }

    private Country getGermanCountry() {
        return Country.builder()
                .country("BR")
                .languages(List.of("de", "en"))
                .build();
    }


}