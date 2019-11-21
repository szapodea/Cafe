import java.math.BigDecimal;

/**
 * Employee class
 *
 * @author Stephan Zapodeanu, szapodea@purdue.edu
 * @version  November 1st, 2019
 */

public class Employee extends Person implements Employable {
    private BigDecimal hourlyWage;

    public Employee(String name, int age, BigDecimal hourlyWage) throws NullPointerException, IllegalArgumentException {
        super(name, age);
        if (hourlyWage == null || super.getName() == null) {
            throw new NullPointerException("Null Pointer Exception");
        } else if (hourlyWage.compareTo(BigDecimal.ZERO) < 0 || super.getAge() < 0) {
            throw new IllegalArgumentException("Illegal Argument Exception");
        }
        this.hourlyWage = hourlyWage;
    }

    @Override
    public BigDecimal getHourlyWage() {
        return hourlyWage;
    }

    @Override
    public void setHourlyWage(BigDecimal hourlyWage) throws NullPointerException, IllegalArgumentException {
        if (hourlyWage == null) {
            throw new NullPointerException("Null Pointer Exception setHourlyWage");
        } else if (hourlyWage.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Illegal Argument Exception. setHourlyWage");
        }
        this.hourlyWage = hourlyWage;
    }

    public boolean equals(Object object) {
        if (object instanceof Employee) {
            Employee employee = (Employee) object;
            return employee.getHourlyWage().equals(hourlyWage) && employee.getAge() == getAge()
                    && employee.getName().equals(getName());
        }
        return false;
    }

    public String toString() {
        return "Employee[" + getName() + ", " + getAge() + ", " + hourlyWage.toString() + "]";
                //String.format("Employee[%s, %d, %s]", this.getName(), this.getAge(), hourlyWage.doubleValue());
    }
}
