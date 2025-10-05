package manager;

import model.ContactData;
import org.openqa.selenium.By;


public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void createContact(ContactData contact) {
        openContactAdditionsPage();
        fillContactForm(contact);
        saveFormContact();
        openCintactPage();
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

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void removeContact() {
        click(By.xpath("//input[@name=\'delete\']"));
    }

    private void saveFormContact() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    private void openCintactPage() {
        click(By.xpath("//a[contains(text(),'home')]"));
    }

    private void openContactAdditionsPage() {
        click(By.xpath("//a[contains(text(),'add new')]"));
    }
}
