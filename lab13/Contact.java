import java.io.Serializable;

/**
 * @author Jack Roach
 * Date: May 1, 2022
 * Class: CSE 271 - E
 */
public class Contact implements Serializable {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String address;

    public Contact() {
        firstName = "";
        lastName = "";
        phoneNumber = "";
        email = "";
        address = "";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Contact)) {
            return false;
        }

        Contact c = (Contact) o;
        return firstName.equals(c.firstName) && lastName.equals(c.lastName)
            && phoneNumber.equals(c.phoneNumber) && email.equals(c.email)
            && address.equals(c.address);
    }

    @Override
    public String toString() {
        return String.format("%s %s, %s, %s, %s", firstName, lastName, address, email, phoneNumber);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}