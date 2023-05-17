package getting_started;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

import static java.time.Duration.ofSeconds;


public class Ejercicio1{
    public WebDriver driver;

    @BeforeClass
    public void setUp() {

        driver = new ChromeDriver();
        driver.get("https://pre.jelpit.com/");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterClass
    public void teardown() {
        System.out.println("test run successful");
        driver.quit();
    }

    @Test
    public void primerEjercicio() throws InterruptedException {
        String title = driver.getTitle();

        WebElement imgLogin = driver.findElement(By.xpath("//span[@class='icon-icono_usuario']"));
        imgLogin.click();
        Thread.sleep(5000);


        WebElement txtEmail = driver.findElement(By.xpath("//input[@id='loginInMail']"));
        txtEmail.sendKeys("martha.oyuela.morales@segurosbolivar.com");
        Thread.sleep(1000);
        WebElement txtPassword = driver.findElement(By.id("loginInPass"));
        txtPassword.sendKeys( "Mora2023les*");
        Thread.sleep(1000);

        WebElement btnLogin = driver.findElement(By.id("loginUser"));
        btnLogin.click();

        String validarUser = driver.findElement(By.xpath("//span[@class='icon-icono_usuario']//following-sibling::span[@class='txt_link']")).getText();
        System.out.println (validarUser);
        Thread.sleep(6000);
        Assert.assertEquals(validarUser,"Hola Martha");
    }
}
