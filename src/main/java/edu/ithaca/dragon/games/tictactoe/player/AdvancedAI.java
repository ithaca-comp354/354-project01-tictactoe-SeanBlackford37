package edu.ithaca.dragon.games.tictactoe.player;

import org.javatuples.Pair;

import edu.ithaca.dragon.games.tictactoe.board.TicTacToeBoard;


public class AdvancedAI implements TicTacToePlayer{
    private int[][] preferredMoves = {
        {1, 1}, {0, 0}, {0, 2}, {2, 0}, {2, 2},
        {0, 1}, {1, 0}, {1, 2}, {2, 1}};
    
    @Override
    public Pair<Integer, Integer> chooseSquare(TicTacToeBoard curBoard, char yourSymbol) {
        
        for(int x = 0; x< 8; x++){
            for(int y = 0; y < 1; y++){
                if(curBoard.isSquareOpen(new Pair<>(preferredMoves[x][y], preferredMoves[x][y+1]))){
                    return new Pair<>(preferredMoves[x][y], preferredMoves[x][y+1]);
                }
                
            }
        }
        throw new IllegalArgumentException("Board with no moves given to player:\n" + curBoard.displayString());
    }

    }
