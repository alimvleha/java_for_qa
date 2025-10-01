package manager;

import model.GroupData;
import org.openqa.selenium.By;

public class GroupHelper {

    private final ApplicationManager manager;

    public GroupHelper(ApplicationManager manager) {
        this.manager = manager;
    }

    public void openGroupsPage() {
        if (!manager.isElementPresent(By.xpath("//input[@name=\'new\']"))) {
            manager.driver.findElement(By.xpath("//a[contains(text(),'groups')]")).click();
        }
    }

    public boolean isGroupPresent() {
        openGroupsPage();
        return manager.isElementPresent(By.name("selected[]"));
    }

    public void createGroup(GroupData group) {
        openGroupsPage();
        manager.driver.findElement(By.xpath("//a[contains(text(),'groups')]")).click();
        manager.driver.findElement(By.xpath("//input[@name=\'new\']")).click();
        manager.driver.findElement(By.xpath("//input[@name=\'group_name\']")).click();
        manager.driver.findElement(By.xpath("//input[@name=\'group_name\']")).sendKeys(group.name());
        manager.driver.findElement(By.xpath("//textarea[@name=\'group_header\']")).click();
        manager.driver.findElement(By.xpath("//textarea[@name=\'group_header\']")).sendKeys(group.header());
        manager.driver.findElement(By.xpath("//textarea[@name=\'group_footer\']")).click();
        manager.driver.findElement(By.xpath("//textarea[@name=\'group_footer\']")).sendKeys(group.footer());
        manager.driver.findElement(By.xpath("//input[@name=\'submit\']")).click();
        manager.driver.findElement(By.xpath("//a[contains(text(),\'group page\')]")).click();
    }

    public void removeGroup() {
        openGroupsPage();
        manager.driver.findElement(By.xpath("//a[contains(text(),\'groups\')]")).click();
        manager.driver.findElement(By.name("selected[]")).click();
        manager.driver.findElement(By.xpath("(//input[@name=\'delete\'])[2]")).click();
        manager.driver.findElement(By.xpath("//a[contains(text(),\'group page\')]")).click();
    }
}
