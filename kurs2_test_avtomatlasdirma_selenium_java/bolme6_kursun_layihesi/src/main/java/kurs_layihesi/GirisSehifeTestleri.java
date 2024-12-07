package kurs_layihesi;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static KitabxanalarLibs.TestKitabxana.*;

public class GirisSehifeTestleri {
    private static WebDriver sürücü;
    // 1. Hazırlıq (Setup)
    // 2. İstenilen funksiya icra olur (Exercise)
    // 3. Yoxlama (Verify)
    // 4. Təmizləmə (Teardown)


    // 1. Hazırlıq (Setup)
    // 2. İstenilen funksiya icra olur (Exercise)
    // 3. Yoxlama (Verify)
    // 4. Təmizləmə (Teardown)
    @Test
    public void TH_İstifadəçiEtibarlıŞifrəEtibarlı()  {
        System.out.println("▶\uFE0F İstifadəçiEtibarlıŞifrəEtibarlı");
        // 1. Hazırlıq (Setup)

        // 2. İstenilen funksiya icra olur (Exercise)
        WebElement mətnQutusuİstifadəçiEmail = sürücü.findElement(
                By.xpath("//*[@name = 'epoçt']"));
        mətnQutusuİstifadəçiEmail.sendKeys("yusif@gmail.com");

        WebElement mətnQutusuŞifrə = sürücü.findElement(
                By.xpath("//*[@name = 'şifrə']"));
        mətnQutusuŞifrə.sendKeys("12");

        mp3_oyna("Düyməyə vururam");
        sürücü.findElement(By.xpath("//*[@class = 'submit']")).click();

        // 3. Yoxlama (Verify)
        // EGER Sistemə uğurlu daxil olsa, Əsas səhifə açılmalı
        mp3_oyna("Mətnin səhifədə olduğunu yoxlayıram");
        List<WebElement> axtarilan_elementler = sürücü.findElements(
                By.xpath("//*[contains(text(),'Yusif Qulamoğlu')]"));

        // 4. Təmizləmə (Teardown)
        // cixis edek
        sürücü.findElement(By.xpath("//a[@href ='çıxış.php']")).click();

    }
    @Test
    public void TH_İstifadəçiEtibarlıŞifrəEtibarsız() {
        System.out.println("▶\uFE0F İstifadəçiEtibarlıŞifrəEtibarsız");

        mp3_oyna("Mətn qutusunda mətn yazıram"); //Quqıl səhifəsini açıram
        WebElement mətnQutusuİstifadəçiEmail = sürücü.findElement(
                By.xpath("//*[@name = 'epoçt']"));
        mətnQutusuİstifadəçiEmail.sendKeys("yusif@gmail.com");

        WebElement mətnQutusuŞifrə = sürücü.findElement(
                By.xpath("//*[@name = 'şifrə']"));
        mətnQutusuŞifrə.sendKeys("yalnissifre");

        mp3_oyna("Düyməyə vururam");
        sürücü.findElement(By.xpath("//*[@class = 'submit']")).click();

        // Sistem uyğun xəta mesaj verməli
        mp3_oyna("Sistem uyğun xəta mesaj verməli");
        sürücü.findElement(By.xpath(
                "//*[contains(text(),'Yanlış istifadəçi adı və/və ya parol. Yenidən cəhd edin.')]"));

    }

    @Test
    public void TH_İstifadəçiEtibarlıŞifrəBoş() {
        mp3_oyna("Mətn qutusunda mətn yazıram"); //Quqıl səhifəsini açıram
        WebElement mətnQutusuİstifadəçiEmail = sürücü.findElement(
                By.xpath("//*[@name = 'epoçt']"));
        mətnQutusuİstifadəçiEmail.sendKeys("yusif@gmail.com");

        WebElement mətnQutusuŞifrə = sürücü.findElement(
                By.xpath("//*[@name = 'şifrə']"));
        mətnQutusuŞifrə.sendKeys("");

        mp3_oyna("Düyməyə vururam");
        sürücü.findElement(By.xpath("//*[@class = 'submit']")).click();

        // Sistem uyğun xəta mesaj verməli
        mp3_oyna("Sistem uyğun xəta mesaj verməli");
        sürücü.findElement(By.xpath(
                "//*[contains(text(),'Yanlış istifadəçi adı və/və ya parol. Yenidən cəhd edin.')]"));

    }

    @Test
    public void TH_İstifadəçiEmailFormatiEtibarsızŞifrəNəOlaBilər() {
        // email xanasi, email formatinda olmaya

        mp3_oyna("Mətn qutusunda mətn yazıram"); //Quqıl səhifəsini açıram
        WebElement mətnQutusuİstifadəçiEmail = sürücü.findElement(
                By.xpath("//*[@name = 'epoçt']"));
        mətnQutusuİstifadəçiEmail.sendKeys("epoçtYALNISformatda");

        WebElement mətnQutusuŞifrə = sürücü.findElement(
                By.xpath("//*[@name = 'şifrə']"));
        mətnQutusuŞifrə.sendKeys("şifrə");

        mp3_oyna("Düyməyə vururam");
        sürücü.findElement(By.xpath("//*[@class = 'submit']")).click();

        // Sistem uyğun xəta mesaj verməli
        mp3_oyna("Sistem uyğun xəta mesaj verməli");
        sürücü.findElement(By.xpath(
                "//*[contains(text(),'Email formatı yalnışdır')]"));
    }

