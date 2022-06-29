package com.sample.test.demo.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebElementUtils {

    public static void click(WebElement element) {
        element.click();
    }

    public static void input(WebElement element, int text) {
        element.clear();
        element.sendKeys("" + text);
    }

    public static void input(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public static void selectByText(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public static void selectByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public static String getText(WebElement element) {
        return element.getText();
    }
}
