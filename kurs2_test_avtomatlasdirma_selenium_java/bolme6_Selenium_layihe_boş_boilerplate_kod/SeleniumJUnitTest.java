import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SeleniumJUnitTest {

    private WebDriver driver;

    @BeforeAll
    public void setupClass() {
        // ChromeDriver-i avtomatik yükləmək üçün WebDriverManager istifadə olunur
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setupTest() {
        // Brauzeri açırıq
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    @Order(1)
    public void testAcilanSəhifəDüzgünBaşlıq() {
        driver.get("https://example.com");
        String pageTitle = driver.getTitle();
        Assertions.assertEquals("Example Domain", pageTitle, "Səhifə başlığı gözləniləndir.");
    }

    @Test
    @Order(2)
    public void testElementTapmaq() {
        driver.get("https://example.com");
        boolean isElementDisplayed = driver.getPageSource().contains("Example Domain");
        Assertions.assertTrue(isElementDisplayed, "Element səhifədə mövcuddur.");
    }

    @AfterEach
    public void tearDownTest() {
        if (driver != null) {
            driver.quit(); // Brauzeri bağlayır
        }
    }

    @AfterAll
    public void tearDownClass() {
        System.out.println("Test icra prosesi tamamlandı.");
    }
}
