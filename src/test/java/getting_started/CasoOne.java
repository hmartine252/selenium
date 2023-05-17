package getting_started;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CasoOne {
    public WebDriver driver;

    @BeforeClass
    public void setUp() {

        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");

    }

    @AfterClass
    public void teardown() {
        System.out.println("test run successful");
        driver.quit();
    }

    @Test
    public void loginScuccess() {
        String title = driver.getTitle();
        Assert.assertEquals("The Internet", title);

        WebElement searchBox = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
        WebElement searchButton = driver.findElement(By.name("btnK"));

        searchBox.sendKeys("Selenium");
        searchButton.click();

        WebElement titulo = new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4")));
        String titleCompleto = titulo.getText();

        Assert.assertEquals(titleCompleto, "Secure Area");
    }
}
