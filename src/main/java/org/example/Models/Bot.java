package org.example.Models;

import org.example.Enum.BotDifficultyLevel;
import org.example.Enum.PlayerType;
import org.example.Strategy.PlayingStartegy.BotPlaying;

public class Bot extends Player{

    private BotDifficultyLevel botDifficultyLevel;
    private BotPlaying botPlayingStrategy;
    public Bot(String name, Symbol symbol, PlayerType playerType, Long id,BotDifficultyLevel botDifficultyLevel,BotPlaying botPlayingStrategy) {
        super(name, symbol, playerType, id);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = botPlayingStrategy;
    }


    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    public BotPlaying getBotPlayingStrategy() {
        return botPlayingStrategy;
    }

    public void setBotPlayingStrategy(BotPlaying botPlayingStrategy) {
        this.botPlayingStrategy = botPlayingStrategy;
    }

    @Override
    public Move makeMove(Board board) {

        Move move = botPlayingStrategy.makeMove(board);
        move.setPlayer(this);
        return move;
    }
}
