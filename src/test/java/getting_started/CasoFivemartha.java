package getting_started;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CasoFiveMartha {
    public WebDriver driver;

    @BeforeClass
    public void setUp() {

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // Especifica la cantidad de tiempo que el controlador debe esperar al buscar un elemento si no está presente de inmediato.

        driver.get("https://pre.jelpit.com/");

        driver.manage().window().maximize();
    }

    @AfterClass
    public void teardown() {
        System.out.println("test run successful");
        driver.quit();
    }

    @Test
    public void ValidatePQRS() throws InterruptedException {

        WebElement botonTienesDudas = driver.findElement(By.xpath("//a[@href='/pqrs']"));
        botonTienesDudas.click();
        Thread.sleep(2000);

        WebElement name = driver.findElement(By.xpath("//input[@id='mat-input-0']"));
        name.sendKeys("Martha Oyuela");

        WebElement typeDocument = driver.findElement(By.xpath("//mat-select[@id='mat-select-0']"));
        typeDocument.click();
        Thread.sleep(1000);

        List<WebElement> listTypeDocument = driver.findElements(By.xpath("//div[@id='mat-select-0-panel']//descendant::span"));
        for (int i = 0; i < listTypeDocument.size(); i++) {
            //System.out.println(listTypeDocument.get(i).getText());
            if (listTypeDocument.get(i).getText().equals("Cédula de ciudadanía")) {
                listTypeDocument.get(i).click();
                break;
            }
        }
        Thread.sleep(1000);

        WebElement numDocument = driver.findElement(By.xpath("//input[@id='mat-input-1']"));
        numDocument.sendKeys("65588781");
        Thread.sleep(1000);

        WebElement email = driver.findElement(By.xpath("//input[@id='mat-input-2']"));
        email.sendKeys("martha1678@yopmail.com");
        Thread.sleep(1000);

        WebElement checkEmail = driver.findElement(By.xpath("//input[@id='mat-input-3']"));
        checkEmail.sendKeys("martha1678@yopmail.com");
        Thread.sleep(1000);

        WebElement cellphone = driver.findElement(By.xpath("//input[@id='mat-input-4']"));
        cellphone.clear();
        cellphone.sendKeys("3105589799");
        Thread.sleep(1000);

        WebElement typeGestion = driver.findElement(By.xpath("//mat-select[@id='mat-select-2']"));
        typeGestion.click();
        Thread.sleep(1000);

        List<WebElement> listTypeGestion = driver.findElements(By.xpath("//div[@id='mat-select-2-panel']//descendant::span"));
        for (int i = 0; i < listTypeGestion.size(); i++) {
            //System.out.println(listTypeGestion.get(i).getText());
            if (listTypeGestion.get(i).getText().equals("Sugerencia")) {
                listTypeGestion.get(i).click();
                break;
            }
        }
        Thread.sleep(1000);

        WebElement service = driver.findElement(By.xpath("//mat-select[@id='mat-select-4']"));
        service.click();
        Thread.sleep(3000);

        List<WebElement> listService = driver.findElements(By.xpath("//div[@id='mat-select-4-panel']//descendant::span"));
        for (int i = 0; i < listService.size(); i++) {
            //System.out.println(listService.get(i).getText());
            if (listService.get(i).getText().equals("Aseo en casa")) {
                listService.get(i).click();
                break;
            }
        }
        Thread.sleep(1000);

        WebElement textArea = driver.findElement(By.id("mat-input-5"));
        textArea.sendKeys("caso five martha");
        Thread.sleep(1000);

        WebElement send = driver.findElement(By.xpath("//button[@class='mat-focus-indicator custom-button mat-raised-button mat-button-base custom-button-ready']"));
        send.click();
        Thread.sleep(5000);

        WebElement confirmation = driver.findElement(By.xpath("//mat-card-content[@class='mat-card-content']//child::div[1]"));
        String confirmationSuccess = confirmation.getText();
        Assert.assertEquals(confirmationSuccess, "¡Tu solicitud ha sido radicada con éxito!");

    }


}
