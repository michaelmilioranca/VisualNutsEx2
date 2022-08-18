package com.visualnuts.exercise2.usecase;

import com.visualnuts.exercise2.entity.Country;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class CountryUseCase implements ICountryUseCase {

    private final static String DE_LANGUAGE = "de";

    @Override
    public long countCountries(final List<Country> countries) {
        return countries.size();
    }

    @Override
    public Country findMostSpokenGermanCountry(final List<Country> countries) {
        return countries.stream()
                .filter( country -> country.speaksLanguage(DE_LANGUAGE))
                .max(Comparator.comparing(Country::getTotalOfLanguages))
                .orElseGet(() -> Country.builder().build());
    }

    @Override
    public Country findMostLanguagesSpokenCountry(final List<Country> countries) {
        return countries.stream()
                .max(Comparator.comparing(Country::getTotalOfLanguages))
                .orElseGet(() -> Country.builder().build());
    }

    @Override
    public long totalOfLanguagesSpoken(final List<Country> countries) {
        return countries.stream()
                .map(country -> country.getLanguages().size())
                .reduce(0, Integer::sum);
    }
    // I dont know if I should be counting duplicates ones, so if I shouldnt this one will work :)
    @Override
    public long totalOfLanguagesSpokenWithoutDuplicates(final List<Country> countries) {
        return countries.stream()
                .map(Country::getLanguages)
                .flatMap(Collection::stream)
                .distinct()
                .count();
    }

    @Override
    public String findMostSpeakedLanguage(final List<Country> countries){
        List<Map.Entry<String, Long>> collect = countries.stream()
                .map(Country::getLanguages)
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .collect(Collectors.toList());
        Collections.reverse(collect);
        Optional<Map.Entry<String, Long>> mostSpeakedLanguage = collect.stream().findFirst();
        return mostSpeakedLanguage.isPresent() ? mostSpeakedLanguage.get().getKey() : "";
    }
}
