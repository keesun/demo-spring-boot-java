package whiteship.domain;

import javax.persistence.*;

@Entity
public class User {

    @Id @GeneratedValue
    private long id;

    private String name;

    @OneToOne
    @JoinTable(
        name = "user_address",
        joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "address_id", referencedColumnName = "id")
    )
    private Address address;

    public void setAddress(Address address) {
        this.address = address;
    }

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

}
