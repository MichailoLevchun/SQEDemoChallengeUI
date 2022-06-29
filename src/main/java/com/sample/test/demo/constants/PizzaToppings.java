package com.sample.test.demo.constants;


public enum PizzaToppings {
    MANGOS("Diced Mango"),
    OLIVES("Olives"),
    MUSHROOMS("Mushrooms"),
    ONIONS("Caramelized onions"),
    ITALIANHAM("Italian Ham"),
    PEPPERONI("Classic Pepperoni"),
    SALAMI("Salami"),
    PROVOLNE("Provolone cheese"),
    EXTRACHEESE("Extra cheese"),
    MOZZARELLA("Mozzarella cheese"),
    PARMASAN("Parmesan cheese"),
    EMPTY_TOPPING1("Choose a Toppings 1"),
    EMPTY_TOPPING2("Choose a Toppings 2")

    ;

    private String displayName;

    private PizzaToppings(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
