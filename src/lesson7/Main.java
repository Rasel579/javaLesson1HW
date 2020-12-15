package lesson7;

public class Main {
    static String[] names = {"Persic", "Harfield", "Tom", "Kuzia", "Liza"};
    static int food = 25;
    public static void main(String[] args) {
        Cat[] cat = new Cat[names.length];
        Plate plate = new Plate();
        plate.setFood(food);
        for (int i = 0; i < names.length; i++) {
            int count = (int)(Math.random()*food);
            cat[i] = new Cat(names[i], count);
            cat[i].showInfo();
            cat[i].eat(plate);
            plate.showInfo();
        }
    }
}
