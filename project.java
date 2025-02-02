package project1;

import java.util.Scanner;
public class Project1 {

    public static void main(String args[]){
        
 char board[][]={{'*','*','*'},{'*','*','*'},{'*','*','*'}};
         char[]players={'X','O'};

         Scanner input= new Scanner(System.in);
          
         for(int i=0; i<players.length; i++){
             System.out.println((i+1)+".Player:"+ players[i]);
         }
       
        int currentPlayer=0;
        int move;
        
        while(true){
            displayBoard(board);
            while(true){
                System.out.println((currentPlayer+1)+".Players turn:");
                move=input.nextInt();
                if(move>=1 && move<=9 && isMoveValid(move,board)){
                    break;    
                    
                  } else {
                    System.out.println("Invalid move,try again");
                }          
                }
            
            makeMove(move, board, players[currentPlayer]);
            if (isWin(board)) {
                displayBoard(board);
                System.out.println((currentPlayer + 1) + ". Player win!");
                break;
                
            }if (isBoardFull(board)) {
                displayBoard(board);
                System.out.println("Draw!");
                break;
                
            }

            currentPlayer = (currentPlayer + 1) % players.length;
        }
            
          input.close();
          
            
            //if(j<board[i].length-1)System.out.println("|");
     }
        //Oyun Tahtasını göster
       public static void displayBoard(char[][]board){
            System.out.println();
            for(int i=0; i<board.length;i++){
                for(int j=0; j<board[i].length;j++){
                    System.out.print("|"); 
                    System.out.print(board[i][j]);
                     
                }
                System.out.print("|");
                System.out.println();
                if(i<board[i].length-1) System.out.println("-------");
            }
            System.out.println();
            
        }
        //Hamle geçerli mi değil mi?
        public static boolean isMoveValid(int move,char[][]board){
            int[]position=convertMoveToPosition(move);
            return board[position[0]][position[1]]=='*';
        }
       //Hamleyi çalıştır
         public static void makeMove(int move,char[][]board,char player) {
                 int[]position=convertMoveToPosition(move);
                 board[position[0]][position[1]]=player;
              }
         //Hamleyi sütun ve satır pozisyonuna çevir
        public static int[]convertMoveToPosition(int move){
            int row=(move-1)/3;
            int col=(move-1)%3;
            return new int[]{row,col};

        //Kazanma durumunu kontrol et 
        }public static boolean isWin(char[][]board) {
        for (int i = 0; i < 3; i++) {
            // Row and column control
        if (board[i][0] != '*' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
                
            }
        if (board[0][i] != '*' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return true;
            }
        }
        // Crossed control
        if (board[0][0] != '*' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }
        if (board[0][2] != '*' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }
        return false;
    }
        //Tahta dolu mu ?
        public static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '*') {
                    return false;
                }
            }
        }
        return true;
    }
}

                   