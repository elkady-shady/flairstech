package com.flairstech.world.controller;

import com.flairstech.world.dto.CountryDTO;
import com.flairstech.world.entity.Country;
import com.flairstech.world.exception.DatabaseServerDown;
import com.flairstech.world.exception.InvalidCountryCodeException;
import com.flairstech.world.service.CountryService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/countries")
public class CountryController {

    private CountryService countryService;

    private ModelMapper modelMapper;

    @Autowired
    public CountryController(CountryService countryService,ModelMapper modelMapper) {
        this.countryService = countryService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/{countryCode}")
    public ResponseEntity<?> getCountry(@PathVariable String countryCode) throws InvalidCountryCodeException, DatabaseServerDown {
        Country country = countryService.getCountry(countryCode);
        CountryDTO countryDTO = mapToCountryDTO(country);


        return new ResponseEntity<>(countryDTO , null , HttpStatus.OK);

    }


    /**
     *
     * @param country
     * @return
     */
    private CountryDTO mapToCountryDTO(Country country) {
        CountryDTO countryDto =  modelMapper.map(country,CountryDTO.class);
        countryDto.setLanguage(country.getCountrylanguageList().get(0).getLanguage());

        return countryDto;
    }
}
