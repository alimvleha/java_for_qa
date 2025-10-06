package manager;

import model.GroupData;
import org.openqa.selenium.By;

public class GroupHelper extends HelperBase {

    public GroupHelper(ApplicationManager manager) {
        super(manager);
    }

    public void openGroupsPage() {
        if (!manager.isElementPresent(By.xpath("//input[@name=\'new\']"))) {
            click(By.xpath("//a[contains(text(),'groups')]"));
        }
    }

    public void createGroup(GroupData group) {
        openGroupsPage();
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        returnToGroupsPage();
    }

    public void removeGroup() {
        openGroupsPage();
        selectGroup();
        removeSelectedGroups();
        returnToGroupsPage();
    }

    public void modifyGroup(GroupData modifiedGroup) {
        openGroupsPage();
        selectGroup();
        initGroupModification();
        fillGroupForm(modifiedGroup);
        submitGroupModification();
        returnToGroupsPage();

    }


    private void fillGroupForm(GroupData group) {
        type(By.xpath("//input[@name=\'group_name\']"), group.name());
        type(By.xpath("//textarea[@name=\'group_header\']"), group.header());
        type(By.xpath("//textarea[@name=\'group_footer\']"), group.footer());

    }


    private void initGroupModification() {
        click(By.name("edit"));

    }

    private void selectGroup() {
        click(By.name("selected[]"));

    }

    private void submitGroupCreation() {
        click(By.xpath("//input[@name=\'submit\']"));
    }


    private void initGroupCreation() {
        click(By.xpath("//input[@name=\'new\']"));
    }

    private void removeSelectedGroups() {
        click(By.xpath("(//input[@name=\'delete\'])[2]"));
    }

    private void returnToGroupsPage() {
        click(By.xpath("//a[contains(text(),\'group page\')]"));

    }

    private void submitGroupModification() {
        click(By.name("update"));

    }

    public int getCount() {
        openGroupsPage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    public void removeAllGroups() {
        openGroupsPage();
        selectAllGroups();
        removeSelectedGroups();
    }

    private void selectAllGroups() {
        var checkboxes = manager.driver.findElements(By.name("selected[]"));
        for (var checkbox : checkboxes) {
            checkbox.click();
        }
    }
}
