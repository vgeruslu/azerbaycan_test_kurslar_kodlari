package az.atg.test_kurslari.ders18_ilk_testimiz;

import KitabxanalarLibs.TestKitabxana;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SalamDunyaWikipediaTesti {

    public static void main(String[] args) {
        System.out.println("Salam dünya və Salam Test Avtomatlaşdırma !");
        WebDriverManager.chromedriver().setup();

        // Chrome brauzerini işə salırıq
        WebDriver sürücü = new ChromeDriver();
        TestKitabxana.brauzerin_mövqe_və_ölçüsünü_dəyiş(sürücü, -1000, 100, 1000, 600);

        try {
            // Test üçün sadə bir səhifə açırıq
            sürücü.get("https://az.wikipedia.org");

            // Səhifənin başlığını yoxlayırıq
            String səhifə_başlığı = sürücü.getTitle();
            if (səhifə_başlığı.contains("Vikipediya")) {
                System.out.println("✅ Test uğurla keçdi: Səhifənin başlığı gözlənildiyi kimidir. səhifə_başlığı = "
                        + səhifə_başlığı);
            } else {
                System.out.println("❌ Test uğursuz oldu: Başlıq fərqlidir -> " + səhifə_başlığı);
            }
        } catch (Exception e) {
            System.out.println("❌ Testdə gözlənilməyən bir istisna halı (Exception) baş verdi: " + e.getMessage());
        } finally {
            // hər vəziyyətdə bu hissə "finally" icra olacaq
            // Brauzeri bağlayırıq
            //sürücü.quit();
        }
    }
}
