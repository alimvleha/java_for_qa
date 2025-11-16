package ru.mantis.manager;

import org.openqa.selenium.By;
import ru.mantis.model.UserData;

public class UserHelper extends HelperBase {
    public UserHelper(ApplicationManager manager) {
        super(manager);
    }


    public void openManagePage() {
        click(By.xpath("//div[@id='sidebar']/ul/li[6]/a/i"));
    }

    public void openManagePagaeUsersForm() {
        click(By.xpath("(//a[contains(text(),'Users')])[2]"));
    }

    public void createNewUser() {
        click(By.xpath("//a[contains(text(),'Create New Account')]"));
    }

    public void saveUser() {
        click(By.xpath("//input[@value='Create User']"));
    }

    private void fillUserForm(UserData user) {
        type(By.xpath("//input[@id='user-username']"), user.username());
        type(By.xpath("//input[@id='user-realname']"), user.realName());
        type(By.xpath("//input[@id='email-field']"), user.email());

    }

    public void createNewUserAccount(UserData user) {
        openManagePage();
        openManagePagaeUsersForm();
        createNewUser();
        fillUserForm(user);
        saveUser();
    }
}

