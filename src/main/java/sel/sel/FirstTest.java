package sel.sel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class FirstTest {
	public static void main(String[] args) {

        //  Open Chrome browser
        WebDriver driver = new ChromeDriver();

        // Open login page
       driver.get("https://the-internet.herokuapp.com/login");

        // Locate username field using ID locator
        WebElement username = driver.findElement(By.id("username"));

        // Locate password field using ID locator
        WebElement password = driver.findElement(By.id("password"));

        // Locate login button using CSS selector
        WebElement loginButton = driver.findElement(By.cssSelector("button.radius"));

        //  Enter correct username
        username.sendKeys("tomsmith");

        //  Enter correct password
        password.sendKeys("SuperSecretPassword!");

        //  Click login button
        loginButton.click();

        //  Locate success message using XPath
        WebElement successMessage = driver.findElement(By.xpath("//*[@id='flash']"));

        //  Print success message in console
        System.out.println("Success message: " + successMessage.getText());
        

////////part 2 using wrong data

        //  Open login page again
        driver.get("https://the-internet.herokuapp.com/login");

        //  Locate elements again
        WebElement username2 = driver.findElement(By.id("username"));
        
        WebElement password2 = driver.findElement(By.id("password"));
        
        WebElement loginButton2 = driver.findElement(By.cssSelector("button.radius"));

        //  Enter wrong username
        username2.sendKeys("wronguser");

        // Enter wrong password
        password2.sendKeys("wrongpassword");

        //  Click login
        loginButton2.click();

        // Locate error message
        WebElement errorMessage = driver.findElement(By.id("flash"));

        //  Print error message
        System.out.println("Error message: " + errorMessage.getText());

        //  Close browser
       // driver.quit();
    }
}