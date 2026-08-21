import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {

        char[][] grid = new char[3][3];

        for(int row = 0 ; row < grid.length ; row++){
            for(int col = 0 ; col < grid[row].length ; col++){
                grid[row][col] = '-' ;
                System.out.print(grid[row][col] + " ");
            }
            System.out.println();
        }

        char player = 'X';

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 9 ; i++){
            System.out.println("dor " + player);
            int[] chosencell = Askbox(scanner);
            int chosenrow = chosencell[0];
            int chosencol = chosencell[1];
            while(grid[chosenrow][chosencol] != '-') {
                System.out.println("the block is already taken. Try again");
                chosencell = Askbox(scanner);
                chosenrow = chosencell[0];
                chosencol = chosencell[1];
            }
            grid[chosenrow][chosencol] = player;
            printGrid(grid);
            if (checkdiagonals(grid)|| checkrows(grid) || checkcols(grid)){
                System.out.println( player + " won!");
                break;
            }

            if(player == 'O'){
                player = 'X';
            }else{
                player = 'O';
            }

        }

        if (!(checkdiagonals(grid)|| checkrows(grid) || checkcols(grid))){
            System.out.println("It's a draw!");

        }

        printGrid(grid);

    }

    public static void printGrid(char[][] grid) {
        for(int row = 0 ; row < grid.length ; row++){
            for(int col = 0 ; col < grid[row].length ; col++){
                System.out.print(grid[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static int [] Askbox(Scanner scanner) {
        int[] chosencell = {0,0};
        System.out.print("enter row: ");
        try {
            chosencell[0] = scanner.nextInt() - 1;
        } catch (InputMismatchException e){
            System.out.println("you cant do that sir!");
        }

        System.out.print("enter column: ");

        try {
            chosencell[1] = scanner.nextInt() - 1;
        } catch (InputMismatchException e){
            System.out.println("you cant do that!");
        }
        return chosencell;
    }

    public static boolean checkrows(char[][] grid){
        for (int row = 0 ; row < 3; row++){
            if (checkrow(grid, row)){
                return true;
            }
        }
        return false;
    }

    public static boolean checkrow(char[][] grid , int row){
        return grid[row][0] != '-' && grid[row][0] == grid[row][1] && grid[row][1] == grid[row][2];
    }

    public static boolean checkcols(char[][] grid){
        for (int col = 0 ; col < 3; col++){
            if (checkcol(grid, col)){
                return true;
            }
        }
        return false;
    }
    public static boolean checkcol(char[][] grid , int col){
        return grid[0][col] != '-' && grid[0][col] == grid[1][col] && grid[1][col] == grid[2][col];
    }

    public static boolean checkdiagonals(char[][] grid){
        return (grid[0][0] != '-' && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) ||
                (grid [0][2] != '-' && grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]);
    }
}