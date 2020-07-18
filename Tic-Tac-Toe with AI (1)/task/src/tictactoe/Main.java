package tictactoe;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in).useDelimiter("");
        String[][] matrix = new String[3][3];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix.length; ++j) {
                matrix[i][j] = " ";
            }
        }
        System.out.print("Input command:");
        Scanner scanner = new Scanner(System.in);
        boolean incorrectInput = true;
        while (incorrectInput) {

            String command = scanner.nextLine();
            String[] commands = command.split(" ");

            clearBoard(matrix);

            if (commands[0].equals("start") && commands[1].equals("user") && commands[2].equals("user")) {
                buildBoard(matrix);
                userVSUser(matrix);
                System.out.print("Input command:");
                incorrectInput = true;
            }else if (commands[0].equals("start") && commands[1].equals("hard") && commands[2].equals("hard")) {
                buildBoard(matrix);
                robotVSRobot(matrix);
                System.out.print("Input command:");
                incorrectInput = true;
            } else if (commands[0].equals("start") && commands[1].equals("easy") && commands[2].equals("easy")) {
                buildBoard(matrix);
                robotVSRobot(matrix);
                System.out.print("Input command:");
                incorrectInput = true;
            } else if (commands[0].equals("start") && (commands[1].equals("easy") || commands[1].equals("user")) && (commands[2].equals("easy") || commands[2].equals("user"))) {
                buildBoard(matrix);
                robotVSUser(matrix);
                System.out.print("Input command:");
                incorrectInput = true;

            }else if(commands[0].equals("start") && (commands[1].equals("easy") || commands[1].equals("medium")) && (commands[2].equals("easy") || commands[2].equals("medium"))) {
                buildBoard(matrix);
                robotVSRobot(matrix);
                System.out.print("Input command:");
                incorrectInput = true;
            }else if (commands[0].equals("start") && commands[1].equals("medium") && commands[2].equals("medium")) {
                buildBoard(matrix);
                robotVSRobot(matrix);
                System.out.print("Input command:");
                incorrectInput = true;
            }else if(commands[0].equals("start") && (commands[1].equals("medium") || commands[1].equals("user")) && (commands[2].equals("medium") || commands[2].equals("user"))) {
                buildBoard(matrix);
                robotVSUser(matrix);
                System.out.print("Input command:");
                incorrectInput = true;
            }else if(commands[0].equals("start") && (commands[1].equals("hard") || commands[1].equals("user")) && (commands[2].equals("hard") || commands[2].equals("user"))) {
                buildBoard(matrix);
                robotVSUser(matrix);
                System.out.print("Input command:");
                incorrectInput = true;
            }else if(commands[0].equals("start") && (commands[1].equals("hard") || commands[1].equals("medium")) && (commands[2].equals("hard") || commands[2].equals("medium"))) {
                buildBoard(matrix);
                robotVSRobot(matrix);
                System.out.print("Input command:");
                incorrectInput = true;
            }else if(commands[0].equals("start") && (commands[1].equals("easy") || commands[1].equals("hard")) && (commands[2].equals("easy") || commands[2].equals("hard"))) {
                buildBoard(matrix);
                robotVSRobot(matrix);
                System.out.print("Input command:");
                incorrectInput = true;
            }
            else if (commands[0].equals("exit")) {
                //   System.out.println("goodbye");
                incorrectInput = false;
            } else {
                System.out.println("Bad parameters!");
                System.out.print("Input command:");
                incorrectInput = true;
            }
        }
    }

    public static void clearBoard(String[][] matrix) {
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix.length; ++j) {
                matrix[i][j] = " ";
            }
        }
    }


    public static void buildBoard(String[][] matrix) {
        System.out.println("---------");

        for (String[] strings : matrix) {
            System.out.print("|" + " ");
            for (int j = 0; j < matrix.length; ++j) {
                System.out.print("  ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");
    }


    public static void robotVSRobot(String[][] matrix) {
        boolean isChanged = false;
        boolean xTurn = true;
        boolean won = false;
        boolean xWon = false;
        boolean oWon = false;
        boolean empty = false;
        boolean draw = false;
        int count = 0;
        Random random = new Random();
        do {
            try {
                if (xTurn) {
                    count++;
                    boolean isEmpty = false;
                    System.out.println("Making move level \"easy\"");
                    int easyXCoordinate = random.nextInt(3);//2
                    int easyYCoordinate = random.nextInt(3);//2
                    while (!isEmpty) {
                        if (!matrix[easyXCoordinate][easyYCoordinate].equals(" ")) {
                            easyXCoordinate = random.nextInt(3);
                            easyYCoordinate = random.nextInt(3);
                            //matrix[easyXCoordinate][easyYCoordinate] = "O";
                            // buildBoard(matrix);
                            // xTurn = true;
                        }
                        if (matrix[easyXCoordinate][easyYCoordinate].equals(" ")) {
                            isEmpty = true;
                            //  easyXCoordinate = random.nextInt(3);
                            // easyYCoordinate = random.nextInt(3);
                            // matrix[easyXCoordinate][easyYCoordinate] = "O";
                            // buildBoard(matrix);
                            // xTurn = true;
                        }
                    }
                    matrix[easyXCoordinate][easyYCoordinate] = "X";
                    buildBoard(matrix);
                    xTurn = false;
                    // xWon = victory(matrix, "X");
                    xWon = victory(matrix, "X");
                    if (xWon) {
                        won = true;
                        break;
                    }
                    if (count == 9) {
                        draw = true;
                        won = true;
                        break;
                    }
                }
                if (!xTurn) {
                    count++;
                    boolean isEmpty = false;
                    System.out.println("Making move level \"easy\"");
                    int easyXCoordinate = random.nextInt(3);//2
                    int easyYCoordinate = random.nextInt(3);//2
                    while (!isEmpty) {
                        if (!matrix[easyXCoordinate][easyYCoordinate].equals(" ")) {
                            easyXCoordinate = random.nextInt(3);
                            easyYCoordinate = random.nextInt(3);
                            //matrix[easyXCoordinate][easyYCoordinate] = "O";
                            // buildBoard(matrix);
                            // xTurn = true;
                        }
                        if (matrix[easyXCoordinate][easyYCoordinate].equals(" ")) {
                            isEmpty = true;
                            //  easyXCoordinate = random.nextInt(3);
                            // easyYCoordinate = random.nextInt(3);
                            // matrix[easyXCoordinate][easyYCoordinate] = "O";
                            // buildBoard(matrix);
                            // xTurn = true;
                        }
                    }
                    matrix[easyXCoordinate][easyYCoordinate] = "O";
                    buildBoard(matrix);
                    xTurn = true;
                    // xWon = victory(matrix, "X");
                    oWon = victory(matrix, "O");
                    if (oWon) {
                        won = true;
                        break;
                    }
                    if (count == 9) {
                        draw = true;
                        won = true;
                        break;
                    }
                }
                //  xWon = victory(matrix, "X");
                //     oWon = victory(matrix, "O");
                //   if (xWon || oWon) {
                //       won = true;
                //   }
                //if (count == 9) {
                //     draw = true;
                //     won = true;
                // }
                //}
                // }


                //   if (isChanged) {
                //     buildBoard(matrix);
                //   } //else {
                //  System.out.println("This cell is occupied! Choose another one!");
                // }


            } catch (InputMismatchException e) {
                System.out.println("You should enter numbers!");
                //break;
            }
        } while (!won);


        if (xWon) {
            System.out.println("X wins");
        } else if (oWon) {
            System.out.println("O wins");
        } else if (draw) {
            System.out.println("Draw");

      /*  if (!xWon && !oWon && !empty){
            System.out.println("Draw");
        }
        else if (xWon) {
            System.out.println("X won");
        } else if (oWon) {
            System.out.println("O won");
      */
        }

    }

    public static void userVSUser(String[][] matrix) {
        boolean isChanged = false;
        boolean xTurn = true;
        boolean won = false;
        boolean xWon = false;
        boolean oWon = false;
        boolean empty = false;
        boolean draw = false;
        int count = 0;
        do {
            try {
                count++;
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter the coordinates: ");


                int xCoordinate = sc.nextInt();
                int yCoordinate = sc.nextInt();

                if (xCoordinate >= 1 && xCoordinate <= 3 && yCoordinate >= 1 && yCoordinate <= 3) {

                    if (matrix[Math.abs(3 - yCoordinate)][Math.abs(xCoordinate - 1)].equals(" ")) {

                        if (xTurn) {
                            matrix[Math.abs(3 - yCoordinate)][Math.abs(xCoordinate - 1)] = "X";
                            isChanged = true;
                            xTurn = false;
                        } else {
                            matrix[Math.abs(3 - yCoordinate)][Math.abs(xCoordinate - 1)] = "O";
                            isChanged = true;
                            xTurn = true;

                        }
                        // break;
                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                        isChanged = false;
                    }
                    xWon = victory(matrix, "X");
                    oWon = victory(matrix, "O");
                    if (xWon || oWon) {
                        won = true;
                    }
                    if (count == 9) {
                        draw = true;
                        won = true;
                    }
                    //}
                    // }

                } else {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }
                if (isChanged) {
                    buildBoard(matrix);
                } //else {
                //  System.out.println("This cell is occupied! Choose another one!");
                // }


            } catch (InputMismatchException e) {
                System.out.println("You should enter numbers!");
                //break;
            }
        } while (!won);


        if (xWon) {
            System.out.println("X wins");
        } else if (oWon) {
            System.out.println("O wins");
        } else if (draw) {
            System.out.println("Draw");

      /*  if (!xWon && !oWon && !empty){
            System.out.println("Draw");
        }
        else if (xWon) {
            System.out.println("X won");
        } else if (oWon) {
            System.out.println("O won");
      */
        }

    }

    public static void robotVSUser(String[][] matrix) {
        boolean isChanged = false;
        boolean xTurn = true;
        boolean won = false;
        boolean xWon = false;
        boolean oWon = false;
        boolean empty = false;
        boolean draw = false;
        int count = 0;
        Random random = new Random();
        do {
            try {
                if (xTurn) {
                    count++;
                    Scanner sc = new Scanner(System.in);
                    System.out.print("Enter the coordinates: ");

                    int xCoordinate = sc.nextInt();
                    int yCoordinate = sc.nextInt();
                    //sc.close();
                    if (xCoordinate >= 1 && xCoordinate <= 3 && yCoordinate >= 1 && yCoordinate <= 3) {

                        if (matrix[Math.abs(3 - yCoordinate)][Math.abs(xCoordinate - 1)].equals(" ")) {
                            matrix[Math.abs(3 - yCoordinate)][Math.abs(xCoordinate - 1)] = "X";
                            buildBoard(matrix);
                            xTurn = false;
                            xWon = victory(matrix, "X");
                            //  oWon = victory(matrix, "O");
                            if (xWon) {
                                won = true;
                                break;
                            }
                            continue;
                            //  break;
                        } else {
                            System.out.println("This cell is occupied! Choose another one!");
                            isChanged = false;
                        }
                    } else {
                        System.out.println("Coordinates should be from 1 to 3!");
                        continue;
                    }
                    xWon = victory(matrix, "X");
                    //  oWon = victory(matrix, "O");
                    if (xWon) {
                        won = true;
                        break;
                    }
                }
                if (!xTurn) {
                    count++;
                    boolean isEmpty = false;
                    System.out.println("Making move level \"easy\"");
                    int easyXCoordinate = random.nextInt(3);//2
                    int easyYCoordinate = random.nextInt(3);//2
                    while (!isEmpty) {
                        if (!matrix[easyXCoordinate][easyYCoordinate].equals(" ")) {
                            easyXCoordinate = random.nextInt(3);
                            easyYCoordinate = random.nextInt(3);
                            //matrix[easyXCoordinate][easyYCoordinate] = "O";
                            // buildBoard(matrix);
                            // xTurn = true;
                        }
                        if (matrix[easyXCoordinate][easyYCoordinate].equals(" ")) {
                            isEmpty = true;
                            //  easyXCoordinate = random.nextInt(3);
                            // easyYCoordinate = random.nextInt(3);
                            // matrix[easyXCoordinate][easyYCoordinate] = "O";
                            // buildBoard(matrix);
                            // xTurn = true;
                        }
                    }
                    matrix[easyXCoordinate][easyYCoordinate] = "O";
                    buildBoard(matrix);
                    xTurn = true;
                    // xWon = victory(matrix, "X");
                    oWon = victory(matrix, "O");
                    if (oWon) {
                        won = true;
                        break;
                    }
                }
                //  xWon = victory(matrix, "X");
                //     oWon = victory(matrix, "O");
                //   if (xWon || oWon) {
                //       won = true;
                //   }
                if (count == 9) {
                    draw = true;
                    won = true;
                }
                //}
                // }


                //   if (isChanged) {
                //     buildBoard(matrix);
                //   } //else {
                //  System.out.println("This cell is occupied! Choose another one!");
                // }


            } catch (InputMismatchException e) {
                System.out.println("You should enter numbers!");
                //break;
            }
        } while (!won);


        if (xWon) {
            System.out.println("X wins");
        } else if (oWon) {
            System.out.println("O wins");
        } else if (draw) {
            System.out.println("Draw");

      /*  if (!xWon && !oWon && !empty){
            System.out.println("Draw");
        }
        else if (xWon) {
            System.out.println("X won");
        } else if (oWon) {
            System.out.println("O won");
      */
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