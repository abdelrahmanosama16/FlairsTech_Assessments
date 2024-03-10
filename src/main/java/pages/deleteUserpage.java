package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class deleteUserpage {
    private WebDriver driver;



    public deleteUserpage(WebDriver driver) {
        this.driver = driver;
    }
    public  void deleteUser() {


         By deletebtn = By.xpath("//button[@class='oxd-icon-button oxd-table-cell-action-space'][1]");

         By confirmdeletebtn = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']");

        WebElement delete1 = new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(deletebtn));
        delete1.click();
        WebElement delete2 = driver.findElement(confirmdeletebtn);
        delete2.click();


    }
}
