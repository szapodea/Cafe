import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Tea class
 *
 * @author Stephan Zapodeanu, szapodea@purdue.edu
 * @version  November 1st, 2019
 */

public class Tea extends Drink {

    private Ingredient[] ingredients;
    private Type type;

    public Tea(String name, int calories, BigDecimal cost, BigDecimal price, Size size, Type type,
               Ingredient... ingredients) throws NullPointerException, IllegalArgumentException {
        super(name, calories, cost, price, size);
        this.type = type;
        this.ingredients = ingredients;
        for (int i = 0; i < ingredients.length; i++) {
            if (name == null || cost == null || price == null || size == null || type == null ||
                    ingredients[i] == null)  {
                throw new NullPointerException("NullPointerException for Tea");
            } else if (calories < 0 || cost.compareTo(BigDecimal.ZERO) < 0 || price.compareTo(BigDecimal.ZERO) < 0) {
                throw new IllegalArgumentException("IllegalArgument Exception for Tea");
            }
        }
    }

    public Tea(String name, Size size, Type type, Ingredient... ingredients) throws NullPointerException {
        super(name, size);
        this.type = type;
        this.ingredients = ingredients;
        if (name == null || size == null || type == null) {
            throw new NullPointerException("Null Pointer Exception for Tea");
        }
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

    }

    public Type getType() {
        return type;
    }

    public Ingredient[] getIngredients() {
        return ingredients;
    }

    public boolean equals(Object object) {
        if (object instanceof Tea) {
            Tea tea = (Tea) object;
            boolean isTrue = true;
            for (int i = 0; i < ingredients.length; i++) {
                if (tea.ingredients[i].equals(this.ingredients[i])) {
                    isTrue = true;
                } else {
                    isTrue = false;
                    break;
                }
            }
            if (isTrue) {
                return tea.getCalories() == this.getCalories() && tea.getCost().equals(this.getCost())
                        && tea.getName().equals(this.getName()) && tea.getPrice().equals(this.getPrice()) &&
                        tea.getSize().equals(this.getSize()) && tea.getType().equals(this.type);
            }

        }
        return false;
    }

    public String toString() {
        return "Tea[" + getName() + ", " + getCalories() + ", " + getCost().toString() + ", " + getPrice().toString()
                + ", " + getSize() + ", " + type + ", " + Arrays.toString(ingredients) + "]";
    }
}
