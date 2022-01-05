import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObject_1 {
    public static void main(String[] args) {
        Person[] people = {new Person(1, "Bob"), new Person(2, "Tom"), new Person(3, "Jack")};

        try {
            FileOutputStream fos = new FileOutputStream("people_1.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeInt(people.length);

            for(Person person : people) {
                oos.writeObject(people);
            }

            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
