import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;


public class FailedLoginSauceDemo {
    @Test
    public void Failed_Login() throws InterruptedException {
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";
        WebDriverManager.chromedriver().setup();

        // apply chrome driver setup
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("1234sauce");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        //driver.findElement(By.id("login-button")).click();

        String Gagal = driver.findElement(By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3")).getText();
        Assert.assertEquals(Gagal, "Epic sadface: Username and password do not match any user in this service");

    }
}
