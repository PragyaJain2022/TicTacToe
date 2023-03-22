import java.util.*;
import java.util.ArrayList;

import static java.util.Collections.unmodifiableList;

public class Game {
    private List<Player> players;
    private Board board;
    private List<Move> moves;
    private List<GameWinningStrategy> gameWinningStrategies;
    private int lastMovedPlayerIndex;
    private GameStatus gameStatus;
    private Player winner;

    public List<Player> getPlayers(){
        return players;
    }

    public Board getBoard() {
        return board;
    }
    public List<Move> getMoves(){
        return moves;
    }

    public List<GameWinningStrategy> getGameWinningStrategies() {
        return gameWinningStrategies;
    }
    public int gameLastMovedPlayerIndex(){
        return lastMovedPlayerIndex;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public Player getWinner() {
        return winner;
    }

    private Game() {
        this.players = new ArrayList<>();
        this.moves = new ArrayList<>();
        this.gameWinningStrategies = new ArrayList<>();
        this.lastMovedPlayerIndex = -1;
        this.gameStatus = GameStatus.IN_PROGRESS;
    }

    public void makeMove(){
        this.lastMovedPlayerIndex += 1;
        this.lastMovedPlayerIndex %= this.players.size();

        Move move= this.players.get(this.lastMovedPlayerIndex)
                .makeMove(this.board);

        this.moves.add(move);
        move.getCell().setSymbol(move.getSymbol());

        //System.out.println("cell"+ board.getCell(row-1,col-1).getRow());

        for(GameWinningStrategy strategy : gameWinningStrategies){
            if(strategy.checkIfWon(this.board,this.players.get(lastMovedPlayerIndex),move.getRow(),move.getCol(),move.getCell())){
                gameStatus=GameStatus.ENDED;
                winner=this.players.get(lastMovedPlayerIndex);
                //System.out.println("winner"+ winner.getPlayerType());
                return;
            }
        }

        if(moves.size() == this.board.getDimension() * this.board.getDimension()){
            gameStatus = GameStatus.DRAW;
            return;
        }
    }

    public static Builder create(){

        return new Builder();
    }
    public boolean undo() throws EmptyMovesUndoOperationException{
        if(this.moves.size() == 0)
             throw new EmptyMovesUndoOperationException();

    Move lastMove=this.moves.get(this.moves.size() -1);
    Cell relevantCell=lastMove.getCell();
    relevantCell.clearCell();
    this.lastMovedPlayerIndex -= 1;
    this.lastMovedPlayerIndex = (this.lastMovedPlayerIndex + this.players.size()) % this.players.size();
    this.moves.remove(lastMove);
    return true;

}

public static class Builder{
    private List<Player> players;
    private List<GameWinningStrategy> gameWinningStrategies;
    private int dimension;

    Builder(){
        this.players=new ArrayList<>();
        this.gameWinningStrategies= new ArrayList<>();
    }

    public Builder addPlayer(Player player){
        this.players.add(player);
        return this;
    }
    public Builder addPlayers(List<Player> players){
        this.players.addAll(players);
        return this;
    }
    public Builder setDimension(int dimension){
        this.dimension=dimension;
        return this;
    }
    public Builder addGameWinningStrategy(GameWinningStrategy strategy){
        this.gameWinningStrategies.add(strategy);
        return this;
    }
    public Builder addGameWinningStrategies(List<GameWinningStrategy> strategies){
        this.gameWinningStrategies.addAll(strategies);
        return this;
    }
    private boolean checkIfSingleBotMax(){
        int count=0;
        for(Player player:players){
            if(player.getPlayerType().equals(PlayerType.BOT))
                count+=1;
        }

    return count<=1;
}
public Game build() throws MultipleBotsException{
    if(!checkIfSingleBotMax()){
        throw new MultipleBotsException();
    }
    Game game=new Game();
    game.players.addAll(this.players);
    game.gameWinningStrategies.addAll(this.gameWinningStrategies);
    game.board=new Board(dimension);
    return game;
}
}
}