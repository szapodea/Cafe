import java.math.BigDecimal;

/**
 * FoodProduct class
 *
 * @author Stephan Zapodeanu, szapodea@purdue.edu
 * @version  November 1st, 2019
 */

public class FoodProduct implements Identifiable, Consumable, Sellable {

    private int calories;
    private BigDecimal cost;
    private String name;
    private BigDecimal price;

    public FoodProduct(String name, int calories, BigDecimal cost, BigDecimal price) throws NullPointerException,
            IllegalArgumentException {
        if (name == null || cost == null || price == null) {
            throw new NullPointerException("Null Pointer Exception");
        } else if (calories < 0 || cost.compareTo(BigDecimal.ZERO) < 0 || price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Illegal Argument Exception");
        }
        this.name = name;
        this.calories = calories;
        this.cost = cost;
        this.price = price;
    }

    @Override
    public int getCalories() {
        return calories;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public BigDecimal getCost() {
        return cost;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    public boolean equals(Object o) {
        if (o instanceof FoodProduct) {
            FoodProduct fp = (FoodProduct) o;
            return fp.getCalories() == this.calories && fp.getCost().equals(this.cost) && fp.getName().equals(this.name)
                    && fp.getPrice().equals(this.price);
        }
        return false;
    }

    @Override
    public String toString() {
        return "FoodProduct[" + name + ", " + calories + ", " + cost.toString() + ", " + price.toString() + "]";
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
