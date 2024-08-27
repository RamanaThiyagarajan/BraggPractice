package BraggIndia.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BraggIndia.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "a.button.transparent.icon-profile")
	WebElement clientLogin;
	
	@FindBy(css="div.cmplz-cookiebanner-inner")
	WebElement cookieAlertBox;
	
	@FindBy(css= "button.cmplz-btn.cmplz-accept")
	WebElement acceptbutton;

	public void ClientLoginPage() {
		clientLogin.click();
		 

	}
	
	public void goTo() {
		driver.get("https://bragg.group/");
		waitForTheElementToAppear(cookieAlertBox);
		acceptbutton.click();
	}

}
