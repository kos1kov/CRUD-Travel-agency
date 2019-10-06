package travel.essense;

import java.io.Serializable;

public class Client implements Serializable {
    public Client(String name, String surname, String phoneNumber) {
            this.firstName = name;
            this.lastName = surname;
            this.email = phoneNumber;
            }
    private String firstName;
    private String lastName;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String print() {
        return " First name: " + firstName + " Last name: " + lastName + " Email: " + email;
    }
}
