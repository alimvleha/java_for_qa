package tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.addressbook.common.CommonFunctions;

import java.util.Random;

public class TestsContactToGroup extends TestsBase {

    @Test
    public void testAddContactToGroup() {
        var contacts = app.hbm().getContactList();
        var groups = app.hbm().getGroupList();

        ContactData contactToAdd = null;
        GroupData targetGroup = null;

        for (var group : groups) {
            var contactsInGroup = app.hbm().getContactsInGroup(group);
            for (var contact : contacts) {
                if (!contactsInGroup.contains(contact)) {
                    contactToAdd = contact;
                    targetGroup = group;
                    break;
                }
            }
            if (contactToAdd != null) break;
        }

        if (contactToAdd == null) {
            if (groups.isEmpty()) {
                app.hbm().createGroup(new GroupData("", "group-" + CommonFunctions.randomString(5), "group_header№1", "group_footer№1"));
                groups = app.hbm().getGroupList();
            }

            var rnd = new Random();
            targetGroup = groups.get(rnd.nextInt(groups.size()));
            System.out.println(targetGroup);

            String testFirstName = CommonFunctions.randomString(10);
            String testLastName = "Алимов-" + CommonFunctions.randomString(5);

            contactToAdd = new ContactData()
                        .withFirstName(testFirstName)
                        .withLastName(testLastName)
                        .withAddress("г. Москва")
                        .withHomePhone("79160000001")
                        .withEmail("alexey@example.com");
                app.contacts().createContact(contactToAdd);

            var newContacts = app.hbm().getContactList();
            contactToAdd = newContacts.stream()
                    .filter(c -> c.firstName().equals(testFirstName) && c.lastName().equals(testLastName))
                    .findFirst()
                    .orElseThrow();
        }

        var oldContactsInGroup = app.hbm().getContactsInGroup(targetGroup);
        app.contacts().addContactToGroup(contactToAdd, targetGroup);
        var newContactsInGroup = app.hbm().getContactsInGroup(targetGroup);

        Assertions.assertEquals(oldContactsInGroup.size() + 1, newContactsInGroup.size(),
                "Количество контактов в группе должно увеличиться на 1");
    }

    @Test
    public void testRemoveContactFromGroup() {
        if (app.hbm().getContactCount() == 0) {
            app.contacts().createContact(new ContactData()
                    .withFirstName("Алексей")
                    .withLastName("Алимов")
                    .withAddress("г. Москва")
                    .withHomePhone("79160000001")
                    .withEmail("alexey@example.com"));
        }
        if (app.hbm().getGroupCount() == 0) {
            app.hbm().createGroup(new GroupData("", "group_contact№2", "group_header№2", "group_footer№2"));
        }
        var contact = app.hbm().getContactList().get(0);
        var group = app.hbm().getGroupList().get(0);

        app.contacts().addContactToGroup(contact, group);

        var oldContactsInGroup = app.hbm().getContactsInGroup(group).size();

        app.contacts().removeContactFromGroup(contact, group);

        var newContactsInGroup = app.hbm().getContactsInGroup(group).size();

        Assertions.assertEquals(oldContactsInGroup - 1, newContactsInGroup,
                "Количество контактов в группе должно уменьшиться на 1");
    }
}
