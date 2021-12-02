package homework2;

public class HomeworkApp2 {

    public static int strToInt(String[][] myArray1) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (myArray1.length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < myArray1.length; i++) {
            if (myArray1[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < myArray1[i].length; j++) {
                try {
                    sum += Integer.parseInt(myArray1[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(e.getMessage(), i, j);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String[][] myArray1 = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] myArray2 = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10"}
        };
        String[][] myArray3 = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "@", "11", "12"},
                {"13", "14", "15", "16"}
        };
        try {
            System.out.println("Массив 1:");
            System.out.println("Сумма элементов массива = " + strToInt(myArray1));
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.getMessage();
        }

        try {
            System.out.println("Массив 2:");
            System.out.println("Сумма элементов массива = " + strToInt(myArray2));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("Массив 3:");
            System.out.println("Сумма элементов массива = " + strToInt(myArray3));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

    }

}
