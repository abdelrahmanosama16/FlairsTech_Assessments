package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    private By usernameInput = By.name("username");
    private By passwordInput = By.name("password");
    private By loginButton = By.className("oxd-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUsername(String username) {
        WebElement usernameField = new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(usernameInput));
        usernameField.sendKeys(username);
    }

    public void setPassword(String password) {
        WebElement passwordField = driver.findElement(passwordInput);
        passwordField.sendKeys(password);
    }

    public void clickLogin() {
        WebElement loginBtn = driver.findElement(loginButton);
        loginBtn.click();
    }




}
