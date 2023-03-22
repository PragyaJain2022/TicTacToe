public abstract class Player {
    private Symbol symbol;
    private PlayerType playerType;
    private String name;

    Player(PlayerType type,Symbol symbol){
        this.playerType=type;
        this.symbol=symbol;
    }
    public Symbol getSymbol(){
        return symbol;
    }
    public PlayerType getPlayerType(){
        return playerType;
    }
    public abstract Move makeMove(Board board);
}
