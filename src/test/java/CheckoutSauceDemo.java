import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckoutSauceDemo {


    @Test
    public void checkout() throws InterruptedException {
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

        //Cek Keranjang
        driver.findElement(By.xpath("//*[@id='shopping_cart_container']/a")).click();

        //Checkout
        driver.findElement(By.id("checkout")).click();

        //Isi Form
        driver.findElement(By.id("first-name")).sendKeys("Muhammad");
        driver.findElement(By.id("last-name")).sendKeys("Haries");
        driver.findElement(By.id("postal-code")).sendKeys("24352");

        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("finish")).click();

        //Berhasil Checkout
        String FinishCheckout = driver.findElement(By.xpath("//*[@id='checkout_complete_container']/h2")).getText();
        Assert.assertEquals(FinishCheckout, "Thank you for your order!");
    }




}
