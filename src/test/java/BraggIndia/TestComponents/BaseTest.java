package BraggIndia.TestComponents;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import BraggIndia.pageobjects.LandingPage;



public class BaseTest {

	public WebDriver driver;
	public LandingPage Lp;
	public WebDriver InitializeDriver() {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D://Automation path//BraggIndia//chromedriver.exe");		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;

	}
	
	public List<HashMap<String, String>> getJsontoMap(String filepath) throws IOException {
		//JSON to String
		String jsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir")+ filepath), StandardCharsets.UTF_8);
		
		//String to HashMap
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){
		});
		return data;
	}
	
	public String getScreenshot(String testcasename, WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") +"//reports" +testcasename +".png");
		FileUtils.copyFile(Source, file);
		return System.getProperty("user.dir")+"//reports" + testcasename +".png";
		
	}
	
	@BeforeMethod
	public void  LaunchApplication() {
		driver = InitializeDriver();
		Lp = new LandingPage(driver);
		Lp.goTo();
		Lp.ClientLoginPage();
		
		
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
