package details;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProductDetails {

    private WebDriver driver;
    private WebDriverWait wait;
    @BeforeMethod
    public void setup(){
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("/home/sharma/Downloads/firefox/firefox");
        driver = new FirefoxDriver(options);

        driver.get("https://www.amazon.in");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void ProductsCheck(){
        try{
            WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
            searchField.sendKeys("Mobile");
            WebElement searchbtn = driver.findElement(By.id("nav-search-submit-button"));
            searchbtn.click();
            WebElement productdetails = driver.findElement(By.cssSelector("a-size-medium a-color-base a-text-normal"));
            productdetails.click();
        } catch (Exception e) {
            Assert.fail("Error Gen:" +e.getMessage());
        }
    }
}
