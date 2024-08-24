package org.example.Strategy.WinningStartegy;

import org.example.Models.Board;
import org.example.Models.Move;
import org.example.Models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class diagonalWinningStartegy implements PlayerWinning{

    private Map<Symbol,Integer> left = new HashMap<>();
    private Map<Symbol,Integer> right = new HashMap<>();
    @Override
    public boolean checkWinner(Move move, Board board) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();
        if(row == col){
            left.put(symbol,left.getOrDefault(symbol,0)+1);
        }
        if(row + col == board.getSize()-1){
            right.put(symbol,right.getOrDefault(symbol,0)+1);
        }
        return ((row == col && left.get(symbol) == board.getSize()) || (row + col == board.getSize()-1 && right.get(symbol) == board.getSize()));
    }
}
