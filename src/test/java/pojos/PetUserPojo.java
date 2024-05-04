package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PetUserPojo {

    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String phone;
    private Integer userStatus;

    public PetUserPojo() {
    }

    public PetUserPojo( String username, String firstname, String lastname, String email, String password, String phone, Integer userStatus) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.userStatus = userStatus;
    }


    public String getUsername() { return username;
    }

    public void setUsername(String username) { this.username = username;
    }
    public String getfirstName() { return firstname;
    }

    public void setfirstName(String firstname) { this.firstname = firstname;
    }

    public String getlastName() { return lastname;
    }

    public void setlastName(String lastname) { this.lastname = lastname;
    }

    public String getEmail() { return email;
    }

    public void setEmail(String email) { this.email = email;
    }
    public String getPassword() { return password;
    }

    public void setPassword(String password) { this.password = password;
    }
    public String getPhone() { return phone;
    }

    public void setPhone(String phone) { this.phone = phone;
    }

    public Integer getUserStatus() { return userStatus;
    }

    public void setUserStatus(Integer userStatus) { this.userStatus = userStatus;
    }
    @Override
    public String toString() {
        return "PetUserPojo{" +
                "username='" + username + '\'' +
                ", firstName='" + firstname + '\'' +
                ", lastName='" + lastname + '\'' +
                ", email=" + email +
                ", password=" + password + '\'' +
                ", phone=" + phone +
                ", userStatus=" + userStatus + '\'' +
                '}';
    }

}



