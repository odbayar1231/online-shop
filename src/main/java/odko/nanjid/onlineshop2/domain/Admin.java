package odko.nanjid.onlineshop2.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("admin")
public class Admin extends User{
    public Admin(){}

    public Admin(String firstName, String lastName, String email, String password) {
        super(firstName, lastName, email, password);
    }
}
