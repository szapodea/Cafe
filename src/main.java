import java.math.BigDecimal;
import java.math.BigInteger;

public class main {
    public static void main(String[] args) {
        FoodProduct fp = new FoodProduct("test" , 100, new BigDecimal(1.06), BigDecimal.ONE);
        Drink drink = new Drink("test", 50, new BigDecimal(1.06), new BigDecimal(1.25), Size.SMALL);
        Drink drink1 = new Drink("test", 50, new BigDecimal(1.06), new BigDecimal(1.25), Size.SMALL);
        Ingredient[] ingredients = new Ingredient[]{Ingredient.CREAM, Ingredient.CREAM, Ingredient.SUGAR, Ingredient.CREAM};
        Ingredient[] ingredients1 = new Ingredient[]{Ingredient.CREAM, Ingredient.CREAM, Ingredient.SUGAR, Ingredient.CREAM};
        Coffee coffee = new Coffee("test", 50, new BigDecimal(1.06), new BigDecimal(1.25), Size.SMALL, Roast.DARK, ingredients);
        Coffee coffee1 = new Coffee("test", 50, new BigDecimal(1.06), new BigDecimal(1.25), Size.SMALL, Roast.DARK, ingredients1);

        Cafe cafe = new Cafe();

        cafe.toString();
        //System.out.println(coffee.toString());
        System.out.println(coffee.equals(coffee1));
    }
}
