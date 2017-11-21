package testcases;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.cucumber.listener.Reporter;
import base.TestBase;
import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.LoginPage;


public class LogInTest extends TestBase{
	   
    LoginPage loginObj;
    Scenario scenario;
    
	@Before
    public void beforeScenario(){
        initialization();
    }
	
	@After
    public void afterScenario(Scenario scenario) throws IOException{
        
		if (scenario.isFailed()) {
				
		//Without sdf, screnshot will only go in Extent report
			
		//SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss");
		//Timestamp timestamp = new Timestamp(System.currentTimeMillis());	
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);	
		
		
		FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\extent-report\\screenshot.png")); 
		//FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\extent-report\\"+sdf.format(timestamp)+".png")); 
		//FileUtils.copyFile(src, new File("../extent-report"+sdf.format(timestamp)+".png")); 
		
		
		Reporter.addScreenCaptureFromPath("../extent-report/screenshot.png");
		//Reporter.addScreenCaptureFromPath(System.getProperty("user.dir")+"\\Screenshot\\"+sdf.format(timestamp)+".png");
		
		
		}
			
      if (driver != null) {
      driver.quit();
      }
   }
    
    @Then("^print test case started$")
    public void print_test_case_started() throws Throwable {
       System.out.println("Test case started");
    }
    	
	@Given("^I am on CRM login page$")
	public void i_am_on_CRM_login_page() throws Throwable {
	    
		loginObj = new LoginPage();
	}

	@When("^I enter valid username and password and click on Login button$")
	public void i_enter_invalid_username_and_password() throws Throwable {
	    
		loginObj.login();
	}

	@Then("^I should successfully login$")
	public void i_should_successfully_login() throws Throwable {
		
		System.out.println("Login successful");
	}
	
	@When("^I enter invalid username and invalid password and click on Login button$")
	public void i_enter_invalid_username_and_invalid_password_and_click_on_Login_button() throws Throwable {
	    
		driver.findElement(By.name("username")).sendKeys("kunal");
		driver.findElement(By.name("password")).sendKeys("test");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}

	@Then("^I should not be able to login$")
	public void i_should_not_be_able_to_login() throws Throwable {
	   
		System.out.println("Not able to login");
	}
	
	@When("^I enter valid username as \"(.*)\" and password as \"(.*)\" and click on Login button$")
	public void i_enter_valid_username_as_and_password_as_and_click_on_Login_button(String username, String password) throws Throwable {

		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
    }
	
	@When("^I enter following for login$")
	public void i_enter_following_for_login(DataTable table) throws Throwable {
	 
		List<List<String>> data = table.raw();
		driver.findElement(By.name("username")).sendKeys(data.get(1).get(0));
		driver.findElement(By.name("password")).sendKeys(data.get(1).get(1));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}
	
	@When("^I enter (.*) and ([^\"]*) for login$")
	public void i_enter_Username_and_test_for_login(String Username, String Password) throws Throwable {
		
		driver.findElement(By.name("username")).sendKeys(Username);
		driver.findElement(By.name("password")).sendKeys(Password);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}
}