package fi.academy.kontrollerit;

import fi.academy.jpa.entities.City;
import fi.academy.jpa.entities.Country;
import fi.academy.jpa.repositories.CityRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/cities")
public class CityController {
    private CityRepositorio repo;

    @Autowired
    public CityController(CityRepositorio repo) {
        this.repo = repo;
    }

    @GetMapping("")
    public Page<City> sivutetutKaupungit(Pageable pageable) {
        final PageRequest page1 = new PageRequest(
                pageable.getPageNumber(), pageable.getPageSize(), Sort.Direction.ASC, "name"
        );
        return repo.findAll(page1);

    }
    @GetMapping("/{id}")
    public ResponseEntity<?> haeKaupunki(@PathVariable(name = "id") int id) {
        Optional<City> optcity = repo.findById(id);
        if(optcity.isPresent()) {
            return ResponseEntity.ok(optcity.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{code}")
    public ResponseEntity<?> haeYksiMaa(@PathVariable(name = "code") String code) {
        Optional<Country> optionalCountry = repo.findById(code);
        if(optionalCountry.isPresent()) {
            return ResponseEntity.ok(optionalCountry.get());
        }
        return ResponseEntity.notFound().build();
    }
}
