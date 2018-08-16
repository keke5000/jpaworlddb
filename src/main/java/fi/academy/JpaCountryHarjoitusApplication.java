package fi.academy;

import fi.academy.jpa.entities.City;
import fi.academy.jpa.repositories.CityRepositorio;
import fi.academy.jpa.repositories.CountryRepositorio;
import fi.academy.jpa.entities.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.stream.StreamSupport;

@SpringBootApplication
public class JpaCountryHarjoitusApplication {
    Logger logger = LoggerFactory.getLogger(JpaCountryHarjoitusApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(JpaCountryHarjoitusApplication.class, args);
    }

    @Bean
    public CommandLineRunner testaa(CountryRepositorio repo, CityRepositorio cityrepo) {
        return args -> {
            Iterable<Country> maat = repo.findAll();
            StreamSupport.stream(maat.spliterator(), false)
                    .limit(20)
            //        .forEach(c -> System.out.println(c.getName() + " - " + c.getPopulation()))
                    .forEach(System.out::println);
            System.out.println();
            //List<Country> fimaat = repo.findAllByNameContainsOrLocalNameContains("fi", "fi");
            List<Country> fimaat = repo.etsiKaikkiNimellaTaiLocalNimella("uom");
            System.out.println(fimaat);
            System.out.println();
            maat = repo.findAllByOrderByPopulationDesc();
            StreamSupport.stream(maat.spliterator(), false)
                    .limit(10)
                    .forEach(System.out::println);

            System.out.println("\n** Cities **\n");
            Iterable<City> cityt = cityrepo.findAll();
            StreamSupport.stream(cityt.spliterator(), false)
                    .limit(10)
                    .forEach(System.out::println);

            List<Country> rajatutmaat =
                    repo.findAll(new PageRequest(0, 20)).getContent();
            System.out.println("\n''''''''''''\n");
            System.out.println(rajatutmaat);
            logger.info("Tietoa");
        };
    }
}
