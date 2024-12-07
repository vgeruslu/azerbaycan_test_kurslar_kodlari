package kurs_layihesi;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Optional;

import static KitabxanalarLibs.TestKitabxana.*;

public class ProfilimSehifeTestleri {
    private static WebDriver sürücü;
    // 1. Hazırlıq (Setup)
    // 2. İstenilen funksiya icra olur (Exercise)
    // 3. Yoxlama (Verify)
    // 4. Təmizləmə (Teardown)

    //@Test
    public void TH_x() throws Exception {

    }

    @Test
    public void TH_Profilim_Əkranın_xanaları_və_məlumatları_düzgün_açılmalı() throws Exception {
        String cari_istifadəçi_email = "yusif@gmail.com";
        // 1. Hazırlıq (Setup)
        daxil_ol(sürücü,cari_istifadəçi_email, "12");

        // indi EsasSehife de olmaliyiq

        // 2. İstenilen funksiya icra olur (Exercise)
        // Profilim sehifesine getmeliyik
        sürücü.findElement(By.xpath("//a[@href ='profilim.php']")).click();
        // indi profilim sehifesinde olmaliyiq

        // 3. Yoxlama (Verify)
        // Əkran düzgün_açılmalı
        System.out.println("❓ Yoxlama- Profilim əkranının xanaları və məlumatları düzgün açılmalı");

        mətnin_səhifədə_olduğunu_yoxla(sürücü, "İstifadəçi adı (e-poçt)");
        mətnin_səhifədə_olduğunu_yoxla(sürücü, "Şifrə dəyişmək");

        mətnin_səhifədə_olduğunu_yoxla(sürücü, "yusif@gmail.com");

        //mətnin_səhifədə_olduğunu_yoxla(sürücü, "Yusif");
        WebElement axtarılan_element = sürücü.findElement(
                By.xpath("//input[@value='Yusif']"));
        System.out.println("✅ Ad tapıldı");
        obyektın_kənarını_rəng_ilə_vurğula(sürücü, axtarılan_element);

        //mətnin_səhifədə_olduğunu_yoxla(sürücü, "Qulamoğlu");
        axtarılan_element = sürücü.findElement(
                By.xpath("//input[@value='Qulamoğlu']"));
        System.out.println("✅ Soyad tapıldı");
        obyektın_kənarını_rəng_ilə_vurğula(sürücü, axtarılan_element);

        // 4. Təmizləmə (Teardown)
        // cixis et
        sürücü.findElement(By.xpath("//a[@href ='çıxış.php']")).click();

    }

