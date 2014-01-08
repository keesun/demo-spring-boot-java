package whiteship.domain;

import javax.persistence.*;

/**
 * @author Keesun Baik
 */
@Entity
public class User {

    @Id @GeneratedValue
    private long id;

    private String name;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
