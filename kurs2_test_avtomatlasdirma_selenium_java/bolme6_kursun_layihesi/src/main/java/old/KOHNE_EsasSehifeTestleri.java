package old;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.reflect.InvocationTargetException;

import static KitabxanalarLibs.TestKitabxana.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class KOHNE_EsasSehifeTestleri {
    static WebDriver sürücü;

    public static void UğurluDaxilOl(String istifadəçiEmaili, String şifrə) throws Exception {
        mp3_oyna("Uğurlu daxil oluram"); //Quqıl səhifəsini açıram
        WebElement mətnQutusuİstifadəçiEmail = sürücü.findElement(
                By.xpath("//*[@name = 'epoçt']"));
        mətnQutusuİstifadəçiEmail.sendKeys(istifadəçiEmaili);
        // Etibarlı bir İstifadəçi adı və etibarlı Şifrə daxil edir (verilən email və şifrə birgə, sistem DB-sində bir hesab ilə "match" edirlər)
        WebElement mətnQutusuŞifrə = sürücü.findElement(
                By.xpath("//*[@name = 'şifrə']"));
        mətnQutusuŞifrə.sendKeys(şifrə);

        mp3_oyna("Düyməyə vururam");
        sürücü.findElement(By.xpath("//*[@class = 'submit']")).click();
    }

    public static void db_den_melumati_oxu() throws Exception{
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
    }

    public static void ƏsasSəhifəƏkranıXanalarıVəMəlumatıDüzgünAçılmalı () throws Exception{
        // 1. Hazırlıq (Setup)
        // 2. İstenilen funksiya icra olur (Exercise)
        UğurluDaxilOl("yusif@gmail.com", "12");

        // 3. Yoxlama (Verify)
        // İstifadəçinin ismi, şəkili, dostlar siyahısı, və xəbər lenti doğru açılır mı?
        mp3_oyna("Mətnin səhifədə olduğunu yoxlayıram");
        WebElement axtarılan_element = sürücü.findElement(
                By.xpath("//*[contains(text(),'Yusif Qulamoğlu')]"));
        obyektın_kənarını_rəng_ilə_vurğula(sürücü, axtarılan_element);
        yoxlama_uğurlu();

        // şəkili
        mp3_oyna("Profil şəklinin səhifədə mövcudluğunu yoxlayıram");
        axtarılan_element = sürücü.findElement(
                By.xpath("//img[@src='istifadəçi_üz_şəkilləri\\yusif@gmail.com.jpg']"));
        obyektın_kənarını_rəng_ilə_vurğula(sürücü, axtarılan_element);
        yoxlama_uğurlu();

        //  dostlar siyahısı, və xəbər lenti doğru açılır mı?
        mp3_oyna("Ekrandakı vurqulanan məlumatları, verilənlər bazasındakı məlumatlarla müqayisə edirəm");
        axtarılan_element = sürücü.findElement(
                By.xpath("//*[contains(text(),'Dostlar')]"));
        obyektın_kənarını_rəng_ilə_vurğula(sürücü, axtarılan_element);

        // DB-den Dostlar melumatini alaq
        db_den_melumati_oxu();



        // 4. Təmizləmə (Teardown)
        // cixis et
        sürücü.findElement(By.xpath("//a[@href ='çıxış.php']")).click();
    }
    public static void PaylaşımXüsusiyyətiHappyPathPaylaşımMətniBoşOlmaya () throws Exception{
    }
    public static void PaylaşımXüsusiyyətiNegativPaylaşımMətniBoşOla () throws Exception{
    }
    public static void CariİstifadəçiÖzPaylaşımlarınıSiləBilməli () throws Exception{
    }
    public static void CariİstifadəçiDostlarınınPaylaşımlarınıSiləBilməməli () throws Exception{
    }
    public static void DostluqdanÇıxarma () throws Exception{
    }
    public static void BirDostunProfiliniGörmək () throws Exception{
    }
    public static void HərHansıSəhifədəÇıxışDüyməsiDüzgünÇıxışEdir () throws Exception{
    }


    public static void AZ_EN_DilinəDəyişmə() throws Exception{
        UğurluDaxilOl("yusif@gmail.com", "12");
        mp3_oyna("Dil dəyişmə düyməsinə vururam");
        sürücü.findElement(By.xpath("//*[contains(text(),'Change to English')]")).click();

        mp3_oyna("Səhifənin dilinin dəyişdirildiyini yoxlayıram");

        //MətninSəhifədəOlduğunuYoxla(sürücü, "Mini-Facebook | in English");
        //MətninSəhifədəOlduğunuYoxla(sürücü, "Azərbaycan dilinə dəyiş");
        mətnin_səhifədə_olduğunu_yoxla(sürücü, "Sign up");

        // 4. Təmizləmə (Teardown)
        // cixis et
        sürücü.findElement(By.xpath("//a[@href ='çıxış.php']")).click();

    }

    public static void EN_AZ_DilinəDəyişmə() throws Exception{
        UğurluDaxilOl("yusif@gmail.com", "12");
        mp3_oyna("Dil dəyişmə düyməsinə vururam");
        sürücü.findElement(By.xpath("//*[contains(text(),'Azərbaycan dilinə dəyiş')]")).click();

        mp3_oyna("Səhifənin dilinin dəyişdirildiyini yoxlayıram");

        mətnin_səhifədə_olduğunu_yoxla(sürücü, "Azərbaycan dilində");
        mətnin_səhifədə_olduğunu_yoxla(sürücü, "Change to English");
        mətnin_səhifədə_olduğunu_yoxla(sürücü, "Qeydiyyatdan keç");

        // 4. Təmizləmə (Teardown)
        // cixis et
        sürücü.findElement(By.xpath("//a[@href ='çıxış.php']")).click();

    }

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        sürücü = new ChromeDriver();
        brauzerin_mövqe_və_ölçüsünü_dəyiş(sürücü, -1000, 100, 1000, 600);

        try {
            sürücü.get("http://localhost/MiniFacebook/daxil_ol.php");
            sürücü.navigate().refresh();

            // Test ssenarilərini bir-bir çağırırıq
            String[] testlər = {
                    "ƏsasSəhifəƏkranıXanalarıVəMəlumatıDüzgünAçılmalı",
                    "PaylaşımXüsusiyyətiHappyPathPaylaşımMətniBoşOlmaya",
                    "PaylaşımXüsusiyyətiNegativPaylaşımMətniBoşOla",
                    "CariİstifadəçiÖzPaylaşımlarınıSiləBilməli",
                    "CariİstifadəçiDostlarınınPaylaşımlarınıSiləBilməməli",
                    "DostluqdanÇıxarma",
                    "BirDostunProfiliniGörmək",
                    "HərHansıSəhifədəÇıxışDüyməsiDüzgünÇıxışEdir",
                    "AZ_EN_DilinəDəyişmə",
                    "EN_AZ_DilinəDəyişmə"
            };

            test_seti_icra_et("Əsas səhifənin testləri", testlər);

        }
        catch (InvocationTargetException ite) {
            // https://stackoverflow.com/questions/6020719/what-could-cause-java-lang-reflect-invocationtargetexception
            Throwable cause = ite.getCause();
            System.out.println("❌ InvocationTargetException. Sebeb = " + cause.toString());
            if (ite.getCause().getClass().equals(NoSuchWindowException.class)) {
                System.out.println("❌ İnternet browser bağlanmış. Test otomasyon də çıxış edir");
                mp3_oyna("İnternet browser bağlanmış. Test otomasyon də çıxış edir");
                return;
            }
        }
        catch (Exception e) {

            System.out.println("❌ EsasSehifeTestleri -- Ümumi test istisnası: " + e.getMessage());
        } finally {
            sürücü.quit();
        }
    } // end main

} // class
