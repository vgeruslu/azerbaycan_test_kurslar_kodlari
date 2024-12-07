package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");

        WebDriverManager.chromedriver().setup();
        WebDriver sürücü = new ChromeDriver();
        sürücü.get("https://az.wikipedia.org");

    } // end main
} // end class