package ru.mantis.tests;

import org.junit.jupiter.api.Test;

public class TestsUserRegistration extends TestBase{

    @Test
    void testRegisterUser(String username){
        var email = String.format("%s@localhost", username);

    }
}
