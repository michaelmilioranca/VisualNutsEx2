package com.visualnuts.exercise2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@EqualsAndHashCode
public class Country {
    private final String country;
    private final List<String> languages;

    public boolean speaksLanguage(final String languageToSearch){
        return this.languages.stream().anyMatch(language -> language.equals(languageToSearch));
    }

    @JsonIgnore
    public long getTotalOfLanguages(){
        return languages.size();
    }
}
