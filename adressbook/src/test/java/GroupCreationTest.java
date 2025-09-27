import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import java.util.*;
public class GroupCreationTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new FirefoxDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void test() {
    driver.get("http://localhost/addressbook/");
    driver.manage().window().setSize(new Dimension(1167, 863));
    driver.findElement(By.xpath("//input[@name=\'user\']")).click();
    driver.findElement(By.xpath("//input[@name=\'user\']")).sendKeys("admin");
    driver.findElement(By.xpath("//input[@name=\'pass\']")).click();
    driver.findElement(By.xpath("//input[@name=\'pass\']")).sendKeys("secret");
    driver.findElement(By.name("pass")).sendKeys(Keys.ENTER);
    driver.findElement(By.xpath("//input[@value=\'Login\']")).click();
    driver.findElement(By.xpath("//a[contains(.,'groups')]")).click();
    driver.findElement(By.xpath("//input[@name=\'new\']")).click();
    driver.findElement(By.xpath("//input[@name=\'group_name\']")).click();
    driver.findElement(By.xpath("//input[@name=\'group_name\']")).sendKeys("groupname");
    driver.findElement(By.xpath("//textarea[@name=\'group_header\']")).click();
    driver.findElement(By.xpath("//textarea[@name=\'group_header\']")).sendKeys("groupheader");
    driver.findElement(By.xpath("//textarea[@name=\'group_footer\']")).click();
    driver.findElement(By.xpath("//textarea[@name=\'group_footer\']")).sendKeys("groupfooter");
    driver.findElement(By.xpath("//input[@name=\'submit\']")).click();
    driver.findElement(By.xpath("//a[contains(text(),\'group page\')]")).click();
    driver.findElement(By.xpath("//a[contains(text(),\'Logout\')]")).click();
  }
}
