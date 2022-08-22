package Form;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertTrue;

public class StepForm {

    WebDriver driver;

    @Given("^Open the chrome and launch demo eCommerce web application$")
    public void Open_the_chrome_and_launch_demo_eCommerce_web_application() throws Throwable {
//        System.out.println("This is step user open the chrome and launch demo eCommerce web application");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
//        Assert URL Endpoint
        String urlRedirect = driver.getCurrentUrl();
        String urlExpected = "https://rahulshettyacademy.com/angularpractice/";
        System.out.println("URL nya "+ urlRedirect);
        Assert.assertEquals(urlRedirect, urlExpected);
//        Assert Title
        String titleProtoCommerce = driver.getTitle();
        String titleExpected = "ProtoCommerce";
        System.out.println("Title " +titleProtoCommerce);
        Assert.assertEquals(titleProtoCommerce, titleExpected);
        Thread.sleep(2000);
    }

    @When("^User entered data in demo eCommerce web application field$")
    public void User_entered_data_in_demo_eCommerce_web_application_field() throws Throwable {
//        System.out.println("This is step when user entered data");
        driver.findElement(By.xpath("/html/body/app-root/form-comp/div/form/div[1]/input")).sendKeys("Indra Purnomo");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/app-root/form-comp/div/form/div[2]/input")).sendKeys("indra@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("semoga");
        Thread.sleep(2000);
//        Select and Assert Checkbox
        WebElement checkboxIceCreams = driver.findElement(By.id("exampleCheck1"));
        checkboxIceCreams.click();
        System.out.println("Check me out if you Love IceCreams! checkbox is selected "+ checkboxIceCreams.isSelected());
        Assert.assertTrue(driver.findElement(By.id("exampleCheck1")).isSelected());
        Thread.sleep(2000);
//        Select and Assert Dropdown Male
        WebElement dropdownMale = driver.findElement(By.id("exampleFormControlSelect1"));
        dropdownMale.click();
        System.out.println("Gender Male is selected "+ dropdownMale.isSelected());
        Assert.assertEquals(dropdownMale, dropdownMale);
        Thread.sleep(2000);
//        Select and Assert Radio Button Employed
        WebElement radioEmployed = driver.findElement(By.id("inlineRadio2"));
        radioEmployed.click();
        System.out.println("Employed radio button is selected "+ radioEmployed.isSelected());
        Assert.assertTrue(driver.findElement(By.id("inlineRadio2")).isSelected());
        Thread.sleep(2000);
//        Assert Disabled Radio Button
        WebElement radioEntrepreneur = driver.findElement(By.id("inlineRadio3"));
        boolean selectEntrepreneur = radioEntrepreneur.isEnabled();
        if (!selectEntrepreneur) {
            radioEntrepreneur.click();
        }
        System.out.println("Assert disabled radio button "+ radioEntrepreneur.isEnabled());
        Assert.assertEquals(radioEntrepreneur, radioEntrepreneur);
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/app-root/form-comp/div/form/div[7]/input")).sendKeys("10101995");
        Thread.sleep(2000);
    }

    @And("^User click Submit button$")
    public void User_click_Submit_button() throws Throwable {
//        System.out.println("This is step user click Submit button");
        driver.findElement(By.xpath("/html/body/app-root/form-comp/div/form/input")).click();
        Thread.sleep(2000);
    }

    @Then("^User successfully submitted the form$")
    public void User_successfully_submitted_the_form() throws Throwable {
//        System.out.println("This is step user successfully submitted the form");
        String actualString = driver.findElement(By.xpath("/html/body/app-root/form-comp/div/div[2]/div")).getText();
        assertTrue(actualString.contains("Success! The Form has been submitted successfully!."));
        Thread.sleep(2000);
//        Assert Data
        String actualData = driver.findElement(By.xpath("/html/body/app-root/form-comp/div/h4")).getText();
        assertTrue(actualData.contains("Two-way Data Binding example:"));
//        Assert Name
        WebElement nameIndraPurnomo = driver.findElement(By.xpath("/html/body/app-root/form-comp/div/h4/input"));
        nameIndraPurnomo.isDisplayed();
        System.out.println("Name Indra Purnomo is displayed "+ nameIndraPurnomo.isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/app-root/form-comp/div/h4/input")).isDisplayed());


    }
}
