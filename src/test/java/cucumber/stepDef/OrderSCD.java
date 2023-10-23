package cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class OrderSCD {


    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";


    @Given("Login Sauce Demo")
    public void loginsaucedemo() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.setHeadless(false);

        driver = new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @When("Isi Username")
    public void isiUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("Isi Password")
    public void isiPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @Then("Tombol Login Di Tekan")
    public void tombolLoginDiTekan() {
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @And("Berhasil masuk")
    public void berhasilMasuk() {
        String Masok = driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span")).getText();
        Assert.assertEquals(Masok, "Products");
    }

    @Then("Klik Item Barang")
    public void klikItemBarang() {
        driver.findElement(By.xpath("//*[@id='item_4_title_link']/div")).click();
    }

    @And("Tekan Tombol Add To Cart")
    public void tekanTombolAddToCart() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    @Then("Tombol Add To Cart Berubah Menjadi Remove")
    public void tombolAddToCartBerubahMenjadiRemove() {
        String CekTombol = driver.findElement(By.xpath("//*[@id='remove-sauce-labs-backpack']")).getText();
        Assert.assertEquals(CekTombol, "Remove");
    }
}
