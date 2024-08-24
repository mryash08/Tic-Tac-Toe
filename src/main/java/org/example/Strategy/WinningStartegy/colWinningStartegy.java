package org.example.Strategy.WinningStartegy;

import org.example.Models.Board;
import org.example.Models.Move;
import org.example.Models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class colWinningStartegy implements PlayerWinning{
    private Map<Integer , Map<Symbol,Integer>> colMaps = new HashMap<>();
    @Override
    public boolean checkWinner(Move move, Board board) {
        int col  = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();

        if(!colMaps.containsKey(col)) {
            colMaps.put(col,new HashMap<>());
        }
        Map<Symbol,Integer> currcolMap = colMaps.get(col);
        currcolMap.put(symbol,currcolMap.getOrDefault(col,0)+1);

        return currcolMap.get(symbol) == board.getSize();
    }
}
