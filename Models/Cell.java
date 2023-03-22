public class Cell {
    private int row;
    private int col;
    private Symbol symbol;

    public boolean isEmpty()
    {
        return (symbol==null);
    }
    public int getRow(){return this.row;}
    public int getColumn(){return this.col;}
    public Symbol getSymbol(){return symbol;}
    public void setSymbol(Symbol symbol){
        this.symbol=symbol;
    }
    public void clearCell(){
        this.symbol=null;
    }


}

