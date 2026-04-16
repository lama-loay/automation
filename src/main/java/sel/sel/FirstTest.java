package sel.sel;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        try {
            
            driver.get("https://www.google.com");

            WebElement searchbox = driver.findElement(By.name("q"));
            searchbox.sendKeys("Selenium Automation");
            searchbox.submit();

            
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#search h3")));

            
            List<WebElement> results = driver.findElements(By.cssSelector("div#search h3"));

            System.out.println("Top 5 Results in search about selenium:\n");

            int count = 0;

            for (WebElement result : results) {

                if (count == 5) break; 

                try {
                    String title = result.getText();

                    String url = result.findElement(By.xpath("./ancestor::a"))
                                       .getAttribute("href");

                    System.out.println("Result " + (count + 1));
                    System.out.println("Title: " + title);
                    System.out.println("URL: " + url);

                    
                    if (!title.toLowerCase().contains("selenium")) {
                        System.out.println("Warning: Title does not contain Selenium");
                    }

                    System.out.println("-------------------------------------");

                    count++;

                } catch (Exception e) {
                   
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            
            driver.quit();
        }
    }
}