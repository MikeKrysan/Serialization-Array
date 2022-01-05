import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;

public class ReadObject {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("people.bin");
            ObjectInputStream ois  = new ObjectInputStream(fis);

            int personCount = ois.readInt();    // В этой переменной хранится количество объектов
            Person[] people = new Person[personCount];

            for(int i = 0; i < personCount; i++) {
               people[i] = (Person) ois.readObject();
            }

            System.out.println(Arrays.toString(people));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
