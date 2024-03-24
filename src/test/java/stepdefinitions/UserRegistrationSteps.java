package stepdefinitions;

import org.junit.Assert;
import pages.RegistrationPage;
import utils.WebDriverUtil;
import utils.WaitUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class UserRegistrationSteps {

    private RegistrationPage registrationPage;
    private WebDriver driver;
    private WaitUtil waitUtil;

    @Before
    public void setup() {
        // Use WebDriverUtil to initialize driver based on desired browser type
        driver = WebDriverUtil.getDriver("chrome"); // or "firefox", read from config ideally
        registrationPage = new RegistrationPage(driver);
        waitUtil = new WaitUtil(driver, 10); // 10 seconds wait time
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @And("I attempt to submit the form")
    public void iAttemptToSubmitTheForm() {
        registrationPage.submitForm();
    }

    @And("I should see a message indicating the last name is required")
    public void iShouldSeeAMessageIndicatingTheLastNameIsRequired() {
        WebElement lastNameError = waitUtil.waitForElementToBeVisible(By.id("member_lastname-error"));
        Assert.assertEquals("Last Name is required", lastNameError.getText());
    }

    @When("I fill in all required fields")
    public void iFillInAllRequiredFields() {
        registrationPage.fillInAllExcept("");
    }

    @And("I should see a message indicating the passwords do not match")
    public void iShouldSeeAMessageIndicatingThePasswordsDoNotMatch() {
        WebElement passwordError = waitUtil.waitForElementToBeVisible(By.id("signupunlicenced_confirmpassword-error"));
        Assert.assertEquals("Passwords do not match", passwordError.getText());
    }

    @And("I do not accept the terms and conditions")
    public void iDoNotAcceptTheTermsAndConditions() {
        registrationPage.fillInAllExcept("terms");
    }

    @And("I should see a message indicating terms and conditions acceptance is required")
    public void iShouldSeeAMessageIndicatingTermsAndConditionsAcceptanceIsRequired() {
        WebElement termsError = waitUtil.waitForElementToBeVisible(By.id("sign_up_25-error"));
        Assert.assertEquals("You must accept the terms and conditions", termsError.getText());
    }

    @Then("I should be successfully registered")
    public void iShouldBeSuccessfullyRegistered() {
        WebElement successMessage = waitUtil.waitForElementToBeVisible(By.id("success-message"));
        Assert.assertEquals("Account successfully created", successMessage.getText());
    }

    @And("I should be redirected to the account dashboard")
    public void iShouldBeRedirectedToTheAccountDashboard() {
        WebElement dashboardHeader = waitUtil.waitForElementToBeVisible(By.tagName("h1"));
        Assert.assertEquals("Account Dashboard", dashboardHeader.getText());
    }

    @Given("I am on the New Supporter Account registration page")
    public void iAmOnTheNewSupporterAccountRegistrationPage() {
        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount");
    }

    @Then("I should be prevented from creating an account")
    public void iShouldBePreventedFromCreatingAnAccount() {
        WebElement errorMessage = waitUtil.waitForElementToBeVisible(By.id("error-message"));
        Assert.assertEquals("An error occurred. Please try again later.", errorMessage.getText());
    }

    @When("I fill in all required fields except for the Last Name")
    public void iFillInAllRequiredFieldsExceptForTheLastName() {
        registrationPage.fillInAllExcept("last name");
    }

    @And("I enter Password and ConfirmPassword that do not match")
    public void iEnterPasswordAndConfirmPasswordThatDoNotMatch() {
        registrationPage.enterPassword("password123");
        registrationPage.enterConfirmPassword("password456");
    }

    @When("I fill in all required fields including First Name, Last Name, Email, Password, and accept the terms and conditions")
    public void iFillInAllRequiredFieldsIncludingFirstNameLastNameEmailPasswordAndAcceptTheTermsAndConditions() {
        registrationPage.fillInAllExcept("");
    }
}
