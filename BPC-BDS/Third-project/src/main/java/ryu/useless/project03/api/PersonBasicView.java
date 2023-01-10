package ryu.useless.project03.api;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PersonBasicView {
    public String getName() {
        return nameProperty().get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }


    public String getEmail() {
        return emailProperty().get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getCity() {
        return cityProperty().get();
    }

    public StringProperty cityProperty() {
        return city;
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public long getPhoneNumber() {
        return phoneNumberProperty().get();
    }

    public LongProperty phoneNumberProperty() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public long getId() {
        return idProperty().get();
    }

    public void setId(long id) {
        this.id.set(id);
    }
    public LongProperty idProperty() {
        return id;
    }

    public String getSurname() {
        return  surnameProperty().get();
    }

    public StringProperty surnameProperty() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname.set(surname);
    }

    private LongProperty id = new SimpleLongProperty();
    private StringProperty name = new SimpleStringProperty();
    private StringProperty surname = new SimpleStringProperty();
    private StringProperty email = new SimpleStringProperty();
    private StringProperty city = new SimpleStringProperty();
    private LongProperty phoneNumber = new SimpleLongProperty();

}
