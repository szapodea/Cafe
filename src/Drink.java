import java.math.BigDecimal;

/**
 * Drink Class
 *
 * @author Stephan Zapodeanu, szapodea@purdue.edu
 * @version  November 1st, 2019
 */




public class Drink extends FoodProduct {

    private Size size;

    public Drink(String name, int calories, BigDecimal cost, BigDecimal price, Size size)
            throws NullPointerException, IllegalArgumentException {
        super(name, calories, cost, price);
        this.size = size;

        if (getName().equals(null) || getCost().equals(null) || getPrice() == (null)
                || size == (null)) {
            throw new NullPointerException("Null pointer Exception Drink");
        } else if (calories < 0 ||  cost.compareTo(BigDecimal.ZERO) < 0 ||  price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Illegal Argument Exception Drink");
        }
    }

    public Drink(String name, Size size) throws NullPointerException {
        super(name, size.getCalories(), size.getCost(), size.getPrice());
        this.size = size;
        if (getName().equals(null) || size == null) {
            throw new NullPointerException("Null Pointer Exception Drink");
        }
    }

    public Size getSize() {
        return size;
    }

    public boolean equals(Object object) {
        if (object instanceof Drink) {
            Drink drink = (Drink) object;
            return drink.getCalories() == super.getCalories() && drink.getCost().equals(super.getCost())
                    && drink.getName().equals(super.getName()) && drink.getPrice().equals(super.getPrice())
                    && drink.getSize().equals(size);
        }
        return false;
    }

    public String toString() {
        return "Drink[" + getName() + ", " + getCalories() + ", " + getCost().toString() + ", " +
                getPrice().toString() + ", " + size + "]";
                //String.format("Drink[%s, %d, %s, %s, %s]", getName(), getCalories(),
                //getCost().doubleValue(), getPrice().doubleValue(), size);
    }
}
