import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //Задание 1
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Меркурий");
        arrayList.add("Венера");
        arrayList.add("Земля");
        arrayList.add("Марс");
        arrayList.add("Юпитер");
        arrayList.add("Сатурн");
        arrayList.add("Уран");
        arrayList.add("Нептун");
        arrayList.add("Церера");
        arrayList.add("Плутон");
        arrayList.add("Хаумеа");
        arrayList.add("Макемаке");
        arrayList.add("Эрида");
        arrayList.add("Венера");
        arrayList.add("Сатурн");
        arrayList.add("Плутон");

        HashMap<String, Integer> wordCount = new HashMap<>();

        for (String word : arrayList) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) +1);
        }

        System.out.println("Уникальные слова и их количество:");
        for (Map.Entry<String, Integer> entry :wordCount.entrySet()) {
            System.out.println(entry.getKey()+" - " +entry.getValue());
        }

        //Задание 2
        TelephoneDirectory telephoneDirectory = new TelephoneDirectory();

        telephoneDirectory.add("Жуков", "+79896221344");
        telephoneDirectory.add("Савельев", "+79896221355");
        telephoneDirectory.add("Жуков", "+79896221366");
        telephoneDirectory.add("Короченцев", "+79896221377");
        telephoneDirectory.add("Жуков", "+79896221388");
        telephoneDirectory.add("Савельев", "+79896221399");

        System.out.println("---------------------------");
        System.out.println("Телефоны по фамилии Жуков: " + telephoneDirectory.get("Жуков"));
        System.out.println("Телефоны по фамилии Савельев: " + telephoneDirectory.get("Савельев"));
        System.out.println("Телефоны по фамилии Короченцев: " + telephoneDirectory.get("Короченцев"));
    }
}