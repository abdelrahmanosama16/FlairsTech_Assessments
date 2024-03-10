package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage {
    private WebDriver driver;
    private By adminTab = By.xpath("//ul/li[@class='oxd-main-menu-item-wrapper'][1]");

    private By recordsCount = By.xpath("//div/span[@class='oxd-text oxd-text--span']");

    public AdminPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getAdminTab() {

        WebElement adminTabElement = new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(adminTab)); // Adjust this selector
        //adminTabElement.getText();
        //WebElement adminTabElement = driver.findElement(adminTab);
       return adminTabElement.getText();
    }

    public void clickAdminTab() {
        WebElement adminTabElement = driver.findElement(adminTab);
        adminTabElement.click();
    }

    public String getnumberofrecords(){
        WebElement adminrecordTabElement =new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(recordsCount)); // Adjust this selector
        adminrecordTabElement.getText();
        //WebElement adminrecordTabElement = driver.findElement(recordsCount);
        return adminrecordTabElement.getText();
    }
}
