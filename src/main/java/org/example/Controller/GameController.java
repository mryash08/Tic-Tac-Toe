package org.example.Controller;

import org.example.Builder.GameBuilder;
import org.example.Enum.GameState;
import org.example.Models.Game;
import org.example.Models.Player;
import org.example.Strategy.WinningStartegy.PlayerWinning;

import java.util.List;

public class GameController {

    public Game startGame(int boardDimension, List<Player> playerList, List<PlayerWinning> winningStrategy) throws Exception {
        Game game = Game.getGameBuilder(boardDimension,playerList,winningStrategy).build();
        return game;
    }

    public GameState getGame(Game game){
        return game.getGameState();
    }

    public void makeMove(Game game){
         game.makeMove(game.getBoard());
    }

    public void displayBoard(Game game){
          game.printBoard();
    }

        public Player checkWinner(Game game){
           return game.getWinner();
        }
        public void undo(Game game){
              game.undo();
        }
}
