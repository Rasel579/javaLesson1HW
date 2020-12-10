package lesson4;

import java.util.Scanner;

public class TicTacToe {
    static  final int SIZE = 10;
    static final  int CHECKERS = 6;
    static  final String DOT_EMPTY = "•";
    static  final String DOT_HUMAN = "X";
    static  final String DOT_AI = "O";
    static  final String DOT_HEADER = "♥";
    static  Scanner  scanner = new Scanner(System.in);
    static String[][] map = new String[SIZE][SIZE];

    public static void main(String[] args) {
        initialiseMap();
        int[] AIRowAndColumnCoordinates = AiStep();
        do {
            turnGame();
            int[] HumanRowAndColumnCoordinates = humanStep();
            getWin(HumanRowAndColumnCoordinates, DOT_HUMAN);
            AIRowAndColumnCoordinates = AiStep(AIRowAndColumnCoordinates, HumanRowAndColumnCoordinates);
            getWin(AIRowAndColumnCoordinates, DOT_AI);
        } while (true);

    }

    private static void initialiseMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void turnGame() {
        printHeader();
        printMap();
    }


    private static void printHeader() {
        System.out.print(DOT_HEADER + " ");
        for (int i = 1; i <= SIZE; i++) {
            System.out.print(" " + i + " ");
        }
    }

