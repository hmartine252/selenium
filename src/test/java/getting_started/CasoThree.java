package getting_started;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CasoThree {
    public WebDriver driver;

    @BeforeClass
    public void setUp() {

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // Especifica la cantidad de tiempo que el controlador debe esperar al buscar un elemento si no está presente de inmediato.

        driver.get("https://demoqa.com/select-menu");

        driver.manage().window().maximize();
    }

    @AfterClass
    public void teardown() {
        System.out.println("test run successful");
        driver.quit();
    }

    @Test
    public void ValidateDocumentType() throws InterruptedException{


        List <WebElement> listaDocumentos = Collections.singletonList(driver.findElement(By.id("oldSelectMenu")));

        List<String> lista = new ArrayList<String>();
        // Agregar elementos a la lista
        lista.add("Red");
        lista.add("Green");
        lista.add("Yellow");
        lista.add("Divide");
        lista.add("Concatenate");

            boolean equals = true;
        for (int i = 0; i < listaDocumentos.size(); i++) {
            if (!listaDocumentos.get(i).getText().equals(lista.get(i))){
                equals = false;
                System.out.println("La lista de tipos de documentos no coincide en orden y tamaño con la esperada");
            }

            Assert.assertTrue(equals, "La lista de tipos de documentos no coincide en orden y tamaño con la esperada");
        }

        /*
        WebElement pass = driver.findElement(By.id("loginInPass"));
        pass.sendKeys("Prueba12");
        Thread.sleep(1000);

        WebElement ingresar = driver.findElement(By.id("loginUser"));
        /// prueba
        ingresar.submit();
        Thread.sleep(6000);

        WebElement linkBienvenida = driver.findElement(By.linkText("Hola Alejandra"));
        String bienvenida = linkBienvenida.getText();
        Assert.assertEquals(bienvenida, "Hola Alejandra");
        System.out.println(bienvenida);
     */
    }


}
