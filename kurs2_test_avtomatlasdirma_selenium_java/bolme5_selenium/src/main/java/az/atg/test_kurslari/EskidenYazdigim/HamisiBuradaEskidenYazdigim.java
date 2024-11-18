package az.atg.test_kurslari.EskidenYazdigim;

import KitabxanalarLibs.TestKitabxana;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

public class HamisiBuradaEskidenYazdigim {
    static WebDriver driver;

    public static void test_hal_məhsul_axtar() {
        // 1-setup = quraşdırma
        WebElement axtarış_mətn_qutusu = driver.findElement(By.xpath("//*[@name = 'name' and not (contains(@class, 'search-bar-input-mobile'))]"));
        WebElement axtarış_düyməsi = driver.findElement(By.xpath("(//*[@class = 'input-group-append-overlay search_button'])[1]"));

        // 2-exercise = icra etmək
        axtarış_mətn_qutusu.sendKeys("Samovar");
        axtarış_düyməsi.click();

        // 3-verify = yoxlamaq
        List<WebElement> butov_tapılan_məhsullar = driver.findElements(
                By.xpath("//*[@id= 'ajax-products']//div[contains (@class, 'product-card')] "));

        for (int məhsul_index = 0; məhsul_index < butov_tapılan_məhsullar.size(); məhsul_index++) {
            WebElement məhsul = butov_tapılan_məhsullar.get(məhsul_index);

            WebElement məhsul_qiymeti_span = driver.findElement(
                    By.xpath("(//div[contains (@class, 'product-card')]//div[contains (@class, 'product-price')]//span)[" + (məhsul_index + 1) + "]"));
            //məhsul_qiymeti
            String məhsul_qiymeti = məhsul_qiymeti_span.getAttribute("innerHTML");
            məhsul_qiymeti = məhsul_qiymeti.replaceAll("\\s+", "");
            System.out.println("məhsul_qiymeti = " + məhsul_qiymeti);

            if (!TestKitabxana.IsElementVisibleInViewport(driver, məhsul))
                ((JavascriptExecutor) driver).executeScript(
                        "arguments[0].scrollIntoView();", məhsul);

            ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='2px solid red'", məhsul);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='2px solid white'", məhsul);

        }
        // 4-teardown = təmizləmək
        // bu test heç yeni data sistemə yükləmiyib,
        // ona görə heç "təmizləmək" ehtiyac deyil
    }

    //------------------------------------------------------------------
    public static void TC_login() {
        WebElement istifadeciAdi = driver.findElement(By.id("txtUserName"));
        WebElement Şifrə = driver.findElement(By.id("txtPassword"));

        istifadeciAdi.sendKeys("vgarousi@gmail.com");
        Şifrə.sendKeys("");
    }
    //------------------------------------------------------------------
    public static void test_suite_calisdir() {
        test_hal_məhsul_axtar();
    }
    //------------------------------------------------------------------
    public static void main(String[] args) {
        System.out.println("Salam dünya və Salam Test Otomasyon");
        WebDriverManager.chromedriver().setup();

        try {
            driver = new ChromeDriver();
            driver.get("https://www.hamisiburada.az/");
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

            test_suite_calisdir();
        } catch (Exception e) {
            System.out.println("Test otomasyon baglandi ve ya diger bir problem....");
        }
    } // end main

}// end class