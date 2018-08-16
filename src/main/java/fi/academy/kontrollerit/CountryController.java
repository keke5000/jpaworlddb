package fi.academy.kontrollerit;

import fi.academy.jpa.entities.Country;
import fi.academy.jpa.repositories.CountryRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/countries")
public class CountryController {
    private CountryRepositorio repo;

    public CountryController(@Autowired CountryRepositorio repo) {
        this.repo = repo;
    }

    @GetMapping()
    public Iterable<Country> listaaMaat(@RequestParam(name = "nimi", required = false)
                                        String nimi) {
        if (nimi != null)
            return repo.findAllByNameContainsOrLocalNameContains(nimi, nimi);
        return repo.findAll();
    }

    @GetMapping("paginated")
    public Page<Country> sivutetut(Pageable pageable) {
        Page<Country> maat = repo.findAll(pageable);
        return maat;
    }


    @GetMapping("/sivutettu")
    public Iterable<Country> listaaMaat(Pageable sivutus) {
        return repo.findAll(sivutus).getContent();
    }

}
