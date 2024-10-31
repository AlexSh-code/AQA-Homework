//Исключение для ошибки размера массива
class MyArraySizeException extends Exception {
    public MyArraySizeException(String message) {
        super(message);
    }
}

//Исключение для ошибки данных массива
class MyArrayDataException extends Exception {
    public MyArrayDataException(String message) {
        super(message);
    }
}

public class Main {
    public static void main(String[] args) {
        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] incorrectSizeArray = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
        };

        String[][] incorrectDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "X", "Y", "12"},
                {"13", "14", "15", "Z"}
        };

        // Тестируем корректный массив
        try {
            int result = ArrayChecker.checkArray(correctArray);
            System.out.println("Сумма элементов массива: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Исключение: " + e.getMessage());
        }

        // Тестируем массив с некорректным размером
        try {
            int result = ArrayChecker.checkArray(incorrectSizeArray);
            System.out.println("Сумма элементов массива: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Исключение: " + e.getMessage());
        }

        // Тестируем массив с некорректными данными
        try {
            int result = ArrayChecker.checkArray(incorrectDataArray);
            System.out.println("Сумма элементов массива: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Исключение: " + e.getMessage());
        }
    }
}