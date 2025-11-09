package manager.hbm;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "addressbook")
public class ContactRecord {
    @Id
    @Column(name = "id")
    public int id;

    @Column(name = "firstname")
    public String firstname;

    @Column(name = "lastname")
    public String lastname;

    @Column(name = "address")
    public String address;

    @Column(name = "home")
    public String homePhone;
    @Column(name = "email")
    public String email;

    @Column(name = "email2")
    public String email2;

    @Column(name = "email3")
    public String email3;

    @Column(name = "mobile")
    public String mobilePhone;

    @Column(name = "work")
    public String workPhone;



    public ContactRecord() {
    }

    public ContactRecord(int id, String firstname, String lastname, String address, String homePhone, String email, String email2, String email3,
                          String mobilePhone, String workPhone) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.homePhone = homePhone;
        this.email = email;
        this.email2 = email2;
        this.email3 = email3;
        this.mobilePhone = mobilePhone;
        this.workPhone = workPhone;
    }
}