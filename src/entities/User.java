package entities;

import java.io.Serializable;
import java.util.Objects;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class User implements Serializable {

    private final SimpleIntegerProperty id;
    private final SimpleStringProperty username;
    private final SimpleStringProperty email;
    private final SimpleStringProperty password;
    private final SimpleStringProperty gender;
    private final SimpleStringProperty country;
    private final SimpleStringProperty status;

 
    public User(Integer id, String username, String email, String password, String gender, String country, String status) {
        super();
        
        this.id = new SimpleIntegerProperty(id);
        this.username = new SimpleStringProperty(username);
        this.email = new SimpleStringProperty(email);
        this.password = new SimpleStringProperty(password);
        this.gender = new SimpleStringProperty(gender);
        this.country = new SimpleStringProperty(country);
        this.status = new SimpleStringProperty(status);
        
        
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + ", gender=" + gender + ", country=" + country + ", status=" + status + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.gender, other.gender)) {
            return false;
        }
        if (!Objects.equals(this.country, other.country)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        return true;
    }

    public Integer getId() {
        return id.get();
    }

    public  String getUsername() {
        return username.get();
    }

    public  String getEmail() {
        return email.get();
    }

    public  String getPassword() {
        return password.get();
    }

    public  String getGender() {
        return gender.get();
    }

    public  String getCountry() {
        return country.get();
    }

    public String getStatus() {
        return status.get();
    }


    
}
