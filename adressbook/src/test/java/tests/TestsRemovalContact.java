package tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
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
        var oldContacts = app.contacts().getList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        app.contacts().removeContact(oldContacts.get(index));
        var newContacts = app.contacts().getList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.remove(index);
        Assertions.assertEquals(newContacts, expectedList);
    }

    @Test
    void testRemoveAllContactAtOnce() {
        if (app.contacts().getCount() == 0) {
            app.contacts().createContact(new ContactData()
                    .withFirstName("Алексей")
                    .withMiddleName("Альбертович")
                    .withLastName("Алимов")
                    .withNickname("alimov")
                    .withTitle("Title")
                    .withCompany("OOO MTS")
                    .withAddress("г. Москва")
                    .withHomePhone("79170000000")
                    .withFax("459000000")
                    .withEmail("aaalimo@mts.ru")
                    .withHomepage("www.mts.ru")
                    .withBirthDay("14")
                    .withBirthMonth("January")
                    .withBirthYear("2025")
                    .withGroup("group name"));
        }
        app.contacts().removeAllContacts();
        Assertions.assertEquals(0, app.contacts().getCount());
    }
}
