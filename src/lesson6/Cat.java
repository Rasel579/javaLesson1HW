package lesson6;

public class Cat extends Animal{
    boolean swimmer = false;

    Cat(String name, int age, String color, int limitRun, double limitHeight, int limitSwim) {
        super(name, age, color,limitRun, limitSwim, limitHeight);

    }

    @Override
    void run(int length){
        System.out.println("run: " + (length < this.getLimitRun()));
    }

    @Override
    void jump(int length) {
        System.out.println("jump :" + ((double)length < this.getLimitHeight()));

    }

    void jump(int length, int limit) {
        System.out.println("jump :" + ((double)length < this.getLimitHeight()));

    }

    @Override
    void swim(int length) {
        System.out.println("swim :" + swimmer);
    }
}
