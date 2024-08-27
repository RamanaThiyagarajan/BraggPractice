package BraggIndia.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class Interview {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.findElement(By.xpath("//tagname[@attribute='value']")); //Xpath
		driver.findElement(By.cssSelector("tagname[attribute='value']")); //CSS
		driver.findElement(By.cssSelector("tagname.classname")); //CSS
		driver.findElement(By.cssSelector("tagname#id")); //CSS
		driver.findElement(By.xpath("//tagname[contains(@attribute,'value')]")); //Regular Expression- XPATH
		driver.findElement(By.cssSelector("tagname[attribute*='value']")); //Regular Expression- CSS
		driver.findElement(By.id("ID value")); //path by ID
		driver.findElement(By.className("Classname value")); //path by class
		driver.findElement(By.linkText("Link text name")); //path by linkText
		driver.findElement(By.name("name value")); //path by Name
		driver.findElement(By.tagName("tagname")); //path by TagName
		driver.findElement(By.xpath("//*[text()='Text name']")); //Xpath for Text
		driver.findElement(By.xpath("//tagname[contains(text(),'link Text')]")); //Xpath for linktext
		driver.findElement(By.partialLinkText("Partial Link Text")); //Partial Link Text
		
		//Relative Locators
		WebElement elementName = driver.findElement(By.xpath("//tagname[@attribute='value']"));
		driver.findElement(with(By.tagName("tagname")).above(elementName)).getText();
		driver.findElement(with(By.tagName("tagname")).below(elementName)).getText();
		driver.findElement(with(By.tagName("tagname")).toLeftOf(elementName)).getText();
		driver.findElement(with(By.tagName("tagname")).toLeftOf(elementName)).getText();
	}

}
