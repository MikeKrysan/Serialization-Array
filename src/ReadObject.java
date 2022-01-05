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

            //1-й способ записи массива в файл - записали три отдельных объекта
//            int personCount = ois.readInt();  // В этой переменной хранится количество объектов
//            Person[] people = new Person[personCount];
//
//            for(int i = 0; i < personCount; i++) {
//                people[i] = (Person) ois.readObject();
//            }
//            System.out.println(Arrays.toString(people));

            //2-й способ записи массива в файл - более предпочтительнее. Записали один объект - массив
            Person[] people = (Person[]) ois.readObject(); // Этот метод возвратит тот объект, который был записан в файл(массив Person[]) и мы ожидаем на выходе массив объектов класса Person
            System.out.println(Arrays.toString(people));

            ois.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
