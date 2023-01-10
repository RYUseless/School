package ryu.useless.project03.api;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SQLinjectionView {
    private StringProperty capybara1 = new SimpleStringProperty();
    private StringProperty capybara2 = new SimpleStringProperty();

    public String getCapybara1() {
        return capybara1Property().get();
    }

    public StringProperty capybara1Property() {
        return capybara1;
    }

    public void setCapybara1(String capybara1) {
        this.capybara1.set(capybara1);
    }

    public String getCapybara2() {
        return capybara2Property().get();
    }

    public StringProperty capybara2Property() {
        return capybara2;
    }

    public void setCapybara2(String capybara2) {
        this.capybara2.set(capybara2);
    }

}
