package sel.sel;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstTest {
	 WebDriver driver;

	    @BeforeMethod
	    public void setup() {
	        driver = new ChromeDriver();
	        driver.manage().window();
	        driver.get("https://the-internet.herokuapp.com/login");
	    }

	    //1.Verify Page Title
	    
	    @Test(priority = 0)
	    public void verifyPageTitle() {
	        String title = driver.getTitle();
	        Assert.assertTrue(title.contains("The Internet"));
	    }
	    
	    // 2.Successful Login
	    
	    @Test(priority = 1)
	    public void successfulLogin() {

	        driver.findElement(By.id("username")).sendKeys("tomsmith");
	        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
	        driver.findElement(By.cssSelector("button.radius")).click();

	        WebElement successMsg = driver.findElement(By.id("flash"));

	        Assert.assertTrue(successMsg.getText().contains("You logged into a secure area!"));
	    }
	 // 3. Failed Login (Wrong Password)
	    
	    @Test(priority = 2)
	    public void wrongPasswordLogin() {

	        driver.findElement(By.id("username")).sendKeys("tomsmith");
	        driver.findElement(By.id("password")).sendKeys("wrongPassword");
	        driver.findElement(By.cssSelector("button.radius")).click();

	        WebElement errorMsg = driver.findElement(By.id("flash"));

	        Assert.assertTrue(errorMsg.getText().contains("Your password is invalid!"));

	        // Ensure dashboard is not visible
	        Assert.assertFalse(driver.getCurrentUrl().contains("/secure"));
	    }

	    // 4. Failed Login (Empty Fields)
	    
	    @Test(priority = 3)
	    public void emptyFieldsLogin() {

	        driver.findElement(By.id("username")).sendKeys("");
	        driver.findElement(By.id("password")).sendKeys("");
	        driver.findElement(By.cssSelector("button.radius")).click();

	        WebElement errorMsg = driver.findElement(By.id("flash"));

	        Assert.assertTrue(errorMsg.getText().contains("Your username is invalid!"));
	    }

	    @AfterMethod
	    public void closeBrowser() {
	        driver.quit();
	    }
}