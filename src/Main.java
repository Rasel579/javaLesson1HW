public class Main {
    public static void main(String[] args) {
        //1. Задать целочисленный массив, состоящий из элементов 0 и 1.
        // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
        // С помощью цикла и условия заменить 0 на 1, 1 на 0;
        final int SIZE = 10;
        int[] array = {0, 1, 1, 0, 1, 1, 0, 1, 1, 1};
        int[] newArray = new int[SIZE];
        changeArrayValues0to1(array, newArray);

        //2. Задать пустой целочисленный массив размером 8.
        // С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        final  int newSize = 8;
        int[] tripleArray = new int[newSize];
        makeArrayEllementsByThree(tripleArray);

        /*
        3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
         пройти по нему циклом, и числа меньшие 6 умножить на 2;
        */
        int[] arrayMultiplyByThree = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int[] newArr = new int[12];
        multiplyElementsByTwo(arrayMultiplyByThree, newArr);

        //4. Создать квадратный двумерный целочисленный массив
        // (количество строк и столбцов одинаковое),
        // и с помощью цикла(-ов) заполнить его диагональные элементы единицами
        final int SIZEFORSQUADARRAY = 10;
        int[][] squadArray = new int[SIZEFORSQUADARRAY][SIZEFORSQUADARRAY];
        makeSquadElementsArr(squadArray);
        // Показывает двумерный массив в консоли
        showSquadArray(squadArray);

        //5.** Задать одномерный массив и найти в нем минимальный
        // и максимальный элементы (без помощи интернета);
        int[] arrayForFithTask = {36, 35, 4, 0, 23, 34, 1, 0};
        minAndMaxValueOfArray(arrayForFithTask);

        //6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
        // метод должен вернуть true, если в массиве есть место,
        // в котором сумма левой и правой части массива равны.
        // Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
        // checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.
        int[] arrayForTaskSix = {2, 2, 2, 1, 2, 2, 10, 1};
        System.out.println();
        System.out.println(checkBalance(arrayForTaskSix));

        //7. **** Написать метод, которому на вход подается одномерный массив
        // и число n (может быть положительным, или отрицательным),
        // при этом метод должен сместить все элементымассива на n позиций.
        // Для усложнения задачи нельзя пользоваться вспомогательными массивами.
        int[] arrayForTaskSeven = {1, 2, 3, 4, 5, 6 };
        int[] newArrayForTaskSeven = new int[arrayForTaskSeven.length];
        int step = 0;
        slideArrayByStep(arrayForTaskSeven, newArrayForTaskSeven, step);
        showArray(newArrayForTaskSeven);


    }

    private static void showArray(int[] newArrayForTaskSeven) {
        for (int i = 0; i < newArrayForTaskSeven.length; i++){
            System.out.printf("%d ", newArrayForTaskSeven[i]);
        }
    }

    private static void slideArrayByStep(int[] arrayForTaskSeven, int[] newArrayForTaskSeven, int step) {
        if(step > 0){
            for(int i = 0; i < step; i++){
                newArrayForTaskSeven[i] = arrayForTaskSeven[arrayForTaskSeven.length - 1 -i];
            }
            for (int i = 0; i < arrayForTaskSeven.length - step; i++){
                newArrayForTaskSeven[arrayForTaskSeven.length - (arrayForTaskSeven.length - step) + i] = arrayForTaskSeven[i];
            }
        } else {
            step = Math.abs(step);
            for(int i = 0; i < arrayForTaskSeven.length - step; i++){
                newArrayForTaskSeven[i] = arrayForTaskSeven[i + step];
            }
            for (int i = 0; i < step; i++){
                newArrayForTaskSeven[arrayForTaskSeven.length - step + i] = arrayForTaskSeven[i];
            }
        }

    }

    private static boolean checkBalance(int[] arrayForTaskSix) {
        int i = 0;
        int sumRight = 0;
        while (i < arrayForTaskSix.length){
            int sumLeft = 0;
            sumRight+=arrayForTaskSix[i];
            for (int j = arrayForTaskSix.length - 1; j > i ; j--) {
                sumLeft+=arrayForTaskSix[j];
            }
            if(sumLeft == sumRight){
                System.out.println("Breakpoint: " + i);
                return true;
            }
            i++;
        }
        return false;
    }

    private static void minAndMaxValueOfArray(int[] arrayForFithTask) {
        int max = arrayForFithTask[0];
        int min = arrayForFithTask[0];
        for (int i = 0; i < arrayForFithTask.length; i++) {
            max = (max < arrayForFithTask[i]) ? arrayForFithTask[i] : max;
            min = (min > arrayForFithTask[i]) ? arrayForFithTask[i] : min;
        }
        System.out.printf("Max: %d, Min: %d ", max, min);
    }

    private static void showSquadArray(int[][] squadArray) {
        System.out.println();
        for (int i = 0; i <squadArray.length ; i++) {
            for (int j = 0; j < squadArray.length; j++) {
                System.out.printf("%d ", squadArray[i][j]);
            }
            System.out.println();

        }
    }

    private static void makeSquadElementsArr(int[][] squadArray) {
        int j = 0;
        for (int i = 0; i < squadArray.length; i++) {
            j = i;
            squadArray[i][j] = 1;
          }
        }


    private static void makeArrayEllementsByThree(int[] tripleArray) {
        for(int i = 0; i < tripleArray.length; i++){
            tripleArray[i] = 3 * i;
            System.out.printf("%d ", tripleArray[i]);
        }
        System.out.println();
    }

    private static void changeArrayValues0to1(int[] array, int[] newArray) {
        for (int i = 0; i < array.length; i++) {
            newArray[i] = ((array[i] == 0) ? 1 : 0);
            System.out.printf("%d ", newArray[i]);
        }
        System.out.println();
    }

    public static void  multiplyElementsByTwo(int[] array, int[] newArr){
        for (int i = 0; i < array.length; i++) {
            newArr[i] = (array[i] < 6) ? array[i]*2 : array[i];
            System.out.printf("%d ", newArr[i]);
        }
    }
}

