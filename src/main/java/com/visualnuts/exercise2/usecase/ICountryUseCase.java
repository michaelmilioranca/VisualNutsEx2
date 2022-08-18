package com.visualnuts.exercise2.usecase;

import com.visualnuts.exercise2.entity.Country;

import java.util.List;

public interface ICountryUseCase {

    public long countCountries(List<Country> countries);

    public Country findMostSpokenGermanCountry(List<Country> countries);

    public Country findMostLanguagesSpokenCountry(List<Country> countries);

    public long totalOfLanguagesSpoken(List<Country> countries);

    public long totalOfLanguagesSpokenWithoutDuplicates(final List<Country> countries);

    public String findMostSpeakedLanguage(final List<Country> countries);
}
