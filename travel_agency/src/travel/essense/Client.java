package travel.essense;

import java.io.Serializable;

public class Client implements Serializable {

    public Client(int id, String name, String surname, String phoneNumber) {
        this.id = id;
        this.firstName = name;
        this.lastName = surname;
        this.email = phoneNumber;
    }

    public Client(){
    }

    private  int id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return "Client{ ID=" + id + " ,First name= " + firstName + " ,Last name= " + lastName + " ,Email: " + email + " }";
    }


}
