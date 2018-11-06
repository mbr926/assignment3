package aba;

public class GeneralBean {
//declaring beans variables that will be used to get users information from "GeneralBean" class	

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    public boolean valid;

    // get user's First Name
    public String getFirstName() {
        return firstName;
    }
// set First Name

    public void setFirstName(String newFirstName) {
        firstName = newFirstName;
    }

    // get Last Name
    public String getLastName() {
        return lastName;
    }
//set Last Name

    public void setLastName(String newLastName) {
        lastName = newLastName;
    }

//get user's Password
    public String getPassword() {
        return password;
    }
//set user's Password

    public void setPassword(String newPassword) {
        password = newPassword;
    }

    // get user's Username	
    public String getUsername() {
        return username;
    }
// set User Name

    public void setUserName(String newUsername) {
        username = newUsername;
    }

    // returns "True" if the user is valid otherwise "False"			
    public boolean isValid() {
        return valid;
    }
// set a boolean status to the user 

    public void setValid(boolean newValid) {
        valid = newValid;
    }

}
