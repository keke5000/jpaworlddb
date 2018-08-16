package fi.academy.jpa.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Country {
    private String code;
    private String name;
    private String continent;
    private String region;
    private double surfaceArea;
    private Short indepYear;
    private int population;
    private Double lifeExpectancy;
    private Double gnp;
    private Double gnpOld;
    private String localName;
    private String governmentForm;
    private String headOfState;
    private City capital;
    private String code2;
    private Collection<City> citiesByCode;

    @Id
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "continent")
    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    @Basic
    @Column(name = "region")
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Basic
    @Column(name = "surfacearea")
    public double getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    @Basic
    @Column(name = "indepyear")
    public Short getIndepYear() {
        return indepYear;
    }

    public void setIndepYear(Short indepYear) {
        this.indepYear = indepYear;
    }

    @Basic
    @Column(name = "population")
    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Basic
    @Column(name = "lifeexpectancy")
    public Double getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(Double lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    @Basic
    @Column(name = "gnp")
    public Double getGnp() {
        return gnp;
    }

    public void setGnp(Double gnp) {
        this.gnp = gnp;
    }

    @Basic
    @Column(name = "gnpold")
    public Double getGnpOld() {
        return gnpOld;
    }

    public void setGnpOld(Double gnpOld) {
        this.gnpOld = gnpOld;
    }

    @Basic
    @Column(name = "localname")
    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    @Basic
    @Column(name = "governmentform")
    public String getGovernmentForm() {
        return governmentForm;
    }

    public void setGovernmentForm(String governmentForm) {
        this.governmentForm = governmentForm;
    }

    @Basic
    @Column(name = "headofstate")
    public String getHeadOfState() {
        return headOfState;
    }

    public void setHeadOfState(String headOfState) {
        this.headOfState = headOfState;
    }

    @OneToOne
    @JoinColumn(name = "capital")
    public City getCapital() {
        return capital;
    }

    public void setCapital(City capital) {
        this.capital = capital;
    }

    @Basic
    @Column(name = "code2")
    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Double.compare(country.surfaceArea, surfaceArea) == 0 &&
                population == country.population &&
                Objects.equals(code, country.code) &&
                Objects.equals(name, country.name) &&
                Objects.equals(continent, country.continent) &&
                Objects.equals(region, country.region) &&
                Objects.equals(indepYear, country.indepYear) &&
                Objects.equals(lifeExpectancy, country.lifeExpectancy) &&
                Objects.equals(gnp, country.gnp) &&
                Objects.equals(gnpOld, country.gnpOld) &&
                Objects.equals(localName, country.localName) &&
                Objects.equals(governmentForm, country.governmentForm) &&
                Objects.equals(headOfState, country.headOfState) &&
                Objects.equals(capital, country.capital) &&
                Objects.equals(code2, country.code2);
    }

    @Override
    public int hashCode() {

        return Objects.hash(code, name, continent, region, surfaceArea, indepYear, population, lifeExpectancy, gnp, gnpOld, localName, governmentForm, headOfState, capital, code2);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Country{");
        sb.append("code='").append(code).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", continent='").append(continent).append('\'');
        sb.append(", region='").append(region).append('\'');
        sb.append(", surfaceArea=").append(surfaceArea);
        sb.append(", indepYear=").append(indepYear);
        sb.append(", population=").append(population);
        sb.append(", lifeExpectancy=").append(lifeExpectancy);
        sb.append(", gnp=").append(gnp);
        sb.append(", gnpOld=").append(gnpOld);
        sb.append(", localName='").append(localName).append('\'');
        sb.append(", governmentForm='").append(governmentForm).append('\'');
        sb.append(", headOfState='").append(headOfState).append('\'');
        sb.append(", capital=").append(capital);
        sb.append(", code2='").append(code2).append('\'');
        sb.append(", citiesByCode=").append(citiesByCode);
        sb.append('}');
        return sb.toString();
    }

    // TODO: tämän JsonIgnoren voisi ottaa pois jos halutaan listata maassa olevat kaupungitkin
//    @JsonIgnore
    @OneToMany(mappedBy = "countryByCountryCode", fetch = FetchType.EAGER)
    public Collection<City> getCitiesByCode() {
        return citiesByCode;
    }

    public void setCitiesByCode(Collection<City> citiesByCode) {
        this.citiesByCode = citiesByCode;
    }

}
