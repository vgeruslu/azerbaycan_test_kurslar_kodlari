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
import java.util.Random;

import static KitabxanalarLibs.TestKitabxana.*;
import static KitabxanalarLibs.TestKitabxana.obyektın_kənarını_rəng_ilə_vurğula;

public class QeydiyyatSehifeTestleri {

    private static WebDriver sürücü;
    // 1. Hazırlıq (Setup)
    // 2. İstenilen funksiya icra olur (Exercise)
    // 3. Yoxlama (Verify)
    // 4. Təmizləmə (Teardown)
    //@Test
    public void TH_() throws Exception {

    }

    //@Test
    public void TH_Etibarlı_Epoçt_Etibarlı_Şifrə_Etibarlı_Ad_Etibarlı_Soyad() throws Exception {
        // 1. Hazırlıq (Setup)

        sürücü.findElement(By.xpath("//a[@href ='qeydiyyat.php']")).click();
        // indi qeydiyyat sehifesinde olmaliyiq

        // 2. İstenilen funksiya icra olur (Exercise)
        System.out.println("\uD83D\uDCE2 Xanalarda etibarlı dəyərlər yazıram");

        String yeni_istifdadeçi_email = randomİstifadeciEmailUser(10) + "@gmail.com";
        System.out.println("yeni_istifdadeçi = " + yeni_istifdadeçi_email);

        WebElement axtarılan_element = sürücü.findElement(
                By.xpath("//input[@name='epoçt']"));
        obyektın_kənarını_rəng_ilə_vurğula(sürücü, axtarılan_element);
        axtarılan_element.sendKeys(yeni_istifdadeçi_email);

        axtarılan_element = sürücü.findElement(
                By.xpath("//input[@name='şifrə']"));
        obyektın_kənarını_rəng_ilə_vurğula(sürücü, axtarılan_element);
        axtarılan_element.sendKeys("Abc12345.");

        axtarılan_element = sürücü.findElement(
                By.xpath("//input[@name='ad']"));
        obyektın_kənarını_rəng_ilə_vurğula(sürücü, axtarılan_element);
        axtarılan_element.sendKeys("TEST_AD");

        axtarılan_element = sürücü.findElement(
                By.xpath("//input[@name='soyad']"));
        obyektın_kənarını_rəng_ilə_vurğula(sürücü, axtarılan_element);
        axtarılan_element.sendKeys("TEST_SOYAD");

        System.out.println("\uD83D\uDCE2 Duymeye vururam");
        axtarılan_element = sürücü.findElement(
                By.xpath("//input[@value = 'Qeydiyyatdan keç']"));
        obyektın_kənarını_rəng_ilə_vurğula(sürücü, axtarılan_element);
        axtarılan_element.click();

        // 3. Yoxlama (Verify)
        // Sistem uyğun bir təsdiq mesajı verməli: Yeni hesab yaradıldı.
        mətnin_səhifədə_olduğunu_yoxla(sürücü, "Yeni hesab yaradıldı.");

        //Sistemdə yeni istifadəçi yaradılmalı.
        // Yeni istifadəçinin düzdün yaradılmasını yoxlamaq üçün, Daxil Olmaq əkranıa gedib və yeni istifadəçinin ilə daxil olacağam.
        mp3_oyna("Yeni istifadəçinin düzdün yaradılmasını yoxlamaq üçün-Daxil Olmaq");

        sürücü.findElement(By.xpath("//a[@href ='daxil_ol.php']")).click();
        daxil_ol(sürücü,yeni_istifdadeçi_email, "Abc12345.");

        // 4. Təmizləmə (Teardown)
        // cixis et
        sürücü.findElement(By.xpath("//a[@href ='çıxış.php']")).click();
    }

