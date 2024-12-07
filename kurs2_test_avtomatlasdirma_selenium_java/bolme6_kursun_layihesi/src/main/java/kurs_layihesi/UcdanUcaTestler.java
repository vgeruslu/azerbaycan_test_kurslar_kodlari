package kurs_layihesi;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.RegisterExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Optional;

import static KitabxanalarLibs.TestKitabxana.*;

public class UcdanUcaTestler {

    private static WebDriver sürücü;
    // 1. Hazırlıq (Setup)
    // 2. İstenilen funksiya icra olur (Exercise)
    // 3. Yoxlama (Verify)
    // 4. Təmizləmə (Teardown)
    //@Test
    public void TH_() throws Exception {

    }

    //@Test
    public void TH_istifadəçi_bir_dostu_silir_onu_təkrar_əlavə_edir_və_əsas_səhifədə_görə_bilməli() throws Exception {
        // 1. Hazırlıq (Setup)
            daxil_ol(sürücü, "yusif@gmail.com", "12");

        // 2. İstenilen funksiya icra olur (Exercise)

        // Əsas səhifə: Hər hansı dostu sil (dostluqdan çıxar)
        // FƏRZ edəl ən az bir dost var
        // ilk, dostun ad ve emailini backup et, sona ehtiyac olacaq
        WebElement axtarılan_element = sürücü.findElement(
            By.xpath("(//div[@name = 'dost_ad_soyad']) [1]"));
        String silinecek_dostun_ad_soyadi = axtarılan_element.getAttribute("innerHTML");
        obyektın_kənarını_rəng_ilə_vurğula(sürücü, axtarılan_element);
        System.out.println("silinecek_dostun_ad_soyadi = " + silinecek_dostun_ad_soyadi);

        String silinecek_dostun_emaili = sürücü.findElement(
                By.xpath("(//input[@name = 'dost_epoçt']) [1]")).getAttribute("value");
        System.out.println("silinecek_dostun_emaili = " + silinecek_dostun_emaili);

        // Əsas səhifə: Hər hansı dostu sil (dostluqdan çıxar)
        axtarılan_element = sürücü.findElement(
                By.xpath("(//div[@name = 'dostu_cixar']) [1]"));
        obyektın_kənarını_rəng_ilə_vurğula(sürücü, axtarılan_element);
        axtarılan_element.click();
        System.out.println("dostu_cixar duymesini vurdum = " + silinecek_dostun_ad_soyadi);

        // 3. Yoxlama (Verify)
        // Həmin dost, dostlar siyahısındən silinməli (Tək səhifəlik testlərdə bu yoxlama olmuş. Təkrar yoxlamağa ehtiyac yox)

        System.out.println("Dostun siyahıdan çıxmasını yoxlayıram");

        if (sürücü.findElements(By.xpath("//*[contains(text(), '" + silinecek_dostun_ad_soyadi + "')]")).size() == 0)
            yoxlama_uğurlu(); // yoxdur
        else {
            yoxlama_uğurlu();
            fail("\uD83D\uDC1E XƏTA: Silinmiş dost adı '" + silinecek_dostun_ad_soyadi + "' hələ də səhifədə var !");
        }

        // Dost əlavə et səhifəsi : Həmin istifadəçini altında "Dost ol" olmalı
        sürücü.findElement(By.xpath("//a[@href ='dost_əlavə_et.php']")).click();
        System.out.println("Dost əlavə et səhifəsinde : Həmin istifadəçini altında 'Dost ol' olmalı");

        // Həmin istifadəçiyə "dost ol" et
        axtarılan_element = sürücü.findElement(By.xpath(
                "//div[@name='istifadəçi_tam_adi' and contains(string(), '" +
                    silinecek_dostun_ad_soyadi + "')]/parent::a/parent::div//div[@name='dostdurlar_ya_yox']"));
        obyektın_kənarını_rəng_ilə_vurğula(sürücü, axtarılan_element);
        yoxlama_uğurlu();
        axtarılan_element.click();
        System.out.println("Həmin istifadəçidə 'Dost ol' linkinə vurdum");

        // Həmin istifadəçini altında "Artıq dostunuzdur" olmalı
        System.out.println("İstifadəçi altında -Artıq dostunuzdur- olmalı");
        axtarılan_element = sürücü.findElement(By.xpath(
                "//div[@name='istifadəçi_tam_adi' and contains(string(), '" +
                        silinecek_dostun_ad_soyadi + "')]/parent::a/parent::div//div[@name='dostdurlar_ya_yox']"));
        obyektın_kənarını_rəng_ilə_vurğula(sürücü, axtarılan_element);
        yoxlama_uğurlu();
        String istifadəçi_altında_metn = axtarılan_element.getAttribute("innerHTML");
        System.out.println("istifadəçi_altında_metn = " + istifadəçi_altında_metn);
        assertEquals(istifadəçi_altında_metn, "Artıq dostunuzdur",
                "\uD83D\uDC1E Cunku bu dost elave olunub, altinda 'Artıq dostunuzdur' metni yazilmali idi.");
        //Əsas səhifə :	Həmin istifadəçini əsas səhifədə təkrar dost olaraq görə bilməli

        // İstifadəçinin ismi, şəkili, dostlar siyahısı, və xəbər lenti doğru açılır mı?
        /*
        System.out.println("❔ Əsas səhifə əkranı xanaları və məlumatının düzgün açıldıqlarını yoxlayıram");

        mp3_oyna("Mətnin səhifədə olduğunu yoxlayıram");
        mətnin_səhifədə_olduğunu_yoxla(sürücü, "Yusif Qulamoğlu");

        // şəkili
        mp3_oyna("Profil şəklinin səhifədə mövcudluğunu yoxlayıram");
        WebElement axtarılan_element = sürücü.findElement(
                By.xpath("//img[@src='istifadəçi_üz_şəkilləri\\yusif@gmail.com.jpg']"));
        obyektın_kənarını_rəng_ilə_vurğula(sürücü, axtarılan_element);

        //  dostlar siyahısı doğru açılır mı?
        mətnin_səhifədə_olduğunu_yoxla(sürücü, "Dostlar");

        //  xəbər lenti doğru açılır mı?
        mətnin_səhifədə_olduğunu_yoxla(sürücü, "Xəbər lentı:");
*/
        // 4. Təmizləmə (Teardown)
        // cixis et
        sürücü.findElement(By.xpath("//a[@href ='çıxış.php']")).click();
    }

