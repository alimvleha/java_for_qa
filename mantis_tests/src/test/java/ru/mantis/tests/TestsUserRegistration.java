package ru.mantis.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.mantis.common.CommonFunctions;
import ru.mantis.model.UserData;

import java.time.Duration;
import java.util.regex.Pattern;

public class TestsUserRegistration extends TestBase {

    @Test
    void testAddUserNoEmail() {
        app.session().login("administrator", "root");
        Assertions.assertTrue(app.session().isLoggedIn());

    }


    @Test
    void testRegistrationUser() {
        var username = "alimov." + (CommonFunctions.randomString(3));
        var email = String.format("%s@localhost", username);
        var password = "password";
        app.jamesCli().addUser(email, password);
        System.out.println(username);
        System.out.println(email);

        app.session().login("administrator", "root");

        var userData = new UserData(username, username, email);
        app.user().createNewUserAccount(userData);

        var messages = app.mail().receive(email, password, Duration.ofSeconds(30));
        var text = messages.get(0).content();
        var pattern = Pattern.compile("http://\\S+");
        var matcher = pattern.matcher(text);
        if (matcher.find()) {
            var url = text.substring(matcher.start(), matcher.end());
            System.out.println("Ссылка для подтверждения регистрации: " + url);
        } else {
            Assertions.fail("Письмо не пришло или ссылка не пришла");
        }

    }


}
