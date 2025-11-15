package ru.mantis.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.regex.Pattern;

public class TestsMail extends TestBase {

    @Test
    void testDeleteInbox() {
        app.mail().deleteMail("user1@localhost", "password");
    }

    @Test
    void testReceiveEmail() {
        var message = app.mail().receive("user1@localhost", "password", Duration.ofSeconds(30));
        Assertions.assertEquals(1, message.size());
        System.out.println("Письмо: " + message);
    }

    @Test
    void testExctractUrl() {
        var message = app.mail().receive("user1@localhost", "password", Duration.ofSeconds(30));
        var text = message.get(0).content();
        var pattertn = Pattern.compile("http://\\S+");
        var matcher = pattertn.matcher(text);
        if (matcher.find()) {
            var url = text.substring(matcher.start(), matcher.end());
            System.out.println("Ссылка для подтверждения регистрации: " + url);
        }


    }
}
