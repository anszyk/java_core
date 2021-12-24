package java_core.homework5;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class AppData {

    public static final String SEPARATION = ";"; //Вынесли константой разделитель

    private String[] header; //инициализировали заголовок
    private Integer[][] data; // и данные

    public String[] getHeader() {
        return header;
    }

    public Integer[][] getData() {
        return data;
    }

    public void read(String file) {//чтение файла. file - путь до него

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){ //BufferedReader работает быстрее, в него заложили FileReader(file)
            ArrayList<Integer[]> list = new ArrayList<>(); //инициализировали список list
            header = (bufferedReader.readLine().split(SEPARATION)); //чтение первой строки, разделение с помощью ";"
            String line; //инициализировали переменную line
            while ((line = bufferedReader.readLine()) != null){ //с текущего положения читаем построчно пока не вернется null(т.е. до конца файла)
                String[] strings = line.split(SEPARATION); //использую разделение с помощью ";", получаю массив строк 10;20;30
                Integer[] integers = new Integer[strings.length]; //инициализировали новый массив Integer - integers на длину массива strings(он на три элемента)
                for (int i = 0; i < strings.length; i++){ //перебираю строковый массив
                    integers[i] = Integer.parseInt(strings[i]); //и преобразую в Integer
                }
                list.add(integers); //и кладу в общий список
            }
            data = list.toArray(new Integer[][]{}); //преобразуем список list(куда собраны integer-ы) в двумерный Integer[][]
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void write(String fileName) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName),
                    StandardCharsets.UTF_8));

            StringBuffer stringBuffer = new StringBuffer(); //в переменной stringBuffer хранится всегда одна строка
            for (int i = 0; i < header.length; i++) { //беру массив значений в header
                stringBuffer.append(header[i]); //и склеиваю их в одну строчку через ";"
                stringBuffer.append(SEPARATION);
            }
            bufferedWriter.write(stringBuffer.toString()); //преобразовываю в строку то, что собрал StringBuffer
            bufferedWriter.newLine(); //прыгаю на новую строчку

            for (int i = 0; i < data.length; i++) { //беру массив значений в data
                Integer[] integersData = data[i]; //вытаскиваю первый массив чисел
                stringBuffer.delete(0, stringBuffer.length()); //очищаю текущую строку
                for (int j = 0; j < integersData.length; j++) { //и склеиваю их в одну строчку через ";"
                    stringBuffer.append(integersData[j]);
                    stringBuffer.append(SEPARATION);
                }
                bufferedWriter.write(stringBuffer.toString()); //преобразовываю в строку то, что собрал StringBuffer
                bufferedWriter.newLine(); //прыгаю на новую строчку
            }

            bufferedWriter.flush(); //запиши все
            bufferedWriter.close(); //закрой
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}