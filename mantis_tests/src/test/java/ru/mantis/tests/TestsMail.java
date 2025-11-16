package ru.mantis.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;

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
        var confirmUrl = app.user().extractConfirmUrl("user1@localhost", "password");
        System.out.println("Ссылка для подтверждения регистрации: " + confirmUrl);
    }
}

