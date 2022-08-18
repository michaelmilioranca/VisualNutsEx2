package com.visualnuts.exercise2.controller;

import com.visualnuts.exercise2.entity.Country;
import com.visualnuts.exercise2.usecase.ICountryUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {

    private final ICountryUseCase countryUseCase;

    public CountryController(ICountryUseCase countryUseCase) {
        this.countryUseCase = countryUseCase;
    }

    // returns the number of countries in the world
    @PostMapping("/count")
    public ResponseEntity<Long> countCountry(@RequestBody List<Country> countries){
        return ResponseEntity.ok(countryUseCase.countCountries(countries));
    }
    // finds the country with the most official languages, where they officially speak German (de)
    @PostMapping("/mostGermanSpeaker")
    public ResponseEntity<Country> findMostSpokenGermanCountry(@RequestBody List<Country> countries){
        return ResponseEntity.ok(countryUseCase.findMostSpokenGermanCountry(countries));
    }
    // that counts all the official languages spoken in the listed countries. ( if it should be a property in the response
    // There is a @JsonIgnore in the Country object that can be removed
    @PostMapping("/mostLanguagesSpoke")
    public ResponseEntity<Country> findMostLanguagesSpokeCountry(@RequestBody List<Country> countries){
        return ResponseEntity.ok(countryUseCase.findMostLanguagesSpokenCountry(countries));
    }
    // to find the country with the highest number of official languages.
    @PostMapping("/totalOfLanguagesSpoken")
    public ResponseEntity<Long> totalOfLanguagesSpoken(@RequestBody List<Country> countries){
        return ResponseEntity.ok(countryUseCase.totalOfLanguagesSpoken(countries));
    }
    // to find the most common official language(s), of all countries.
    @PostMapping("/mostSpeakedLanguage")
    public ResponseEntity<String> findMostSpeakedLanguage(@RequestBody List<Country> countries){
        return ResponseEntity.ok(countryUseCase.findMostSpeakedLanguage(countries));
    }
}
