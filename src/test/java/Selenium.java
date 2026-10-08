import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Selenium {

    WebDriver driver;

    @BeforeEach
    void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterEach
    void finish() {
        driver.quit();//driver.close();
    }

    @Test
    @DisplayName("Deve poder cadastrar um ponto de doação")
    void createPoint() {

        //Login
        driver.get("https://petlov.vercel.app/signup");

        //Chekpoint
        WebElement title = driver.findElement(By.cssSelector("h1"));

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(d -> title.isDisplayed());

        assertEquals("Cadastro de ponto de doação", title.getText(), "Verificando o Slogan");

        //Inspecionar Elementos
        WebElement name = driver.findElement(By.cssSelector("input[placeholder='Nome do ponto de doação']"));
        name.sendKeys("Mariana Point");

        WebElement email = driver.findElement(By.cssSelector("input[name=email]"));
        email.sendKeys("mariana@gmail.com");

        WebElement cep = driver.findElement(By.cssSelector("input[name=cep]"));
        cep.sendKeys("31930250");

        WebElement cepButton = driver.findElement(By.cssSelector("input[value='Buscar CEP']"));
        cepButton.click();

        WebElement nameAddress = driver.findElement(By.cssSelector("input[name='addressNumber']"));
        nameAddress.sendKeys("1000");

        WebElement details = driver.findElement(By.cssSelector("input[name='addressDetails']"));
        details.sendKeys("Ao lado da padaria");

        //Pets para adoção
        driver.findElement(By.xpath("//span[text()=\"Cachorros\"]/..")).click();

        //Cadastrar
        driver.findElement(By.className("button-register")).click();

        //Cadastro realizado com sucesso
        WebElement result = driver.findElement(By.cssSelector("success-page p"));
        Wait<WebDriver> waitResult = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitResult.until(d -> result.isDisplayed());

        String target = "Seu ponto de doação foi adicionado com sucesso. Juntos, podemos criar um mundo onde todos os animais recebam o amor e cuidado que merecem.";
        assertEquals(target.trim(), result.getText().trim(), "Verificar a mensagem de sucesso.");
    }
}
