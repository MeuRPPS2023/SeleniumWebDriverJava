package automacaoSelenium.page;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePO {
    public WebDriver driver;
    public final WebDriverWait wait;

    public BasePO(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    /**
     * Obtém o título da página e imprime no console
     * 
     * @return
     */
    public String ObterTituloPagina(String tituloEsperado) {
        String titulo = driver.getTitle();
        assertEquals(tituloEsperado, titulo);
        assert titulo != null : "O título da página é nulo.";
        System.out.println("Título da página: " + titulo);
        return titulo;
    }

    /**
     * Imprime o nome do WebElement no console
     * 
     * @param elemento
     */
    public void systemResult(String elemento) {
        System.out.println("Texto do Elemento: " + elemento);
    }

    /**
     * Imprime o nome do WebElement dentro de um frame no console
     * 
     * @param frame
     * @param elemento
     */
    public void systemResultFrame(WebElement frame, WebElement elemento) {
        driver.switchTo().frame(frame);
        System.out.println("Elemento: " + elemento.getAccessibleName());
    }

    /**
     * Aguarda até que o elemento seja visível na página
     * 
     * @param elemento
     */
    public void delay(WebElement elemento) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(elemento));
        elemento.isDisplayed();
        elemento.isEnabled();
        elemento.getText().isEmpty();
    }

    /**
     * Aguarda até que o elemento seja visível na página e, em seguida, clica nele
     * 
     * @param elemento
     */
    public void delayClick(WebElement elemento) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(elemento));
        elemento.isDisplayed();
        elemento.isEnabled();
        elemento.click();
    }

    public boolean esperarSumirElemento(WebElement elemento) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(
                ExpectedConditions.invisibilityOf(elemento));
    }

    public void retornarTelaPrincial() {
        String janelaPrincipal = driver.getWindowHandle();
        driver.switchTo().window(janelaPrincipal);
    }

}
