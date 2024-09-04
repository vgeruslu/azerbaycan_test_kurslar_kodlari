package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

public class Main {
    static WebDriver driver;
    
    private static boolean IsElementVisibleInViewport(WebElement element) {
        //WebDriver driver = ((RemoteWebElement)element).GetWrappedDriver();

        return
        (boolean)((JavascriptExecutor) driver).executeScript(
            "var elem = arguments[0], "+
            "box = elem.getBoundingClientRect(), "+
            "cx = box.left + box.width / 2,  "+
            "cy = box.top + box.height / 2, "+
            "e = document.elementFromPoint(cx, cy); "+
            "for (; e; e = e.parentElement) "+
            "     { if (e === elem) return true;}"+ 
            "return false;", 
        element);
    }
    
    public static void TC_məhsul_axtar() {
        // setup = quraşdırma
        WebElement axtarış_mətn_qutusu = driver.findElement(By.xpath("//*[@name = 'name' and not (contains(@class, 'search-bar-input-mobile'))]"));
        WebElement axtarış_düyməsi = driver.findElement(By.xpath("(//*[@class = 'input-group-append-overlay search_button'])[1]"));

        // exercise = icra etmək
        axtarış_mətn_qutusu.sendKeys("Samovar");
        axtarış_düyməsi.click();

        // verify = yoxlamaq
        List<WebElement> butov_tapılan_məhsullar = driver.findElements(
                By.xpath("//*[@id= 'ajax-products']//div[contains (@class, 'product-card')] "));

        for(int məhsul_index= 0; məhsul_index<butov_tapılan_məhsullar.size(); məhsul_index++) {
            WebElement məhsul = butov_tapılan_məhsullar.get(məhsul_index);
            
            WebElement məhsul_qiymeti_span = driver.findElement(
                    By.xpath("(//div[contains (@class, 'product-card')]//div[contains (@class, 'product-price')]//span)[" + (məhsul_index+1) + "]"));
            //məhsul_qiymeti.
            String məhsul_qiymeti = məhsul_qiymeti_span.getAttribute("innerHTML");
            məhsul_qiymeti = məhsul_qiymeti.replaceAll("\\s+","");
            System.out.println("məhsul_qiymeti = " + məhsul_qiymeti);
            
            if (!IsElementVisibleInViewport(məhsul)) 
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
        // teardown = təmizləmək


    }

    public static void TC_login() {
        WebElement istifadeciAdi = driver.findElement(By.id("txtUserName"));
        WebElement Şifrə = driver.findElement(By.id("txtPassword"));

        istifadeciAdi.sendKeys("vgarousi@gmail.com");
        Şifrə.sendKeys("");
    }
    public static void main(String[] args) {
        System.out.println("Salam dünya və Salam Test Otomasyon");
        WebDriverManager.chromedriver().setup();

        try {
            driver = new ChromeDriver();
            driver.get("https://www.hamisiburada.az/");
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

            TC_məhsul_axtar();
        }
         catch (Exception e) {
             System.out.println("Test otomasyon baglandi ve ya diger bir problem....");
        }
    }
}