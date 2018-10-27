package StepDefinition;

import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.firefox.FirefoxDriver;		

import cucumber.api.java.en.Given;		
import cucumber.api.java.en.Then;		
import cucumber.api.java.en.When;		

public class Steps {				

    WebDriver driver;			
    		
    @Given("^Open the Firefox and launch the application$")					
    public void open_the_Firefox_and_launch_the_application() throws Throwable																	
    {		
       System.setProperty("webdriver.gecko.driver","C:\\Users\\USer\\eclipse-workspace\\tp1\\src\\geckodriver.exe");					
       driver= new FirefoxDriver();					
       driver.manage().window().maximize();			
       driver.get("http://localhost:8095/tp1/login");					
    }		

    @When("^Enter the Username (\\w*)and Password (\\w*)$")			
    public void enter_the_Username_and_Password(String nom,String passwd) throws Throwable 							
    {		
       driver.findElement(By.name("nom")).sendKeys(nom);					
       driver.findElement(By.name("passwd")).sendKeys(passwd);					
    }		

    @Then("^Submit the credential$")					
    public void	Reset_the_credential() throws Throwable 							
    {		
       driver.findElement(By.name("submit")).click();					
    }		
}		