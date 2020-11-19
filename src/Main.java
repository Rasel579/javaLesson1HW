    public class Main {
        public static void main(String[] args) {
            //Типы данных
            typesJava();
            // выражение a * (b + (c / d))
            System.out.println(calculate(12,13,16,14));
            //метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах от 10 до 20(включительно)
            System.out.println(compareSum(1,9));
            // метод должен напечатать в консоль положительное ли число передали, или отрицательное;
            equalPositiveOrNegativeNumber(23);
            //метод, которому в качестве параметра передается целое число, метод должен вернуть true, если число отрицательное;
            System.out.println(negativeNumber(0));
            //метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
            helloWord("Мир");
            //метод, который определяет является ли год високосным, и выводит сообщение в консоль.
            whatIsYear(2020);
        }

        private static void whatIsYear(int year) {
            if(year%4 == 0){
                System.out.println("Год высокосный");
            } else {
                System.out.println("Невысокосный");
            }
        }

        private static void helloWord(String str) {
            System.out.println("Привет, " + str + "!");
        }

        private static boolean negativeNumber(int a) {
            return a < 0;
        }

        private static void equalPositiveOrNegativeNumber(int a) {
            if(a >= 0){
                System.out.println("Число положительное");
            } else {
                System.out.println("Число отрицательное");
            }
        }

        private static boolean compareSum(int a, int b) {
            return ((a+b) >= 10 && (a + b) <= 20);
        }

        private static double calculate(int a, int b, double c, double d) {
            return a*(b+(c/d));
        }

        private static void typesJava() {
            byte a = 8;
            short b = 12;
            long c = 13;
            int d = 12;
            float e = 13.5f;
            double f = 12.4;
            boolean isActive = true;
            char h = 123;
            String str = "Hello";
            System.out.println(a + " " + b + " " + c + " " + d + " " + e + " " + f + " " + isActive + " " + h + " " + str );
        }
    }
