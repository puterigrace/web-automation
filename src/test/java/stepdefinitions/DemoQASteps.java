package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration; // Import Duration

import static org.junit.Assert.*;

public class DemoQASteps {
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Updated constructor

    @Given("I am on the DemoQA homepage")
    public void i_am_on_the_DemoQA_homepage() {
        driver.get("https://demoqa.com");
    }

    @When("I click on the Elements section")
    public void i_click_on_the_Elements_section() {
        WebElement elementsSection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='card-body']/h5[text()='Elements']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementsSection);
        elementsSection.click();
    }

    @When("I click on the Forms section")
    public void i_click_on_the_Forms_section() {
        WebElement elementsSection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='card-body']/h5[text()='Forms']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementsSection);
        elementsSection.click();
        WebElement practiceFormSection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Practice Form']")));
        practiceFormSection.click();

    }



    @Then("I should see the Elements page")
    public void i_should_see_the_Elements_page() {
        WebElement pageHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='card-body']/h5[text()='Elements']")));
        assertTrue(pageHeader.isDisplayed());
        driver.quit();
    }


    @Given("I am on the Forms page")
    public void i_am_on_the_Forms_page() {
        driver.get("https://demoqa.com/forms");
    }

    @When("I fill out the form with valid data")
    public void i_fill_out_the_form_with_valid_data() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName"))).sendKeys("John");
        driver.findElement(By.id("lastName")).sendKeys("Doe");
        driver.findElement(By.id("userEmail")).sendKeys("john.doe@example.com");
        driver.findElement(By.xpath("//label[@for='gender-radio-1']")).click();
        driver.findElement(By.id("userNumber")).sendKeys("081212121212");
        ((JavascriptExecutor) driver).executeScript("document.getElementById('dateOfBirthInput').value = '';");
        driver.findElement(By.id("dateOfBirthInput")).sendKeys("01 Sep 2020");
        driver.findElement(By.id("subjectsInput")).sendKeys("Eng");
    }

    @When("I submit the form")
    public void i_submit_the_form() {
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
        submitButton.click();
    }

    @Then("I should see a success message")
    public void i_should_see_a_success_message() {
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("successMessage")));
        assertTrue(successMessage.isDisplayed());
        driver.quit();
    }

    @Given("I am on the Widgets page")
    public void i_am_on_the_Widgets_page() {
        driver.get("https://demoqa.com/widgets");
    }

    @When("I interact with the Slider")
    public void i_interact_with_the_Slider() {
        WebElement slider = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='range']")));
        slider.sendKeys("50"); // Adjust the value as needed
    }

    @Then("I should see the updated slider value")
    public void i_should_see_the_updated_slider_value() {
        WebElement sliderValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sliderValue")));
        assertEquals("50", sliderValue.getText()); // Adjust the expected value as needed
        driver.quit();
    }


}
