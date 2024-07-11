package org.example.models;



public class User {

    String username;
    String password;
    int SystemRoleId;

    public User(String username, String password, int roleId) {
        this.username = username;
        this.password = password;
        this.SystemRoleId = roleId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSystemRoleId() {
        return SystemRoleId;
    }

    public void setSystemRoleId(int systemRoleId) {
        SystemRoleId = systemRoleId;
    }
}

