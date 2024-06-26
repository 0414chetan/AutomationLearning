package learning;

	import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
	import io.qameta.allure.Step;

    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
	import org.testng.annotations.*;

	import java.io.IOException;

	public class UserRegistrationTest {
	    WebDriver driver;
	    Registerclass userRegistrationPage;

	    @BeforeClass
	    public void setUp() throws IOException {
	        driver = Utilityfiles.getDriver();
	       // Utilityfiles.setExcelFile("src/test/resources/registrationData.xlsx", "Sheet1");
	        userRegistrationPage = new Registerclass(driver);
	    	
	    }

	    @Test
	    @Description("Test for successful user registration")
	    public void testUserRegistration() {
	        launchApplication();
	        navigateToRegistrationPage();
	        enterUserDetails();
	        submitRegistrationForm();
	        verifyRegistration();
	    }

	    @Step("Launch nopCommerce application")
	    public void launchApplication() {
	        driver.get("https://demo.nopcommerce.com/");
	    }

	    @Step("Navigate to the registration page")
	    public void navigateToRegistrationPage() {
	        driver.findElement(By.linkText("Register")).click();
	    }

	    @Step("Enter user details")
	    public void enterUserDetails() {
	        userRegistrationPage.selectGenderMale();
	        userRegistrationPage.enterFirstName("Chetan");
	        userRegistrationPage.enterLastName("Sahu");
	        userRegistrationPage.enterEmail("chetan.sahu0414@gmail.com");
	        userRegistrationPage.enterPassword("123456");
	        userRegistrationPage.enterConfirmPassword("123456");
	    }

	    @Step("Submit the registration form")
	    public void submitRegistrationForm() {
	        userRegistrationPage.clickRegisterButton();
	    }

	    @Step("Verify registration")
	    public void verifyRegistration() {
	        String expectedMessage = "Your registration completed";
	        Assert.assertTrue(userRegistrationPage.getSuccessMessage().contains(expectedMessage),
	                "Registration failed or success message not found");
	        Assert.assertTrue(userRegistrationPage.isMyAccountLinkDisplayed(),
	                "User is not redirected to the account dashboard");
	    }

	    @AfterClass
	    public void tearDown() {
	        Utilityfiles.tearDown();
	    }
	}

