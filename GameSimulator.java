import java.util.List;
public class GameSimulator {
    private static Symbol symbol;
     public static void main(String[] args){
         int dimension=3;
         Player p1=new HumanPlayer(new Symbol('X'));
         Player p2=new Bot(new Symbol('O'),BotDifficultyLevel.EASY);
         GameWinningStrategy strategy=new OrderOneWinningGameStrategy();
         GameController gameController=new GameController();

         Game game=gameController.createGame(dimension,List.of(p1,p2),List.of(strategy));

         while(gameController.getGameStatus(game).equals(GameStatus.IN_PROGRESS)){
             System.out.println("Please Make next Move. this is current status");
             gameController.display(game);
             gameController.makeMove(game);
         }

         if(gameController.getGameStatus(game).equals(GameStatus.ENDED)){
             System.out.println("Winner "+gameController.getWinner(game).getPlayerType() );
             gameController.display(game);
         }
         if(gameController.getGameStatus(game).equals(GameStatus.DRAW)){
             System.out.println("UH OH.Tru again. No one Won");
             gameController.display(game);
         }
     }
}
