package manager;

import io.qameta.allure.Step;
import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

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

    public void createContact(ContactData contact, GroupData group) {
        openContactAdditionsPage();
        fillContactForm(contact);
        selectGroup(group);
        saveFormContact();
        openContactPage();
    }

    private void selectGroup(GroupData group) {
        new Select(manager.driver.findElement(By.name("new_group"))).selectByValue(group.id());
    }


    private void fillContactForm(ContactData contact) {
        fillPersonalInfo(contact);
        fillOthersInfo(contact);
        fillBirthday(contact);
        addPhoto(contact);
    }

    private void addPhoto(ContactData contact) {
        String photo = contact.photo();
        if (photo != null && !photo.trim().isEmpty()) {
            attach(By.name("photo"), photo);
        }
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

    @Step
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
        initContactModification(contact);
        fillPersonalInfo(modifiedContact);
        fillContactForm(modifiedContact);
        fillOthersInfo(modifiedContact);
        submitContactModification();
        openContactPage();
    }

    private void submitContactModification() {
        click(By.xpath("//input[@name='update']"));
    }

    private void initContactModification(ContactData contact) {
        var contactRow = manager.driver.findElement(By.cssSelector(String.format("input[value='%s']", contact.id()))).findElement(By.xpath("./ancestor::tr"));
        contactRow.findElement(By.xpath(".//img[@alt='Edit']")).click();
        System.out.println(contact.id());
    }

    public void addContactToGroup(ContactData contact, GroupData group) {
        openContactPage();
        selectContact(contact);
        getSelectGroupFor(group);
        clickAddToGroup();
        openContactPage();
    }

    private static void getSelectGroupFor(GroupData group) {
        new Select(manager.driver.findElement(By.name("to_group"))).selectByValue(group.id());
    }

    private void clickAddToGroup() {
        click(By.name("add"));
    }

    public void removeContactFromGroup(ContactData contact, GroupData group) {
        openContactPage();
        selectGroupFilter(group);
        selectContact(contact);
        clickRemoveFromGroup();
        openContactPage();
    }

    private void selectGroupFilter(GroupData group) {
        new Select(manager.driver.findElement(By.name("group"))).selectByValue(group.id());
    }

    private void clickRemoveFromGroup() {
        manager.driver.findElement(By.name("remove")).click();
    }

    public String getPhones(ContactData contact) {
        return manager.driver.findElement(By.xpath(
                String.format("//input[@id='%s']/../../td[6]", contact.id()))).getText();
    }

    public String getEmail(ContactData contact) {
        return manager.driver.findElement(By.xpath(
                String.format("//input[@id='%s']/../../td[5]", contact.id()))).getText();
    }
}

