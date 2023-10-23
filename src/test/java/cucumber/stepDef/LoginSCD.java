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

public class LoginSCD {

    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";


    @Given("Halaman Login Sauce Demo")
    public void halaman_login_sauce_demo() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.setHeadless(false);

        driver = new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @When("Input Username")
    public void input_username() {

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("Input Password")
    public void input_password() {

        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("Menekan tombol Login")
    public void menekan_tombol_login() {

        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @Then("Pengguna berhasil masuk")
    public void pengguna_berhasil_masuk() {
        String Masok = driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span")).getText();
        Assert.assertEquals(Masok, "Products");
    }
}
