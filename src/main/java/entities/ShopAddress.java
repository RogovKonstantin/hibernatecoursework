package entities;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@NamedQuery(name = "ShopAddress.getAll", query = "SELECT s FROM ShopAddress s")
@Table(name = "shop_address", schema = "public", catalog = "electronics_shop")
public class ShopAddress {
    @Basic
    @Column(name = "country")
    private String country;
    @Override
    public String toString() {
        return "ShopAddress{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", buldingNumber=" + buldingNumber +
                '}';}
    @Basic
    @Column(name = "city")
    private String city;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "street")
    private String street;
    @Basic
    @Column(name = "bulding_number")
    private Integer buldingNumber;
    @OneToMany(mappedBy = "shopAddressByStreet")
    private Collection<LocatedAt> locatedAtsByStreet;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getBuldingNumber() {
        return buldingNumber;
    }

    public void setBuldingNumber(Integer buldingNumber) {
        this.buldingNumber = buldingNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShopAddress that = (ShopAddress) o;
        return Objects.equals(country, that.country) && Objects.equals(city, that.city)
                && Objects.equals(street, that.street) && Objects.equals(buldingNumber, that.buldingNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, city, street, buldingNumber);
    }

    public Collection<LocatedAt> getLocatedAtsByStreet() {
        return locatedAtsByStreet;
    }

    public void setLocatedAtsByStreet(Collection<LocatedAt> locatedAtsByStreet) {
        this.locatedAtsByStreet = locatedAtsByStreet;
    }
}
