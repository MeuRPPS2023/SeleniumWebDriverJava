package automacaoSelenium.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    public static WebDriver driver;
    public static final String CAMINHO_DRIVER = "src/test/java/automacaoSelenium/resource/chromedriver.exe";

    @BeforeClass
    public static void inicializar() {
        System.setProperty("webdriver.chromedriver.driver", CAMINHO_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void finalizar() {
        driver.quit();
    }
}
