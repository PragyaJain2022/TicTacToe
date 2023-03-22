public interface GameWinningStrategy {
    boolean checkIfWon(Board board,Player player,int row,int col,Cell moveCell);
}
