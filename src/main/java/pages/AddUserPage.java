package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddUserPage {
    private WebDriver driver;

    // Locators for form fields
    private By addbutton = By.xpath("//div/button[@class='oxd-button oxd-button--medium oxd-button--secondary']");

    private By userroleField = By.xpath("(//div/div/div[@class='oxd-select-text-input'])[1]");

    private By employeenameField = By.xpath("//input[@placeholder='Type for hints...']");

    private By statusField = By.xpath("(//div/div/div[@class='oxd-select-text-input'])[2]");

    private By usernameField = By.xpath("(//div/input[@class='oxd-input oxd-input--active'])[2]");
    private By passwordField = By.xpath("(//div/input[@class='oxd-input oxd-input--active'])[3]");
    private By confirmpasswoedField = By.xpath("(//div/input[@class='oxd-input oxd-input--active'])[4]");
    private By submitButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");

    public AddUserPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to fill out the form with required data
    public void setaddbutton() {
        WebElement adduser = driver.findElement(addbutton);
        adduser.click();
    }
    public void fillUserData(String username, String password, String copass,String userrole, String empo, String status) {

        WebElement usernameInput = new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(usernameField));
        WebElement userroleInput = driver.findElement(userroleField);
        WebElement employeenameInput = driver.findElement(employeenameField);
        WebElement statusInput = driver.findElement(statusField);
        WebElement passwordInput = driver.findElement(passwordField);
        WebElement confirmpasswoedInput = driver.findElement(confirmpasswoedField);



        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        statusInput.sendKeys(status);
        statusInput.sendKeys(Keys.ENTER);

        userroleInput.sendKeys(userrole);
        userroleInput.sendKeys(Keys.ENTER);
        confirmpasswoedInput.sendKeys(copass);
        employeenameInput.sendKeys(empo);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        employeenameInput.sendKeys(Keys.ARROW_DOWN);
        employeenameInput.sendKeys(Keys.ENTER);

    }

    // Method to submit the form
    public void submitForm() {
        WebElement submitBtn = driver.findElement(submitButton);
        submitBtn.click();
    }
}