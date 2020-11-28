package lesson3;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        //1. Написать программу, которая загадывает случайное число от 0 до 9,
        // и пользователю дается 3 попытки угадать это число. При каждой попытке
        // компьютер должен сообщить больше ли указанное пользователем число чем загаданное,
        // или меньше. После победы или проигрыша выводится запрос –
        // «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет)
         tryToAnswer();

    }

    private static void tryToAnswer() {
        int randomNumber = (int)(Math.random()*10);
        int counter = 3;
        do {
            int userAnswer = enterUserAnswer();
            if(userAnswer == randomNumber){
                System.out.println("Вы выйграли!");
                repeatGame();
                break;
            } else {
                showInfo(userAnswer, randomNumber);
                System.out.println("Вы не угадали, попробуйте еще раз");
                --counter;
                if(counter == 0){
                    repeatGame();
                }

            }
        } while(counter > 0);
    }

    private static int enterUserAnswer() {
        System.out.println("Введите число от 0 до 10");
        return scanner.hasNextInt() ? scanner.nextInt() : 0;
    }

    private static void showInfo(int userAnswer, int randomNumber) {
       String helper = userAnswer > randomNumber ? "больше" : "меньше";
        System.out.println("Ваше число " + helper + " загаданного");
    }

    private static void repeatGame() {
        System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
        int userAnswer = scanner.hasNextInt() ? scanner.nextInt() : 0;
        if (userAnswer == 1) {
            tryToAnswer();
        }
    }
}
