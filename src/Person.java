import java.io.Serializable;

/**
 *Person class
 *
 * @author Stephan Zapodeanu, szapodea@purdue.edu
 * @version  November 1st, 2019
 */

public class Person implements Identifiable, Serializable {
    private int age;
    private String name;

    public Person(String name, int age) throws NullPointerException, IllegalArgumentException {
        this.name = name;
        if (name == null) {
            throw new NullPointerException("Null Pointer Exception name");
        }
        this.age = age;
        if (age < 0 ) {
            throw new IllegalArgumentException("Illegal Argument Exception");
        }
    }

    public boolean equals(Object object) {
        if (object instanceof Person) {
            Person person = (Person) object;
            return this.name.equals(person.getName()) && this.age == person.getAge();
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String toString() {
        return String.format("Person[%s, %d]", name, age);
    }
}
