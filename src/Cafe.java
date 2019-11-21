import java.awt.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;

/**
 * FoodProduct class
 *
 * @author Stephan Zapodeanu, szapodea@purdue.edu
 * @version  November 1st, 2019
 */
public class Cafe {
    private ArrayList<Employee> employees;
    private BigDecimal expenses;
    private BigDecimal revenue;

    public Cafe() {
        expenses = BigDecimal.ZERO;
        revenue = BigDecimal.ZERO;
        employees = new ArrayList<>();
    }

    public boolean equals(Object object) {
        if (object instanceof Cafe) {
            Cafe cafe = (Cafe) object;
            return this.expenses.equals(cafe.getExpenses()) && this.revenue.equals(cafe.getRevenue())
                    && this.employees == cafe.employees;
        }
        return false;
    }

    public boolean fireEmployee(Employee employee) throws NullPointerException {
        if (employee == null) {
            throw new NullPointerException("Employee is null.");
        }
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).equals(employee)) {
                employees.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public BigDecimal getExpenses() {
        return expenses;
    }

    public BigDecimal getRevenue() {
        return revenue;
    }

    public BigDecimal getProfit() {
        return revenue.subtract(expenses);
    }

    public void hireEmployee(Employee employee) throws NullPointerException, IllegalArgumentException {
        if (employee == null) {
            throw new NullPointerException("Employee is null, can not hire");
        } else if (employee.getAge() < 14) {
            throw new IllegalArgumentException("Employee is younger than 14");
        }
        employees.add(employee);
    }

    public boolean updateEmployeeWage(Employee employee, BigDecimal newHourlyWage)
            throws NullPointerException, IllegalArgumentException {
        if (employee == null || newHourlyWage == null) {
            throw new NullPointerException("Null Pointer Exception updateEmployeeWage");
        } else if (newHourlyWage.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Illegal Argument exception updateEployeeWage");
        }
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).equals(employee)) {
                employees.get(i).setHourlyWage(newHourlyWage);
                return true;
            }
        }
        return false;
    }

    public void open(int hours, Random random) throws IllegalArgumentException, NullPointerException {
        if (hours < 0) {
            throw new IllegalArgumentException("Illegal Argument Exception open");
        } else if (random == null) {
            throw new NullPointerException("Null Pointer Exception open");
        }

    }

    public static FoodProduct makeFoodProduct(String name, int calories, BigDecimal cost, BigDecimal price)
            throws NullPointerException, IllegalArgumentException {
        if (name == null || cost == null || price == null) {
            throw new NullPointerException("Null Pointer Exception makeFoodProduct");
        } else if (calories < 0 || cost.compareTo(BigDecimal.ZERO) < 0 || price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Illegal Argument Exception makeFoodProduct");
        }
        FoodProduct foodProduct = new FoodProduct(name, calories, cost, price);
        return foodProduct;
    }

    public static Coffee makeCoffee(String name, Size size, Roast roast, Ingredient ... ingredients)
            throws NullPointerException {
        if (name == null || size == null || roast == null || ingredients == null) {
            throw new NullPointerException("NullPointerException for Coffee");
        }
        for (int i = 0; i < ingredients.length; i++) {
            if (ingredients[i] == null) {
                throw new NullPointerException("NullPointerException for Coffee");
            }
        }
        Coffee coffee = new Coffee(name, size, roast, ingredients);
        return coffee;
    }

    public static Tea makeTea(String name, Size size, Type type, Ingredient ... ingredients)
            throws NullPointerException {
        if (name == null || size == null || type == null) {
            throw new NullPointerException("Null Pointer Exception for Tea");
        }
        Tea tea = new Tea(name, size, type, ingredients);
        return tea;
    }

    public String toString() {
        return "Cafe[" + expenses + ", [" + revenue + ", " + getEmployees().toString() + "]]";
    }

    public void sellFoodProduct(FoodProduct foodProduct) throws NullPointerException {
        if (foodProduct == null) {
            throw new NullPointerException("Null Pointer Exception sellFoodProduct");
        }
        expenses.add(foodProduct.getCost());
        revenue.add(foodProduct.getPrice());

    }
}

