package loginfunctionalitycheck;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginCheck {

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
    public void testLogin(){
        try{
            WebElement signButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-link-accountList")));
            signButton.click();
            WebElement emailField = driver.findElement(By.id("ap_email"));
            emailField.sendKeys("akki18829@gmail.com");
            WebElement loginButton = driver.findElement(By.id("continue"));
            loginButton.click();
            WebElement passwordField = driver.findElement(By.id("ap_password"));
            passwordField.sendKeys("ankit1718");
            WebElement siButton = driver.findElement(By.id("signInSubmit"));
            siButton.click();
        } catch (Exception e) {
            Assert.fail("Error Gen:" +e.getMessage());
        }
    }

    @AfterMethod
    public void tearDown(){
        if (driver != null){
            driver.close();
        }
    }
}
