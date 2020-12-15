package lesson7;

public class Plate {
    private int food;
    public void setFood(int food){
        this.food+= food;
    }


    @Override
    public String toString() {
        return "Plate{" +
                "food=" + food +
                '}';
    }

    public void showInfo(){
        System.out.println(this.toString());
    }

    public boolean decreasing(int countFoodForFullness) {
        if(countFoodForFullness < this.food){
            this.food-= countFoodForFullness;
            return true;
        }
        return false;
    }
}
