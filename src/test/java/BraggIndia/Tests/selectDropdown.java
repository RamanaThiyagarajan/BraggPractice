package BraggIndia.Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class selectDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement dropdownOptions = driver.findElement(By.xpath("//*[@id='dropdown-class-example']"));
		
		Select dropdown = new Select(dropdownOptions);
		
		dropdown.selectByVisibleText("Option2");
		
		System.out.println(dropdown.getFirstSelectedOption());
		driver.close();
		
	}

}
