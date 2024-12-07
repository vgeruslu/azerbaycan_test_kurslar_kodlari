package az.atg.test_kurslari.ders24_27;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static KitabxanalarLibs.TestKitabxana.*;

public class Emrler_ve_Exceptionler {

    static WebDriver sürücü;

    public static void main(String[] args) {
        try {
            // WebDriver manager dən ChromeDriver istəyirik
            WebDriverManager.chromedriver().setup();

            // Selenium brauzer sürücüsünü işə salırıq
            sürücü = new ChromeDriver();
            brauzerin_mövqe_və_ölçüsünü_dəyiş(sürücü, -1000, 100, 1000, 600);

            //ders24_Naviqasiya_Əmrləri();
            //ders25_veb_elementlərin_əmrləri();
            ders26_gözləmə_əmrləri();

            // Brauzeri bağla
            MP3_oyna("Brauzeri bağlayıram");
            sürücü.quit();
            System.out.println("Brauzer bağlandı.");

        }
        catch (NoSuchWindowException nswe) {
            System.out.println("❌ İnternet browser bağlanmış. Test otomasyon də çıxış edir");
            MP3_oyna("İnternet browser bağlanmış. Test otomasyon də çıxış edir");
            return;
        }
        catch (AssertionError ae) {
            YoxlamaUğursuz();
        }
        catch (Exception e) {
            System.out.println("\uD83D\uDC1E Test zamanı xəta baş verdi: " + e.toString() + " ---- detal: " + e.getMessage());
        }

    } // end main

    public static void ders24_Naviqasiya_Əmrləri() throws Exception {
        // 1. İlk URL-ə keçid edirik
        MP3_oyna("Hamısı Burada səhifəsini açıram"); //Quqıl səhifəsini açıram
        sürücü.navigate().to("https://www.hamisiburada.az/");
        System.out.println("1ci səhifə açıldı.");

        // 2. İkinci URL-ə keçid edirik
        MP3_oyna("Azərbaycan Test Günləri Linkedİn səhifəsini açıram");
        sürücü.navigate().to("https://www.linkedin.com/groups/12877423/");
        System.out.println("İkinci səhifəsinə keçid edildi.");

        // 3. Əvvəlki səhifəyə geri qayıdırıq
        MP3_oyna("Əvvəlki səhifəyə geri qayıdıram");
        sürücü.navigate().back();
        System.out.println("Əvvəlki səhifəyə geri qayıdıldı.");

        // 4. Növbəti səhifəyə irəliləyirik
        MP3_oyna("Növbəti səhifəyə irəliləyirəm");
        sürücü.navigate().forward();
        System.out.println("Növbəti səhifəyə irəliləndi.");

        // 5. Cari səhifəni
        MP3_oyna("Cari səhifəni yeniləyirəm");
        MP3_oyna("Yəni Brauzeri də F5 düyməsini vururam");
        sürücü.navigate().refresh();
        System.out.println("Cari səhifə yeniləndi).");
    } // funksiya

