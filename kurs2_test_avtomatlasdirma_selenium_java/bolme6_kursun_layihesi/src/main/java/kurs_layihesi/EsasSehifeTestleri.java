package kurs_layihesi;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import static KitabxanalarLibs.TestKitabxana.*;
import static KitabxanalarLibs.TestKitabxana.mətnin_səhifədə_olduğunu_yoxla;
import static org.junit.jupiter.api.Assertions.fail;

public class EsasSehifeTestleri {
    private static WebDriver sürücü;
    // 1. Hazırlıq (Setup)
    // 2. İstenilen funksiya icra olur (Exercise)
    // 3. Yoxlama (Verify)
    // 4. Təmizləmə (Teardown)

    //@Test
    public void ƏsasSəhifəƏkranıXanalarıVəMəlumatıDüzgünAçılmalı() throws Exception {
        // 1. Hazırlıq (Setup)
        daxil_ol(sürücü, "yusif@gmail.com", "12");

        // 2. İstenilen funksiya icra olur (Exercise)

        // 3. Yoxlama (Verify)
        // İstifadəçinin ismi, şəkili, dostlar siyahısı, və xəbər lenti doğru açılır mı?
        System.out.println("❔ Əsas səhifə əkranı xanaları və məlumatının düzgün açıldıqlarını yoxlayıram");

        mp3_oyna("Mətnin səhifədə olduğunu yoxlayıram");
        mətnin_səhifədə_olduğunu_yoxla(sürücü, "Yusif Qulamoğlu");
        /*WebElement axtarılan_element = sürücü.findElement(
                By.xpath("//*[contains(text(),'Yusif Qulamoğlu')]"));
        ObyektınKənarınıRəngləVurğula(sürücü, axtarılan_element);*/

        // şəkili
        mp3_oyna("Profil şəklinin səhifədə mövcudluğunu yoxlayıram");
        WebElement axtarılan_element = sürücü.findElement(
                By.xpath("//img[@src='istifadəçi_üz_şəkilləri\\yusif@gmail.com.jpg']"));
        obyektın_kənarını_rəng_ilə_vurğula(sürücü, axtarılan_element);

        //  dostlar siyahısı doğru açılır mı?
        mətnin_səhifədə_olduğunu_yoxla(sürücü, "Dostlar");
        /*axtarılan_element = sürücü.findElement(
                By.xpath("//*[contains(text(),'Dostlar')]"));
        ObyektınKənarınıRəngləVurğula(sürücü, axtarılan_element);*/

        // DB-den Dostlar melumatini alaq
        //MP3_oyna("Ekrandakı vurqulanan məlumatları, verilənlər bazasındakı məlumatlarla müqayisə edirəm");
        //db_den_melumati_oxu();
        //db_den_yoxla_bu_istifadecinin_dostlarini

        //  xəbər lenti doğru açılır mı?
        mətnin_səhifədə_olduğunu_yoxla(sürücü, "Xəbər lentı:");
        /*axtarılan_element = sürücü.findElement(
                By.xpath("//*[contains(text(),'Xəbər lentı:')]"));
        ObyektınKənarınıRəngləVurğula(sürücü, axtarılan_element);*/

        // İDEAL: DB-dəki xəbər / paylaşım məlumatlarını --- əkrandakl paylaşım məlumatlarını MÜQAYİSƏ
        // etmək və onların EYNİ olduqlarını yoxlamaq
        // TBD = EDİLMƏLİ

        // 4. Təmizləmə (Teardown)
        // cixis et
        sürücü.findElement(By.xpath("//a[@href ='çıxış.php']")).click();
    }

    //@Test
    public void PaylaşımXüsusiyyətiHappyPathPaylaşımMətniBoşOlmaya () throws Exception {
        // 1. Hazırlıq (Setup)
        daxil_ol(sürücü,"yusif@gmail.com", "12");

        // indi EsasSehife de olmaliyiq

        // 2. İstenilen funksiya icra olur (Exercise)
        // Paylaşım mətn xanasında bir mətn yazır və Paylaş düyməsinə vurur
        String yeni_paylaşımın_mətni = "Etibarlı bir mətn (boş deyil)";
        sürücü.findElement(By.xpath("//*[@name = 'yeni_paylaşım']")).
                sendKeys(yeni_paylaşımın_mətni);

        // duymeye vur
        // 2024-12-06 16:54:21
        String indiki_tarix_ve_saat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm").format(Calendar.getInstance().getTime());;
        System.out.println("indiki_tarix_ve_saat = " + indiki_tarix_ve_saat);

        sürücü.findElement(By.xpath("//input[@value='Paylaş']")).click();

        // 3. Yoxlama (Verify)
        //ustdeki metnde bir yeni_paylaşım siyahiye elave olmali
        // Həmin mətn xəbər lentinə əlavə olmalı və doğru (cari) tarix və saat altında yazılmalı
        mətnin_səhifədə_olduğunu_yoxla(sürücü, yeni_paylaşımın_mətni);
        mətnin_səhifədə_olduğunu_yoxla(sürücü, indiki_tarix_ve_saat);

        // 4. Təmizləmə (Teardown)
        // cixis et
        sürücü.findElement(By.xpath("//a[@href ='çıxış.php']")).click();
    }

