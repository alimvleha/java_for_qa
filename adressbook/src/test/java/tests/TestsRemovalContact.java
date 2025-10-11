package tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestsRemovalContact extends TestsBase {
    @Test
    public void testRemoveContact() {
        if (!app.contacts().isContactPresent()) {
            app.contacts().createContact(new ContactData());
        }
        app.contacts().selectContact();
        app.contacts().removeContact();
    }

    @Test
    void testRemoveAllContactAtOnce(){
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
