package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class TestContactModification extends TestsBase {

    @Test
    public void testModifyContact() {
        if (app.contacts().getCount() == 0) {
            app.contacts().createContact(new ContactData("", "Алексей", "", "Алимов", "", "", "ООО MTS", "г.Ульяновск", "+79190000001", "", "", "", "", "", "", ""));
        }
        var oldContact = app.contacts().getList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContact.size());
        var testData = new ContactData()
                .withLastName("Иванов")
                .withAddress("432054 обл Ульяновская, г Ульяновск, ул Камышинская, дом 42");
        app.contacts().modifyContact(oldContact.get(index), testData);
        var newContacts = app.contacts().getList();
        var expectedList = new ArrayList<>(oldContact);
        expectedList.set(index, testData.withId(oldContact.get(index).id()));
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(compareById);
        expectedList.sort(compareById);
        Assertions.assertEquals(newContacts, expectedList);
    }
}
