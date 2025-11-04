package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class TestContactModification extends TestsBase {

    @Test
    public void testModifyContact() {
        if (app.hbm().getContactCount() == 0) {
            app.contacts().createContact(new ContactData()
                    .withFirstName("Алексей")
                    .withLastName("Алимов")
                    .withAddress("г. Москва")
                    .withHomePhone("79160000001")
                    .withEmail("alexey@example.com"));
        }

        var oldContacts = app.hbm().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        var contactToModify = oldContacts.get(index);

        var testData = new ContactData()
                .withLastName("Ибрагим")
                .withFirstName("Петров")
                .withAddress("432054 обл Ульяновская, г Ульяновск, ул Камышинская, дом 66")
                .withHomePhone("79010000001")
                .withEmail("petrov@example.com");

        app.contacts().modifyContact(contactToModify, testData);

        var newContacts = app.hbm().getContactList();
        var modifiedContact = newContacts.stream()
                .filter(c -> c.id().equals(contactToModify.id()))
                .findFirst()
                .orElseThrow();

        Assertions.assertEquals("Петров", modifiedContact.firstName());
        Assertions.assertEquals("Ибрагим", modifiedContact.lastName());
        Assertions.assertEquals("432054 обл Ульяновская, г Ульяновск, ул Камышинская, дом 66", modifiedContact.address());
        Assertions.assertEquals("79010000001", modifiedContact.homePhone());
        Assertions.assertEquals("petrov@example.com", modifiedContact.email());

        Assertions.assertEquals(oldContacts.size(), newContacts.size());
    }
}