    // AD SOYA dəyişmək
    @Test
    public void TH_Etibarlı_Ad_Etibarlı_Soyad() throws Exception {

        // 1. Hazırlıq (Setup)
        daxil_ol(sürücü,"yusif@gmail.com", "12");

        // indi EsasSehife de olmaliyiq
        sürücü.findElement(By.xpath("//a[@href ='profilim.php']")).click();

        // 2. İstenilen funksiya icra olur (Exercise)
        // Profilim sehifesine getmeliyik
        // indi profilim sehifesinde olmaliyiq

        // Etibarlı bir ad mətn və etibarlı soyad mətni daxil edir, və Redaktə Et düyməsinə vurur
        System.out.println("\uD83D\uDCE2 Etibarlı ad daxil edirem");
        sürücü.findElement(
                By.xpath("//input[@name='yeni_ad']")).sendKeys("-ELAVE");

        System.out.println("\uD83D\uDCE2 Etibarlı soyad daxil edirem");
        sürücü.findElement(
                By.xpath("//input[@name='yeni_soyad']")).sendKeys("-ELAVELI");

        System.out.println("\uD83D\uDCE2 Duymeye vururam");
        sürücü.findElement(
                By.xpath("(  //input[@value='Redaktə et']  )  [1]")).click();

        // 3. Yoxlama (Verify)
        // Ad və soyad uğurlu redaktə olmalı
        System.out.println("❓ Yoxlama- Ad və soyad uğurlu redaktə olmalı");
        WebElement axtarılan_element = sürücü.findElement(
                By.xpath("//input[@value='Yusif-ELAVE']"));
        System.out.println("✅ Yeni ad tapıldı");
        obyektın_kənarını_rəng_ilə_vurğula(sürücü, axtarılan_element);

        axtarılan_element = sürücü.findElement(
                By.xpath("//input[@value='Qulamoğlu-ELAVELI']"));
        System.out.println("✅ Yeni soyad tapıldı");
        obyektın_kənarını_rəng_ilə_vurğula(sürücü, axtarılan_element);

        // Sistem uyğun bir təsdiq mesajı verməli: Ad və soyadınız yeniləndi.
        mətnin_səhifədə_olduğunu_yoxla(sürücü, "Ad və soyadınız yeniləndi.");

        // 4. Təmizləmə (Teardown)

        // ad və soyadı əvvəlki orijinal dəyərlərə dəyişirəm
        System.out.println("\uD83D\uDCE2 Ad və soyadı əvvəlki orijinal dəyərlərə dəyişirəm");
        // ad
        sürücü.findElement(
                By.xpath("//input[@name='yeni_ad']")).clear();
        sürücü.findElement(
                        By.xpath("//input[@name='yeni_ad']")).sendKeys("Yusif");

        //soyad
        sürücü.findElement(
                By.xpath("//input[@name='yeni_soyad']")).clear();
        sürücü.findElement(
                By.xpath("//input[@name='yeni_soyad']")).sendKeys("Qulamoğlu");

        sürücü.findElement(
                By.xpath("(  //input[@value='Redaktə et']  )  [1]")).click();

        // cixis et
        sürücü.findElement(By.xpath("//a[@href ='çıxış.php']")).click();
        // Ad və soyad uğurlu redaktə olmalı.

    }
    @Test
    public void TH_Etibarlı_Ad_Boş_Soyad() throws Exception {
        // 1. Hazırlıq (Setup)
        daxil_ol(sürücü,"yusif@gmail.com", "12");

        // indi EsasSehife de olmaliyiq
        sürücü.findElement(By.xpath("//a[@href ='profilim.php']")).click();

        // 2. İstenilen funksiya icra olur (Exercise)
        // Profilim sehifesine getmeliyik
        // indi profilim sehifesinde olmaliyiq

        // Etibarlı bir ad mətn və etibarlı soyad mətni daxil edir, və Redaktə Et düyməsinə vurur
        System.out.println("\uD83D\uDCE2 Etibarlı ad daxil edirem");
        sürücü.findElement(
                By.xpath("//input[@name='yeni_ad']")).sendKeys("-Riza");

        System.out.println("\uD83D\uDCE2 BOŞ soyad daxil edirem");
        sürücü.findElement(
                By.xpath("//input[@name='yeni_soyad']")).clear();

        System.out.println("\uD83D\uDCE2 Duymeye vururam");
        sürücü.findElement(
                By.xpath("(  //input[@value='Redaktə et']  )  [1]")).click();

        // 3. Yoxlama (Verify)
        // Sistem uyğun xəta mesajı verməli
        try {
            mətnin_səhifədə_olduğunu_yoxla(sürücü, "XƏTA: Soyad boş olmamalı.");
        }
        catch (Exception e) {
            // eger kod buraya gelse, yeni XETA olub.. cox ihtimal, yeni ad/soyad yazilib
            // o zaman, original istifadeci ad/soyad data-ni ROLL-BACK
            System.out.println("\uD83D\uDC1E XƏTA BAŞ VERDI. Çox güman ki, xətaya görə, yeni ad və boş soyad data bazasına yazıldı. " +
                            " Ona görə, test-dataların pozulmaması üçün, biz gərək istifadəçi ad və soyadını orijinal dəyərlərə ROL-BƏK edək");
            //mp3_oyna("XƏTA BAŞ VERDI. Ad və soyad roll-back");

            WebElement xana = sürücü.findElement(
                    By.xpath("//input[@name='yeni_ad']"));
            obyektın_kənarını_rəng_ilə_vurğula(sürücü, xana, 2);
            xana.clear();
            xana.sendKeys("Yusif");

            //
            xana = sürücü.findElement(
                    By.xpath("//input[@name='yeni_soyad']"));
            obyektın_kənarını_rəng_ilə_vurğula(sürücü, xana, 2);
            xana.clear();
            xana.sendKeys("Qulamoğlu");

            //
            xana = sürücü.findElement(
                    By.xpath("(  //input[@value='Redaktə et']  )  [1]"));
            obyektın_kənarını_rəng_ilə_vurğula(sürücü, xana, 2);
            xana.click();

            Thread.sleep(2000);
        }

        // 4. Təmizləmə (Teardown)
        // cixis et
        sürücü.findElement(By.xpath("//a[@href ='çıxış.php']")).click();
    }

