package com.flairstech.world.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Country {

    private String code;

    private String name;

    private String continent;

    private String region;

    private float surfacearea;

    private Short indepyear;

    private int population;

    private Float lifeexpectancy;

    private BigDecimal gnp;

    private String localname;

    private String governmentform;

    private String headofstate;

    private String code2;

    private List<Countrylanguage> countrylanguageList = new ArrayList<Countrylanguage>();

    @Id
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Basic
    @Column(name = "surface_area")
    public float getSurfacearea() {
        return surfacearea;
    }

    public void setSurfacearea(float surfacearea) {
        this.surfacearea = surfacearea;
    }

    @Basic
    @Column(name = "indep_year")
    public Short getIndepyear() {
        return indepyear;
    }

    public void setIndepyear(Short indepyear) {
        this.indepyear = indepyear;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Basic
    @Column(name = "life_expectancy")
    public Float getLifeexpectancy() {
        return lifeexpectancy;
    }

    public void setLifeexpectancy(Float lifeexpectancy) {
        this.lifeexpectancy = lifeexpectancy;
    }

    public BigDecimal getGnp() {
        return gnp;
    }

    public void setGnp(BigDecimal gnp) {
        this.gnp = gnp;
    }

    @Basic
    @Column(name = "local_name")
    public String getLocalname() {
        return localname;
    }

    public void setLocalname(String localname) {
        this.localname = localname;
    }

    @Basic
    @Column(name = "government_form")
    public String getGovernmentform() {
        return governmentform;
    }

    public void setGovernmentform(String governmentform) {
        this.governmentform = governmentform;
    }

    @Basic
    @Column(name = "head_of_state")
    public String getHeadofstate() {
        return headofstate;
    }

    public void setHeadofstate(String headofstate) {
        this.headofstate = headofstate;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }

    @OneToMany
    @JoinColumn(name = "country_code")
    public List<Countrylanguage> getCountrylanguageList() {
        return countrylanguageList;
    }

    public void setCountrylanguageList(List<Countrylanguage> countrylanguageList) {
        this.countrylanguageList = countrylanguageList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Float.compare(country.surfacearea, surfacearea) == 0 &&
                population == country.population &&
                Objects.equals(code, country.code) &&
                Objects.equals(name, country.name) &&
                Objects.equals(continent, country.continent) &&
                Objects.equals(region, country.region) &&
                Objects.equals(indepyear, country.indepyear) &&
                Objects.equals(lifeexpectancy, country.lifeexpectancy) &&
                Objects.equals(gnp, country.gnp) &&
                Objects.equals(localname, country.localname) &&
                Objects.equals(governmentform, country.governmentform) &&
                Objects.equals(headofstate, country.headofstate) &&
                Objects.equals(code2, country.code2);
    }

    @Override
    public int hashCode() {

        return Objects.hash(code, name, continent, region, surfacearea, indepyear, population, lifeexpectancy, gnp, localname, governmentform, headofstate, code2);
    }
}
