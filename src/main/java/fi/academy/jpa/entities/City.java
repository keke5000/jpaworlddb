package fi.academy.jpa.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class City {
    private int id;
    private String name;
    private String district;
    private int population;
    private Country countryByCountryCode;


    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Basic
    @Column(name = "district")
    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Basic
    @Column(name = "population")
    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return id == city.id &&
                population == city.population &&
                Objects.equals(name, city.name) &&
                Objects.equals(district, city.district);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, district, population);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("City{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", district='").append(district).append('\'');
        sb.append(", population=").append(population);
        sb.append(", countrycode=").append(countryByCountryCode.getCode());
        sb.append(", countryname=").append(countryByCountryCode.getName());
        sb.append('}');
        return sb.toString();
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "countrycode", referencedColumnName = "code", nullable = false)
    public Country getCountryByCountryCode() {
        return countryByCountryCode;
    }

    public void setCountryByCountryCode(Country countryByCountryCode) {
        this.countryByCountryCode = countryByCountryCode;
    }

    // JSONia varten
    @Transient
    public String getCountryName() {
        return countryByCountryCode.getName();
    }

    @Transient
    public String getCountryCode() {
        return countryByCountryCode.getCode();
    }

}
