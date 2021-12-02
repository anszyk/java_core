package homework2;

public class MyArrayDataException extends Exception {

    public MyArrayDataException(String message, int i, int j) {
        super("Некорректный элемент в массиве. Ошибка в ячейке: " + "[" + i + "]"+ "[" + j + "]");
    }
}
