public class Cat extends Animal {

    private boolean full;
    public Cat(String name) {
        super(name);
        totalCats++;
        this.full = false;
    }

    public void eat(Bowl bowl, int amount) {
        if (bowl.getFood() >= amount) {
            bowl.decreaseFood(amount);
            this.full = true;
            System.out.println("Кот " + name + " поел и теперь сыт");
        } else {
            System.out.println("В миске недостаточно еды, чтобы кот " + name + " наелся");
        }
    }

    public boolean full() {
        return full;
    }

    @Override
    public void run(int distance) {
        super.run(distance);
        if (0 < distance && distance <= 200) {
            System.out.println("Кот " + name + " пробежал " + distance + " м.");
        } else {
            System.out.println("Кот "  + name + " не может пробежать менее 0 м. и более 200 м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("Кот " + name + " не умеет плавать");
    }
}
