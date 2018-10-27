package chromeproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class RunTest {
	public static WebDriver WebDriver ;
   
    public static void main (String[] args) throws InterruptedException {
       // Indiquer au système où trouver le pilote chromé
       System.setProperty ("webdriver.chrome.driver", "C:\\Users\\USer\\eclipse-workspace\\chromeproject\\chromedriver.exe");

       // Ouvre le navigateur Chrome
       WebDriver = new ChromeDriver ();

       // Attendre un peu avant de fermer
       Thread.sleep (7000);

       // Fermeture du navigateur et de WebDriver
       WebDriver.close ();
       WebDriver.quit ();
   }
}