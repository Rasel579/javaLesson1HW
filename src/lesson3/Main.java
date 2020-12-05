package lesson3;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    static String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
            "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak",
            "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
            "pepper", "pineapple", "pumpkin", "potato"};
    public static void main(String[] args) {
        //1. Написать программу, которая загадывает случайное число от 0 до 9,
        // и пользователю дается 3 попытки угадать это число. При каждой попытке
        // компьютер должен сообщить больше ли указанное пользователем число чем загаданное,
        // или меньше. После победы или проигрыша выводится запрос –
        // «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет)
         tryToAnswer();

         //2 * Создать массив из слов String[] words = {"apple", "orange", "lemon",
        // "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic",
        // "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
        // "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        //При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
        //сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь.
        // Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
        //apple – загаданное
        //apricot - ответ игрока
        //ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
        //Для сравнения двух слов посимвольно, можно пользоваться:
        //String str = "apple";
        //str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
        //Играем до тех пор, пока игрок не отгадает слово
        //Используем только маленькие буквы

        guessTheWord(words);

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
        Scanner scanner = new Scanner(System.in);
        return scanner.hasNextInt() ? scanner.nextInt() : 10;
    }

    private static void showInfo(int userAnswer, int randomNumber) {
       String helper = userAnswer > randomNumber ? "больше" : "меньше";
        System.out.println("Ваше число " + helper + " загаданного");
    }

    private static void repeatGame() {
        System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
        Scanner scanner = new Scanner(System.in);
        int userAnswer = scanner.hasNextInt() ? scanner.nextInt() : 0;
        if (userAnswer == 1) {
            tryToAnswer();
        }
    }

    private  static void guessTheWord(String[] words){
        String randomWord = words[(int)(Math.random()*words.length)];
        System.out.println(randomWord);
        String userWord;
        String answer = "";
        while(!answer.equals("Вы выйграли")){
            userWord = Objects.requireNonNull(askToEnterWord()).toLowerCase();
            System.out.println(userWord);
            answer = compare(randomWord, userWord);
            System.out.println(answer);
        }

    }

    private static String compare(String randomWord, String userWord) {
        final int LENGTH = 15;
        StringBuilder compareWord = new StringBuilder();
        int lengthWord = Math.min(randomWord.length(), userWord.length());
        for(int i = 0; i < lengthWord; i++){
            if(randomWord.charAt(i) == userWord.charAt(i)) {
                compareWord.append(randomWord.charAt(i));
            } else compareWord.append("#");
        }
        if( randomWord.equals(compareWord.toString())){
            return "Вы выйграли";
        } else {
            compareWord.append("#".repeat(Math.max(0, LENGTH - (compareWord.toString().length() - 1))));
            return compareWord.toString();
        }
    }

    private static String askToEnterWord() {
        System.out.println("Угадайте слово");
        Scanner scan = new Scanner(System.in);
        String userWord = scan.hasNext() ? scan.next() : null;
        assert userWord != null;
        return userWord;
    }
}
