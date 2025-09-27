import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


public class GroupCreationTest {
    private static WebDriver driver;

    @BeforeEach
    public void setUp() {
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

    @Test
    public void canCreateGroup() {
        if (!isElementPresent(By.xpath("//input[@name=\'new\']"))) {
            driver.findElement(By.xpath("//a[contains(text(),'groups')]")).click();
        }
        driver.findElement(By.xpath("//a[contains(text(),'groups')]")).click();
        driver.findElement(By.xpath("//input[@name=\'new\']")).click();
        driver.findElement(By.xpath("//input[@name=\'group_name\']")).click();
        driver.findElement(By.xpath("//input[@name=\'group_name\']")).sendKeys("groupname");
        driver.findElement(By.xpath("//textarea[@name=\'group_header\']")).click();
        driver.findElement(By.xpath("//textarea[@name=\'group_header\']")).sendKeys("groupheader");
        driver.findElement(By.xpath("//textarea[@name=\'group_footer\']")).click();
        driver.findElement(By.xpath("//textarea[@name=\'group_footer\']")).sendKeys("groupfooter");
        driver.findElement(By.xpath("//input[@name=\'submit\']")).click();
        driver.findElement(By.xpath("//a[contains(text(),\'group page\')]")).click();
    }

    private boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    @Test
    public void canCreateGroupWithEmptyName() {
        if (!isElementPresent(By.xpath("//input[@name=\'new\']"))) {
            driver.findElement(By.xpath("//a[contains(text(),'groups')]")).click();
        }
        driver.findElement(By.xpath("//a[contains(text(),'groups')]")).click();
        driver.findElement(By.xpath("//input[@name=\'new\']")).click();
        driver.findElement(By.xpath("//input[@name=\'group_name\']")).click();
        driver.findElement(By.xpath("//input[@name=\'group_name\']")).sendKeys("");
        driver.findElement(By.xpath("//textarea[@name=\'group_header\']")).click();
        driver.findElement(By.xpath("//textarea[@name=\'group_header\']")).sendKeys("");
        driver.findElement(By.xpath("//textarea[@name=\'group_footer\']")).click();
        driver.findElement(By.xpath("//textarea[@name=\'group_footer\']")).sendKeys("");
        driver.findElement(By.xpath("//input[@name=\'submit\']")).click();
        driver.findElement(By.xpath("//a[contains(text(),\'group page\')]")).click();
    }
}
