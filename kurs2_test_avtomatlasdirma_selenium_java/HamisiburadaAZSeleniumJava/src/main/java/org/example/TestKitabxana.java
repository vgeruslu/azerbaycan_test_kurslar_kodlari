package org.example;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestKitabxana {

    public static boolean IsElementVisibleInViewport(WebDriver driver, WebElement element) {
        return
                (boolean) ((JavascriptExecutor) driver).executeScript(
                        "var elem = arguments[0], " +
                                "box = elem.getBoundingClientRect(), " +
                                "cx = box.left + box.width / 2,  " +
                                "cy = box.top + box.height / 2, " +
                                "e = document.elementFromPoint(cx, cy); " +
                                "for (; e; e = e.parentElement) " +
                                "     { if (e === elem) return true;}" +
                                "return false;",
                        element);
    }
}
