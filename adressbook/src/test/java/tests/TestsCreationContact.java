package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class TestsCreationContact extends TestsBase {

    @Test
    public void testCreateContact() {
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

    @Test
    public void testCreateContactWithNameOnly() {
        app.contacts().createContact(new ContactData().withFirstName("Алексей"));
    }

    @Test
    public void testCreateContactWitchCompanyAndAddressOnly() {
        app.contacts().createContact(new ContactData().withCompany("ИП Алимов А.А").withAddress("123456 г.Ульяновск., ул. Ефремова., д.140"));
    }
}
