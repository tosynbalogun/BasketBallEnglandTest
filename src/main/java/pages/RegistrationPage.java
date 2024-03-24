package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private final WebDriver driver;

    // Locators should be updated based on actual web elements
    private final By dateOfBirthInput = By.id("dp");
    private final By firstNameInput = By.id("member_firstname");
    private final By lastNameInput = By.id("member_lastname");
    private final By emailInput = By.id("member_emailaddress");
    private final By comfirmEmailAddress = By.id("member_confirmemailaddress");
    private final By passwordInput = By.id("signupunlicenced_password");
    private final By confirmPasswordInput = By.id("signupunlicenced_confirmpassword");
    private final By termsCheckbox = By.id("sign_up_25");
    private final By over18Checkbox = By.id("sign_up_26");
    private final By submitButton = By.id("submit");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterDateOfBirth(String dateOfBirth) {
        driver.findElement(dateOfBirthInput).sendKeys(dateOfBirth);
    }

    public void enterFirstName(String firstName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
    }

    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterConfirmEmail(String confirmEmail) {
        driver.findElement(comfirmEmailAddress).sendKeys(confirmEmail);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        driver.findElement(confirmPasswordInput).sendKeys(confirmPassword);
    }

    public void checkTermsCheckbox() {
        driver.findElement(termsCheckbox).click();
    }

    public void checkOver18Checkbox() {
        driver.findElement(over18Checkbox).click();
    }

    public void submitForm() {
        driver.findElement(submitButton).click();
    }

    public void fillInAllExcept(String fieldName) {
        if (!fieldName.equals("first name")) {
            enterFirstName("John");
        }
        if (!fieldName.equals("last name")) {
            enterLastName("Doe");
        }
        if (!fieldName.equals("email")) {
            enterEmail("john.doe@gmail.com");
        }
        if (!fieldName.equals("confirm email")) {
            enterConfirmEmail("john.doe@gmail.com");
        }
        if (!fieldName.equals("password")) {
            enterPassword("P@ssw0rd");
        }
        if (!fieldName.equals("confirm password")) {
            enterConfirmPassword("P@ssw0rd");
        }
        if (!fieldName.equals("terms")) {
            checkTermsCheckbox();
        }
        if (!fieldName.equals("over 18")) {
            checkOver18Checkbox();
        }
        if (!fieldName.equals("date of birth")) {
            enterDateOfBirth("01/01/2000");
        }
    }
}
