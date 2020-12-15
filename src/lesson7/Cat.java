package lesson7;

public class Cat {
    private String name;
    private int countFoodForFullness;
    private boolean fullness = false;
    Cat(String name, int countFoodForFullness){
        this.name = name;
        this.countFoodForFullness = countFoodForFullness;
    }

    public void eat(Plate plate){
        this.fullness = plate.decreasing(this.countFoodForFullness);
        System.out.println(this.name + " is full? " + this.fullness);

    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", countFoodForFullness=" + countFoodForFullness +
                ", fullness=" + fullness +
                '}';
    }

    public void showInfo(){
        System.out.println(this.toString());
    }


}
