package Definition;

 

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
 
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Registr {				

    WebDriver driver;			
    		
    @Given("^I am on a new user registration page$")					
    public void open_the_Firefox_and_launch_the_application() throws Throwable																	
    {		
       System.setProperty("webdriver.gecko.driver","C:\\Users\\USer\\eclipse-workspace\\tp1\\src\\geckodriver.exe");					
       driver= new FirefoxDriver();					
       driver.manage().window().maximize();			
       driver.get("http://localhost:8095/tp1/inscription");					
    }		

    @When("^Enter Username (\\w*) Surname (\\w*) lieunais (\\w*) status (\\w*) passwd (\\w*) birthday (\\d+)$")			
    public void enter_Username_Surname_lieunais_status_passwd_birthday(String nom,String prenom,String lieun,String stat,String passwd,String datenaissance) throws Throwable							
    {	
    	driver.findElement(By.name("nom")).sendKeys(nom);
    	driver.findElement(By.name("prenom")).sendKeys(prenom);
    	driver.findElement(By.name("lieun")).sendKeys(lieun);
        driver.findElement(By.name("stat")).sendKeys(stat);
        driver.findElement(By.name("motp")).sendKeys(passwd);     
        driver.findElement(By.name("datn")).sendKeys("2018-09-29"); 
        //driver.findElement(By.name("reg_passwd__")).sendKeys(); 
        
      //Select dropdownB = new Select(driver.findElement(By.name("datn"))); 
      //dropdownB.selectByValue(datenaissance); 
  		
       // Select dropdownM = new Select(driver.findElement(By.name("birthday_month")));
      //  dropdownM.selectByValue("6"); 
  		
       // Select dropdownY = new Select(driver.findElement(By.name("birthday_year")));
      //  dropdownY.selectByValue("1990"); 
  		
       // driver.findElement(By.className("_58mt")).click(); 
    }

    @Then("^the user registration should be unsuccessful$")					
    							
    public void User_registration_should_be_unsuccessful() {
    	driver.findElement(By.name("submit")).click();
       // if(driver.getCurrentUrl().equalsIgnoreCase("https://www.facebook.com/")){
         //  System.out.println("Test Pass"); 
        //} else { 
        //   System.out.println("Test Failed"); 
       // } 
       // driver.close(); 
     } 
  }