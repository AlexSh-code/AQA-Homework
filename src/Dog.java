public class Dog extends Animal {

    public Dog(String name) {
        super(name);
        totalDogs++;
    }

    @Override
    public void run(int distance) {
        super.run(distance);
        if (0 < distance && distance <=500) {
            System.out.println("Собака " + name + " пробежала " + distance + " м.");
        } else {
            System.out.println("Собака " + name + " не может пробежать менее 0 м. и более 500 м.");
        }
    }

    @Override
    public void swim(int distance) {
        super.swim(distance);
        if (0 < distance && distance <=10) {
            System.out.println("Собака " + name + " проплыла " + distance + " м.");
        } else {
            System.out.println("Собака " + name + " не может проплыть менее 0 м. и более 10 м.");
        }
    }
}
