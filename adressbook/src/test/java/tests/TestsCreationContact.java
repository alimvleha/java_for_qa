package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestsCreationContact extends TestsBase {

    public static List<ContactData> contactProvider() {
        var result = new ArrayList<ContactData>();
        for (var firstName : List.of("", "Алексей")) {
            for (var middleName : List.of("", "Альбертович")) {
                for (var lastName : List.of("", "Алимов")) {
                    for (var address : List.of("", "г. Москва")) {
                        for (var phone : List.of("", "79170000000")) {
                            result.add(new ContactData()
                                    .withFirstName(firstName)
                                    .withMiddleName(middleName)
                                    .withLastName(lastName)
                                    .withAddress(address)
                                    .withHomePhone(phone));
                        }
                    }
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            result.add(new ContactData()
                    .withFirstName(randomString(i * 5))
                    .withMiddleName(randomString(i * 5))
                    .withLastName(randomString(i * 5))
                    .withAddress(randomString(i * 5))
                    .withHomePhone(randomString(i * 5)));
//                    .withNickname(randomString(i * 5))
//                    .withTitle(randomString(i * 5))
//                    .withCompany(randomString(i * 5))
//                    .withFax(randomString(i * 5))
//                    .withEmail(randomString(i * 5))
//                    .withHomepage(randomString(i * 5))
//                    .withBirthDay(randomString(i * 5))
//                    .withBirthMonth(randomString(i * 5))
//                    .withBirthYear(randomString(i * 5))
//                    .withGroup(randomString(i * 5)));
        }
        return result;
    }

    public static List<ContactData> negativeContactProvider() {
        var result = new ArrayList<ContactData>(List.of(
                new ContactData().withFirstName("'invalid_name'"),
                new ContactData().withFirstName("'"),
                new ContactData().withFirstName("Name@#$'")));
        return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void testCreateMultipleContact(ContactData contact) {
        var oldContacts = app.contacts().getList();
        app.contacts().createContact(contact);
        var newContacts = app.contacts().getList();
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(compareById);
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.add(contact.withId(newContacts.get(newContacts.size() - 1).id())
                .withMiddleName(""));
        expectedList.sort(compareById);
        Assertions.assertEquals(newContacts, expectedList);
    }

    @ParameterizedTest
    @MethodSource("negativeContactProvider")
    public void testNotCreateContact(ContactData contact) {
        int contactCount = app.contacts().getCount();
        app.contacts().createContact(contact);
        int newContactCount = app.contacts().getCount();
        Assertions.assertEquals(contactCount, newContactCount);
    }


    @Test
    public void testCreateContact() {
        app.contacts().createContact(new ContactData()
                .withFirstName(randomString(10))
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
                .withGroup("group name")
                .withPhoto(randomFile("src/test/resources/images")));
    }

    @Test
    public void testCreateContactWithNameOnly() {
        app.contacts().createContact(new ContactData()
                .withFirstName("Алексей"));
    }

    @Test
    public void testCreateContactWitchCompanyAndAddressOnly() {
        app.contacts().createContact(new ContactData().withCompany("ИП Алимов А.А").withAddress("123456 г.Ульяновск., ул. Ефремова., д.140"));
    }
}
