package ru.mantis.tests;

import org.junit.jupiter.api.Test;
import ru.mantis.common.CommonFunctions;

public class TestsJames extends TestBase {

    @Test
    void canCreateUser() {
        app.jamesCli().addUser(String.format("%s@localhost", CommonFunctions.randomString(8)), "password");
    }
}
