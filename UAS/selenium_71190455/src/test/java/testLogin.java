import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class testLogin {
    ChromeDriver driver;
    @Given("browser opened")
    public void browser_opened() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Inside Step - Buka  Browser");
        System.setProperty("webdriver.chrome.driver",
                Objects.requireNonNull(getClass().getClassLoader().getResource("driver/chromedriver.exe")).getFile());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
    }
    @Given("user in register page")
    public void user_in_register_page() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Inside Step - pengguna di halaman register");
        driver.navigate().to("https://demo.guru99.com/insurance/v1/register.php");
    }
    @Given("user in login page")
    public void user_in_login_page() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Inside Step - pengguna di halaman login");
        driver.findElement(By.xpath("/html/body/div[3]/a")).click();
    }
    @When("^user insert (.*) and (.*)$")
    public void user_insert_uname_and_password(String uname,String password) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Inside Step - penggna memasukkan namapengguna dan sandi");
        driver.findElement(By.name("email")).sendKeys(uname);
        driver.findElement(By.name("password")).sendKeys(password);
    }
    @When("login button clicked")
    public void login_button_clicked() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Inside Step - tombol login ditekan");
        driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[3]/input")).click();
    }
    @Then("user redirect to main screen")
    public void user_redirect_to_main_screen() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Inside Step - pengguna menuju ke halaman login");
        List<WebElement> list=driver.findElements(By.xpath("/html/body/div[3]/form/input"));
        Assertions.assertTrue(list.size()>0,"text No Found 1");
        driver.close();
        driver.quit();
    }
//"//*[contains(text(),'"+"Log out"+"')]"
}
