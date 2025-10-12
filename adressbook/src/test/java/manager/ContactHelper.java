package manager;

import model.ContactData;
import model.GroupData;
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
        selectGroupToContact(contact);
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
        var spans = manager.driver.findElements(By.cssSelector("tr[name='entry']"));
        for (var span : spans) {
            var name = span.getText();
            var checkbox = span.findElement(By.name("selected[]"));
            var id = checkbox.getAttribute("value");
            contacts.add(new ContactData().withId(id).withFirstName(name));
        }
        return contacts;
    }
}