    @Test
    public void TH_İstifadəçiEmailFormatiEtibarsızŞifrəBoş() {
        mp3_oyna("Mətn qutusunda mətn yazıram"); //Quqıl səhifəsini açıram
        WebElement mətnQutusuİstifadəçiEmail = sürücü.findElement(
                By.xpath("//*[@name = 'epoçt']"));
        mətnQutusuİstifadəçiEmail.sendKeys("epoçtYALNISformatda");

        WebElement mətnQutusuŞifrə = sürücü.findElement(
                By.xpath("//*[@name = 'şifrə']"));
        mətnQutusuŞifrə.sendKeys("");

        mp3_oyna("Düyməyə vururam");
        sürücü.findElement(By.xpath("//*[@class = 'submit']")).click();

        // Sistem uyğun xəta mesaj verməli
        mp3_oyna("Sistem uyğun xəta mesaj verməli");
        sürücü.findElement(By.xpath(
                "//*[contains(text(),'Email formatı yalnışdır')]"));
        sürücü.findElement(By.xpath(
                "//*[contains(text(),'Şirfə xanası doldurulmalıdır')]"));
    }

    @Test
    public void TH_İstifadəçiBoşŞifrəNəOlaBilər() {
        mp3_oyna("Mətn qutusunda mətn yazıram"); //Quqıl səhifəsini açıram
        WebElement mətnQutusuİstifadəçiEmail = sürücü.findElement(
                By.xpath("//*[@name = 'epoçt']"));
        mətnQutusuİstifadəçiEmail.sendKeys("");

        WebElement mətnQutusuŞifrə = sürücü.findElement(
                By.xpath("//*[@name = 'şifrə']"));
        mətnQutusuŞifrə.sendKeys("şifrə");

        mp3_oyna("Düyməyə vururam");
        sürücü.findElement(By.xpath("//*[@class = 'submit']")).click();

        // Sistem uyğun xəta mesaj verməli
        mp3_oyna("Sistem uyğun xəta mesaj verməli");
        sürücü.findElement(By.xpath(
                "//*[contains(text(),'İstifadəçi email xanası doldurulmalıdır')]"));
    }

    @Test
    public void TH_İstifadəçiBoşŞifrəBoş() {

        mp3_oyna("Düyməyə vururam");
        sürücü.findElement(By.xpath("//*[@class = 'submit']")).click();

        // Sistem uyğun xəta mesaj verməli
        mp3_oyna("Sistem uyğun xəta mesaj verməli");
        sürücü.findElement(By.xpath(
                "//*[contains(text(),'İstifadəçi email xanası doldurulmalıdır')]"));
        sürücü.findElement(By.xpath(
                "//*[contains(text(),'Şirfə email xanası doldurulmalıdır')]"));
    }

    @Test
    public void TH_AZ_EN_DilinəDəyişmə() {
        mp3_oyna("Dil dəyişmə düyməsinə vururam");
        sürücü.findElement(By.xpath("//*[contains(text(),'Change to English')]")).click();

        mp3_oyna("Səhifənin dilinin dəyişdirildiyini yoxlayıram");

        sürücü.findElement(
                By.xpath("//*[contains(text(),'Mini-Facebook | in English')]"));
        sürücü.findElement(
                By.xpath("//*[contains(text(),'Azərbaycan dilinə dəyiş')]"));
        sürücü.findElement(
                By.xpath("//*[contains(text(),'Sign up')]"));
        yoxlama_uğurlu();

    }

    @Test
    public void TH_EN_AZ_DilinəDəyişmə() {
        mp3_oyna("Dil dəyişmə düyməsinə vururam");
        sürücü.findElement(By.xpath("//*[contains(text(),'Azərbaycan dilinə dəyiş')]")).click();

        mp3_oyna("Səhifənin dilinin dəyişdirildiyini yoxlayıram");

        sürücü.findElement(
                By.xpath("//*[contains(text(),'Azərbaycan dilində')]"));
        sürücü.findElement(
                By.xpath("//*[contains(text(),'Change to English')]"));
        sürücü.findElement(
                By.xpath("//*[contains(text(),'Qeydiyyatdan keç')]"));
        yoxlama_uğurlu();

    }
    //-------------------------------------------------------------
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

    @AfterEach
    public void hərTestdənSonraTəmizləmə() { //tearDownTest() {
        if (sürücü != null) {
            sürücü.quit(); // Brauzeri bağlayır
        }
    }

    @AfterAll
    public static void bütovTestSetdənSonraTəmizləmə() { //tearDownClass() {
        System.out.println("Test icra prosesi tamamlandı.");
    }
}
