import java.util.ArrayList;
import java.util.List;

public class ArrayChecker {
    public static int checkArray (String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4) {
            throw new MyArraySizeException("Массив должен быть размером 4x4");
        }
        for (int i=0; i <4; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("Массив должен быть размером 4х4");
            }
        }

        int sum = 0;
        List<String> errors = new ArrayList<>(); // Список для накопления ошибок
        //преобразование в int
        for (int i=0; i<4; i++) {
            for (int j=0; j<4; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    //Добавляем ошибки в список без прерывания выполнения
                    errors.add("Неверный формат ячейки [" + i + "][" + j +"], значение - " + array[i][j]);
                }
            }
        }
        // Если есть накопленные ошибки, выбрасываем одно исключение с деталями
        if (!errors.isEmpty()) {
            throw new MyArrayDataException("\n" + String.join("\n", errors));
        }

        return sum;
    }
}