    public static void ders25_veb_elementlərin_əmrləri() throws Exception {
        /* avtomatlasdirilmis test senaryo:

                1. Verilən URL-i açırıq
                2. Axtarış sahəsini tapırıq (findElement funksiya ile) və 'Telefon' metnini daxil edirik (sendKeys funksiya ile)
                3. Axtarış sahəsini təmizləyirik (clear funksiya ile)
                4. Yenidən 'Notebook' sözünü daxil edirik və formun 'SUBMIT' hadisesini işə saliriq
                ... 2 saniye gozleme - umid edirik ki 2 saniye yeterli olacaq!
                5. Axtaris netice sehifesinde bütün məhsulları tapırıq (findElements) və onlarin məlumatlarını çap edirik
                6. Axtaris netice sehifesinde, ilk məhsul üzərinə klik edirik (click)

         */
        // 1. Verilən URL-i açırıq
        MP3_oyna("Hamısı Burada səhifəsini açıram"); // "Test ediləcək veb tətbiqin əsas səhifəsinə gedirəm"
        sürücü.get("https://www.hamisiburada.az/");
        System.out.println("Sayt uğurla açıldı.");

        əgər_reklam_popup_u_varsa_onu_bağla();

        // 2. Axtarış sahəsini tapırıq (findElement) və məlumat daxil edirik (sendKeys)
        //WebElement məhsulAaxtarışMətnQutusu = sürücü.findElement(By.name("q"));
        WebElement məhsulAaxtarışMətnQutusu = sürücü.findElement(
                By.xpath("//*[@name = 'name' and not (contains(@class, 'search-bar-input-mobile'))]"));

        if (məhsulAaxtarışMətnQutusu.isDisplayed() && məhsulAaxtarışMətnQutusu.isEnabled()) {
            MP3_oyna("Mətn qutusunda mətn yazıram");
            məhsulAaxtarışMətnQutusu.sendKeys("Telefon");
            System.out.println("Axtarış sahəsinə 'Telefon' sözü daxil edildi.");
        }

        // 3. Axtarış sahəsini təmizləyirik (clear)
        MP3_oyna("Mətn qutusunu silirəm");
        məhsulAaxtarışMətnQutusu.clear();
        System.out.println("Axtarış mətn qutusu təmizləndi.");

        // 4. Yenidən 'Notebook' sözünü daxil edirik və formun 'SUBMIT' hadisesini işə saliriq

        MP3_oyna("Mətn qutusunda mətn yazıram");
        məhsulAaxtarışMətnQutusu.sendKeys("Notebook");

        MP3_oyna("HTML formasının göndərmə hadisəsini işə salıram");
        məhsulAaxtarışMətnQutusu.submit();

        System.out.println("Axtarış üçün 'Notebook' sözü daxil edildi və təsdiqləndi.");

        // 2 saniye gozleme - umid edirik ki 2 saniye mehsullar axtaris sehifesinin serverden gelmesin ucun, yeterli olacaq!
        Thread.sleep(3000);

        // indi, mehsullar axtaris sehifesi serverden gelmis olmasi gerek
        // 5. Axtaris netice sehifesinde bütün məhsulları tapırıq (findElements) və onlarin məlumatlarını çap edirik
        List<WebElement> məhsullar = sürücü.findElements(
                By.xpath("//*[@id= 'ajax-products']//div[contains (@class, 'product-card')] "));

        System.out.println("Tapılan məhsulların sayı: " + məhsullar.size());
        // bu addimda, isteyirik ki bir FOR donge ile, ekrandaki butov mehsular uzerinde bir bir gedib,
        // ve onlarin melumatlarini loq'da cap edek

        // FOR yanasma alternativ 1:
        for (int i=0; i < məhsullar.size(); i++) {
            WebElement cari_mehsul = məhsullar.get(i);
            System.out.println("Məhsul # " + i + " --- məlumatları: " + cari_mehsul.getText() +
                    "\n----------------\n");
        }
        // FOR yanasma alternativ 2:
        /*int mehsul_sayğac = 1;
        for (WebElement məhsul : məhsullar) {
            System.out.println("Məhsul # " + mehsul_sayğac + " --- məlumatları: " + məhsul.getText() +
                    "\n----------------\n");
            mehsul_sayğac ++; // mehsul_sayğac = mehsul_sayğac + 1
        }*/

        // 6. Axtaris netice sehifesinde, ilk məhsul üzərinə klik edirik (click)
        if (məhsullar.size() > 0) {
            MP3_oyna("İlk məhsul üzərinə klik edirəm");
            məhsullar.get(0).click();
            System.out.println("İlk məhsul seçildi.");
        }
    } // func

