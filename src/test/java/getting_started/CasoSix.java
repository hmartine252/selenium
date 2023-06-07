package getting_started;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CasoSix {
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
    public void ValidatePqrsTipo() throws InterruptedException{

        WebElement ingresarPQR = driver.findElement(By.xpath("//a[@href='/pqrs']"));
        ingresarPQR.click();
        Thread.sleep(2000);

        WebElement TipoPQR = driver.findElement(By.xpath("//div[@class='mat-form-field-infix ng-tns-c101-7']"));
        TipoPQR.click();
        Thread.sleep(2000);

        List <WebElement> listaPQRs = driver.findElements(By.xpath("//span[@class='mat-option-text']"));
        Thread.sleep(2000);
       List<String> lista = new ArrayList<String>();
        // Agregar elementos a la lista
        lista.add("Devolución");
        lista.add("Felicitación");
        lista.add("Queja / Reclamo");
        lista.add("Retracto");
        lista.add("Sugerencia");
        Thread.sleep(5000);

        boolean equals = true;
        for (int i = 0; i < listaPQRs.size(); i++) {
            if (!listaPQRs.get(i).getText().equals(lista.get(i))){
                equals = false;
                System.out.println("La lista del tipo de gestión no coincide en orden y tamaño con la esperada");
            }

        }
        Assert.assertTrue(equals, "La lista del tipo de gestión no coincide en orden y tamaño con la esperada");
    }


}
