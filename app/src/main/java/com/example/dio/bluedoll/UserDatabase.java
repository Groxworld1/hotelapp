package com.example.dio.bluedoll;

public class UserDatabase {
    private String name, pass, email;

    public UserDatabase(String name, String pass, String email){
        this.name = name;
        this.pass = pass;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // public static Vector<> userList = new Vector<>();
}


