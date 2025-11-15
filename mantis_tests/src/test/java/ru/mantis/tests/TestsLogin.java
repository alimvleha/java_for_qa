package ru.mantis.tests;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestsLogin extends TestBase {
    @Test
    void testLogin() {
    app.session().login("administrator", "root");
        Assertions.assertTrue(app.session().isLoggedIn());
    }
}
