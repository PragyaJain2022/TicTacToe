import java.util.List;

public class GameController {
 public Game createGame(int dimensionOfBoard,
                        List<Player> players,
                        List<GameWinningStrategy> strategies){
     Game game=null;

     try{
         game=Game.create()
                 .setDimension(dimensionOfBoard)
                 .addPlayers(players)
                 .addGameWinningStrategies(strategies)
                 .build();

         }
     catch(Exception exception){
         System.out.println("We did something wrong");
         exception.printStackTrace();
     }
     return game;
 }
 public void makeMove(Game game){
     game.makeMove();
 }
 public boolean undo(Game game) throws EmptyMovesUndoOperationException{
     return game.undo();
 }
 public Player getWinner(Game game){
     return game.getWinner();
 }
 public GameStatus getGameStatus(Game game){
     return game.getGameStatus();
 }
 public void display(Game game){
     game.getBoard().printBoard();
 }
}
