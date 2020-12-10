package lesson6;

public class Dog extends Animal{
    Dog(String name, int age, String color, int limitRun, double limitHeight, int limitSwim) {
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

    @Override
    void swim(int length) {
        System.out.println("swim :" + (length < getLimitSwim()));
    }
}
