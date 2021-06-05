package com.patricia.RestAPI.contries.repository;


import com.patricia.RestAPI.contries.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {

}
