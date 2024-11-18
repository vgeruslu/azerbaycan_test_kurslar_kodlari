package az.atg.test_kurslari.ders24_27;

import KitabxanalarLibs.TestKitabxana;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Emrler_ve_Exceptionler {

    static WebDriver sürücü;

    public static void main(String[] args) {
        try {
            // WebDriver manager dən ChromeDriver istəyirik
            WebDriverManager.chromedriver().setup();

            // Selenium brauzer sürücüsünü işə salırıq
            sürücü = new ChromeDriver();
            Thread.sleep(1000);
            test_ediləcək_veb_tətbiqin_əsas_səhifəsini_aç();

            əgər_reklam_popup_u_varsa_onu_bağla();
            //ders24_Naviqasiya_Əmrləri();
            //ders25_veb_elementlərin_əmrləri();
            ders26_gözləmə_əmrləri();

            // Brauzeri bağlayırıq
            TestKitabxana.MP3_oyna("Brauzeri bağlayıram");
            sürücü.quit();
            System.out.println("Brauzer bağlandı.");

        } catch (NoSuchWindowException nswe) {
            System.out.println("Brauzer bağlanmış. Test avto-da durur.");
        } catch (Exception e) {
            System.out.println("Test zamanı xəta baş verdi: " + e.toString() + " ---- detal: " + e.getMessage());
        } finally {

        } // try-catch

    } // end main

    public static void test_ediləcək_veb_tətbiqin_əsas_səhifəsini_aç() throws Exception {
        // 1. Verilən URL-i açırıq
        TestKitabxana.MP3_oyna("Test ediləcək veb tətbiqin əsas səhifəsinə gedirəm");
        sürücü.get("https://www.hamisiburada.az/");
        System.out.println("Sayt uğurla açıldı.");
    }

    public static void ders24_Naviqasiya_Əmrləri() throws Exception {
        // 1. İlk URL-ə keçid edirik
        /*TestKitabxana.MP3_oyna("Hamısı Burada səhifəsini açıram"); //Quqıl səhifəsini açıram
        sürücü.navigate().to("https://www.hamisiburada.az/");
        System.out.println("1ci səhifə açıldı.");*/

        // 2. İkinci URL-ə keçid edirik
        TestKitabxana.MP3_oyna("Azərbaycan Test Günləri Linkedİn səhifəsini açıram");
        sürücü.navigate().to("https://www.linkedin.com/groups/12877423/");
        System.out.println("İkinci səhifəsinə keçid edildi.");

        // 3. Əvvəlki səhifəyə geri qayıdırıq
        TestKitabxana.MP3_oyna("Əvvəlki səhifəyə geri qayıdıram");
        sürücü.navigate().back();
        System.out.println("Əvvəlki səhifəyə geri qayıdıldı (Google).");

        // 4. Növbəti səhifəyə irəliləyirik
        TestKitabxana.MP3_oyna("Növbəti səhifəyə irəliləyirəm");
        sürücü.navigate().forward();
        System.out.println("Növbəti səhifəyə irəliləndi (Example.com).");

        // 5. Cari səhifəni
        TestKitabxana.MP3_oyna("Cari səhifəni yeniləyirəm");
        sürücü.navigate().refresh();
        System.out.println("Cari səhifə yeniləndi (Example.com).");
    } // fun

    public static void ders25_veb_elementlərin_əmrləri() throws Exception {
        // 1. Verilən URL-i açırıq
        /*TestKitabxana.MP3_oyna("Test ediləcək veb tətbiqin əsas səhifəsinə gedirəm");
        sürücü.get("https://www.hamisiburada.az/");
        System.out.println("Sayt uğurla açıldı.");*/

        // 2. Axtarış sahəsini tapırıq (findElement) və məlumat daxil edirik (sendKeys)
        //WebElement məhsulAaxtarışMətnQutusu = sürücü.findElement(By.name("q"));
        WebElement məhsulAaxtarışMətnQutusu = sürücü.findElement(
                By.xpath("//*[@name = 'name' and not (contains(@class, 'search-bar-input-mobile'))]"));

        if (məhsulAaxtarışMətnQutusu.isDisplayed() && məhsulAaxtarışMətnQutusu.isEnabled()) {
            TestKitabxana.MP3_oyna("Mətn qutusunda mətn yazıram");
            TestKitabxana.MP3_oyna("Məhsul axtarış mətn qutusu");
            məhsulAaxtarışMətnQutusu.sendKeys("Telefon");
            System.out.println("Axtarış sahəsinə 'Telefon' sözü daxil edildi.");
        }

        // 3. Axtarış sahəsini təmizləyirik (clear)
        TestKitabxana.MP3_oyna("Xananı silirəm");
        TestKitabxana.MP3_oyna("Məhsul axtarış mətn qutusu");
        məhsulAaxtarışMətnQutusu.clear();
        System.out.println("Axtarış sahəsi təmizləndi.");

        // 4. Yenidən 'Notebook' sözünü daxil edirik və 'Enter' basırıq

        TestKitabxana.MP3_oyna("Mətn qutusunda mətn yazıram");
        TestKitabxana.MP3_oyna("Məhsul axtarış mətn qutusu");
        məhsulAaxtarışMətnQutusu.sendKeys("Notebook");

        TestKitabxana.MP3_oyna("Düyməyə vururam");
        TestKitabxana.MP3_oyna("Məhsul axtar düyməsi");
        məhsulAaxtarışMətnQutusu.submit();

        System.out.println("Axtarış üçün 'Notebook' sözü daxil edildi və təsdiqləndi.");

        Thread.sleep(2000);

        // 5. Bütün məhsulları tapırıq (findElements) və məlumatlarını çap edirik
        List<WebElement> məhsullar = sürücü.findElements(
                By.xpath("//*[@id= 'ajax-products']//div[contains (@class, 'product-card')] "));

        System.out.println("Tapılan məhsulların sayı: " + məhsullar.size());
        for (WebElement məhsul : məhsullar) {
            System.out.println("Məhsul adı: " + məhsul.getText());
        }

        // 6. İlk məhsul üzərinə klik edirik (click)
        if (məhsullar.size() > 0) {
            TestKitabxana.MP3_oyna("İlk məhsul üzərinə klik edirəm");
            məhsullar.get(0).click();
            System.out.println("İlk məhsul seçildi.");
        }
    } // func

    public static void ders26_gözləmə_əmrləri() throws Exception {
        // 1. ⭐⭐⭐ İmplicit Wait ⭐⭐- Elementlərin avtomatik yüklənməsini gözləyir 🧐🧐
        /* Qaynaq: https://www.selenium.dev/documentation/webdriver/waits/
        [AZ]
        Gizli-Gözləmə müddəti parametri, bütün sessiya üçün hər bir element yeri çağırışına aid olan qlobal
        parametrdir. Varsayılan dəyər 0-dır, yəni element tapılmazsa, dərhal xəta qaytaracaq. Gizli gözləmə təyin
         edilərsə, sürücü xətanı qaytarmazdan əvvəl verilən dəyərin müddətini gözləyəcək. Nəzərə alın ki, element
         yerləşən kimi sürücü element istinadını qaytaracaq və kod icra etməyə davam edəcək, beləliklə, daha böyük
          gizli gözləmə dəyəri sessiyanın müddətini mütləq artırmayacaq.

        [EN]
        The İmplicit-Wait duration setting is a global setting that applies to every element location call for the
         entire session.
         The default value is 0, which means that if the element is not found, it will immediately return an error.
         If an implicit wait is set, the driver will wait for the duration of the provided value before returning
         the error. Note that as soon as the element is located, the driver will return the element reference and
         the code will continue executing, so a larger implicit wait value won’t necessarily increase the duration
         of the session.
         */
        sürücü.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Implicit Wait 10 saniyə təyin edildi.");

        // 2. Verilən URL-i açırıq
        /*TestKitabxana.MP3_oyna("Test ediləcək veb tətbiqin əsas səhifəsinə gedirəm");
        sürücü.get("https://www.hamisiburada.az/");
        System.out.println("Sayt uğurla açıldı.");*/

        // 3. Axtarış sahəsini tapırıq (findElement) və məlumat daxil edirik (sendKeys)
        WebElement məhsulAaxtarışMətnQutusu = sürücü.findElement(
                By.xpath("//*[@name = 'name' and not (contains(@class, 'search-bar-input-mobile'))]"));

        //WebElement istifadəçi_adı_mətn_qutusu = sürücü.findElement(
        //        By.xpath("//*[@name = 'istifadəçi_ad']"));

        //ChatGPT vermisdi, ama yalnis di:
        //sürücü.findElement(By.name("q"));

        if (məhsulAaxtarışMətnQutusu.isDisplayed() && məhsulAaxtarışMətnQutusu.isEnabled()) {
            TestKitabxana.MP3_oyna("Mətn qutusunda mətn yazıram");
            TestKitabxana.MP3_oyna("Məhsul axtarış mətn qutusu");
            məhsulAaxtarışMətnQutusu.sendKeys("Telefon");
            System.out.println("Axtarış sahəsinə 'Telefon' sözü daxil edildi.");
        }

        // 4. ⭐⭐⭐WebDriverWait.until⭐⭐⭐Elementin mövcud olmasını WebDriverWait ilə gözləyirik
        WebDriverWait gözlə = new WebDriverWait(sürücü, Duration.ofSeconds(10));
        WebElement axtarışDüyməsi = gözlə.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//*[@class = 'input-group-append-overlay search_button'])[1]")));
        //ChatGPT vermisdi, ama yalnis di:
        // By.xpath("//button[@type='submit']")));
        System.out.println("Axtarış düyməsi klik edilməyə hazırdır.");

        // 5. Axtarışı təsdiqləyirik (click)
        TestKitabxana.MP3_oyna("Düyməyə vururam");
        TestKitabxana.MP3_oyna("Məhsul axtar düyməsi");
        axtarışDüyməsi.click();
        System.out.println("Axtarış düyməsinə klik edildi.");

        // 6. ⭐⭐⭐Thread.sleep⭐⭐⭐ ilə əlavə vaxt gözləyirik (❗❗tövsiyə olunmur❗❗, amma lazım ola bilər)
        Thread.sleep(3000); // 3 saniyə
        System.out.println("3 saniyəlik Thread.sleep ilə əlavə gözləmə edildi.");

        // 7. Tapılan məhsulları yoxlayırıq
        List<WebElement> məhsullar = sürücü.findElements(
                By.xpath("//*[@id= 'ajax-products']//div[contains (@class, 'product-card')] "));
        //ChatGPT vermisdi, ama yalnis di:
        // By.className("product"));
        System.out.println("Tapılan məhsulların sayı: " + məhsullar.size());

        // İlk məhsulun məlumatını götürürük
        if (məhsullar.size() > 0) {
            WebElement ilkMəhsul = məhsullar.get(0);
            System.out.println("İlk məhsulun adı: " + ilkMəhsul.getText());

            // İlk məhsul üzərinə klik edirik
            TestKitabxana.MP3_oyna("İlk məhsul üzərinə klik edirəm");
            ilkMəhsul.click();
            System.out.println("İlk məhsul seçildi.");
        }

    } //func

    public static void əgər_reklam_popup_u_varsa_onu_bağla() {
        int sehifede_popup_sayi = sürücü.findElements(By.xpath("//*[@class = 'modal fade show']")).size();
        System.out.println("sehifede_popup_sayi = "+ sehifede_popup_sayi);

        if (sehifede_popup_sayi >= 1) {
            TestKitabxana.MP3_oyna("Pop-up ekranı tapdım. Onu bağlayıram");

            WebElement reklam_popup_in_bagla_X_duymesi = sürücü.findElement(
                    By.xpath("//*[@class = 'modal fade show']//button[@class = 'close']"));
            reklam_popup_in_bagla_X_duymesi.click();
        }
        else // = 0
            System.out.println("Pop-up ekranı tapılmadi");
    } // func

} // end class
