package lesson6;

public abstract class Animal {
    private String name;
    private int age;
    private String color;
    private int limitRun;
    private int limitSwim;
    private double limitHeight;

    public int getLimitRun() {
        return limitRun;
    }

    public int getLimitSwim() {
        return limitSwim;
    }

    public double getLimitHeight() {
        return limitHeight;
    }

    Animal(String name, int age, String color, int limitRun, int limitSwim, double limitHeight){
        this.name = name;
        this.age = age;
        this.color = color;
        this.limitHeight = limitHeight;
        this.limitRun = limitRun;
        this.limitSwim = limitSwim;
    }

    @Override
    public String toString() {
        return this.getClass().getName() +"{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                ", limitRun=" + limitRun +
                ", limitSwim=" + limitSwim +
                ", limitHeight=" + limitHeight +
                '}';
    }

    public void printInfo(){
        System.out.println(this.toString());
    }

    abstract void run(int length);
    abstract void jump(int length);
    abstract void swim(int length);

}
