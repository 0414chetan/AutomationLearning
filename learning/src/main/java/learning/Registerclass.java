package learning;
	
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;

	public class Registerclass {
		
	   private static WebDriver driver;

	    public Registerclass(WebDriver driver) {
	        this.driver = driver;
	    }

	    private By genderMale = By.id("gender-male");
	    private By firstName = By.id("FirstName");
	    private By lastName = By.id("LastName");
	    private By email = By.id("Email");
	    private By password = By.id("Password");
	    private By confirmPassword = By.id("ConfirmPassword");
	    private By registerButton = By.id("register-button");
	    private By successMessage = By.className("result");
	    private By myAccountLink = By.linkText("My account");

	    public void selectGenderMale() {
	        WebDriverUtils.click(driver, genderMale);
	       
	    }

	    public void enterFirstName(String fName) {
	        WebDriverUtils.sendKeys(driver, firstName, fName);
	    }

	    public void enterLastName(String lName) {
	        WebDriverUtils.sendKeys(driver, lastName, lName);
	    }

	    public void enterEmail(String emailAddr) {
	        WebDriverUtils.sendKeys(driver, email, emailAddr);
	    }

	    public void enterPassword(String pwd) {
	        WebDriverUtils.sendKeys(driver, password, pwd);
	    }

	    public void enterConfirmPassword(String confirmPwd) {
	        WebDriverUtils.sendKeys(driver, confirmPassword, confirmPwd);
	    }

	    public void clickRegisterButton() {
	        WebDriverUtils.click(driver, registerButton);
	    }

	    public String getSuccessMessage() {
	        return WebDriverUtils.getText(driver, successMessage);
	    }

	    public boolean isMyAccountLinkDisplayed() {
	        return WebDriverUtils.isDisplayed(driver, myAccountLink);
	    }
	}



