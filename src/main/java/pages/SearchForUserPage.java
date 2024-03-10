package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchForUserPage {
    private WebDriver driver;
    private By UsernameSearchField = By.xpath("(//div/input)[2]");
    private By SearchButton = By.xpath("(//button)[5]");

    public SearchForUserPage(WebDriver driver) {
        this.driver = driver;
    }
    public void setUsernameSearchField (String username) {
        WebElement usernameField = new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(UsernameSearchField));
        usernameField.sendKeys(username);
    }
    public void clickSearch() {
        WebElement SearchBtn = driver.findElement(SearchButton);
        SearchBtn.click();
    }




}
