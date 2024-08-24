package org.example.Builder;

import org.example.Enum.GameState;
import org.example.Models.Board;
import org.example.Models.Game;
import org.example.Models.Move;
import org.example.Models.Player;
import org.example.Strategy.WinningStartegy.PlayerWinning;

import java.util.ArrayList;
import java.util.List;

public class GameBuilder {

    private Board board;
    private List<Player> players;

    private GameState gameState;
    private Player Winner;
    private int nextMovePlayer;
    private List<Move> moves;

    private List<PlayerWinning> winningsStrategies;

    public Board getBoard() {
        return board;
    }

    public GameBuilder setBoard(Board board) {
        this.board = board;
        return this;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public GameBuilder setPlayers(List<Player> players) {
        this.players = players;
        return this;
    }

    public GameState getGameState() {
        return gameState;
    }

    public GameBuilder setGameState(GameState gameState) {
        this.gameState = gameState;
        return this;
    }

    public Player getWinner() {
        return Winner;
    }

    public GameBuilder setWinner(Player winner) {
        Winner = winner;
        return this;
    }

    public int getNextMovePlayer() {
        return nextMovePlayer;
    }

    public GameBuilder setNextMovePlayer(int nextMovePlayer) {
        this.nextMovePlayer = nextMovePlayer;
        return this;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public GameBuilder setMoves(List<Move> moves) {
        this.moves = moves;
        return this;
    }

    public List<PlayerWinning> getWinningsStrategies() {
        return winningsStrategies;
    }

    public GameBuilder setWinningsStrategies(List<PlayerWinning> winningsStrategies) {
        this.winningsStrategies = winningsStrategies;
       return this;
    }
   public GameBuilder(int dimension , List<Player> players, List<PlayerWinning> winningsStrategies){
        this.board = new Board(dimension);
        this.gameState = GameState.IN_PROGRESS;
        this.nextMovePlayer = 0;
        this.moves = new ArrayList<>();
        this.winningsStrategies = winningsStrategies;
        this.players = players;
    }

    public Game build() throws Exception {
         if(!Validation()){
             throw new Exception("Validation Failed");
         }
         return new Game(this);
    }

    public boolean Validation(){

        return true;
    }
}
