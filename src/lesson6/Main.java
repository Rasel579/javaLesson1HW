package lesson6;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Pushok", 2, "grey", 200, 2, 0);
        Dog dog1 = new Dog("Hasky", 3, "black", 400, 0.5, 10);
        Dog dog2 = new Dog("Sharik", 2, "white", 600, 0.5, 10);
        cat.printInfo();
        cat.swim(12);
        cat.run(300);
        cat.jump(1);

        dog1.printInfo();
        dog1.swim(8);
        dog1.run(500);
        dog1.jump(1);

        dog2.printInfo();
        dog2.swim(8);
        dog2.run(500);
        dog2.jump(1);
    }
}
