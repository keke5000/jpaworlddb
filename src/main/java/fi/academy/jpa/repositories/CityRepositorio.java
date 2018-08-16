package fi.academy.jpa.repositories;

import fi.academy.jpa.entities.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CityRepositorio extends PagingAndSortingRepository<City, Integer> {
}
