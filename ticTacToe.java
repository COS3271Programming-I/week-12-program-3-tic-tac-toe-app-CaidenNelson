import java.util.Scanner;

class TTT {
    private int turnNumber = 1; // Initialize turn counter
    static Scanner userinput = new Scanner(System.in);
    char[][] board = {{'.', '.', '.'}, {'.', '.', '.'}, {'.', '.', '.'}};
    int turn = 1;
    char player = 'X';

    public void printBoard() {
        int i, j;
        System.out.println("");
        for (i = 0; i <= 2; i++) {
            for (j = 0; j <= 2; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public void move(int i, int j) {
        board[i][j] = player;
        turn++;
    }

    public void unDoMove(int i, int j) {
        board[i][j] = '.';
        turn--;
    }

    public void switchPlayers() {
        if (player == 'X') {
            player = 'O';
        } else player = 'X';
    }

    public boolean isLegal(int i, int j) {
        if (board[i][j] == '.') return true;
        else return false;
    }

    public boolean winner() {
        int i;
        boolean test = false;
        for (i = 0; i <= 2; i++) {
            if ((board[i][0] == board[i][1]) && (board[i][1] == board[i][2]) &&
                    (board[i][0] != '.')) {
                test = true;
            }
            if ((board[0][i] == board[1][i]) && (board[1][i] == board[2][i]) &&
                    (board[0][i] != '.')) {
                test = true;
            }
        }
        if ((board[0][0] == board[1][1]) && (board[1][1] == board[2][2]) &&
                (board[0][0] != '.')) {
            test = true;
        }

        if ((board[2][0] == board[1][1]) && (board[1][1] == board[0][2]) &&
                (board[2][0] != '.')) {
            test = true;
        }
        return test;
    }

    public void human() {
        int i, j;

        boolean test = false;  //have I found a place to go
        while (test == false) {
            System.out.println("\nEnter Coordinates Where To Go Separated By A Space...");
            i = userinput.nextInt();
            j = userinput.nextInt();
            userinput.nextLine();
            if (isLegal(i - 1, j - 1) == true) {
                test = true;
                move(i - 1, j - 1);
            }
        }
    }

    public void ai() {
        int i, j;
        //random
        boolean test = false;  //have I found a place to go
        while (test == false) {

            if ((board[0][0] == board[0][1]) && board[0][0] == 'X') {
                if (isLegal(0, 2) == true) {
                    test = true;
                    move(0, 2);
                }
            }
            // stops 1 3
            if ((board[1][2] == board[2][2]) && board[2][2] == 'X') {
                if (isLegal(0, 2) == true) {
                    test = true;
                    move(0, 2);
                }
            }
            // stops 1 3

            if ((board[1][1] == board[2][0]) && board[1][1] == 'X') {
                if (isLegal(0, 2) == true) {
                    test = true;
                    move(0, 2);
                }
            }
            //stops 1 3


            if ((board[0][0] == board [1][0]) && board[0][0] == 'X'){
                if(isLegal(2, 0)){
                    test = true;
                    move(2,0);
                }
            }
            // stops 3 1

            if ((board[2][2] == board [2][1]) && board[2][2]  == 'X'){
                if(isLegal(2, 0)){
                    test = true;
                    move(2,0);
                }
            }
            // stops 3 1

            if((board[1][1] == board[0][2] && board[0][2]  == 'X')){
                if(isLegal(2, 0)){
                    test = true;
                    move(2,0);
                }

            }
            //stops 3 1

            if((board[2][0] == board[1][0]) && board[2][0]  == 'X'){
                if(isLegal(0, 0)){
                    test = true;
                    move(0,0);
                }
            }
            // stop 1 1

            if((board[0][1] == board[0][2]) && board[0][1]  == 'X'){
                if(isLegal(0, 0)){
                    test = true;
                    move(0,0);
                }
            }
            // stops 1 1

            if((board[1][1] == board[2][2]) && board[1][1]  == 'X'){
                if(isLegal(0, 0)){
                    test = true;
                    move(0,0);
                }
            }
            //stops 1 1

            if ((board[2][0] == board[2][1]) && board[2][1]  == 'X') {
                if (isLegal(2, 2) == true) {
                    test = true;
                    move(2, 2);
                }
            }

            //Stops 3 3
            if ((board[0][2] == board[1][2]) && board[1][2]  == 'X') {
                if (isLegal(2, 2) == true) {
                    test = true;
                    move(2, 2);
                }
            }
            //Stops 3 3

            if ((board[1][1] == board[0][0]) && board[1][1]  == 'X') {
                if (isLegal(2, 2) == true) {
                    test = true;
                    move(2, 2);
                }
            }
            //Stops 3 3

            if ((board[1][1] == board[1][2]) && board[1][1]  == 'X') {
                if (isLegal(1, 0) == true) {
                    test = true;
                    move(1, 0);
                }
            }
            // Stops 2 1
            if ((board[0][0] == board[2][0]) && board[0][0]  == 'X') {
                if (isLegal(1, 0) == true) {
                    test = true;
                    move(1, 0);
                }
            }
            // Stops 2 1

            if ((board[1][1] == board[2][1]) && board[2][1]  == 'X') {
                if (isLegal(0, 1) == true) {
                    test = true;
                    move(0, 1);
                }
            }
            //Stops 1 2

            if ((board[0][0] == board[0][2]) && board[0][0]  == 'X') {
                if (isLegal(0, 1) == true) {
                    test = true;
                    move(0, 1);
                }
            }
            //Stops 1 2

            if ((board[1][0] == board[1][1]) && board[1][1]  == 'X') {
                if (isLegal(1, 2) == true) {
                    test = true;
                    move(1, 2);
                }
            }
            //Stops 2 3
            if ((board[0][2] == board[2][2]) && board[2][2]  == 'X') {
                if (isLegal(1, 2) == true) {
                    test = true;
                    move(1, 2);
                }
            }
            //Stops 2 3

            if ((board[1][1] == board[0][1]) && board[0][1]  == 'X') {
                if (isLegal(2, 1) == true) {
                    test = true;
                    move(2, 1);
                }
            }
            //Stops 3 2

            if ((board[2][0] == board[2][2]) && board[2][1]  == 'X') {
                if (isLegal(2, 1) == true) {
                    test = true;
                    move(2, 1);
                }
            }
            //Stops 3 2

            if ((board[0][1] == board[2][1]) && board[2][1]  == 'X') {
                if (isLegal(1, 1) == true) {
                    test = true;
                    move(1, 1);
                }
            }
            //stops 2 2

            if ((board[0][0] == board[2][2]) && board[2][2]  == 'X') {
                if (isLegal(1, 1) == true) {
                    test = true;
                    move(1, 1);
                }
            }
            //stops 2 2
            if ((board[0][2] == board[2][0]) && board[2][0]  == 'X') {
                if (isLegal(1, 1) == true) {
                    test = true;
                    move(1, 1);
                }
            }
            //stops 2 2
            if ((board[1][0] == board[1][2]) && board[1][2]  == 'X') {
                if (isLegal(1, 1) == true) {
                    test = true;
                    move(1, 1);
                }
            }
            //stops 2 2
            if(isLegal(1,1) == true){
                test = true;
                move(1, 1);
            }

            if(test !=true) {
                i = (int) (Math.random() * 3.0);
                j = (int) (Math.random() * 3.0);
                if (isLegal(i, j) == true) {
                    test = true;
                    move(i, j);
                }
            }

        }

            System.out.println("AI is moving ... ");
//            turnNumber++;

        }
    }

    public class ticTacToe {
        static Scanner userinput = new Scanner(System.in);

        public static void main(String[] args) {

            TTT game = new TTT();
            game.printBoard();
            for (int i = 1; i <= 5; i++) {
                game.human();
                game.printBoard();
                if ((game.winner() == true) || (i == 5)) {
                    break;
                }
                game.switchPlayers();
                game.ai();
                game.printBoard();
                if ((game.winner() == true) || (i == 5)) {
                    break;
                }
                game.switchPlayers();
            }

            if (game.winner() == true) {
                System.out.println("\nThe winner is " + game.player);
            } else {
                System.out.println("\nCat Game.");
            }
        } //end main line
    } //end class
