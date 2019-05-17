package com.flairstech.world.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CountryDTO {

    private String countryCode;

    private String name;

    private String continent;

    private long population;

    @JsonProperty("life_expectancy")
    private long lifeExpectancy;

    @JsonProperty("country_language")
    private String language;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public long getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(long lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
