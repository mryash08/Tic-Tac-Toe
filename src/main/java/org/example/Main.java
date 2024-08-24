package org.example;

import org.example.Controller.GameController;
import org.example.Enum.BotDifficultyLevel;
import org.example.Enum.GameState;
import org.example.Enum.PlayerType;
import org.example.Models.Bot;
import org.example.Models.Game;
import org.example.Models.Player;
import org.example.Models.Symbol;
import org.example.Strategy.PlayingStartegy.EasyBotPlaying;
import org.example.Strategy.WinningStartegy.PlayerWinning;
import org.example.Strategy.WinningStartegy.colWinningStartegy;
import org.example.Strategy.WinningStartegy.diagonalWinningStartegy;
import org.example.Strategy.WinningStartegy.rowWinningStartegy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws Exception {
        GameController gameController = new GameController();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Dimension");
        int dimension = scanner.nextInt();

        int numberOfPLayers = dimension-1;
        List<Player> players = new ArrayList<>();

        players.add(new Player("jan",new Symbol('X'), PlayerType.HUMAN,1L));
        players.add(new Bot("Bot",new Symbol('O'), PlayerType.BOT,2L, BotDifficultyLevel.EASY,new EasyBotPlaying()));

        List<PlayerWinning> winningsrategy = new ArrayList<>();
        winningsrategy.add(new colWinningStartegy());
        winningsrategy.add(new diagonalWinningStartegy());
        winningsrategy.add(new rowWinningStartegy());

        Game game = gameController.startGame(dimension,players,winningsrategy);
        while (gameController.getGame(game).equals(GameState.IN_PROGRESS)){
            System.out.println("Current State Board");
            gameController.displayBoard(game);
            gameController.makeMove(game);
        }
        if(gameController.getGame(game).equals(GameState.DRAW)){
            System.out.println("Game has Drawn");
        }else{
            System.out.println("Winner is " + gameController.checkWinner(game).getName());
        }
     }
    }
