import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrderSauceDemo {

    @Test
    public void orderr() throws InterruptedException {
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();

        // apply chrome driver setup
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        //driver.findElement(By.id("login-button")).click();

        String Masok = driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span")).getText();
        Assert.assertEquals(Masok, "Products");

        driver.findElement(By.xpath("//*[@id='item_4_title_link']/div")).click();

        //Masukin Keranjang
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        String CekTombol = driver.findElement(By.xpath("//*[@id='remove-sauce-labs-backpack']")).getText();
        Assert.assertEquals(CekTombol, "Remove");
    }



}
