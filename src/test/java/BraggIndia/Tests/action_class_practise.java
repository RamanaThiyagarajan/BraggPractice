package BraggIndia.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class action_class_practise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Actions action = new Actions(driver);
		WebElement mouseHover = driver.findElement(By.id("mousehover"));
		action.moveToElement(mouseHover).build().perform();
		driver.findElement(By.xpath("//a[contains(text(),'Top')]")).click();
		js.executeScript("window.scrollBy(0,1000)");
		action.moveToElement(mouseHover).build().perform();
		driver.findElement(By.xpath("//*[text()='Reload']")).click();
		
	}

}
