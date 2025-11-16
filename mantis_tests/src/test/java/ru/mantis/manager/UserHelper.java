package ru.mantis.manager;

import org.openqa.selenium.By;
import ru.mantis.model.UserData;

import java.time.Duration;
import java.util.regex.Pattern;

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

    private void fillConfirmUserForm(UserData user) {
        type(By.xpath("//input[@id='password']"), user.userPassword());
        type(By.xpath("//input[@id='password-confirm']"), user.confirmUserPassword());
    }

    public void updateConfirmUserForm() {
        click(By.xpath("//form[@id='account-update-form']/fieldset/span/button/span"));
    }

    public String extractConfirmUrl(String email, String password) {
        var messages = manager.mail().receive(email, password, Duration.ofSeconds(30));
        var text = messages.get(0).content();
        var pattern = Pattern.compile("http://\\S+");
        var matcher = pattern.matcher(text);
        if (matcher.find()) {
            var url = text.substring(matcher.start(), matcher.end());
            System.out.println("Ссылка для подтверждения регистрации: " + url);
            return url;
        }
        throw new RuntimeException("Письмо не пришло или ссылка не пришла");
    }

    public void openUrlConfirm(String email, String password) {
        var confirmationUrl = extractConfirmUrl(email, password);
        manager.driver().get(confirmationUrl);
    }

    public void createNewUserAccount(UserData user) {
        openManagePage();
        openManagePagaeUsersForm();
        createNewUser();
        fillUserForm(user);
        saveUser();
    }

    public void confirmUserAccount(String email, String password, UserData user) {
        openUrlConfirm(email, password);
        fillConfirmUserForm(user);
        updateConfirmUserForm();
    }
}