    //@Test
    public void PaylaşımXüsusiyyətiNegativPaylaşımMətniBoşOla () throws Exception {
        // 1. Hazırlıq (Setup)
        daxil_ol(sürücü,"yusif@gmail.com", "12");

        // indi EsasSehife de olmaliyiq

        // 2. İstenilen funksiya icra olur (Exercise)
        // Paylaşım mətn xanasında bir mətn yazır və Paylaş düyməsinə vurur
        sürücü.findElement(By.xpath("//*[@name = 'yeni_paylaşım']")).
                sendKeys("");

        // duymeye vur
        // 2024-12-06 16:54:21
        String indiki_tarix_ve_saat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm").format(Calendar.getInstance().getTime());;
        System.out.println("indiki_tarix_ve_saat = " + indiki_tarix_ve_saat);

        sürücü.findElement(By.xpath("//input[@value='Paylaş']")).click();

        // 3. Yoxlama (Verify)
        // Sistem uyğun xəta mesaj verməli
        mp3_oyna("Sistem uyğun xəta mesaj verməli");
        sürücü.findElement(By.xpath(
                "//*[contains(text(),'Paylaşım mətni boş olmamalı')]"));

        // 4. Təmizləmə (Teardown)
        // cixis et
        sürücü.findElement(By.xpath("//a[@href ='çıxış.php']")).click();

    }

    //@Test
    public void CariİstifadəçiÖzPaylaşımlarınınQabağındaSilDüyməsiOlmalı () throws Exception {
        // 1. Hazırlıq (Setup)
        daxil_ol(sürücü,"yusif@gmail.com", "12");

        // indi EsasSehife de olmaliyiq

        // 2. İstenilen funksiya icra olur (Exercise)
        // Paylaşım mətn xanasında bir mətn yazır və Paylaş düyməsinə vurur


        // 3. Yoxlama (Verify)
        // bu userin butvo paylasimlar qabaginda, "Paylaşımı sil" duymesi oldugunu yoxla
        List<WebElement> buIstifadecininButovPaylasimlari= sürücü.findElements(By.xpath(
                "//div[contains(text(),  'Yusif:')]"));
        int index = 1;
        for (WebElement birPaylasimDivi : buIstifadecininButovPaylasimlari) {
            // div-in icinde,  "Paylaşımı sil" duymesi oldugunu yoxla
            WebElement paylaşımı_sil_duymesi =  sürücü.findElement(By.xpath(
                    "(//div[contains(text(),  'Yusif:')]//a[text()='Paylaşımı sil'])[" + index + "]"));
            obyektın_kənarını_rəng_ilə_vurğula(sürücü, paylaşımı_sil_duymesi);
            index++;
        }

        // 4. Təmizləmə (Teardown)
        // cixis et
        sürücü.findElement(By.xpath("//a[@href ='çıxış.php']")).click();
    }

    //@Test
    public void CariİstifadəçiÖzBirPaylaşımınıSilmək () throws Exception {
        // 1. Hazırlıq (Setup)
        daxil_ol(sürücü,"yusif@gmail.com", "12");

        // indi EsasSehife de olmaliyiq

        // 2. İstenilen funksiya icra olur (Exercise)
        System.out.println("Test bir paylaşım əlavə edirəm: TEST PAYLASIM-SILMEK UCUN");
        sürücü.findElement(By.xpath("//*[@name = 'yeni_paylaşım']")).
                sendKeys("TEST PAYLASIM-SILMEK UCUN");

        // duymeye vur
        sürücü.findElement(By.xpath("//input[@value='Paylaş']")).click();

        mətnin_səhifədə_olduğunu_yoxla(sürücü, "TEST PAYLASIM-SILMEK UCUN");

        // Öz paylaşımlarından - ustdeki, "TEST PAYLASIM-SILMEK UCUN" - sil düyməsinə vurur
        System.out.println("Sil düyməsinə vururam");
        sürücü.findElement(By.xpath(
                "//div//*[contains(text(), 'TEST PAYLASIM-SILMEK UCUN')]/parent::div//*[text()='Paylaşımı sil']")).click();

        // silindiyini yoxla -- mətnin səhifədə olmadığını
        System.out.println("Test paylaşımın silindiyini yoxlayıram");

        if (sürücü.findElements(By.xpath("//*[contains(text(), 'TEST PAYLASIM-SILMEK UCUN')]")).size() == 0)
            yoxlama_uğurlu(); // yoxdur
        else {
            yoxlama_uğurlu();
            fail("Silinmiş payaşım 'TEST PAYLASIM-SILMEK UCUN' hələ də səhifədə var !");
        }

        // 4. Təmizləmə (Teardown)
        // cixis et
        sürücü.findElement(By.xpath("//a[@href ='çıxış.php']")).click();
    }

