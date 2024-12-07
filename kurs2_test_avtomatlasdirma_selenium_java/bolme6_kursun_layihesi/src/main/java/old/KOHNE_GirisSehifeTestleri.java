package old;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static KitabxanalarLibs.TestKitabxana.*;

public class KOHNE_GirisSehifeTestleri {
    static WebDriver sürücü;



    public static void İstifadəçiEtibarlıŞifrəEtibarlı() throws Exception {
        mp3_oyna("Mətn qutusunda mətn yazıram"); //Quqıl səhifəsini açıram
        WebElement mətnQutusuİstifadəçiEmail = sürücü.findElement(
                By.xpath("//*[@name = 'epoçt']"));
        mətnQutusuİstifadəçiEmail.sendKeys("yusif@gmail.com");
        // Etibarlı bir İstifadəçi adı və etibarlı Şifrə daxil edir (verilən email və şifrə birgə, sistem DB-sində bir hesab ilə "match" edirlər)
        WebElement mətnQutusuŞifrə = sürücü.findElement(
                By.xpath("//*[@name = 'şifrə']"));
        mətnQutusuŞifrə.sendKeys("12");

        mp3_oyna("Düyməyə vururam");
        sürücü.findElement(By.xpath("//*[@class = 'submit']")).click();

        // Sistemə uğurlu daxil olmaq. Əsas səhifə açılmalı
        mp3_oyna("Mətnin səhifədə olduğunu yoxlayıram");
        List<WebElement> axtarilan_elementler = sürücü.findElements(
                By.xpath("//*[contains(text(),'Yusif Qulamoğlu')]"));

        // cixis edek
        sürücü.findElement(By.xpath("//a[@href ='çıxış.php']")).click();

        //Assert.assertTrue("İstifadəçi adı səhifədə tapılmadı", axtarilan_elementler.size() > 0);
        if (axtarilan_elementler.size() > 0)
            yoxlama_uğurlu();
        else {
            yoxlama_uğursuz();
            //fail();
        }
    }

    public static void İstifadəçiEtibarlıŞifrəEtibarsız() throws Exception {
        mp3_oyna("Mətn qutusunda mətn yazıram"); //Quqıl səhifəsini açıram
        WebElement mətnQutusuİstifadəçiEmail = sürücü.findElement(
                By.xpath("//*[@name = 'epoçt']"));
        mətnQutusuİstifadəçiEmail.sendKeys("yusif@gmail.com");
        // Etibarlı bir İstifadəçi adı və etibarlı Şifrə daxil edir (verilən email və şifrə birgə, sistem DB-sində bir hesab ilə "match" edirlər)
        WebElement mətnQutusuŞifrə = sürücü.findElement(
                By.xpath("//*[@name = 'şifrə']"));
        mətnQutusuŞifrə.sendKeys("yalnissifre");

        mp3_oyna("Düyməyə vururam");
        sürücü.findElement(By.xpath("//*[@class = 'submit']")).click();

        // Sistem uyğun xəta mesaj verməli
        mp3_oyna("Sistem uyğun xəta mesaj verməli");
        List<WebElement> axtarilan_elementler = sürücü.findElements(
                By.xpath("//*[contains(text(),'Yanlış istifadəçi adı və/və ya parol. Yenidən cəhd edin.')]"));

        //Assert.assertTrue("İstifadəçi adı səhifədə tapılmadı", axtarilan_elementler.size() > 0);
        if (axtarilan_elementler.size() > 0)
            yoxlama_uğurlu();
        else {
            yoxlama_uğursuz();
            //fail();
        }
    }

    public static void İstifadəçiEtibarlıŞifrəBoş() throws Exception{
        mp3_oyna("Mətn qutusunda mətn yazıram"); //Quqıl səhifəsini açıram
        WebElement mətnQutusuİstifadəçiEmail = sürücü.findElement(
                By.xpath("//*[@name = 'epoçt']"));
        mətnQutusuİstifadəçiEmail.sendKeys("yusif@gmail.com");
        // Etibarlı bir İstifadəçi adı və etibarlı Şifrə daxil edir (verilən email və şifrə birgə, sistem DB-sində bir hesab ilə "match" edirlər)
        WebElement mətnQutusuŞifrə = sürücü.findElement(
                By.xpath("//*[@name = 'şifrə']"));
        mətnQutusuŞifrə.sendKeys("");

        mp3_oyna("Düyməyə vururam");
        sürücü.findElement(By.xpath("//*[@class = 'submit']")).click();

        // Sistem uyğun xəta mesaj verməli
        mp3_oyna("Sistem uyğun xəta mesaj verməli");
        List<WebElement> axtarilan_elementler = sürücü.findElements(
                By.xpath("//*[contains(text(),'Yanlış istifadəçi adı və/və ya parol. Yenidən cəhd edin.')]"));

        //Assert.assertTrue("İstifadəçi adı səhifədə tapılmadı", axtarilan_elementler.size() > 0);
        if (axtarilan_elementler.size() > 0)
            yoxlama_uğurlu();
        else {
            yoxlama_uğursuz();
            //fail();
        }
    }

    public static void İstifadəçiEtibarsızŞifrəEtibarlı() throws Exception{
            // bu test hala ehtiyac yox
    }

