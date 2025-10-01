package manager;

import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ApplicationManager {
    protected static WebDriver driver;

    public void init() {
        if (driver == null) {
            driver = new FirefoxDriver();
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
            driver.get("http://localhost/addressbook/");
            driver.manage().window().setSize(new Dimension(1076, 640));
            driver.findElement(By.xpath("//input[@name=\'user\']")).click();
            driver.findElement(By.xpath("//input[@name=\'user\']")).sendKeys("admin");
            driver.findElement(By.xpath("//input[@name=\'pass\']")).click();
            driver.findElement(By.xpath("//input[@name=\'pass\']")).sendKeys("secret");
            driver.findElement(By.xpath("//input[@value=\'Login\']")).click();
        }
    }

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public void createGroup(GroupData group) {
        driver.findElement(By.xpath("//a[contains(text(),'groups')]")).click();
        driver.findElement(By.xpath("//input[@name=\'new\']")).click();
        driver.findElement(By.xpath("//input[@name=\'group_name\']")).click();
        driver.findElement(By.xpath("//input[@name=\'group_name\']")).sendKeys(group.name());
        driver.findElement(By.xpath("//textarea[@name=\'group_header\']")).click();
        driver.findElement(By.xpath("//textarea[@name=\'group_header\']")).sendKeys(group.header());
        driver.findElement(By.xpath("//textarea[@name=\'group_footer\']")).click();
        driver.findElement(By.xpath("//textarea[@name=\'group_footer\']")).sendKeys(group.footer());
        driver.findElement(By.xpath("//input[@name=\'submit\']")).click();
        driver.findElement(By.xpath("//a[contains(text(),\'group page\')]")).click();
    }

    public void openGroupsPage() {
        if (!isElementPresent(By.xpath("//input[@name=\'new\']"))) {
            driver.findElement(By.xpath("//a[contains(text(),'groups')]")).click();
        }
    }

    public boolean isGroupPresent() {
        return isElementPresent(By.name("selected[]"));
    }

    public void removeGroup() {
        driver.findElement(By.xpath("//a[contains(text(),\'groups\')]")).click();
        driver.findElement(By.name("selected[]")).click();
        driver.findElement(By.xpath("(//input[@name=\'delete\'])[2]")).click();
        driver.findElement(By.xpath("//a[contains(text(),\'group page\')]")).click();
    }
}
