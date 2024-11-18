package az.atg.test_kurslari.ders18_ilk_testimiz;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SalamDunyaTesti {

    public static void main(String[] args) {
        System.out.println("Salam dünya və Salam Test Avtomatlaşdırma !");
        WebDriverManager.chromedriver().setup();

        // Chrome brauzerini işə salırıq
        WebDriver sürücü = new ChromeDriver();

        try {
            // Test üçün sadə bir səhifə açırıq
            sürücü.get("https://az.wikipedia.org");

            // Səhifənin başlığını yoxlayırıq
            String başlıq = sürücü.getTitle();
            if (başlıq.contains("Vikipediya")) {
                System.out.println("✅ Test uğurla keçdi: Səhifənin başlığı gözlənildiyi kimidir.");
            } else {
                System.out.println("❌ Test uğursuz oldu: Başlıq fərqlidir -> " + başlıq);
            }
        } catch (Exception e) {
            System.out.println("❌ Testdə gözlənilməyən bir istisna halı (Exception) baş verdi: " + e.getMessage());
        } finally {
            // hər vəziyyətdə bu hissə "finally" icra olacaq
            // Brauzeri bağlayırıq
            sürücü.quit();
        }
    }
}