    public static void İstifadəçiEtibarsızŞifrəEtibarsız() throws Exception{
        mp3_oyna("Mətn qutusunda mətn yazıram"); //Quqıl səhifəsini açıram
        WebElement mətnQutusuİstifadəçiEmail = sürücü.findElement(
                By.xpath("//*[@name = 'epoçt']"));
        mətnQutusuİstifadəçiEmail.sendKeys("yusif@gmailXYZ.com");
        // Etibarlı bir İstifadəçi adı və etibarlı Şifrə daxil edir (verilən email və şifrə birgə, sistem DB-sində bir hesab ilə "match" edirlər)
        WebElement mətnQutusuŞifrə = sürücü.findElement(
                By.xpath("//*[@name = 'şifrə']"));
        mətnQutusuŞifrə.sendKeys("xxx");

        mp3_oyna("Düyməyə vururam");
        sürücü.findElement(By.xpath("//*[@class = 'submit']")).click();

        // Sistem uyğun xəta mesaj verməli
        mp3_oyna("Sistem uyğun xəta mesaj verməli");
        List<WebElement> axtarilan_elementler = sürücü.findElements(
                By.xpath("//*[contains(text(),'Yanlış istifadəçi adı və/və ya parol. Yenidən cəhd edin.')]"));

        //Assert.assertTrue("İstifadəçi adı səhifədə tapılmadı", axtarilan_elementler.size() > 0);
        if (axtarilan_elementler.size() > 0)
            yoxlama_uğurlu();
        else {
            yoxlama_uğursuz();
            //fail();
        }
    }

    public static void İstifadəçiEtibarsızŞifrəBoş() throws Exception{
        mp3_oyna("Mətn qutusunda mətn yazıram"); //Quqıl səhifəsini açıram
        WebElement mətnQutusuİstifadəçiEmail = sürücü.findElement(
                By.xpath("//*[@name = 'epoçt']"));
        mətnQutusuİstifadəçiEmail.sendKeys("yusif@gmailXYZ.com");
        // Etibarlı bir İstifadəçi adı və etibarlı Şifrə daxil edir (verilən email və şifrə birgə, sistem DB-sində bir hesab ilə "match" edirlər)
        WebElement mətnQutusuŞifrə = sürücü.findElement(
                By.xpath("//*[@name = 'şifrə']"));
        mətnQutusuŞifrə.sendKeys("xxx");

        mp3_oyna("Düyməyə vururam");
        sürücü.findElement(By.xpath("//*[@class = 'submit']")).click();

        // Sistem uyğun xəta mesaj verməli
        mp3_oyna("Sistem uyğun xəta mesaj verməli");
        List<WebElement> axtarilan_elementler = sürücü.findElements(
                By.xpath("//*[contains(text(),'Yanlış istifadəçi adı və/və ya parol. Yenidən cəhd edin.')]"));

        //Assert.assertTrue("İstifadəçi adı səhifədə tapılmadı", axtarilan_elementler.size() > 0);
        if (axtarilan_elementler.size() > 0)
            yoxlama_uğurlu();
        else {
            yoxlama_uğursuz();
            //fail();
        }
    }

    public static void İstifadəçiBoşŞifrəEtibarlı() throws Exception{

    }

    public static void İstifadəçiBoşŞifrəEtibarsız() throws Exception{

    }

    public static void İstifadəçiBoşŞifrəBoş() throws Exception{

    }

    public static void AZ_EN_DilinəDəyişmə() throws Exception{
        mp3_oyna("Dil dəyişmə düyməsinə vururam");
        sürücü.findElement(By.xpath("//*[contains(text(),'Change to English')]")).click();

        mp3_oyna("Səhifənin dilinin dəyişdirildiyini yoxlayıram");

        mətnin_səhifədə_olduğunu_yoxla(sürücü, "Mini-Facebook | in English");
        mətnin_səhifədə_olduğunu_yoxla(sürücü, "Azərbaycan dilinə dəyiş");
        mətnin_səhifədə_olduğunu_yoxla(sürücü, "Sign up");
    }

    public static void EN_AZ_DilinəDəyişmə() throws Exception{
        mp3_oyna("Dil dəyişmə düyməsinə vururam");
        sürücü.findElement(By.xpath("//*[contains(text(),'Azərbaycan dilinə dəyiş')]")).click();

        mp3_oyna("Səhifənin dilinin dəyişdirildiyini yoxlayıram");

        mətnin_səhifədə_olduğunu_yoxla(sürücü, "Azərbaycan dilində");
        mətnin_səhifədə_olduğunu_yoxla(sürücü, "Change to English");
        mətnin_səhifədə_olduğunu_yoxla(sürücü, "Qeydiyyatdan keç");
    }

    public static void main(String[] args) {
        System.out.println("Giriş səhifə testləri başlayır");
        WebDriverManager.chromedriver().setup();
        sürücü = new ChromeDriver();
        brauzerin_mövqe_və_ölçüsünü_dəyiş(sürücü, -1000, 100, 1000, 600);

        try {
            sürücü.get("http://localhost/MiniFacebook/daxil_ol.php");
            sürücü.navigate().refresh();

            // Test ssenarilərini bir-bir çağırırıq
            String[] testlər = {
                    "İstifadəçiEtibarlıŞifrəEtibarlı",
                    "İstifadəçiEtibarlıŞifrəEtibarsız",
                    "İstifadəçiEtibarlıŞifrəBoş",
                    "İstifadəçiEtibarsızŞifrəEtibarlı",
                    "İstifadəçiEtibarsızŞifrəEtibarsız",
                    "İstifadəçiEtibarsızŞifrəBoş",
                    "İstifadəçiBoşŞifrəEtibarlı",
                    "İstifadəçiBoşŞifrəEtibarsız",
                    "İstifadəçiBoşŞifrəBoş",
                    "AZ_EN_DilinəDəyişmə",
                    "EN_AZ_DilinəDəyişmə"
            };

            test_seti_icra_et("Giriş səhifənin testləri", testlər);

        } catch (Exception e) {
            System.out.println("❌ GirisSehifeTestleri -- Ümumi test istisnası: " + e.getMessage());
        } finally {
            sürücü.quit();
        }
    } // end main

} // class
