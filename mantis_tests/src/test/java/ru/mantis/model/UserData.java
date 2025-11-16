package ru.mantis.model;

public record UserData(String username, String realName, String email, String userPassword,
                       String confirmUserPassword) {
    public UserData() {
        this("", "", "", "", "");
    }

    public UserData(String username, String realName, String email) {
        this(username, realName, email, "", "");
    }

    public UserData(String username, String realName, String email, String password) {
        this(username, realName, email, password, password);
    }

    public UserData withUsername(String username) {
        return new UserData(username, this.realName, this.email, this.userPassword, this.confirmUserPassword);
    }

    public UserData withRealName(String realName) {
        return new UserData(this.username, realName, this.email, this.userPassword, this.confirmUserPassword);
    }

    public UserData withEmail(String email) {
        return new UserData(this.username, this.realName, email, this.userPassword, this.confirmUserPassword);
    }

    public UserData withUserPassword(String userPassword) {
        return new UserData(this.username, this.realName, this.email, userPassword, this.confirmUserPassword);
    }

    public UserData withUserConfirmPassword(String confirmUserPassword) {
        return new UserData(this.username, this.realName, this.email, this.userPassword, confirmUserPassword);
    }
}