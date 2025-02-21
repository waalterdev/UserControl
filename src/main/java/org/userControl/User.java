package org.userControl;

import lombok.Data;

@Data
public class User {
    private String firstname;
    private String lastname;
    private String cpf;

    public User(String firstname, String lastname, String cpf) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.cpf = cpf;
    }
}
