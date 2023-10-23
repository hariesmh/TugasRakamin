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

public class FailedLoginSCD {

    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";


    @Given("Halaman Login")
    public void failed_login() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.setHeadless(false);

        driver = new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @When("Masukkan Username")
    public void masukkanUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("Masukkan Password Salah")
    public void masukkanPasswordSalah() {
        driver.findElement(By.id("password")).sendKeys("1234sauce");
    }

    @And("Tekan Tombol Login")
    public void tekanTombolLogin() {
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @Then("Pengguna gagal masuk")
    public void penggunaGagalMasuk() {
        String Gagal = driver.findElement(By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3")).getText();
        Assert.assertEquals(Gagal, "Epic sadface: Username and password do not match any user in this service");

    }
}