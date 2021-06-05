package com.patricia.RestAPI.contries;

import com.patricia.RestAPI.contries.repository.CountryRepository;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.awt.print.Pageable;
import java.util.Optional;

@Entity
@Table(name = "pais")
public class Country {

    @Id
    private Long id;

    @Column(name = "nome")
    private String name;

    @Column(name = "nome_pt")
    private String portugueseName;

    @Column(name = "sigla")
    private String code;

    private Integer bacen;

    public Country() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPortugueseName() {
        return portugueseName;
    }

    public String getCode() {
        return code;
    }

    public Integer getBacen() {
        return bacen;
    }

    @RestController
    @RequestMapping("/countries")

    public static class CountryResource {

        private CountryRepository repository;

        public CountryResource(CountryRepository repository) {
            this.repository = repository;
        }

        @GetMapping
        public Page<Country> contries(Pageable page){
            return repository.findAll(page);
        }


        @GetMapping("/(id)")
        public Country getOne(@PathVariable Long id){
            Optional<Country> optional = repository.findAllById(id);
            if (optional.isPresent()){
                return ResponseEntity.ok().body(optional.get());
            }else{
                return ResponseEntity.notFound().build();
            }


        }


    }
}
