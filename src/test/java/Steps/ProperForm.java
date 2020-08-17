package Steps;

import cucumber.api.PendingException;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.runner.Request;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.logging.Level;

@RunWith(Cucumber.class)
public class ProperForm {
    WebDriver driver;
    String browser = "chrome";
    String company = "My company";
    String email = "email@email.com";
    String name = "Jan Kowalski";
    String phone = "123456789";
    String password = "12345678";

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

    @And("^User fill Email$")
    public void user_fill_email() {
        driver.findElement(By.id("user_register_email")).sendKeys(email);
    }

    @And("^User fill Imię i nazwysko$")
    public void user_fill_imi_i_nazwysko() {
        driver.findElement(By.id("user_register_name")).sendKeys(name);
    }

    @And("^User fill phone number$")
    public void user_fill_phone_number() {
        driver.findElement(By.id("user_register_phone")).sendKeys(phone);
    }

    @And("^User fill 8 digit long password$")
    public void user_fill_8_digit_long_password() {
        driver.findElement(By.id("user_register_plainPassword")).sendKeys(password);
    }

    @And("^User click on Zapoznałem się z regulaminem checkbox$")
    public void user_click_on_zapoznaem_si_z_regulaminem_checkbox() {
        driver.findElement(By.id("user_register_settings_agreementRegulations")).click();
    }

    @And("^User click on second checkbox$")
    public void user_click_on_second_checkbox() {
        driver.findElement(By.id("user_register_settings_agreementPersonalData")).click();

    }

    @And("^User click Zarejestruj button$")
    public void user_click_zarejestruj_button() {
        driver.findElement(By.id("user_register_submit")).click();
    }

    @Then("^User is registered$")
    public void user_is_registered() throws IOException, InterruptedException {
        /** check HTTP response
         URL url = new URL("https://dev-1.clicktrans.pl/register-test/courier");
         HttpURLConnection connection = (HttpURLConnection)url.openConnection();
         connection.setRequestMethod("POST");
         connection.connect();
         int code = connection.getResponseCode();
         System.out.println(code);
         **/
        driver.findElement(By.xpath("/html/body/div[6]/div"));
    }
}

