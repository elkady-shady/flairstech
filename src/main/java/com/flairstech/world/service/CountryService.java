package com.flairstech.world.service;

import com.flairstech.world.entity.Country;
import com.flairstech.world.exception.DatabaseServerDown;
import com.flairstech.world.exception.InvalidCountryCodeException;
import com.flairstech.world.repository.CountryRepository;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.CannotCreateTransactionException;

import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.NoSuchElementException;

@Service
public class CountryService {

    private CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Country getCountry(String countryCode) throws InvalidCountryCodeException, DatabaseServerDown {
        Country country;
        try{
            country =  countryRepository.findById(countryCode).get();
        } catch (NoSuchElementException ex) {
            throw new InvalidCountryCodeException("INVALID_COUNTRY_CODE");
        } catch (CannotCreateTransactionException ex) {
            throw new DatabaseServerDown("INTERNAL_ERROR");
        }

        return country;
    }
}