    @Test
    public void TH_istifadəçi_profilim_səhifəsində_şifrəsini_dəyişir_çıxış_edir_köhnə_şifrə_ilə_daxil_ola_biməməli_yeni_şifrə_işləməli() throws Exception {
        //Giriş səhifəsi
        daxil_ol(sürücü, "yusif@gmail.com", "12");

        //Əsas səhifə - GETMELI

        //Profilim səhifəsi
        System.out.println("Profilim səhifəsi gedirem");
        WebElement axtarılan_element = sürücü.findElement(By.xpath("//a[@href ='profilim.php']"));
        obyektın_kənarını_rəng_ilə_vurğula(sürücü, axtarılan_element);
        axtarılan_element.click();

        // Şifrəni dəyiş
        axtarılan_element = sürücü.findElement(By.xpath("//*[@name ='cari_şifrə']"));
        obyektın_kənarını_rəng_ilə_vurğula(sürücü, axtarılan_element);
        axtarılan_element.sendKeys("12");

        axtarılan_element = sürücü.findElement(By.xpath("//*[@name ='yeni_şifrə']"));
        obyektın_kənarını_rəng_ilə_vurğula(sürücü, axtarılan_element);
        axtarılan_element.sendKeys("Baki2024");

        axtarılan_element = sürücü.findElement(By.xpath("//*[@name ='yeni_şifrə_təkrar']"));
        obyektın_kənarını_rəng_ilə_vurğula(sürücü, axtarılan_element);
        axtarılan_element.sendKeys("Baki2024");

        System.out.println("\uD83D\uDCE2 Duymeye vururam");
        axtarılan_element = sürücü.findElement(
                By.xpath("(  //input[@value='Redaktə et']  )  [2]"));
        obyektın_kənarını_rəng_ilə_vurğula(sürücü, axtarılan_element);
        axtarılan_element.click();

        // yoxla
        mətnin_səhifədə_olduğunu_yoxla(sürücü, "Şifrəniz yeniləndi.");

        //Çıxış et
        sürücü.findElement(By.xpath("//a[@href ='çıxış.php']")).click();

        //Giriş səhifəsi
        //YOXLAMA: Köhnə şifrə işləməməli
        daxil_ol(sürücü, "yusif@gmail.com", "12");

        // hele de daxil ol sehifesinde qalmali ve xeta mesaji verilmeli
        mp3_oyna("Sistem uyğun xəta mesaj verməli");
        sürücü.findElement(By.xpath(
                "//*[contains(text(),'Yanlış istifadəçi adı və/və ya parol. Yenidən cəhd edin.')]"));

        //YOXLAMA: yeni şifrə işləməli
        daxil_ol(sürücü, "yusif@gmail.com", "Baki2024");

        //Əsas səhifə
        mp3_oyna("Mətnin səhifədə olduğunu yoxlayıram");
        List<WebElement> axtarilan_elementler = sürücü.findElements(
                By.xpath("//*[contains(text(),'Yusif Qulamoğlu')]"));

        // ONEMLI: TEKRAR SIFRENI ESKI 12-E DEYISMEMIZ LAZIM, CUNKU BUTOV TESTLER 12 SIFRESINI ISTIFADE EDIRLER
            System.out.println("Profilim səhifəsi gedirem");
            axtarılan_element = sürücü.findElement(By.xpath("//a[@href ='profilim.php']"));
            obyektın_kənarını_rəng_ilə_vurğula(sürücü, axtarılan_element);
            axtarılan_element.click();

            // Şifrəni dəyiş
            axtarılan_element = sürücü.findElement(By.xpath("//*[@name ='cari_şifrə']"));
            obyektın_kənarını_rəng_ilə_vurğula(sürücü, axtarılan_element);
            axtarılan_element.sendKeys("Baki2024");

            axtarılan_element = sürücü.findElement(By.xpath("//*[@name ='yeni_şifrə']"));
            obyektın_kənarını_rəng_ilə_vurğula(sürücü, axtarılan_element);
            axtarılan_element.sendKeys("12");

            axtarılan_element = sürücü.findElement(By.xpath("//*[@name ='yeni_şifrə_təkrar']"));
            obyektın_kənarını_rəng_ilə_vurğula(sürücü, axtarılan_element);
            axtarılan_element.sendKeys("12");

            System.out.println("\uD83D\uDCE2 Duymeye vururam");
            axtarılan_element = sürücü.findElement(
                    By.xpath("(  //input[@value='Redaktə et']  )  [2]"));
            obyektın_kənarını_rəng_ilə_vurğula(sürücü, axtarılan_element);
            axtarılan_element.click();

            // yoxla
            mətnin_səhifədə_olduğunu_yoxla(sürücü, "Şifrəniz yeniləndi.");

        //Çıxış et
        sürücü.findElement(By.xpath("//a[@href ='çıxış.php']")).click();

    }

    //@Test
    public void TH_istifadəçi_profilim_səhifəsində_ad_və_soyadın_dəyişir_sonra_əsas_səhifədə_ismi_yenilənməli() throws Exception {

    }

    //@Test
    public void TH_yeni_bir_istifadəçi_qeydiyyat_edirik_və_həmin_istifadəçi_ilə_daxil_olmaq() throws Exception {
        // QeydiyyatSehifeTestleri-nden birisi idi bu...
    }

    //@Test
    public void TH_istifadəçi_A_bir_paylaşım_mətni_yazır_Onun_dostu_istifadəçi_B_daxil_olub_və_istifadəçi_A_in_paylaşım_mətnini_görməli_və_doğru_tarix_saat_ilə() throws Exception {

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
