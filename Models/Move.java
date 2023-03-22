public class Move {
    private Symbol symbol;
    private Cell cell;
    private Player player;

    private int row;
    private int col;



    public Cell getCell(){
        return cell;
    }
    public Symbol getSymbol()
    {
        return symbol;
    }
    public int getRow(){return this.row;}
    public int getCol(){return this.col;}
    public void setSymbol(Symbol symbol){
        this.symbol=symbol;
    }
    public void setCell(Cell cell){
        this.cell=cell;
    }
    public Player getPlayer(){
        return player;
    }
    public void setPlayer(Player player){
        this.player=player;
    }
    public void setRow(int row){
        this.row=row;
       // System.out.println("rowadded"+row);

    }
    public void setCol(int col){
        this.col=col;
        //System.out.println("coladded"+col);
    }


}
