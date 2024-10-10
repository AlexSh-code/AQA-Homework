public class Main {
    public static void main(String[] args) {
        //Задание 1
        Employee employee1 = new Employee();
        employee1.info();
        //Задание 2
        Employee[] empArray = new Employee[5];
        empArray[0] = new Employee("Советов Станислав Ильич", "Программист",
                "sovetovstas@yandex.ru", 89882135438L, 210690, 35);
        empArray[1] = new Employee("Сибирская Ирина Валерьевна", "HR",
                "irinasiberia@mail.ru", 89892995636L, 40000, 23);
        empArray[2] = new Employee("Теперичев Игорь Родионович", "Аналитик",
                "sovetovstas@yandex.ru", 89212177488L, 86000, 35);
        empArray[3] = new Employee("Особенная Арина Витальевна", "QA",
                "osobenna9arina@gmail.com", 89882875666L, 59000, 26);
        empArray[4] = new Employee("Собянин Артем Артемович", "QA Lead",
                "sobyaninarar@yandex.ru", 89816475470L, 110000, 33);
        empArray[0].info();
        empArray[1].info();
        empArray[2].info();
        empArray[3].info();
        empArray[4].info();
        //Задание 3
        Park.Attraction attraction1 = new Park.Attraction("Колесо обозрения", "С 10 утра до 8 вечера", 900);
        attraction1.infoPark();




    }
}