    private static void printMap() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print("\n" + (i + 1));
            for (int j = 0; j < SIZE; j++) {
                System.out.print("  " + map[i][j]);
            }

        }
        System.out.println();
    }

    private static int[] humanStep() {
        int checkRow = 0;
        int checkColumn = 0;
        boolean isAi = false;
        do {
            System.out.println("Введите номер строки:");
            if(scanner.hasNextInt()){
                checkRow = scanner.nextInt();
            } else {
                System.out.println("Введите число");
                scanner.next();
                continue;
            }
            System.out.println("Введите номер столбца:");
            if(scanner.hasNextInt()){
                checkColumn = scanner.nextInt();
            } else {
                System.out.println("Введите число");
                scanner.next();
            }
        } while(isCheckValidate(checkRow, checkColumn, isAi));

        map[checkRow - 1][checkColumn - 1] = DOT_HUMAN;

        return new int[]{checkRow - 1, checkColumn - 1};
    }

    private static boolean isCheckValidate(int checkRow, int checkColumn, boolean isAi) {
        if(checkColumn > SIZE || checkRow > SIZE || checkColumn <= 0 || checkRow <= 0){
            System.out.println("Введите строку или колонку в пределах поля");
            return  true;
        }
        if (map[checkRow - 1][checkColumn - 1] == DOT_AI || map[checkRow - 1][checkColumn - 1] == DOT_HUMAN) {
            System.out.println("Эта ячейка уже занята");
            return true;
        }
        return false;

    }

    private static void getWin(int[] rowAndColumnCoordinates, String playerStep) {
        int quantityOfStep = 0;
        int row = rowAndColumnCoordinates[0];
        int column = rowAndColumnCoordinates[1];
        getForWinLeftDiagonal(playerStep, quantityOfStep, row, column, rowAndColumnCoordinates);
        getForWinRightDiagonal(playerStep, quantityOfStep, row, column, rowAndColumnCoordinates);
        getWinVertical(playerStep, quantityOfStep, row, column);
        getWinHorizontal(playerStep, quantityOfStep, row, column);

    }

    private static void getForWinLeftDiagonal(String playerStep, int quantityOfStep, int row, int column, int[] rowAndColumnCoordinates){
        while(row < SIZE && column < SIZE){
            if(map[row][column] == playerStep ){
                quantityOfStep++;
            }else break;
            didWin(playerStep, quantityOfStep);
            row++;
            column++;
        }
        row = rowAndColumnCoordinates[0] - 1;
        column = rowAndColumnCoordinates[1] -1;
        while (row >= 0 && column >= 0){
            if(map[row][column] == playerStep ){
                quantityOfStep++;
            } else break;
            didWin(playerStep, quantityOfStep);
            row--;
            column--;
        }
    }

    private static void didWin(String playerStep, int quantityOfStep) {
        if(quantityOfStep == CHECKERS){
            String player = playerStep.equals(DOT_HUMAN) ? "Человек" : "Искусственный разум";
            turnGame();
            System.out.println("Выйграл " + player);
            System.exit(0);
        }
    }

    private static void getForWinRightDiagonal(String playerStep, int quantityOfStep, int row, int column, int[] rowAndColumnCoordinates) {
        while(row < SIZE && column >= 0){
            if(map[row][column] == playerStep ){
                quantityOfStep++;
            }else break;
            didWin(playerStep, quantityOfStep);
            row++;
            column--;
        }
        row = rowAndColumnCoordinates[0] - 1;
        column = rowAndColumnCoordinates[1] + 1;
        while (row >= 0 && column < SIZE){
            if(map[row][column] == playerStep ){
                quantityOfStep++;
            } else {
                break;
            }
            didWin(playerStep, quantityOfStep);
            row--;
            column++;
        }
    }

    private static void getWinVertical(String playerStep, int quantityOfStep, int row, int column) {
        int j = column;
        for (int i = 0; i < SIZE; i++) {
            if(map[i][j] == playerStep){
                quantityOfStep++;
            } else break;
            didWin(playerStep, quantityOfStep);
        }
        quantityOfStep = 0;
        for (int i = SIZE - 1; i >= 0; i--) {
            if(map[i][j] == playerStep){
                quantityOfStep++;
            } else break;
            didWin(playerStep, quantityOfStep);
        }
    }

    private static void getWinHorizontal(String playerStep, int quantityOfStep, int row, int column) {
        int i = row;
        for (int j = 0; j < SIZE; j++) {
            if(map[i][j] == playerStep){
                quantityOfStep++;
            } else break;
            didWin(playerStep, quantityOfStep);
        }
        quantityOfStep = 0;
        for (int j = SIZE - 1; j >= 0; j--) {
            if(map[i][j] == playerStep){
                quantityOfStep++;
            } else break;
            didWin(playerStep, quantityOfStep);
        }
    }

    private static int[] AiStep() {
        int checkColumn = 0;
        int checkRow = 0;
        boolean isAi = true;
        do {
            checkColumn = (int)(Math.random()*(SIZE + 1));
            checkRow  = (int)(Math.random()*(SIZE + 1));
        } while (isCheckValidate(checkRow, checkColumn, isAi));
        return new int[]{checkRow - 1, checkColumn - 1};
    }

    private static int[] AiStep(int[] aiRowAndColumnCoordinates, int[] humanRowAndColumnCoordinates) {
        return  checkForWinAI(aiRowAndColumnCoordinates, humanRowAndColumnCoordinates);

    }

    private static int[] checkForWinAI(int[] aiRowAndColumnCoordinates, int[] humanRowAndColumnCoordinates) {
        int preWin = CHECKERS - 1;
        int quantityOfStep = 0;
        int row = aiRowAndColumnCoordinates[0];
        int column = aiRowAndColumnCoordinates[1];
        int[] nothing = { -1, -1};
        int[] leftDiagonal = SeekForWinLeftDiagonal(quantityOfStep, row, column, aiRowAndColumnCoordinates, preWin);
        int[] rightDiagonal = SeekForWinRightDiagonal(quantityOfStep, row, column, aiRowAndColumnCoordinates, preWin);
        int[] horizontal = SeekForWinHorizontal(quantityOfStep, row, column, aiRowAndColumnCoordinates, preWin);
        int[] vertical = SeekForWinVertical(quantityOfStep, row, column, aiRowAndColumnCoordinates, preWin);
        int[] AiBlockedHuman = AiBlockedHuman(humanRowAndColumnCoordinates);

        if(leftDiagonal[0] != nothing[0]){
            map[leftDiagonal[0]][leftDiagonal[1]] = DOT_AI;
            return leftDiagonal;
        }
        else if(rightDiagonal[0] != nothing[0]){
            map[rightDiagonal[0]][rightDiagonal[1]] = DOT_AI;
            return rightDiagonal;
        }
        else if(horizontal[0] != nothing[0]){
            map[horizontal[0]][horizontal[1]] = DOT_AI;
            return  horizontal;
        }
        else  if (vertical[0] != nothing[0]){
            map[vertical[0]][vertical[1]] = DOT_AI;
            return vertical;
        }
        else  if (AiBlockedHuman[0] != nothing[0]){
            map[AiBlockedHuman[0]][AiBlockedHuman[1]] = DOT_AI;
            return AiBlockedHuman;
        }
        else {
            int[] AIstep = AiStep();
            map[AIstep[0]][AIstep[1]] = DOT_AI;
            return AIstep;
        }

    }

    private static int[] SeekForWinLeftDiagonal(int quantityOfStep, int row, int column, int[] aiRowAndColumnCoordinates, int preWin) {
        while(row < SIZE  && column >= 0 ){
            if(map[row][column] == DOT_AI){
                quantityOfStep++;
            }else break;
            if(quantityOfStep == preWin && row != SIZE - 1 && column != 0 && map[row + 1][column - 1] != DOT_HUMAN ){
                map[row + 1][column - 1] = DOT_AI;
                return new int[]{row + 1,column - 1};
            }
            if(quantityOfStep == preWin && map[aiRowAndColumnCoordinates[0] - 1][aiRowAndColumnCoordinates[1] + 1] != DOT_HUMAN ){
                map[aiRowAndColumnCoordinates[0] - 1][aiRowAndColumnCoordinates[1] + 1] = DOT_AI;
                return new int[]{aiRowAndColumnCoordinates[0] - 1, aiRowAndColumnCoordinates[1] + 1};
            }
            row++;
            column--;
        }
        row = aiRowAndColumnCoordinates[0] - 1;
        column = aiRowAndColumnCoordinates[1] + 1;

        while (row >= 0 && column < SIZE){
            if(map[row][column] == DOT_AI ){
                quantityOfStep++;
            } else break;
            if(quantityOfStep == preWin && row != 0 && column != SIZE - 1 && map[row - 1][column + 1] != DOT_HUMAN){
                map[row - 1][column + 1] = DOT_AI;
                return new int[]{row - 1,column + 1};
            }
            if(quantityOfStep == preWin && map[aiRowAndColumnCoordinates[0] - 1][aiRowAndColumnCoordinates[1] + 1] != DOT_HUMAN){
                map[aiRowAndColumnCoordinates[0] - 1][aiRowAndColumnCoordinates[1] + 1] = DOT_AI;
                return new int[]{aiRowAndColumnCoordinates[0] - 1,aiRowAndColumnCoordinates[1] + 1};
            }
            row--;
            column--;
        }

        return new int[]{-1, -1};
    }

    private static int[] SeekForWinRightDiagonal(int quantityOfStep, int row, int column, int[] aiRowAndColumnCoordinates, int preWin) {
        while(row < SIZE  && column < SIZE ){
            if(map[row][column] == DOT_AI){
                quantityOfStep++;
            }else break;
            if(quantityOfStep == preWin && row != SIZE - 1 && column != SIZE -1 && map[row + 1][column + 1] != DOT_HUMAN ){
                map[row + 1][column + 1] = DOT_AI;
                return new int[]{row + 1,column + 1};
            }
            if(quantityOfStep == preWin && map[aiRowAndColumnCoordinates[0] - 1][aiRowAndColumnCoordinates[1] - 1] != DOT_HUMAN && aiRowAndColumnCoordinates[0] >= 0 && aiRowAndColumnCoordinates[0] < SIZE ){
                map[aiRowAndColumnCoordinates[0] - 1][aiRowAndColumnCoordinates[1] - 1] = DOT_AI;
                return new int[]{aiRowAndColumnCoordinates[0] - 1,aiRowAndColumnCoordinates[1] - 1};
            }
            row++;
            column++;
        }
        row = aiRowAndColumnCoordinates[0] - 1;
        column = aiRowAndColumnCoordinates[1] -1;

        while (row >= 0 && column >= 0){
            if(map[row][column] == DOT_AI ){
                quantityOfStep++;
            } else break;
            if(quantityOfStep == preWin && row != 0 && column != 0 && map[row - 1][column - 1] != DOT_HUMAN){
                map[row - 1][column - 1] = DOT_AI;
                return new int[]{row - 1,column - 1};
            }
            if(quantityOfStep == preWin && map[aiRowAndColumnCoordinates[0] + 2][aiRowAndColumnCoordinates[1] + 2] != DOT_HUMAN){
                map[aiRowAndColumnCoordinates[0] + 2][aiRowAndColumnCoordinates[1] + 2] = DOT_AI;
                return new int[]{aiRowAndColumnCoordinates[0] + 2,aiRowAndColumnCoordinates[1] + 2};
            }
            row--;
            column--;
        }
        return new int[]{-1, -1};
     }


    private static int[] SeekForWinHorizontal(int quantityOfStep, int row, int column, int[] aiRowAndColumnCoordinates, int preWin) {
        int i = row;
        for (int j = column; j < SIZE; j++) {
            if(map[i][j] == DOT_AI){
                quantityOfStep++;
            } else break;

            if(quantityOfStep == preWin && j != SIZE - 1 && map[i][j + 1] != DOT_HUMAN){
                map[i][j + 1] = DOT_AI;
                return  new int[]{ i, j + 1};
            }
            if(quantityOfStep == preWin && map[i][column - 1] != DOT_HUMAN){
                map[i][column - 1] = DOT_AI;
                return  new int[]{i, column - 1};
            }
        }
        for (int j = column - 1; j >= 0; j--) {
            if(map[i][j] == DOT_AI){
                quantityOfStep++;
            } else break;

            if(quantityOfStep == preWin && j != 0 && map[i][j - 1] != DOT_HUMAN){
                map[i][j - 1] = DOT_AI;
                return  new int[]{i, j - 1};
            }
        }

        return new int[]{ -1, -1};
    }

    private static int[] SeekForWinVertical(int quantityOfStep, int row, int column, int[] aiRowAndColumnCoordinates, int preWin) {
        int i = column;
        int chance = 0;
        for (int j = row; j < SIZE; j++) {
            if(map[j][i] == DOT_AI){
                quantityOfStep++;
            } else break;

            if(quantityOfStep == preWin && j != SIZE - 1 && map[j + 1][i] != DOT_HUMAN){
                map[j + 1][i] = DOT_AI;
                return  new int[]{j + 1, i};
            }
            if(quantityOfStep == preWin && map[row - 1][i] != DOT_HUMAN){
                map[row - 1][i] = DOT_AI;
                return  new int[]{row - 1, i};
            }
        }
        for (int j = row - 1; j >= 0; j--) {
            if(map[j][i] == DOT_AI){
                quantityOfStep++;
            } else break;

            if(quantityOfStep == preWin && j != 0 && map[j - 1][i] != DOT_HUMAN){
                map[j - 1][i] = DOT_AI;
                return  new int[]{j - 1, i};
            }
        }

        return new int[]{ -1, -1};
    }

    private static int[] AiBlockedHuman(int[] humanRowAndColumnCoordinates) {
        int preWin = CHECKERS - 1;
        int quantityOfStep = 0;
        int row = humanRowAndColumnCoordinates[0];
        int column = humanRowAndColumnCoordinates[1];
        int[] nothing = { -1, -1};
        int[] leftDiagonal = SeekForBlockLeftDiagonal(quantityOfStep, row, column, humanRowAndColumnCoordinates, preWin);
        int[] rightDiagonal = SeekForBlockRightDiagonal(quantityOfStep, row, column, humanRowAndColumnCoordinates, preWin);
        int[] horizontal = SeekForBlockHorizontal(quantityOfStep, row, column, humanRowAndColumnCoordinates, preWin);
        int[] vertical = SeekForBlockVertical(quantityOfStep, row, column, humanRowAndColumnCoordinates, preWin);
        if(leftDiagonal[0] != nothing[0]){
            map[leftDiagonal[0]][leftDiagonal[1]] = DOT_AI;
            return leftDiagonal;
        }
        else if(rightDiagonal[0] != nothing[0]){
            map[rightDiagonal[0]][rightDiagonal[1]] = DOT_AI;
            return rightDiagonal;
        }
        else if(horizontal[0] != nothing[0]){
            map[horizontal[0]][horizontal[1]] = DOT_AI;
            return  horizontal;
        }
        else  if (vertical[0] != nothing[0]){
            map[vertical[0]][vertical[1]] = DOT_AI;
            return vertical;
        }
        else {

            return nothing;
        }
    }

    private static int[] SeekForBlockLeftDiagonal(int quantityOfStep, int row, int column, int[] aiRowAndColumnCoordinates, int preWin) {
        while(row < SIZE  && column >= 0 ){
            if(map[row][column] == DOT_HUMAN){
                quantityOfStep++;
            }else break;
            if(quantityOfStep == preWin && row != SIZE - 1 && column != 0 && map[row + 1][column - 1] != DOT_AI ){
                map[row + 1][column - 1] = DOT_AI;
                return new int[]{row + 1,column - 1};
            }
            if(quantityOfStep == preWin && map[aiRowAndColumnCoordinates[0] - 1][aiRowAndColumnCoordinates[1] + 1] != DOT_AI ){
                map[aiRowAndColumnCoordinates[0] - 1][aiRowAndColumnCoordinates[1] + 1] = DOT_AI;
                return new int[]{aiRowAndColumnCoordinates[0] - 1, aiRowAndColumnCoordinates[1] + 1};
            }
            row++;
            column--;
        }
        row = aiRowAndColumnCoordinates[0] - 1;
        column = aiRowAndColumnCoordinates[1] + 1;

        while (row >= 0 && column < SIZE){
            if(map[row][column] == DOT_HUMAN ){
                quantityOfStep++;
            } else break;
            if(quantityOfStep == preWin && row != 0 && column != SIZE - 1 && map[row - 1][column + 1] != DOT_AI){
                map[row - 1][column + 1] = DOT_AI;
                return new int[]{row - 1,column + 1};
            }
            if(quantityOfStep == preWin && map[aiRowAndColumnCoordinates[0] - 1][aiRowAndColumnCoordinates[1] + 1] != DOT_AI){
                map[aiRowAndColumnCoordinates[0] - 1][aiRowAndColumnCoordinates[1] + 1] = DOT_AI;
                return new int[]{aiRowAndColumnCoordinates[0] - 1,aiRowAndColumnCoordinates[1] + 1};
            }
            row--;
            column--;
        }

        return new int[]{-1, -1};
    }

    private static int[] SeekForBlockRightDiagonal(int quantityOfStep, int row, int column, int[] aiRowAndColumnCoordinates, int preWin) {
        while(row < SIZE  && column < SIZE ){
            if(map[row][column] == DOT_HUMAN){
                quantityOfStep++;
            }else break;
            if(quantityOfStep == preWin && row != SIZE - 1 && column != SIZE -1 && map[row + 1][column + 1] != DOT_AI ){
                map[row + 1][column + 1] = DOT_AI;
                return new int[]{row + 1,column + 1};
            }
            if(quantityOfStep == preWin && map[aiRowAndColumnCoordinates[0] - 1][aiRowAndColumnCoordinates[1] - 1] != DOT_AI ){
                map[aiRowAndColumnCoordinates[0] - 1][aiRowAndColumnCoordinates[1] - 1] = DOT_AI;
                return new int[]{aiRowAndColumnCoordinates[0] - 1,aiRowAndColumnCoordinates[1] - 1};
            }
            row++;
            column++;
        }
        row = aiRowAndColumnCoordinates[0] - 1;
        column = aiRowAndColumnCoordinates[1] -1;

        while (row >= 0 && column >= 0){
            if(map[row][column] == DOT_HUMAN ){
                quantityOfStep++;
            } else break;
            if(quantityOfStep == preWin && row != 0 && column != 0 && map[row - 1][column - 1] != DOT_AI){
                map[row - 1][column - 1] = DOT_AI;
                return new int[]{row - 1,column - 1};
            }
            if(quantityOfStep == preWin && map[aiRowAndColumnCoordinates[0] + 1][aiRowAndColumnCoordinates[1] + 1] != DOT_AI && aiRowAndColumnCoordinates[0] < SIZE - 1 && aiRowAndColumnCoordinates[1] < SIZE - 1){
                map[aiRowAndColumnCoordinates[0] + 1][aiRowAndColumnCoordinates[1] + 1] = DOT_AI;
                return new int[]{aiRowAndColumnCoordinates[0] + 1,aiRowAndColumnCoordinates[1] + 1};
            }
            row--;
            column--;
        }
        return new int[]{-1, -1};
    }


    private static int[] SeekForBlockHorizontal(int quantityOfStep, int row, int column, int[] aiRowAndColumnCoordinates, int preWin) {
        int i = row;
        for (int j = column; j < SIZE; j++) {
            if(map[i][j] == DOT_HUMAN){
                quantityOfStep++;
            } else break;

            if(quantityOfStep == preWin && j != SIZE - 1 && map[i][j + 1] != DOT_AI){
                map[i][j + 1] = DOT_AI;
                return  new int[]{ i, j + 1};
            }
            if(quantityOfStep == preWin && map[i][column - 1] != DOT_AI){
                map[i][column - 1] = DOT_AI;
                return  new int[]{i, column - 1};
            }
        }
        for (int j = column - 1; j >= 0; j--) {
            if(map[i][j] == DOT_HUMAN){
                quantityOfStep++;
            } else break;

            if(quantityOfStep == preWin && j != 0 && map[i][j - 1] != DOT_AI){
                map[i][j - 1] = DOT_AI;
                return  new int[]{i, j - 1};
            }
            if(quantityOfStep == preWin && map[i][column + 1] != DOT_AI){
                map[i][column + 1] = DOT_AI;
                return  new int[]{i, column + 1};
            }
        }

        return new int[]{ -1, -1};
    }

    private static int[] SeekForBlockVertical(int quantityOfStep, int row, int column, int[] aiRowAndColumnCoordinates, int preWin) {
        int i = column;
        for (int j = row; j < SIZE; j++) {
            if(map[j][i] == DOT_HUMAN){
                quantityOfStep++;
            } else break;

            if(quantityOfStep == preWin && j != SIZE - 1 && map[j + 1][i] != DOT_AI){
                map[j + 1][i] = DOT_AI;
                return  new int[]{j + 1, i};
            }
            if(quantityOfStep == preWin && map[row - 1][i] != DOT_AI){
                map[row - 1][i] = DOT_AI;
                return  new int[]{row - 1, i};
            }
        }
        for (int j = row - 1; j >= 0; j--) {
            if(map[j][i] == DOT_HUMAN){
                quantityOfStep++;
            } else break;

            if(quantityOfStep == preWin && j != 0 && map[j - 1][i] != DOT_AI && map[j - 1][i] != DOT_HUMAN){
                map[j - 1][i] = DOT_AI;
                return  new int[]{j - 1, i};
            }
            if(quantityOfStep == preWin && map[row + 1][i] != DOT_AI && map[row + 1][i] != DOT_HUMAN && row < SIZE - 1 ){
                map[row + 1][i] = DOT_AI;
                return  new int[]{row + 1, i};
            }
        }

        return new int[]{ -1, -1};
    }
}

