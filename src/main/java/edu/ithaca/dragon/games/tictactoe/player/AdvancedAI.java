package edu.ithaca.dragon.games.tictactoe.player;

import org.javatuples.Pair;

import edu.ithaca.dragon.games.tictactoe.board.TicTacToeBoard;


public class AdvancedAI implements TicTacToePlayer{
    private int[][] preferredMoves = {
        {1, 1}, {0, 0}, {0, 2}, {2, 0}, {2, 2},
        {0, 1}, {1, 0}, {1, 2}, {2, 1}};
    
    @Override
    public Pair<Integer, Integer> chooseSquare(TicTacToeBoard curBoard, char yourSymbol) {
        Pair<Integer,Integer> wMHorz = winningMoveHorz(curBoard);
        Pair<Integer,Integer> bHorz = blockingMoveHorz(curBoard);
        Pair<Integer,Integer> check = new Pair<>(-1,-1);
        
        
        if(!wMHorz.equals(check)){
            return wMHorz;
        }
        else if(!bHorz.equals(check)){
           return bHorz;
        }
        
        
        for(int x = 0; x< 8; x++){
           
            for(int y = 0; y < 1; y++){
                if(curBoard.isSquareOpen(new Pair<>(preferredMoves[x][y], preferredMoves[x][y+1]))){
                    return new Pair<>(preferredMoves[x][y], preferredMoves[x][y+1]);
                }
            }
        }
        
       
        
       
        throw new IllegalArgumentException("Board with no moves given to player:\n" + curBoard.displayString());
    }
        private Pair<Integer, Integer> winningMoveHorz(TicTacToeBoard curBoard){
    
        char[][] boardChars = curBoard.getSquare();
        //rows
        for(int i = 0; i < boardChars.length; i++){
            int emptyI = -1;
            int emptyJ = -1;
            int count = 0;
            for(int j = 0; j < boardChars.length; j++){
                //System.out.println("Loc(" + i +"," + j + ")" + boardChars[i][j]);
                
                if(curBoard.isSquareOpen(new Pair<>(j, i))){
                    emptyI = j;
                    emptyJ = i;
                }
                if(boardChars[j][i] == 'O'){
                    count++;
                }
               
                if(count == 2){
                    System.out.println("Winner");
                    return new Pair<>(emptyI,emptyJ);
                }
                //System.out.println("row: " + i + " count:"  + count);    
            }
    }
    return new Pair<>(-1,-1);
        }

        private Pair<Integer, Integer> blockingMoveHorz(TicTacToeBoard curBoard){
    
            char[][] boardChars = curBoard.getSquare();
            //rows
            for(int i = 0; i < boardChars.length; i++){
                int emptyI = -1;
                int emptyJ = -1;
                int count = 0;
                for(int j = 0; j < boardChars.length; j++){
                    //System.out.println("Loc(" + i +"," + j + ")" + boardChars[i][j]);
                    
                    if(curBoard.isSquareOpen(new Pair<>(j, i))){
                        emptyI = j;
                        emptyJ = i;
                    }
                    if(boardChars[j][i] == 'X'){
                        count++;
                    }
                    if(count == 2){
                        System.out.println("Blocked");
                        return new Pair<>(emptyI,emptyJ);
                    }
                      
                }
        }
        return new Pair<>(-1,-1);
            }
}