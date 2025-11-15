package ru.mantis.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestsMail extends TestBase {

    @Test
    void testReceiveEmail() {
        var message = app.mail().receive("user1@localhost", "password");
        Assertions.assertEquals(1, message.size());
        System.out.println(message);
    }
}
