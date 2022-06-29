package com.sample.test.demo.tests;

import com.sample.test.demo.core.TestBase;
import com.sample.test.demo.constants.PizzaToppings;
import com.sample.test.demo.constants.PizzaTypes;
import com.sample.test.demo.models.ContactInfo;
import com.sample.test.demo.models.PizzaItem;
import org.testng.annotations.Test;

public class PizzaOrderTest extends TestBase {

    @Test(description = "Happy Path - Create order with Pizza and 1 topping", groups = {"happy path"})
    public void createOrderWithPizzaAndOneTopping() {

        PizzaItem pizzaItem = PizzaItem.builder()
                        .pizzaType(PizzaTypes.SMALL_ONETOPPINGS)
                        .topping1(PizzaToppings.ITALIANHAM)
                        .quantity(2)
                        .build();

        pizzaOrderActions
                .addPizzaToOrder(pizzaItem)
                .addPickupInformation(ContactInfo.defaultModel())
                .addCashPayment()
                .placeOrder();


        pizzaOrderActions.verifyPizzaOrderCreatedMessage(pizzaItem);
    }

    @Test(description = "Negative - Create order with no pizza", groups = {"negative"})
    public void createOrderWithNoPizzaSelected() {

        PizzaItem pizzaItem = PizzaItem.builder()
                .topping1(PizzaToppings.ITALIANHAM)
                .quantity(2)
                .build();

        pizzaOrderActions
                .addPizzaToOrder(pizzaItem)
                .addPickupInformation(ContactInfo.defaultModel())
                .addCashPayment()
                .placeOrder();


        pizzaOrderActions.verifySuccessCreatedDialogIsNotDisplayed();
    }

    @Test(description = "Boundary - Create order with zero quantity", groups = {"boundary"})
    public void createOrderWithZeroQuantity() {

        PizzaItem pizzaItem = PizzaItem.builder()
                .topping1(PizzaToppings.ITALIANHAM)
                .quantity(0)
                .build();

        pizzaOrderActions
                .addPizzaToOrder(pizzaItem)
                .addPickupInformation(ContactInfo.defaultModel())
                .addCashPayment()
                .placeOrder();


        pizzaOrderActions.verifyErrorMessagePresent("Minimum quantity - 1");
    }


    @Test(description = "Boundary - Input letter in number field", groups = {"boundary"})
    public void inputLetterInNumberField() {

        PizzaItem pizzaItem = PizzaItem.builder()
                .pizzaType(PizzaTypes.SMALL_ONETOPPINGS)
                .topping1(PizzaToppings.ITALIANHAM)
                .quantity(2)
                .build();

        ContactInfo contactInfo =  ContactInfo.builder()
                .name("John Wick")
                .email("wick@mail.com")
                .phone("sdfdsfdsf")
                .build();

        pizzaOrderActions
                .addPizzaToOrder(pizzaItem)
                .addPickupInformation(contactInfo)
                .addCashPayment()
                .placeOrder();


        pizzaOrderActions.verifyErrorMessagePresent("InvalidFormat: Number shouldn't contain letters");
    }

    @Test(description = "Boundary - Input number with 2 digits", groups = {"boundary"})
    public void inputNumberWithTwoDigits() {

        PizzaItem pizzaItem = PizzaItem.builder()
                .pizzaType(PizzaTypes.SMALL_ONETOPPINGS)
                .topping1(PizzaToppings.ITALIANHAM)
                .quantity(2)
                .build();

        ContactInfo contactInfo =  ContactInfo.builder()
                .name("John Wick")
                .email("wick@mail.com")
                .phone("23")
                .build();

        pizzaOrderActions
                .addPizzaToOrder(pizzaItem)
                .addPickupInformation(contactInfo)
                .addCashPayment()
                .placeOrder();


        pizzaOrderActions.verifyErrorMessagePresent("InvalidFormat: Number should  starts with '+' and contains from 9 to 11 digits");
    }
}
