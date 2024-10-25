//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Задание 1

        // Часть 1
        Cat cat1 = new Cat("Ренгар");
        Cat cat2 = new Cat("Сефирот");
        Dog dog1 = new Dog("Лютик");

        cat1.run(200);
        cat1.swim(10);

        cat2.run(-8);
        cat2.swim(10);

        dog1.run(160);
        dog1.swim(10);

        System.out.println("Всего создано животных: " + Animal.totalAnimals);
        System.out.println("Из них " + Animal.totalCats + " - коты и " + Animal.totalDogs + " - собаки");
        System.out.println("---------------------------");
        //Часть 2
        Bowl bowl = new Bowl(70);

        Cat[] cats = {
                new Cat("Пуля"),
                new Cat ("Сэм"),
                new Cat("Орианна")
        };

        //Попытка поесть
        for (Cat cat : cats) {
            cat.eat(bowl, 30);
        }

        for (Cat cat : cats) {
            String status = cat.full() ? "сыт" : "голоден";
            System.out.println("Кот " + cat.name + " сейчас " + status);
        }

        //Докладываем еду
        bowl.addFood(20);

        //Снова попытка поесть
        for (Cat cat : cats) {
            if (!cat.full()) {
                cat.eat(bowl, 30);
            }
        }

        for (Cat cat : cats) {
            String status = cat.full() ? "сыт" : "голоден";
            System.out.println("Кот " + cat.name + " сейчас " + status);
        }

        System.out.println("Всего создано животных: " + Animal.totalAnimals);
        System.out.println("Из них " + Animal.totalCats + " - коты и " + Animal.totalDogs + " - собаки");
        System.out.println("---------------------------");

        // Задание 2
        Circle circle = new Circle(3);
        circle.setFillColor("Желтый");
        circle.setBorderColor("Зеленый");

        Rectangle rectangle = new Rectangle(5,7);
        rectangle.setFillColor("Красный");
        rectangle.setBorderColor("Чёрный");

        Triangle triangle = new Triangle(4,4,6);
        triangle.setFillColor("Фиолетовый");
        triangle.setBorderColor("Чёрный");

        System.out.println("Круг:");
        printShapeInfo(circle);
        System.out.println("Прямуогольник:");
        printShapeInfo(rectangle);
        System.out.println("Треугольник:");
        printShapeInfo(triangle);


        }
    private static void printShapeInfo(Shape shape) {
        System.out.println("Периметр: " + shape.calcPerimeter());
        System.out.println("Площадь: " + shape.calcSquare());
        System.out.println("Цвет заливки: " + shape.getFillColor());
        System.out.println("Цвет границы: " + shape.getBorderColor());
    }
}