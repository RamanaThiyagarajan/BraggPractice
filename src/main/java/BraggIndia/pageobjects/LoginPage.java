package BraggIndia.pageobjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BraggIndia.AbstractComponents.AbstractComponent;

public class LoginPage extends AbstractComponent {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "user_login")
	WebElement userName;

	@FindBy(id = "user_pass")
	WebElement passWord;

	@FindBy(css = "[class*='tml-button']")
	WebElement Login;

	@FindBy(css = "[class*='tml-error']")
	WebElement errorMessage;

	public void switchtoClientLoginWindow() throws InterruptedException {

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow);
		Thread.sleep(5000);

	}

	public void LoginActions(String username, String password) {
		
		userName.sendKeys(username);
		passWord.sendKeys(password);
		Login.click();

	}

	public String getErrorMessage() {
		waitForTheElementToAppear(errorMessage);
		String errormessage = errorMessage.getText();
		return errormessage;

	}

}
