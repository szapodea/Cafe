import java.io.*;

/**
 * FoodProduct class
 *
 * @author Stephan Zapodeanu, szapodea@purdue.edu
 * @version  November 1st, 2019
 */
public class CafeUtilities {
    private CafeUtilities() {

    }

    public static Cafe readFromFile(File file) throws NullPointerException, IOException, ClassNotFoundException {
        if (file == null) {
            throw new NullPointerException("Null Pointer Exception readFromFile");
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Cafe cafe = (Cafe) objectInputStream.readObject();
        objectInputStream.close();
        return cafe;
    }

    public static void saveToFile(Cafe cafe, File file) throws NullPointerException, IOException {
        if (cafe == null || file == null) {
            throw new NullPointerException("Null Pointer Exception saveToFile");
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(new CafeUtilities());
        objectOutputStream.close();
    }
}
