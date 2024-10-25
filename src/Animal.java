public class Animal {
    static int totalAnimals = 0;
    static int totalCats = 0;
    static int totalDogs = 0;

    protected String name;

    public Animal(String name) {
        this.name = name;
        totalAnimals++;
    }

    public void run(int distance) {

    }

    public void swim (int distance) {

    }
}
