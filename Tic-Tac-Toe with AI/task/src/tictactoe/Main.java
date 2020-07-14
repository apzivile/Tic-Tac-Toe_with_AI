package tictactoe;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static int xAmount = 0;
    private static int oAmount = 0;
    private static int emptyAmount = 0;

    // int xAmount=0;
    // int oAmount = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("");
        String[][] matrix = new String[3][3];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix.length; ++j) {
                matrix[i][j] = scanner.next();
                if (matrix[i][j].equals("_")) {
                    emptyAmount++;
                }
                if (matrix[i][j].equals("X")) {
                    xAmount++;
                }
                if (matrix[i][j].equals("O")) {
                    oAmount++;
                }
            }
        }

        buildBoard(matrix);
        coordinate(matrix);

        //  victory(coordinate(matrix););

    }

    public static void buildBoard(String[][] matrix) {
        System.out.println("---------");
        for (String[] strings : matrix) {
            System.out.print("|" + " ");
            for (int j = 0; j < matrix.length; ++j) {
                // if (strings[j].equals("_")){
                //   emptyAmount++;
                //}
                System.out.print(strings[j].replace("_", " ") + " ");
                //  if (strings[j].equals("X")){
                //      xAmount++;
                //  }
                //  if (strings[j].equals("O")){
                //      oAmount++;
                //  }
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");
    }

    public static void coordinate(String[][] matrix) {
        boolean isChanged = false;
        boolean xTurn = true;
        boolean won = false;
        boolean xWon = false;
        boolean oWon = false;
        boolean empty = false;
        boolean draw = false;
        boolean loop = false;
        boolean notFinished = false;
        int count = 0;
        do {
            loop=false;
            try {
                count++;
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter the coordinates: ");


                int xCoordinate = sc.nextInt();
                int yCoordinate = sc.nextInt();

                if (xAmount> oAmount){
                    xTurn=false;
                }
                // else {
                //       xTurn=true;
                //  }

                if (xCoordinate >= 1 && xCoordinate <= 3 && yCoordinate >= 1 && yCoordinate <= 3) {

                    if (matrix[Math.abs(3 - yCoordinate)][Math.abs(xCoordinate - 1)].equals("_")) {
                        emptyAmount--;
                        if (xTurn) {
                            matrix[Math.abs(3 - yCoordinate)][Math.abs(xCoordinate - 1)] = "X";
                            xAmount++;
                            isChanged = true;
                            xTurn = false;
                        } else {
                            matrix[Math.abs(3 - yCoordinate)][Math.abs(xCoordinate - 1)] = "O";
                            oAmount++;
                            isChanged = true;
                            xTurn = true;

                        }
                        // break;
                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                        loop=true;
                        isChanged = false;
                    }
                    xWon = victory(matrix, "X");
                    oWon = victory(matrix, "O");
                    if (xWon || oWon) {
                        won = true;
                    }
                    if (emptyAmount==0) {
                        draw = true;
                        won = true;
                    }
                 //   if (emptyAmount != 0 && (xAmount >= 3 && oAmount >= 4 || xAmount >= 4 && oAmount >= 3)){
                  ///      notFinished = true;
                  //      won=true;
                   // }
                    if (!xWon && !oWon &&emptyAmount !=0){
                        notFinished=true;
                        won=true;
                    }
                    //}
                    // }

                } else {
                    System.out.println("Coordinates should be from 1 to 3!");
                    loop=true;
                    continue;
                }
                if (isChanged) {
                    buildBoard(matrix);
                } //else {
                //  System.out.println("This cell is occupied! Choose another one!");
                // }


            } catch (InputMismatchException e) {
                System.out.println("You should enter numbers!");
                loop=true;
                //break;
            }
        } while (!won || loop);


        if (xWon) {
            System.out.println("X wins");
        } else if (oWon) {
            System.out.println("O wins");
        } else if (notFinished) {
            System.out.println("Game not finished");
        } else if (draw){
            System.out.println("Draw");
        }

    }

    public static boolean victory(String[][] matrix, String piece) {

        int counter = 0;

        for (String[] strings : matrix) {
            for (String string : strings) {
                if (counter == 3)
                    break;
                if (string.equals(piece))
                    counter++;
                else
                    counter = 0;
            }
            if (counter != 3)
                counter = 0;
        }
        //check columns
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (counter == 3)
                    break;
                if (matrix[j][i].equals(piece))
                    counter++;
                else
                    counter = 0;
            }
            if (counter != 3)
                counter = 0;
        }

        //check diagonal
        for (int i = 0; i < matrix.length; i++) {
            if (counter == 3)
                break;
            if (matrix[i][i].equals(piece))
                counter++;
            else
                counter = 0;
        }
        if (matrix[0][2].equals(piece) && matrix[1][1].equals(piece) && matrix[2][0].equals(piece))
            counter = 3;
        return counter == 3;
    }
}