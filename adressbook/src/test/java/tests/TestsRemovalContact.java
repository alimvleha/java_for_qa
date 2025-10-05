package tests;

import model.ContactData;
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
}
