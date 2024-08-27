package BraggIndia.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BraggIndia.TestComponents.BaseTest;
import BraggIndia.TestComponents.Retry;
import BraggIndia.pageobjects.LoginPage;


public class ErrorValidation extends BaseTest{

	@Test(dataProvider = "getData")
	public void ErrorMessageValidation(HashMap<String,String> input) throws InterruptedException {
		// TODO Auto-generated method stub
         
		
		LaunchApplication();
		LoginPage Lop = new LoginPage(driver);
		Lop.switchtoClientLoginWindow();
		//Thread.sleep(5000);
		Lop.LoginActions(input.get("username"), input.get("password"));
		Assert.assertEquals("Error: The username "+ input.get("username") +" is not registered on this site. If you are unsure of your username, try your email address instead.", Lop.getErrorMessage());
	}
	
	@DataProvider
	public Object[] getData() throws IOException {
		
		List<HashMap<String, String>> data = getJsontoMap("//src//test//java//BraggIndia//data//datas.json");
		return new Object[][] {{data.get(0)}, {data.get(1)}};
	}

}
