package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestsContactInfo extends TestsBase {
//    @Test
//    void testPhones() {
//        var contacts = app.hbm().getContactList();
//        var contact = contacts.get(0);
//        var phones = app.contacts().getPhones(contact);
//        var expected = Stream.of(contact.homePhone(), contact.mobilePhone(), contact.workPhone())
//                .filter(s -> s != null && !"".equals(s))
//                .collect(Collectors.joining("\n"));
//        Assertions.assertEquals(expected, phones);
//        System.out.println("бд expected: " + expected);
//        System.out.println("ui phones: " + phones);
//    }
//
//    @Test
//    void testEmail() {
//        var contacts = app.hbm().getContactList();
//        var contact = contacts.get(0);
//        var emails = app.contacts().getEmail(contact);
//        var expected = Stream.of(contact.email(), contact.email2(), contact.email3())
//                .filter(s -> s != null && !"".equals(s))
//                .collect(Collectors.joining("\n"));
//        Assertions.assertEquals(expected, emails);
//        System.out.println("бд expected: " + expected);
//        System.out.println("ui emails: " + emails);
//    }

    @Test
    void testPhonesAndEmail() {
        var contacts = app.hbm().getContactList();
        var contact = contacts.get(0);

        var phones = app.contacts().getPhones(contact);
        var expectedPhones = Stream.of(contact.homePhone(), contact.mobilePhone(), contact.workPhone())
                .filter(s -> s != null && !"".equals(s))
                .collect(Collectors.joining("\n"));
        Assertions.assertEquals(expectedPhones, phones);

        var emails = app.contacts().getEmail(contact);
        var expectedEmails = Stream.of(contact.email(), contact.email2(), contact.email3())
                .filter(s -> s != null && !"".equals(s))
                .collect(Collectors.joining("\n"));
        Assertions.assertEquals(expectedEmails, emails);
    }
}
