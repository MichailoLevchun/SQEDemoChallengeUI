package com.sample.test.demo.actions;

import com.sample.test.demo.constants.PizzaToppings;
import com.sample.test.demo.models.ContactInfo;
import com.sample.test.demo.models.PizzaItem;
import com.sample.test.demo.pages.PizzaOrderFormPO;
import org.openqa.selenium.WebDriver;

import java.util.Optional;

import static com.sample.test.demo.utils.WebElementUtils.*;
import static com.sample.test.demo.utils.WebElementUtils.click;
import static org.apache.maven.surefire.shade.booter.org.apache.commons.lang3.StringUtils.SPACE;
import static org.testng.Assert.assertEquals;

public class PizzaOrderActions {
    private PizzaOrderFormPO pizzaOrderFormPO;

    public PizzaOrderActions(WebDriver driver) {
        pizzaOrderFormPO = new PizzaOrderFormPO(driver);
    }

    public PizzaOrderActions addPizzaToOrder(PizzaItem pizzaItem) {
        selectByValue(pizzaOrderFormPO.getPizzaSelect(), pizzaItem.getPizzaType().getDisplayName());

        selectByText(pizzaOrderFormPO.getToppings1Select(), Optional
                .ofNullable(
                        pizzaItem.getTopping1())
                .orElse(PizzaToppings.EMPTY_TOPPING1)
                .getDisplayName()
        );

        selectByText(pizzaOrderFormPO.getToppings2Select(), Optional
                .ofNullable(
                        pizzaItem.getTopping2())
                .orElse(PizzaToppings.EMPTY_TOPPING2)
                .getDisplayName()
        );

        input(pizzaOrderFormPO.getPizzaQtyField(), pizzaItem.getQuantity());
        return this;
    }

    public PizzaOrderActions addPickupInformation(ContactInfo contactInfo) {
        input(pizzaOrderFormPO.getNameField(), contactInfo.getName());
        input(pizzaOrderFormPO.getEmailField(), contactInfo.getEmail());
        input(pizzaOrderFormPO.getPhoneField(), contactInfo.getPhone());
        return this;
    }

    public PizzaOrderActions addCreditCardPayment() {
        click(pizzaOrderFormPO.getCreditCardOption());
        return this;
    }

    public PizzaOrderActions addCashPayment() {
        click(pizzaOrderFormPO.getCashOption());
        return this;
    }

    public PizzaOrderActions placeOrder() {
        click(pizzaOrderFormPO.getPlaceOrderButton());
        return this;
    }

    public PizzaOrderActions resetOrder() {
        click(pizzaOrderFormPO.getResetButton());
        return this;
    }

    public void verifyPizzaOrderCreatedMessage(PizzaItem pizzaItem) {
        assertEquals(getText(pizzaOrderFormPO.getOrderDialogText()),
                "Thank you for your order! TOTAL: " + (int) pizzaItem.getPizzaType().getCost() * pizzaItem.getQuantity()
                        + SPACE + pizzaItem.getPizzaType().getDisplayName(),
                "Message is not correct");
    }
}
