package org.example.Strategy.WinningStartegy;

import org.example.Models.Board;
import org.example.Models.Move;

public interface PlayerWinning {

    boolean checkWinner(Move move , Board board);
}
