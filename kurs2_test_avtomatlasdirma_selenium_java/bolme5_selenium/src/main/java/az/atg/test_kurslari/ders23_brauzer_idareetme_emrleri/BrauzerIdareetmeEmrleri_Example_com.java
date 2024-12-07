package az.atg.test_kurslari.ders23_brauzer_idareetme_emrleri;

import KitabxanalarLibs.TestKitabxana;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BrauzerIdareetmeEmrleri_Example_com {

    public static void main(String[] args) {
        // WebDriver manager dən ChromeDriver istəyirik
        WebDriverManager.chromedriver().setup();

        // Brauzer sürücüsünü işə salırıq
        WebDriver sürücü = new ChromeDriver();
        TestKitabxana.brauzerin_mövqe_və_ölçüsünü_dəyiş(sürücü, -1000, 100, 1000, 600);

        try {
            // get(String url)
            // 1. Verilən URL-i açırıq
            sürücü.get("https://aztu.edu.azzzz");
            System.out.println("Səhifə uğurla açılmış.");

            // getTitle()
            // 2. Cari səhifənin başlığını əldə edirik
            TestKitabxana.MP3_oyna("Səhifənin başlığını oxuyub və yoxlayıram");
            String başlıq = sürücü.getTitle();
            System.out.println("Səhifənin başlığı: " + başlıq);
            // YOXLAMA
            assertTrue(başlıq.contains("Azərbaycan Texniki Universiteti"));

            TestKitabxana.YoxlamaUğurlu();

            // getCurrentUrl()
            // 3. Cari səhifənin URL-ni əldə edirik
            TestKitabxana.MP3_oyna("Cari səhifənin veb adresini əldə edirəm");
            String cariURL = sürücü.getCurrentUrl();
            System.out.println("Cari URL: " + cariURL);
            TestKitabxana.MP3_oyna("Yoxlama edirəm-Səhifənin internet adresində, gözlənilən mətn olmalı");
            assertTrue(cariURL.contains("aztu.edu.az"));
            TestKitabxana.YoxlamaUğurlu();

            // getPageSource()
            // 4. Cari səhifənin mənbə kodunu əldə edirik
            TestKitabxana.MP3_oyna("Cari səhifənin Ech-TML mənbə-kodunu əldə edirəm");
            String mənbəKod = sürücü.getPageSource();
            System.out.println("Cari səhifənin HTML mənbə-kodu:");
            System.out.println("\tUzunluğu: " + mənbəKod.length() + " simvol");
            //System.out.println("\tİlk 20 karakteri: " + mənbəKod.substring(0, 20) + "...");
            //System.out.println("\tSon 20 karakteri: ..." + mənbəKod.substring(mənbəKod.length() - 3));

            //
            TestKitabxana.MP3_oyna("Brauzer-də yeni bir təb açıram");
            sürücü.switchTo().newWindow(WindowType.TAB);
            sürücü.get("https://az.wikipedia.org");

            // close()
            // 5. Cari pəncərəni bağlayırıq
            TestKitabxana.MP3_oyna("Brauzer-dəki yeni pəncərəni bağlayıram");
            sürücü.close();
            System.out.println("Cari pəncərə bağlandı.");
            Thread.sleep(2000);

            // quit()
            // 6. Brauzerin bütün sekmelerini bağlayırıq
            sürücü.quit();
            System.out.println("Bütün brauzer sekmeleri bağlandı.");
            TestKitabxana.MP3_oyna("Bütün brauzer indi bağlanış olmalı");

            TestKitabxana.MP3_oyna("Avtomatlaşdırılmış test skriptimiz bitdi");


        }
        catch (NoSuchWindowException nswe) {
            System.out.println("❌ İnternet browser bağlanmış. Test otomasyon də çıxış edir");
            TestKitabxana.MP3_oyna("İnternet browser bağlanmış. Test otomasyon də çıxış edir");
            return;
        }
        catch (AssertionError ae) {
            TestKitabxana.YoxlamaUğursuz();
        }
        catch (Exception e) {
            System.out.println("❌ Xəta baş verdi: " + e.toString());//.getMessage());
        }
        /*finally {
            // 6. Brauzeri bağlayırıq
            sürücü.quit();
            System.out.println("Bütün brauzer sekmeleri bağlandı.");
            TestKitabxana.MP3_oyna("Bütün brauzer indi bağlanış olmalı");

            TestKitabxana.MP3_oyna("Avtomatlaşdırılmış test skriptimiz bitdi");
        }*/
    }
}
