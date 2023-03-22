import java.util.List;
public class RandomBotPlayingStrategy implements BotPlayingStrategy{
    int count=0,countcol=0;
    @Override
    public Move makeNextMove(Board board,Player player){
         count=0;

        for(List<Cell> row:board.getBoard()){
            count++;
            countcol=0;
            for(Cell cell:row){
                countcol++;
                if(cell.isEmpty()){

                    Move move=new Move();
                    move.setSymbol(player.getSymbol());
                    move.setPlayer(player);
                    move.setCell(cell);
                    move.setRow(count-1);
                    move.setCol(countcol-1);

                    return move;
                }
            }
        }
        return null;
    }
}
