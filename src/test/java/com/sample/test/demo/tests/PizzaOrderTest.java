package com.sample.test.demo.tests;

import com.sample.test.demo.TestBase;
import com.sample.test.demo.constants.PizzaToppings;
import com.sample.test.demo.constants.PizzaTypes;
import com.sample.test.demo.models.ContactInfo;
import com.sample.test.demo.models.PizzaItem;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PizzaOrderTest extends TestBase {

    @Test(description = "Happy Path - Create order with Pizza and 1 topping")
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
}