    //@Test
    public void CariİstifadəçiDostlarınınPaylaşımlarınıSiləBilməməli () throws Exception{
        // 1. Hazırlıq (Setup)
        // 2. İstenilen funksiya icra olur (Exercise)
        // 3. Yoxlama (Verify)
        // 4. Təmizləmə (Teardown)

        //Əsas səhifə də olarkən
        // Dostların paylaşımlarının yanında "Paylaşım sil" düyməsi olmamalı.
        // Qeyd: Dostlardan ən az bir paylaşım olmalı sistemdə. (TEST DATA management)
    }

    //@Test
    public void DostluqdanÇıxarma () throws Exception{
        // 1. Hazırlıq (Setup)
        // 2. İstenilen funksiya icra olur (Exercise)
        // 3. Yoxlama (Verify)
        // 4. Təmizləmə (Teardown)
    }

    //@Test
    public void BirDostunProfiliniGörmək () throws Exception{
        // 1. Hazırlıq (Setup)
        // 2. İstenilen funksiya icra olur (Exercise)
        // 3. Yoxlama (Verify)
        // 4. Təmizləmə (Teardown)
    }

    //@Test
    public void HərHansıSəhifədəÇıxışDüyməsiDüzgünÇıxışEdir () throws Exception{
        // 1. Hazırlıq (Setup)
        // 2. İstenilen funksiya icra olur (Exercise)
        // 3. Yoxlama (Verify)
        // 4. Təmizləmə (Teardown)
    }

   // @Test
    public void AZ_EN_DilinəDəyişmə() throws Exception{
        daxil_ol(sürücü,"yusif@gmail.com", "12");
        mp3_oyna("Dil dəyişmə düyməsinə vururam");
        sürücü.findElement(By.xpath(
                "//*[contains(text(),'Change to English')]")).click();

        mp3_oyna("Səhifənin dilinin dəyişdirildiyini yoxlayıram");

        mətnin_səhifədə_olduğunu_yoxla(sürücü, "Mini-Facebook | in English");
        mətnin_səhifədə_olduğunu_yoxla(sürücü, "Azərbaycan dilinə dəyiş");
        mətnin_səhifədə_olduğunu_yoxla(sürücü, "Add Friend");

        // 4. Təmizləmə (Teardown)
        // cixis et
        sürücü.findElement(By.xpath("//a[@href ='çıxış.php']")).click();

    }

   // @Test
    public void EN_AZ_DilinəDəyişmə() throws Exception{
        daxil_ol(sürücü,"yusif@gmail.com", "12");
        // sayt, default AZ dilinde acilir ilk
        // ona gore, EN diline cevirmeyi vurub, sonra tekrar AZ diline cevirmeyi vurmaliyiq
        sürücü.findElement(By.xpath(
                "//*[contains(text(),'Change to English')]")).click();

        mp3_oyna("Dil dəyişmə düyməsinə vururam");
        sürücü.findElement(By.xpath(
                "//*[contains(text(),'Azərbaycan dilinə dəyiş')]")).click();

        mp3_oyna("Səhifənin dilinin dəyişdirildiyini yoxlayıram");

        mətnin_səhifədə_olduğunu_yoxla(sürücü, "Azərbaycan dilində");
        mətnin_səhifədə_olduğunu_yoxla(sürücü, "Change to English");
        mətnin_səhifədə_olduğunu_yoxla(sürücü, "Dost əlavə et");

        // 4. Təmizləmə (Teardown)
        // cixis et
        sürücü.findElement(By.xpath("//a[@href ='çıxış.php']")).click();

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
    /*public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        System.out.println("❌ InvocationTargetException. Sebeb = ");
    }*/

    /*@AfterEach
    public void hərTestdənSonraTəmizləmə() { //tearDownTest() {
        if (sürücü != null) {
            sürücü.quit(); // Brauzeri bağlayır
        }
    }*/

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

    public static void db_den_yoxla_bu_istifadecinin_dostlarini() {
        // MySQL bağlantı detalları
        String url = "jdbc:mysql://localhost:3306/mini_facebook"; // Məlumat bazası URL-i
        String username = "root"; // MySQL istifadəçi adı
        String password = ""; // MySQL parolu

        // Bağlantı obyektləri
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // MySQL-ə bağlantı yaradılır
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("✅ Bağlantı uğurla quruldu!");

            // SQL sorğusu yaradılır
            String query = "SELECT * FROM tbl_dostluq_münasibətləri"; // Sorğunuza uyğun cədvəl adı
            statement = connection.createStatement();

            // SQL sorğusu icra edilir
            resultSet = statement.executeQuery(query);

            // Nəticələr oxunur
            while (resultSet.next()) {
                // Sətirləri oxumaq üçün sütun adlarını istifadə edin
                System.out.println("istifadəçi1_epoçt: " + resultSet.getString("istifadəçi1_epoçt"));
                System.out.println("istifadəçi2_epoçt: " + resultSet.getString("istifadəçi2_epoçt"));
            }
        } catch (Exception e) {
            // Xətaları idarə edir
            System.out.println("❌ Bağlantı və ya sorğu zamanı xəta: " + e.getMessage());
        } finally {
            // Resursları bağlayırıq
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                System.out.println("❌ Resursları bağlama zamanı xəta: " + e.getMessage());
            }
        }
    }  // end func

} // end class
