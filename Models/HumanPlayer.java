import java.util.Scanner;

public class HumanPlayer  extends Player {
    public HumanPlayer(Symbol symbol) {

        super(PlayerType.HUMAN, symbol);
    }

    @Override
    public Move makeMove(Board board) {
        Scanner myobj = new Scanner(System.in);
        System.out.println("Tell Row Number Starting from 1");
        int row = myobj.nextInt();


        System.out.println("Tell column number where you want to make move from 1");
        int col = myobj.nextInt();


        Move move = new Move();
        move.setCell(board.getCell(row - 1, col - 1));
        move.setRow(row-1);
        move.setCol(col-1);
        move.setPlayer(this);
        move.setSymbol(this.getSymbol());
        //FillRowCol(row,col);
        return move;
    }

}

