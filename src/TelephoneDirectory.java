import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TelephoneDirectory {
    private Map<String, List<String>> telephoneDirectory;

    public TelephoneDirectory() {
        telephoneDirectory = new HashMap<>();
    }

    // Метод для добавления записи в справочник
    public void add(String lastName, String phoneNumber) {
        telephoneDirectory.computeIfAbsent(lastName, k -> new ArrayList<>()).add(phoneNumber);
        //Лямбда-выражение k -> new ArrayList<>() просто означает: «если ключа нет, создаем новый пустой ArrayList»
    }

    //Метод для получения списка номеров по фамилии
    public List<String> get(String lastName) {
        return telephoneDirectory.getOrDefault(lastName, new ArrayList<>());

    }
}
