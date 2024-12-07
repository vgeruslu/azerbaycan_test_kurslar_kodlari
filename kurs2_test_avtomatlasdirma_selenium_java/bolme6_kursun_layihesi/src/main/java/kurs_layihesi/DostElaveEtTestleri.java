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

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static KitabxanalarLibs.TestKitabxana.*;
import static KitabxanalarLibs.TestKitabxana.mətnin_səhifədə_olduğunu_yoxla;
import static org.junit.jupiter.api.Assertions.*;

public class DostElaveEtTestleri {

    private static WebDriver sürücü;
    // 1. Hazırlıq (Setup)
    // 2. İstenilen funksiya icra olur (Exercise)
    // 3. Yoxlama (Verify)
    // 4. Təmizləmə (Teardown)

    @Test
    public void TH_Əkran_və_istifadeciler_melumatlari_düzgün_açılmalı() throws Exception {
        String cari_istifadəçi_email = "yusif@gmail.com";
        // 1. Hazırlıq (Setup)
        daxil_ol(sürücü,cari_istifadəçi_email, "12");

        // indi EsasSehife de olmaliyiq

        // 2. İstenilen funksiya icra olur (Exercise)
        // DostElaveEt sehifesine getmeliyik
        sürücü.findElement(By.xpath("//a[@href ='dost_əlavə_et.php']")).click();
        // indi dost_əlavə_et sehifesinde olmaliyiq

        // 3. Yoxlama (Verify)
        // Əkran düzgün_açılmalı
        mətnin_səhifədə_olduğunu_yoxla(sürücü, "Bütün istifadəçilərin siyahısı");

        /* istifadeciler melumatları düzgünaçılmalı :
           Yoxlama 1- Bütün istifadəçilər siyahıdə görünməli

           Yoxlama 2- Cari istifadəçi ("yusif@gmail.com") ilə dost olan istifadəçilər isimləri altında "Artıq dostunuz"
            yazılmalı

           Yoxlama 3-Və cari istifadəçi ilə dost olMAYan istifadəçilər isimləri altında "Dostluq sorğusu göndər" yazılmalı.
        */

        // Yoxlama 1- Bütün istifadəçilər siyahıdə görünməli
        System.out.println("❓ Yoxlama 1- Bütün istifadəçilər siyahıdə görünməli");

        // Bağlantı obyektləri
        Connection bağlantı = db_bağlantısı_yarat();
        Statement statement = null;
        ResultSet resultSet = null;

        class Istifadəçi
        {
            public String epoçt;
            public String ad;
            public String   soyad;
        };
        List<Istifadəçi> istifadəçiler=new ArrayList<Istifadəçi>();
        List<String> db_den_istifadəçi_tam_adlari = new ArrayList<String>();

        try {
            // SQL sorğusu yaradılır
            String query = ("SELECT epoçt, ad, soyad FROM tbl_istifadəçi " +
                    "WHERE epoçt != '"+ cari_istifadəçi_email + "'");
            statement = bağlantı.createStatement();

            // SQL sorğusu icra edilir
            resultSet = statement.executeQuery(query);

            // Nəticələr oxunur
            Istifadəçi istifadəçi = new Istifadəçi();
            while (resultSet.next()) {
                // Sətirləri oxumaq üçün sütun adlarını istifadə edin
                // epoçt 		ad 	soyad
                istifadəçi.epoçt =  resultSet.getString("epoçt");
                istifadəçi.ad =  resultSet.getString("ad");
                istifadəçi.soyad =  resultSet.getString("soyad");
                //System.out.println("DB-den istifadəçi melumati oxundu: " + istifadəçi.epoçt + "---" +
                // istifadəçi.ad + "---" + istifadəçi.soyad);
                istifadəçiler.add(istifadəçi);
                db_den_istifadəçi_tam_adlari.add(istifadəçi.ad + " " + istifadəçi.soyad);
            }
        } catch (Exception e) {
            // Xətaları idarə edir
            System.out.println("❌ DB-e bağlantı və ya sorğu zamanı xəta gorundu: " + e.getMessage());
            fail();
        } finally {
            // Resursları bağlayırıq
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (bağlantı != null) bağlantı.close();
            } catch (Exception e) {
                System.out.println("❌ Resursları bağlama zamanı xəta: " + e.getMessage());
                fail();
            }
        }
        //istifadəçiler
        List<WebElement> ekrandaki_butov_istifadeciler = sürücü.findElements(By.xpath(
                "//div[@name='istifadəçi_tam_adi']"));
        int ekrandaki_istifadeci_sayi = 0;
        for (WebElement ekrandaki_istifadeci : ekrandaki_butov_istifadeciler) {
            String ekrandaki_tam_ad = ekrandaki_istifadeci.getAttribute("innerHTML");
            System.out.println("ekrandaki_tam_ad = " + ekrandaki_tam_ad); //Leyla Qulamoğlu
            /*String[] ad_yazi_parcalanmis = ekrandaki_tam_ad.split("\\s+");
            System.out.println("ekrandaki_ad = " + ad_yazi_parcalanmis[0]);
            System.out.println("ekrandaki_soyad = " + ad_yazi_parcalanmis[1]); */
            assertTrue(db_den_istifadəçi_tam_adlari.contains(ekrandaki_tam_ad),
                    "ekrandaki_tam_ad (" + ekrandaki_tam_ad + ") db_deki gelen istifadəçi adlarda tapilmadi");

            //WebElement paylaşımı_sil_duymesi =  sürücü.findElement(By.xpath(
            //        "(//div[contains(text(),  'Yusif:')]//a[text()='Paylaşımı sil'])[" + index + "]"));
            //obyektın_kənarını_rəng_ilə_vurğula(sürücü, paylaşımı_sil_duymesi);
            ekrandaki_istifadeci_sayi++;
        }

        assertEquals(ekrandaki_istifadeci_sayi, db_den_istifadəçi_tam_adlari.size(),
                "ekrandaki_istifadeci_sayi ("+ ekrandaki_istifadeci_sayi + ")ve DB-deki istifadəçi_sayi ("+
                        db_den_istifadəçi_tam_adlari.size()+ ") eyni degiller");

        // Yoxlama 2- Cari istifadəçi ("yusif@gmail.com") ilə dost olan istifadəçilər isimləri altında "Artıq dostunuz"
        System.out.println("❓ Yoxlama 2- Cari istifadəçi (yusif@gmail.com) ilə dost olan istifadəçilər isimləri altında 'Artıq dostunuz'");

        // Yoxlama 3-Və cari istifadəçi ilə dost olMAYan istifadəçilər isimləri altında "Dostluq sorğusu göndər" yazılmalı.
        System.out.println("❓ Yoxlama 3-Və cari istifadəçi ilə dost olMAYan istifadəçilər isimləri altında 'Dostluq sorğusu göndər' yazılmalı.");

        // 4. Təmizləmə (Teardown)
        // cixis et
        sürücü.findElement(By.xpath("//a[@href ='çıxış.php']")).click();
    }

    //@Test
    public void TH_Bir_istifadəçinin_profilini_görmək() throws Exception {

    }

    //@Test
    public void TH_Dostluq_sorğusu_göndərmək() throws Exception {

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
