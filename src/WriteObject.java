import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObject {
    public static void main(String[] args) {
        Person[] people = {new Person(1, "Bob"), new Person(2, "Tom"), new Person(3, "Jack")};

        try {
            FileOutputStream fos = new FileOutputStream("people.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            //1-й способ
//            oos. writeInt(people.length);   // Сначал будет записано число объектов в массиве
//
//            for(Person person : people) {   // Затем будет записано число объектов класса Person
//                oos.writeObject(person);
//            }

            // 2 способ - предпочтительнее
            oos.writeObject(people);

            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
