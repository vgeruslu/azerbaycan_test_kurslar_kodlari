package az.atg.test_kurslari.ders27_exceptionler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static KitabxanalarLibs.TestKitabxana.*;

public class ExceptionMisallar {
    static WebDriver sürücü;

    public static void main(String[] args) {
        // Veb brauzer sürücüsünü işə salırıq
        WebDriverManager.chromedriver().setup();

        // Selenium brauzer sürücüsünü işə salırıq
        sürücü = new ChromeDriver();
        brauzerin_mövqe_və_ölçüsünü_dəyiş(sürücü, -550, 50, 500, 800);
        try {
            sürücü.navigate().to("file:///D:/Code/Azerbaijan_Code/azerbaycan_test_kurslar_kodlari/" +
                    "kurs2_test_avtomatlasdirma_selenium_java/bolme5_selenium/src/main/java/az/atg/test_kurslari/" +
                    "ders27_exceptionler/sade_login_sehifesi.html");
            ekran_loqunda_yaz("Səhifə açıldı");

            WebElement istifadəçi_adı_mətn_qutusu = sürücü.findElement(
                By.xpath("//*[@name = 'istifadəçi_adı']"));
            // digər Selenium kodları
            istifadəçi_adı_mətn_qutusu.sendKeys("istifadəçi@gmail.com");
            ekran_loqunda_yaz("✅ Heç bir Exception baş vermədi...");

            Thread.sleep(8000);
            // Brauzeri bağlayırıq
            sürücü.quit();
            ekran_loqunda_yaz("Brauzeri bağladım...");

        } catch (NoSuchElementException e) {
            // Bu Exception baş verdikdə bu mesaj çap ediləcək
            ekran_loqunda_yaz("❌Xəta: Test kodunda təqdim etdiyiniz lokatorla ekranda heç bir element tapılmadı.");
            MP3_oyna("Xəta. Test kodunda təqdim etdiyiniz lokatorla ekranda heç bir element tapılmadı.");
        }
        catch (ElementNotInteractableException e) {
            // Bu Exception baş verdikdə, bu mesaj çap ediləcək
            ekran_loqunda_yaz("❌Xəta: İstisna halı baş verdi. Element ilə əlaqə mümkün deyil. " +
                    "Element görünmür və ya aktiv deyil.");
            MP3_oyna("İstisna halı baş verdi-Element ilə əlaqə qurulması mümkün deyil");
        }
        catch (Exception e) {
            // digər Exception
            ekran_loqunda_yaz("❌Xəta: Başqa bir istisna hal (eksepşın) baş verdi: " + e.getMessage());
            MP3_oyna("Başqa bir istisna hal (eksepşın) baş verdi");
        }


    } // end func
} // end class
