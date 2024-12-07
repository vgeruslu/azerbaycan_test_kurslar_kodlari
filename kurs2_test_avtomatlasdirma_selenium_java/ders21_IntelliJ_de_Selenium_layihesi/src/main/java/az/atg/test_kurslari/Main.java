package az.atg.test_kurslari;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        // WebDriver manager dən ChromeDriver istəyirik
        WebDriverManager.chromedriver().setup();

        // Chrome brauzerini işə salırıq
        WebDriver sürücü = new ChromeDriver();

        // Test üçün sadə bir səhifə açırıq
        sürücü.get("https://az.wikipedia.org");
    }
}