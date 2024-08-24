package org.example.Strategy.WinningStartegy;

import org.example.Models.Board;
import org.example.Models.Move;
import org.example.Models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class rowWinningStartegy implements PlayerWinning{

    private Map<Integer , Map<Symbol,Integer>> rowMaps = new HashMap<>();
    @Override
    public boolean checkWinner(Move move, Board board) {
        int row  = move.getCell().getRow();
        Symbol symbol = move.getPlayer().getSymbol();

        if(!rowMaps.containsKey(row)) {
            rowMaps.put(row,new HashMap<>());
        }
        Map<Symbol,Integer> currRowMap = rowMaps.get(row);
            currRowMap.put(symbol,currRowMap.getOrDefault(row,0)+1);

        return currRowMap.get(symbol) == board.getSize();
    }
}