    public static void ders26_gözləmə_əmrləri() throws Exception {
        /* avtomatlasdirilmis test senaryo:

                1. Verilən URL-i açırıq
                2- İmplicit Wait təyin etmək: Elementlərin yüklənməsinin ümumi gözləmə vaxtı (timeout)
                3. Axtarış mətn qutusun tapırıq (findElement ilə) və onda "Samovar" sözünu daxil edirik (sendKeys ilə)
                4. Axtarış düyməsini WebDriverWait.until əmri ilə gözləyirik
                5. Axtarış düyməsini klikləmək
                6. Məhsul axtarış nəticələrinin serverdən alınması üçün 3 saniyə gözləyirik.
                       Thread.sleep ilə əlavə vaxt gözləyirik (❗❗tövsiyə olunmur❗❗, amma lazım ola bilər)
                7. Axtarış nəticələrində, bütün tapılan məhsullarda "Samovar" terminini yoxlayıram

         */

        // 1. Verilən URL-i açırıq
        MP3_oyna("Hamısı Burada səhifəsini açıram"); // "Test ediləcək veb tətbiqin əsas səhifəsinə gedirəm"
        sürücü.get("https://www.hamisiburada.az/");
        System.out.println("Sayt uğurla açıldı.");

        əgər_reklam_popup_u_varsa_onu_bağla();

        // ⭐ İmplicit Wait ⭐- Elementlərin avtomatik yüklənməsini gözləyir
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

        // 3. Axtarış mətn qutusunda tapırıq (findElement) və məlumat daxil edirik (sendKeys)
        WebElement məhsulAaxtarışMətnQutusu = sürücü.findElement(
                By.xpath("//*[@name = 'name' and not (contains(@class, 'search-bar-input-mobile'))]"));

        if (məhsulAaxtarışMətnQutusu.isDisplayed() && məhsulAaxtarışMətnQutusu.isEnabled()) {
            MP3_oyna("Məhsul axtarış mətn qutusunda Samovar yazıram");
            məhsulAaxtarışMətnQutusu.sendKeys("Samovar");
            System.out.println("Axtarış sahəsinə 'Samovar' sözü daxil edildi.");
        }

        // 4. axtarış Düyməsini WebDriverWait.until əmri ilə gözləyirik
        MP3_oyna("Axtarış düyməsinin kliklənə bilən olduğunu yoxlayıram və əgər lazımdırsa, gözləyirəm");

        WebDriverWait gözlə = new WebDriverWait(sürücü, Duration.ofSeconds(10)); // 10 saniyə maksimum timeout
        WebElement axtarışDüyməsi = gözlə.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//*[contains(@class, 'search_button')]) [1]")));
        // fərqli GÖZLƏNƏN ŞƏRTLƏR (ExpectedConditions) siyahısı birada:
        // https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/ui/ExpectedConditions.html

        System.out.println("Axtarış düyməsi klik edilməyə hazırdır.");

        // 5. Axtarışı klikləmək
        MP3_oyna("Məhsul axtarış düyməsinə vururam");
        System.out.println("Məhsul axtarış düyməsinə vurdum");
        axtarışDüyməsi.click();

        // 6. ⭐Thread.sleep⭐ ilə əlavə vaxt gözləyirik (❗❗tövsiyə olunmur❗❗, amma lazım ola bilər)
        MP3_oyna("Məhsul axtarış nəticələrinin serverdən alınması üçün 3 saniyə gözləyirəm");
        Thread.sleep(3000); // 3 saniyə
        System.out.println("3 saniyəlik Thread.sleep ilə əlavə gözləmə edildi.");

        // 7. Axtarış nəticələrində, bütün tapılan məhsullarda "Samovar" terminini yoxlayıram
        MP3_oyna("Axtarış nəticələrində, bütün tapılan məhsullarda Samovar terminini yoxlayıram");

        List<WebElement> butov_tapılan_məhsullar = sürücü.findElements(
                By.xpath("//*[@id= 'ajax-products']//div[contains (@class, 'product-card')] "));

        for (int məhsul_index = 0; məhsul_index < butov_tapılan_məhsullar.size(); məhsul_index++) {
            WebElement məhsul = butov_tapılan_məhsullar.get(məhsul_index);

            //məhsul adını cixartmaq
            WebElement cari_məhsulun_adı_element = sürücü.findElement(By.xpath(
                    "(//div[contains (@class, 'product-card')]//div[contains (@class, 'product-title1')]//a)" +
                            "[" + (məhsul_index + 1) + "]"));
            String cari_məhsulun_adı = cari_məhsulun_adı_element.getAttribute("innerHTML");
            System.out.println("cari_məhsulun_adı = " + cari_məhsulun_adı);

            cari_məhsulun_adı = cari_məhsulun_adı.replaceAll("\n", ""); // metn temizlemek:
                                                    // alinan metnde, ENTER leri, "" ile deyisdir
            cari_məhsulun_adı = cari_məhsulun_adı.trim();
            System.out.println("cari_məhsulun_adı (temizlemekden sonra)= " + cari_məhsulun_adı);

            // YOXLAMA !
            if (cari_məhsulun_adı.toUpperCase().contains("SAMOVAR")) // "Samovar" ... samovar
                YoxlamaUğurlu();
            else
                YoxlamaUğursuz();
            
            // məhsul qiymeti-ni cixartmaq
            WebElement məhsul_qiymeti_span = sürücü.findElement(By.xpath(
                    "(//div[contains (@class, 'product-card')]//div[contains (@class, 'product-price')]//span)[" +
                            (məhsul_index + 1) + "]"));
            String məhsul_qiymeti = məhsul_qiymeti_span.getAttribute("innerHTML");
            məhsul_qiymeti = məhsul_qiymeti.replaceAll("\\s+", "");
            System.out.println("məhsul_qiymeti = " + məhsul_qiymeti);

            // obyektin ekranda görünür olduğunu yoxla
            if (!ElementEkrandaGörünürMu(sürücü, məhsul))
                // Görünüşə sürüşdür
                ((JavascriptExecutor) sürücü).executeScript(
                        "arguments[0].scrollIntoView();", məhsul);

            // obyektin kənarını QIRMIZ rəngləndir
            ((JavascriptExecutor) sürücü).executeScript("arguments[0].style.border='2px solid red'", məhsul);
            // 1 saniyə PAUSE et
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            // obyektin kənarını normala döndər... AĞ rəngləndir
            ((JavascriptExecutor) sürücü).executeScript("arguments[0].style.border='2px solid white'", məhsul);

        }

    } //func ders26

