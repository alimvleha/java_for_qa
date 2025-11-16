package ru.mantis.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.mantis.common.CommonFunctions;
import ru.mantis.model.UserData;

public class TestsUserRegistration extends TestBase {

//    @Test
//    void testAddUserNoEmail() {
//        app.session().login("administrator", "root");
//        Assertions.assertTrue(app.session().isLoggedIn());
//    }


    @Test
    void testRegistrationUserCli() {
        var username = "alimovleha." + (CommonFunctions.randomString(3));
        var email = String.format("%s@localhost", username);
        var password = "password";
        app.jamesCli().addUser(email, password);
        System.out.println(username);
        System.out.println(email);

        app.session().login("administrator", "root");

        var userData = new UserData(username, username, email, password, password);
        app.user().createNewUserAccount(userData);

        app.user().confirmUserAccount(email, password, userData);

        app.http().login(username, password);
        System.out.println("Зашел под пользуном : " + username + " : " + password);
        Assertions.assertTrue(app.http().isLoggedIn());
    }

    @Test
    void testRegistrationUserApi() {
        var username = "alimovleha." + (CommonFunctions.randomString(3));
        var email = String.format("%s@localhost", username);
        var password = "password";
        app.jamesApi().addUser(email, password);
        System.out.println(username);
        System.out.println(email);

        app.session().login("administrator", "root");

        var userData = new UserData(username, username, email, password, password);
        app.user().createNewUserAccount(userData);

        app.user().confirmUserAccount(email, password, userData);

        app.http().login(username, password);
        System.out.println("Зашел под пользуном : " + username + " : " + password);
        Assertions.assertTrue(app.http().isLoggedIn());
    }
}