    //@Test
    public void TH_Etibarsız_Epoçt__Boş_Şifrə__Etibarsız_Ad__Boş_Soyad() throws Exception {
        // 1. Hazırlıq (Setup)
        sürücü.findElement(By.xpath("//a[@href ='qeydiyyat.php']")).click();
        // indi qeydiyyat sehifesinde olmaliyiq

        // 2. İstenilen funksiya icra olur (Exercise)
        System.out.println("\uD83D\uDCE2 Xanalarda dəyərlər yazıram");

        //Etibarsız_Epoçt
        String yeni_istifdadeçi_email = randomİstifadeciEmailUser(10) + "@123";
        System.out.println("yeni_istifdadeçi = " + yeni_istifdadeçi_email);
        WebElement axtarılan_element = sürücü.findElement(
                By.xpath("//input[@name='epoçt']"));
        obyektın_kənarını_rəng_ilə_vurğula(sürücü, axtarılan_element);
        axtarılan_element.sendKeys(yeni_istifdadeçi_email);

        //Boş_Şifrə
        axtarılan_element = sürücü.findElement(
                By.xpath("//input[@name='şifrə']"));
        obyektın_kənarını_rəng_ilə_vurğula(sürücü, axtarılan_element);
        axtarılan_element.sendKeys("");

        // Etibarsız_Ad
        axtarılan_element = sürücü.findElement(
                By.xpath("//input[@name='ad']"));
        obyektın_kənarını_rəng_ilə_vurğula(sürücü, axtarılan_element);
        axtarılan_element.sendKeys("1234");

        // Boş_Soyad
        axtarılan_element = sürücü.findElement(
                By.xpath("//input[@name='soyad']"));
        obyektın_kənarını_rəng_ilə_vurğula(sürücü, axtarılan_element);
        axtarılan_element.sendKeys("");

        System.out.println("\uD83D\uDCE2 Duymeye vururam");
        axtarılan_element = sürücü.findElement(
                By.xpath("//input[@value = 'Qeydiyyatdan keç']"));
        obyektın_kənarını_rəng_ilə_vurğula(sürücü, axtarılan_element);
        axtarılan_element.click();

        // 3. Yoxlama (Verify)
        // Sistem uyğun xəta mesajı verməli
        mətnin_səhifədə_olduğunu_yoxla(sürücü, "Xəta: Şifrə xanası doldurulmalıdır");
        mətnin_səhifədə_olduğunu_yoxla(sürücü, "Xəta: Ad mətni etibarsızdır");
        mətnin_səhifədə_olduğunu_yoxla(sürücü, "Xəta: Soyad xanası doldurulmalıdır");

        // 4. Təmizləmə (Teardown)

    }
    //@Test
    public void TH_Boş_Epoçt_Etibarsız_Şifrə_Boş_Ad_Etibarsız_Soyad() throws Exception {

    }

    @Test
    public void TH_AZ_EN_DilinəDəyişmə() throws Exception{
        // 1. Hazırlıq (Setup)
        sürücü.findElement(By.xpath("//a[@href ='qeydiyyat.php']")).click();

        mp3_oyna("Dil dəyişmə düyməsinə vururam");

        // 2. İstenilen funksiya icra olur (Exercise)
        sürücü.findElement(By.xpath(
                "//*[contains(text(),'Change to English')]")).click();

        // 3. Yoxlama (Verify)
        mp3_oyna("Səhifənin dilinin dəyişdirildiyini yoxlayıram");

        mətnin_səhifədə_olduğunu_yoxla(sürücü, "Mini-Facebook | in English");
        mətnin_səhifədə_olduğunu_yoxla(sürücü, "Azərbaycan dilinə dəyiş");
        mətnin_səhifədə_olduğunu_yoxla(sürücü, "Sign up a new account");

        // 4. Təmizləmə (Teardown)
    }

    @Test
    public void TH_EN_AZ_DilinəDəyişmə() throws Exception{
        // 1. Hazırlıq (Setup)
        sürücü.findElement(By.xpath("//a[@href ='qeydiyyat.php']")).click();

        // sayt, default AZ dilinde acilir ilk
        // ona gore, EN diline cevirmeyi vurub, sonra tekrar AZ diline cevirmeyi vurmaliyiq
        System.out.println("İlk, AZ dilindən, EN-ə dəyişirəm...");
        sürücü.findElement(By.xpath(
                "//*[contains(text(),'Change to English')]")).click();

        // 2. İstenilen funksiya icra olur (Exercise)
        mp3_oyna("Dil dəyişmə düyməsinə vururam");
        sürücü.findElement(By.xpath(
                "//*[contains(text(),'Azərbaycan dilinə dəyiş')]")).click();

        // 3. Yoxlama (Verify)
        mp3_oyna("Səhifənin dilinin dəyişdirildiyini yoxlayıram");

        mətnin_səhifədə_olduğunu_yoxla(sürücü, "Azərbaycan dilində");
        mətnin_səhifədə_olduğunu_yoxla(sürücü, "Change to English");
        mətnin_səhifədə_olduğunu_yoxla(sürücü, "Qeydiyyatdan keçin");

        // 4. Təmizləmə (Teardown)
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

    String randomİstifadeciEmailUser(int len){
        final String AB = "abcdefghijklmnopqrstuvwxyz";
        Random rnd = new Random();

        StringBuilder sb = new StringBuilder(len);
        for(int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

} // end class
