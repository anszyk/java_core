package java_core.homework5;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class HomeworkApp5 {

    public static void main(String[] args) throws IOException, InterruptedException {

        AppData data = new AppData(); //создали объект
        File tempFile = new File("homework5.csv");
        tempFile.createNewFile();
        data.read("homework5.csv"); //прочитай файл "hw5.csv"
        System.out.println(Arrays.toString(data.getHeader())); //и напечатай то, что получается в конце data.getHeader() и data.getData()
        System.out.println(Arrays.deepToString(data.getData()));

        data.write("new_homework5.csv"); //и сохрани в "new_homework5.csv"
    }
}