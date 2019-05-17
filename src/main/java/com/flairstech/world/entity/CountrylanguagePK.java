package com.flairstech.world.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class CountrylanguagePK implements Serializable {
    private String countrycode;
    private String language;

    @Column(name = "country_code")
    @Id
    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    @Column(name = "language")
    @Id
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountrylanguagePK that = (CountrylanguagePK) o;
        return Objects.equals(countrycode, that.countrycode) &&
                Objects.equals(language, that.language);
    }

    @Override
    public int hashCode() {

        return Objects.hash(countrycode, language);
    }
}
