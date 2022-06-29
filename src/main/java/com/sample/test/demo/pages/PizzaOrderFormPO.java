package com.sample.test.demo.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class PizzaOrderFormPO {

    @FindBy(id = "pizza1Pizza")
    WebElement pizzaSelect;
    @FindBy(className = "toppings1")
    WebElement toppings1Select;
    @FindBy(className = "toppings2")
    WebElement toppings2Select;;
    @FindBy(id = "pizza1Qty")
    WebElement pizzaQtyField;
    @FindBy(id = "name")
    WebElement nameField;
    @FindBy(id = "email")
    WebElement emailField;
    @FindBy(id = "phone")
    WebElement phoneField;
    @FindBy(id = "ccpayment")
    WebElement creditCardOption;
    @FindBy(id = "cashpayment")
    WebElement cashOption;
    @FindBy(id = "placeOrder")
    WebElement placeOrderButton;
    @FindBy(id = "reset")
    WebElement resetButton;
    @FindBy(css = "#dialog > p")
    WebElement orderDialogText;

    public PizzaOrderFormPO(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
