package guru.springframework.spring5webapp.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String Name;
    private String AddressLine1;
    private String AddressCity;
    private String AddressState;
    private String AddressZip;

    @OneToMany //(cascade = {CascadeType.ALL})
    @JoinColumn(name = "publisher_id")
    private Set<Book> books = new HashSet<>();

    public Publisher() {
    }

    public Publisher(String name, String addressLine1, String addressCity, String addressState, String addressZip) {
        Name = name;
        AddressLine1 = addressLine1;
        AddressCity = addressCity;
        AddressState = addressState;
        AddressZip = addressZip;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddressLine1() {
        return AddressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        AddressLine1 = addressLine1;
    }

    public String getAddressCity() {
        return AddressCity;
    }

    public void setAddressCity(String addressCity) {
        AddressCity = addressCity;
    }

    public String getAddressState() {
        return AddressState;
    }

    public void setAddressState(String addressState) {
        AddressState = addressState;
    }

    public String getAddressZip() {
        return AddressZip;
    }

    public void setAddressZip(String addressZip) {
        AddressZip = addressZip;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return Objects.equals(Id, publisher.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", AddressLine1='" + AddressLine1 + '\'' +
                ", AddressCity='" + AddressCity + '\'' +
                ", AddressState='" + AddressState + '\'' +
                ", AddressZip='" + AddressZip + '\'' +
                '}';
    }
}
