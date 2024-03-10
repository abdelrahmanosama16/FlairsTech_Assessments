package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import pages.AddUserPage;
import pages.LoginPage;
import pages.AdminPage;
import pages.SearchForUserPage;
import pages.deleteUserpage;
import utils.WebDriverFactory;
import static org.junit.Assert.assertEquals;


public class LoginStepDefs {

    private WebDriver driver;
    private LoginPage loginPage;
    private AdminPage adminPage;
    private AddUserPage addUserPage;
    private deleteUserpage dele;
    private SearchForUserPage searchforuserpage;
    private int numberofrecord,numberofrecordafter,numberofrecordbefore;


    String inc ="Abdelrhman Osama";

    @Given("^I am on the login page$")
    public void navigateToLoginPage() {
        driver = WebDriverFactory.createWebDriver();
        loginPage = new LoginPage(driver);
        driver.get("https://opensource-demo.orangehrmlive.com/");

    }

    @When("^I enter username \"([^\"]*)\" and password \"([^\"]*)\" and click login$")
    public void login(String username, String password) {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickLogin();
    }

    @Then("^I should be on the admin page$")
    public void verifyAdminPage() {

        adminPage = new AdminPage(driver);
        String TitleOfAdmin = adminPage.getAdminTab();
        assertEquals("Admin",TitleOfAdmin);

    }
    @When("^I click on the Admin tab$")
    public void clickAdminTab() {
        adminPage = new AdminPage(driver);
        adminPage.clickAdminTab();
    }
    @And("^I get the number of records before adding a new user$")
    public void getNumberOfRecordsBefore() {


        adminPage = new AdminPage(driver);
         numberofrecord=Integer.parseInt( adminPage.getnumberofrecords().replaceAll("[^0-9]", ""));


    }
    @When("^I add a new user with required data$")
    public void addNewUser() {
        addUserPage = new AddUserPage(driver);
        addUserPage.setaddbutton();
        addUserPage.fillUserData(inc, "password123", "password123","a","a","e");
        addUserPage.submitForm();
    }
    @Then("^I should see the number of records increased by 1$")
    public void verifyRecordIncreased() {


        adminPage = new AdminPage(driver);
         numberofrecordafter=Integer.parseInt( adminPage.getnumberofrecords().replaceAll("[^0-9]", ""));
         if(numberofrecordafter==numberofrecord+1)
        {}
        else
        {throw new RuntimeException();}
    }
    @When("^I search for the new user$")
    public void searchForNewUser() {
        searchforuserpage = new SearchForUserPage(driver);


        searchforuserpage.setUsernameSearchField(inc);

        searchforuserpage.clickSearch();


    }
    @And("^I delete the new user$")
    public void iDeleteTheUserWithUsername() {

        dele = new deleteUserpage(driver);
        dele.deleteUser();
    }

    @Then("^I should see the number of records decreased by 1$")
    public void verifyRecordDecreased() {


        adminPage = new AdminPage(driver);
        adminPage.clickAdminTab();
         numberofrecordbefore =Integer.parseInt( adminPage.getnumberofrecords().replaceAll("[^0-9]", ""));
        if(numberofrecordbefore==numberofrecord)
        {}
        else
        {throw new RuntimeException();}

    }


}