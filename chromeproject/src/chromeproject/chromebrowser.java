package chromeproject;


	
	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class chromebrowser {

	 public static void main(String[] args) {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\USer\\eclipse-workspace\\chromeproject\\chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("http://localhost:8095/tp1/login");
	  if (driver.findElement(By.xpath("//input[@name='q']")).isEnabled()) {
	   System.out.println("Google search text box Is enabled.");
	   driver.findElement(By.xpath("//input[@name='q']")).sendKeys("WebDriver Test successful.");
	   driver.findElement(By.xpath("//button[@name='btnG']")).click();
	   System.out.println("Google search completed.");
	  } else {
	   System.out.println("Google search test box Is Not enabled.");

	  }
	  driver.close();
	 }
	

}
