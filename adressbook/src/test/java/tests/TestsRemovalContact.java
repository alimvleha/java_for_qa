package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class TestsRemovalContact extends TestsBase {
    @Test
    public void testRemoveContact() {
        if (app.contacts().getCount() == 0) {
            app.contacts().createContact(new ContactData()
                    .withId("")
                    .withFirstName("Алексей")
                    .withMiddleName("Альбертович")
                    .withLastName("Алимов")
                    .withNickname("alimov"));
        }
        var oldContacts = app.hbm().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        var contactToRemove = oldContacts.get(index);

        app.contacts().removeContact(contactToRemove);

        var newContacts = app.hbm().getContactList();

        Assertions.assertFalse(newContacts.contains(contactToRemove));

        Assertions.assertEquals(oldContacts.size() - 1, newContacts.size());
    }

    @Test
    void testRemoveAllContactAtOnce() {
        if (app.hbm().getContactCount() == 0) {
            app.contacts().createContact(new ContactData()
                    .withFirstName("Алексей")
                    .withLastName("Алимов"));
            app.contacts().createContact(new ContactData()
                    .withFirstName("Иван")
                    .withLastName("Петров"));
        }

        var oldCount = app.hbm().getContactCount();

        app.contacts().removeAllContacts();

        var newCount = app.hbm().getContactCount();
        Assertions.assertEquals(0, newCount, "Контакты должны быть полностью удалены из базы данных");

        var contactList = app.hbm().getContactList();
        Assertions.assertTrue(contactList.isEmpty(), "Список контактов должен быть пустым");
    }
}