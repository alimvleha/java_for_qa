package manager;

import model.ContactData;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;


public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void createContact(ContactData contact) {
        openContactAdditionsPage();
        fillContactForm(contact);
        saveFormContact();
        openContactPage();
    }


    private void fillContactForm(ContactData contact) {
        fillPersonalInfo(contact);
        fillOthersInfo(contact);
        fillBirthday(contact);
//        selectGroupToContact(contact);
    }

    private void fillOthersInfo(ContactData contact) {
        type(By.xpath("//input[@name='title']"), contact.title());
        type(By.xpath("//input[@name='company']"), contact.company());
        type(By.xpath("//textarea[@name='address']"), contact.address());
        type(By.xpath("//input[@name='home']"), contact.homePhone());
        type(By.xpath("//input[@name='fax']"), contact.fax());
        type(By.xpath("//input[@name='email']"), contact.email());
        type(By.xpath("//input[@name='homepage']"), contact.homepage());
    }

    private void fillPersonalInfo(ContactData contact) {
        type(By.xpath("//input[@name='firstname']"), contact.firstName());
        type(By.xpath("//input[@name='middlename']"), contact.middleName());
        type(By.xpath("//input[@name='lastname']"), contact.lastName());
        type(By.xpath("//input[@name='nickname']"), contact.nickname());
    }

    private void fillBirthday(ContactData contact) {
        manager.driver.findElement(By.name("bday")).sendKeys(contact.birthDay());
        manager.driver.findElement(By.name("bmonth")).sendKeys(contact.birthMonth());
        type(By.xpath("//input[@name='byear']"), contact.birthYear());
    }

    private void selectGroupToContact(ContactData contact) {
        manager.driver.findElement(By.name("new_group")).sendKeys(contact.group());
    }

    public void selectContact(ContactData contact) {

        click(By.cssSelector(String.format("input[value='%s']", contact.id())));
    }

    public boolean isContactPresent() {
        openContactPage();
        return manager.isElementPresent(By.name("selected[]"));
    }

    public void removeContact(ContactData contact) {
        selectContact(contact);
        removeSelectedContacts();
    }

    private void saveFormContact() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    private void openContactPage() {
        click(By.xpath("//a[contains(text(),'home')]"));
    }

    private void openContactAdditionsPage() {
        click(By.xpath("//a[contains(text(),'add new')]"));
    }

    public int getCount() {
        openContactPage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    public void removeAllContacts() {
        openContactPage();
        selectAllContacts();
        removeSelectedContacts();
    }

    private void removeSelectedContacts() {
        click(By.xpath("//input[@value='Delete']"));
    }

    private void selectAllContacts() {
        var checkboxes = manager.driver.findElements(By.name("selected[]"));
        for (var checkbox : checkboxes) {
            checkbox.click();
        }
    }

    public List<ContactData> getList() {
        var contacts = new ArrayList<ContactData>();
        var contactRows = manager.driver.findElements(By.cssSelector("tr"));
        for (var contactRow : contactRows) {
            var cells = contactRow.findElements(By.cssSelector("td"));
            if (cells.size() < 6) continue;
            var checkbox = contactRow.findElement(By.name("selected[]"));
            contacts.add(new ContactData()
                    .withId(checkbox.getAttribute("value"))
                    .withLastName(cells.get(1).getText())
                    .withFirstName(cells.get(2).getText())
                    .withAddress(cells.get(3).getText())
                    .withHomePhone(cells.get(5).getText()));
        }
        return contacts;
    }

    public void modifyContact(ContactData contact, ContactData modifiedContact) {
        openContactPage();
        selectContact(contact);
        initContactModification();
        fillPersonalInfo(modifiedContact);
        fillContactForm(modifiedContact);
        fillOthersInfo(modifiedContact);
        submitContactModification();
        openContactPage();
    }

    private void submitContactModification() {
        click(By.xpath("//input[@name='update']"));
    }

    private void initContactModification() {
        click(By.xpath("//img[@alt='Edit']"));
    }
}

