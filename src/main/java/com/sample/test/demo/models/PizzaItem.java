package com.sample.test.demo.models;

import com.sample.test.demo.constants.PizzaToppings;
import com.sample.test.demo.constants.PizzaTypes;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PizzaItem {

    private PizzaTypes pizzaType;
    private PizzaToppings topping1;
    private PizzaToppings topping2;
    private int quantity;

}
