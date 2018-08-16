package fi.academy.jpa.repositories;

import fi.academy.jpa.entities.Country;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CountryRepositorio extends PagingAndSortingRepository<Country, String> {
    List<Country> findAllByNameContainsOrLocalNameContains(String name, String localName);
    //<editor-fold desc="Sama yhdellä parametrilla (piilossa)">
    @Query("select c from Country c where c.name like concat(concat('%', :nimi), '%') or c.localName like concat(concat('%', :nimi), '%')")
    List<Country> etsiKaikkiNimellaTaiLocalNimella(@Param("nimi") String nimiparametri);
    //</editor-fold>
    List<Country> findAllByOrderByPopulationDesc();
}
