package BraggIndia.Tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class table_validation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	//	.table-display td:nth-child(3)
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		
		List<WebElement> courseTable = driver.findElements(By.cssSelector(".table-display td:nth-child(3)"));
		
		int sum= 0;
		for(int i=0; i<courseTable.size(); i++) {
			
			sum = sum + Integer.parseInt(courseTable.get(i).getText());
		}
		System.out.println(sum);
		
		driver.close();

	}

}
