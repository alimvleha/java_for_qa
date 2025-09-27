import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestsBase {
    protected static WebDriver driver;

    protected static void removeGroup() {
        driver.findElement(By.xpath("//a[contains(text(),\'groups\')]")).click();
        driver.findElement(By.name("selected[]")).click();
        driver.findElement(By.xpath("(//input[@name=\'delete\'])[2]")).click();
        driver.findElement(By.xpath("//a[contains(text(),\'group page\')]")).click();
    }

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

    protected boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    protected void createGroup(String groupname, String groupheader, String groupfooter) {
        driver.findElement(By.xpath("//a[contains(text(),'groups')]")).click();
        driver.findElement(By.xpath("//input[@name=\'new\']")).click();
        driver.findElement(By.xpath("//input[@name=\'group_name\']")).click();
        driver.findElement(By.xpath("//input[@name=\'group_name\']")).sendKeys(groupname);
        driver.findElement(By.xpath("//textarea[@name=\'group_header\']")).click();
        driver.findElement(By.xpath("//textarea[@name=\'group_header\']")).sendKeys(groupheader);
        driver.findElement(By.xpath("//textarea[@name=\'group_footer\']")).click();
        driver.findElement(By.xpath("//textarea[@name=\'group_footer\']")).sendKeys(groupfooter);
        driver.findElement(By.xpath("//input[@name=\'submit\']")).click();
        driver.findElement(By.xpath("//a[contains(text(),\'group page\')]")).click();
    }

    protected void openGroupsPage() {
        if (!isElementPresent(By.xpath("//input[@name=\'new\']"))) {
            driver.findElement(By.xpath("//a[contains(text(),'groups')]")).click();
        }
    }

    protected boolean isGroupPresent() {
        return isElementPresent(By.name("selected[]"));
    }
}
