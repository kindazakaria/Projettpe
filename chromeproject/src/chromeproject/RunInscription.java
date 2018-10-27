package chromeproject;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RunInscription {public static WebDriver WebDriver ;

 public static void main (String[] args) throws InterruptedException {
    // Indiquer au système où trouver le pilote chromé
	 System.setProperty ("webdriver.chrome.driver", "C:\\Users\\USer\\eclipse-workspace\\chromeproject\\chromedriver.exe");

    // Ouvre le navigateur Chrome
    WebDriver = new ChromeDriver ();

    // Agrandir la fenêtre du navigateur
    WebDriver.manage (). window (). maximize ();
    
    
    if (testBibliothequeinscription ()) {
        System.out.println ("Test Bibliothèque inscription: Réussi");
    } else {
        System.out.println ("Test Bibliothèque inscription: Échec");

    }

    // Ferme le navigateur et WebDriver
  // WebDriver.close ();
   //WebDriver.quit ();
}

private static boolean testBibliothequeinscription () {
    try {
    	//String name ="";
    	//String surname ="";
        //String password="";
        //Scanner saisi = new Scanner(System.in);
       // System.out.println("Veuillez entrer le user:");
       // name = saisi.nextLine();
        
       // System.out.println("Veuillez entrer le mot de passe:");
        //password= saisi.nextLine();
    	
        // Ouvrir google.com
        WebDriver.navigate().to ("http://localhost:8095/tp1/login");

        // Tapez le nom d'utilisateur
        WebDriver.findElement (By.name("nom")). sendKeys ("zak");

        // Tapez le prenom
        WebDriver.findElement (By.name ("prenom")). sendKeys ("kinda");
        
        // Tapez le lieu de naissance
        WebDriver.findElement (By.name ("naissance")). sendKeys ("Hanoi");
        
        // Tapez le status
        WebDriver.findElement (By.name ("status")). sendKeys ("Visiteur");
        
        // Tapez le mot de passe
        WebDriver.findElement (By.name ("password")). sendKeys ("test");

        // Cliquez sur le bouton Soumettre
        WebDriver.findElement (By.name("submit")).click();

        // Attends un peu (7000 millisecondes)
        Thread.sleep (700);

        // Vérifie si le h1 est égal à "Dashboard"
       // if (WebDriver.findElement (By.tagName ("h1")). getText ()
         //       .equals ("Accueil")) {
            return true;
        //} else {
          //  return false;
        //}

    // Si quelque chose ne va pas, retourne false.
    } catch (Exception e) {
        //System.out.println (e.getClass (). ToString ());
    	System.out.println ("Erreur");
        return false;
    }
}
}