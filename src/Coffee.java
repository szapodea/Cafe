import javax.swing.*;
import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Coffee class
 *
 * @author Stephan Zapodeanu, szapodea@purdue.edu
 * @version  November 1st, 2019
 */

public final class Coffee extends Drink {
    private Ingredient[] ingredients;
    private Roast roast;

    public Coffee(String name, int calories, BigDecimal cost, BigDecimal price,
                  Size size, Roast roast, Ingredient... ingredients)
            throws NullPointerException, IllegalArgumentException {
        super(name, calories, cost, price, size);

        if (name == null || cost == null || price == null || size == null || roast == null || ingredients == null) {
            throw new NullPointerException("NullPointerException for Coffee");
        }
        for (int i = 0; i < ingredients.length; i++) {
            if (ingredients[i] == null) {
                throw new NullPointerException("NullPointerException for Coffee");
            }
        }
        if (calories < 0 || cost.compareTo(BigDecimal.ZERO) < 0 || price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("IllegalArgument Exception for Coffee");
        }
        this.ingredients = ingredients;
        this.roast = roast;
    }


    public Coffee(String name, Size size, Roast roast, Ingredient... ingredients) throws NullPointerException {
        super(name, size);
        this.roast = roast;
        this.ingredients = ingredients;

        int calculateCalories = 0;
        for (int i = 0; i < ingredients.length; i++) {
            calculateCalories += ingredients[i].getCalories();
        }
        setCalories(calculateCalories + size.getCalories());

        BigDecimal calculatePrice = size.getPrice();
        for (int i = 0; i < ingredients.length; i++) {
            calculatePrice = calculatePrice.add(ingredients[i].getPrice());
        }
        setPrice(calculatePrice);

        BigDecimal calculateCost = size.getCost();
        for (int i = 0; i < ingredients.length; i++) {
            calculateCost = calculateCost.add(ingredients[i].getCost());
        }
        setCost(calculateCost);

        if (name == null || size == null || roast == null) {
            throw new NullPointerException("Null Pointer Exception Coffee");
        }
    }

    public Ingredient[] getIngredients() {
        return ingredients;
    }

    public Roast getRoast() {
        return roast;
    }

    //  roast, and ingredients are equal to this coffee's. Name comparisons are case-sensitive.
    public boolean equals(Object object) {
        if (object instanceof Coffee) {
            Coffee coffee = (Coffee) object;
            boolean isTrue = true;
            for (int i = 0; i < ingredients.length; i++) {
                if (coffee.ingredients[i].equals(this.ingredients[i])) {
                    isTrue = true;
                } else {
                    isTrue = false;
                    break;
                }
            }
            if (isTrue) {
                return coffee.getCalories() == this.getCalories() && coffee.getCost().equals(this.getCost())
                        && coffee.getName().equals(this.getName()) && coffee.getPrice().equals(this.getPrice()) &&
                        coffee.getSize().equals(this.getSize()) && coffee.getRoast().equals(this.roast);
            }
        }
        return false;
    }


    public String toString() {
        return "Coffee[" + getName() + ", " + getCalories() + ", " + getCost().toString() + ", " + getPrice().toString()
                + ", " + getSize() + ", " + roast + ", " + Arrays.toString(ingredients) + "]";
    }
}