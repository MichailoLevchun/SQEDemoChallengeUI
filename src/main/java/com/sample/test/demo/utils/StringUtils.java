package com.sample.test.demo.utils;

import com.sample.test.demo.models.PizzaItem;

import static org.apache.maven.surefire.shade.booter.org.apache.commons.lang3.StringUtils.SPACE;

public class StringUtils {

    public static String concatCreatePizzaOrderDialogMessage(PizzaItem pizzaItem) {
        return "Thank you for your order! TOTAL: "
                + Math.round(pizzaItem.getPizzaType().getCost() * pizzaItem.getQuantity())
                + SPACE
                + pizzaItem.getPizzaType().getDisplayName();
    }
}
