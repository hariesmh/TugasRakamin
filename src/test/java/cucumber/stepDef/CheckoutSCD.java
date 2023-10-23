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

public class CheckoutSCD {



    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";


    @Given("Login Halaman Web Sauce Demo")
    public void LoginHalamanWebSauceDemo() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.setHeadless(false);

        driver = new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @When("Isi Username Terdaftar")
    public void isiUsernameTerdaftar() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("Isi Password Terdaftar")
    public void isiPasswordTerdaftar() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @Then("Tekan Login")
    public void tekanLogin() {
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @And("Berhasil Masuk Inventory")
    public void berhasilMasukInventory() {
        String Masok = driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span")).getText();
        Assert.assertEquals(Masok, "Products");
    }

    @Then("Pilih Barang")
    public void pilihBarang() {
        driver.findElement(By.xpath("//*[@id='item_4_title_link']/div")).click();
    }

    @And("Tekan Add To Cart")
    public void tekanAddToCart() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    @Then("Tombol Add To Cart Berubah")
    public void tombolAddToCartBerubah() {
        String CekTombol = driver.findElement(By.xpath("//*[@id='remove-sauce-labs-backpack']")).getText();
        Assert.assertEquals(CekTombol, "Remove");
    }

    @And("Tekan Tombol Keranjang")
    public void tekanTombolKeranjang() {
        driver.findElement(By.xpath("//*[@id='shopping_cart_container']/a")).click();

    }


    @And("Tekan Tombol Checkout")
    public void tekanTombolCheckout() {
        driver.findElement(By.id("checkout")).click();
    }

    @Then("Isi Form Nama Depan")
    public void isiFormNamaDepan() {
        driver.findElement(By.id("first-name")).sendKeys("Muhammad");
    }

    @And("Isi Form Nama Belakang")
    public void isiFormNamaBelakang() {
        driver.findElement(By.id("last-name")).sendKeys("Haries");
    }

    @And("Isi Kode Pos")
    public void isiKodePos() {
        driver.findElement(By.id("postal-code")).sendKeys("24352");
    }

    @Then("Tekan Continue")
    public void tekanContinue() {
        driver.findElement(By.id("continue")).click();
    }

    @And("Tekan Finish")
    public void tekanFinish() {
        driver.findElement(By.id("finish")).click();
    }

    @Then("Berhasil Checkout")
    public void berhasilCheckout() {
        String FinishCheckout = driver.findElement(By.xpath("//*[@id='checkout_complete_container']/h2")).getText();
        Assert.assertEquals(FinishCheckout, "Thank you for your order!");
    }
}
