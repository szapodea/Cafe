import java.math.BigDecimal;
/**
 *Size Enum
 *
 * @author Stephan Zapodeanu, szapodea@purdue.edu
 * @version  November 1st, 2019
 */
public enum Size implements Consumable, Sellable {
    SMALL(5, BigDecimal.valueOf(0.2), BigDecimal.valueOf(2.85)),
    MEDIUM(10, BigDecimal.valueOf(0.3), BigDecimal.valueOf(3.45)),
    LARGE(15, BigDecimal.valueOf(0.4), BigDecimal.valueOf(4.05));

    private int calories;
    private BigDecimal cost;
    private BigDecimal price;

    Size(int calories, BigDecimal cost, BigDecimal price) {
        this.calories = calories;
        this.cost = cost;
        this.price = price;
    }

    public int getCalories() {
        return calories;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getCost() {
        return cost;
    }

}