    public static void əgər_reklam_popup_u_varsa_onu_bağla() {
        MP3_oyna("Bəzən əsas ekranda reklam popup açılır; varsa, onu bağlayıram");

        try {
            WebElement sehifede_popup_element= new WebDriverWait(sürücü, Duration.ofSeconds(4)).until(
                    ExpectedConditions.presenceOfElementLocated((
                            By.xpath("//*[@class = 'modal fade show']"))));
            // EGER USTDEKI setir kod fail etse, yeni reklam_popup_u acilmamis
            // EGER fail etmezse, yeni reklam_popup_u acilmis

            //int sehifede_popup_sayi = sürücü.findElements(By.xpath("//*[@class = 'modal fade show']")).size();
            //System.out.println("sehifede_popup_sayi = "+ sehifede_popup_sayi);

            //MP3_oyna("Pop-up ekranı tapdım. Onu bağlayıram");

            WebElement reklam_popup_in_bagla_X_duymesi = sürücü.findElement(By.xpath(
                    "//*[@class = 'modal fade show']//button[@class = 'close']"));

            reklam_popup_in_bagla_X_duymesi.click();
        } catch (Exception e) {
            System.out.println("Pop-up ekranı tapılmadı");
            MP3_oyna("Pop-up ekranı tapılmadı");
        }
    } // end func əgər_reklam_popup_u_varsa_onu_bağla

} // end class