    //@Test
    public void TH_Etibarsız_Ad_Etibarlı_Soyad() throws Exception {

    }

    //@Test
    public void TH_Etibarsız_Ad_Etibarsız_Soyad() throws Exception {

    }

    //@Test
    public void TH_Etibarsız_Ad_Boş_Soyad() throws Exception {

    }

    //@Test
    public void TH_Boş_Ad_Etibarlı_Soyad() throws Exception {

    }

    //@Test
    public void TH_Boş_Ad_Etibarsız_Soyad() throws Exception {

    }

    //@Test
    public void TH_Boş_Ad_Boş_Soyad() throws Exception {

    }

    //Şifrə dəyişmək
    // Etibarlı: Şifrə_siyasətinə_uyğundur
    // Etibarsız: Siyasəti_uyğun_deyil
    // xüsusi_simvol: !,_@,_#,_$,_və_s.

    //@Test
    public void CŞ_Etibarlı_YŞ_Etibarlı_YŞT_YŞ_ilə_eynidir() throws Exception {

    }
    //@Test
    public void CŞ_Etibarsız_YŞ_etibarsız_Hansı_şərti_pozur_Şifrə_ən_azı_8_simvoldan_ibarət_olmalıdır_YŞT_YŞ_ilə_eyni_deyil() throws Exception {

    }

    //@Test
    public void CŞ_Boş_YŞ_etibarsız_Hansı_şərti_pozur_Ən_azı_bir_böyük_hərf_YŞT_Boş() throws Exception {

    }

    //@Test
    public void CŞ_Etibarlı_YŞ_etibarsız_Hansı_şərti_pozur_Ən_azı_bir_kiçik_hərf_YŞT_YŞ_ilə_eynidir() throws Exception {

    }

    //@Test
    public void CŞ_Boş_YŞ_etibarsız_Hansı_şərti_pozur_Ən_azı_bir_rəqəm_0_9_YŞT_YŞ_ilə_eyni_deyil() throws Exception {

    }

    //@Test
    public void CŞ_Etibarlı_YŞ_etibarsız_Hansı_şərti_pozur_Ən_azı_bir_xüsusi_simvol_YŞT_Boş() throws Exception {

    }

    //@Test
    public void CŞ_Boş_YŞ_Boş_YŞT_YŞ_ilə_eyni_deyil() throws Exception {

    }

    //@Test
    public void TH_AZ_EN_dilinə_dəyişmə() throws Exception {

    }

    //@Test
    public void TH_EN_AZ_dilinə_dəyişmə() throws Exception {

    }

    //@Test
    public void TH_Səhifədə_Çıxış_düyməsi_düzgün_Çıxış_edir() throws Exception {

    }

    //-----------------------------------------------------------------------------------------
    @BeforeAll
    public static void bütovTestSetdənƏvvəl() { // setupClass() {
        // ChromeDriver-i avtomatik yükləmək üçün WebDriverManager istifadə olunur
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void HərTestdənƏvvəl() { //setupTest() {
        // Brauzeri açırıq
        sürücü = new ChromeDriver();
        //sürücü.manage().window().maximize();
        brauzerin_mövqe_və_ölçüsünü_dəyiş(sürücü, -1000, 100, 1000, 600);

        sürücü.get("http://localhost/MiniFacebook/daxil_ol.php");
        sürücü.navigate().refresh();
    }

    @RegisterExtension
    //https://stackoverflow.com/questions/49037406/testwatcher-in-junit5/54690217#54690217
    private final AfterTestExecutionCallback afterTest = context -> {
        final Optional<Throwable> exception = context.getExecutionException();
// if you need method name:
//      final Method method = context.getRequiredTestMethod();
// one method for error/success:
//      after(method, exception);
// or if(exception.isPresent()){}else{})
        exception.ifPresentOrElse(this::onFail, this::onSuccess);
    };

    private void onSuccess() {
        if (sürücü != null) {
            System.out.println("Test ugurlu. Chrome-u baglayiram");
            sürücü.quit(); // Brauzeri bağlayır
        }
    }

    private void onFail(Throwable throwable) {
        System.out.println("❌ Test fail oldu. Chrome-u baglamiram ki problem analiz ola bilsin");
    }

    @AfterAll
    public static void bütovTestSetdənSonraTəmizləmə() { //tearDownClass() {
        System.out.println("Test icra prosesi tamamlandı.");
    }
}
