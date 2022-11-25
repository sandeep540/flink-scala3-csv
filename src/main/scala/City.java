package org.acme;

import java.util.Objects;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"city", "country", "type"})
public class City {

    public String city;
    public String country;
    public String type;

    public City() {}

    public City(final String city, final String country, final String type) {
        this.city = city;
        this.country = country;
        this.type = type;
    }

    @Override
    public String toString() {
        return "City{"
                + ", city='"
                + city
                + '\''
                + ", country='"
                + country
                + '\''
                + ", type='"
                + type
                + '\''
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        City city = (City) o;
        return city.equals(city.city)
                && country.equals(city.country)
                && type.equals(city.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, country, type);
    }
}