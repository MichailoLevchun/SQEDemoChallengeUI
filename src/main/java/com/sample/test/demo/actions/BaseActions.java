package com.sample.test.demo.actions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.apache.maven.surefire.shade.booter.org.apache.commons.lang3.StringUtils.SPACE;
import static org.testng.Assert.assertEquals;

public class BaseActions {

    protected Logger log = Logger.getLogger(BaseActions.class.getName());

    public void click(WebElement element) {
        log.info("Click on element " + element.getAttribute("id"));
        element.click();
    }

    public void input(WebElement element, int text) {
        log.info("Input " + text + " into element " + element.getAttribute("id"));
        element.clear();
        element.sendKeys("" + text);
    }

    public void input(WebElement element, String text) {
        log.info("Input " + text + " into element " + element.getAttribute("id"));
        element.clear();
        element.sendKeys(text);
    }

    public void selectByText(WebElement element, String text) {
        log.info("Select dropdown with text  " + text + " on element " + element.getAttribute("id"));
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public void selectByValue(WebElement element, String value) {
        log.info("Select dropdown with value  " + value + " on element " + element.getAttribute("id"));
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public String getText(WebElement element) {
        String text = element.getText();
        log.info("Get text   " + text + " from element " + element.getAttribute("id"));
        return element.getText();
    }

    public void verifyTextOnWebElement(WebElement element, String expectedText) {
        log.info("Element with text "  + element.getText() + "should have text " + expectedText);
        assertEquals(getText(element), expectedText, "Message is not correct");
    }

    public boolean isElementDisplayed(WebElement element) {
        log.info("Element "  + element.toString() + "should be displayed");
        return element.isDisplayed();
    }
}
