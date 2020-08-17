package Steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

@RunWith(Cucumber.class)
public class ProperForm {
    WebDriver driver;
    String browser = "chrome";
    String company = "My company";

    @Given("^User is on site \"([^\"]*)\"$")
    public void user_is_on_site_something(String url) {
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equals("opera")) {
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
        } else if (browser.equals("ie")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.get(url);
    }

    @When("^User fill Pełna nazwa firmy$")
    public void user_fill_pena_nazwa_firmy() {
        driver.findElement(By.id("user_register_company_name")).sendKeys(company);
    }

    @Then("^User is registered$")
    public void user_is_registered() {


    }

    @And("^User fill Email$")
    public void user_fill_email() {
    }

    @And("^User fill Imię i nazwysko$")
    public void user_fill_imi_i_nazwysko() {
    }

    @And("^User fill Polish phone number$")
    public void user_fill_polish_phone_number() {
    }

    @And("^User fill 8 digit long password$")
    public void user_fill_8_digit_long_password() {
    }

    @And("^User click on Zapoznałem się z regulaminem checkbox$")
    public void user_click_on_zapoznaem_si_z_regulaminem_checkbox() {
    }

    @And("^User click on second checkbox$")
    public void user_click_on_second_checkbox() {
    }

    @And("^User click Zarejestruj button$")
    public void user_click_zarejestruj_button() {
    }

}