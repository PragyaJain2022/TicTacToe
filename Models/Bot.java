public class Bot extends Player{
    private BotPlayingStrategy botPlayingStrategy;
    private BotDifficultyLevel botDiffilcultyLevel;

    public Bot(Symbol symbol, BotDifficultyLevel botDifficultyLevel){
        super(PlayerType.BOT,symbol);
        this.botDiffilcultyLevel=botDiffilcultyLevel;
        this.botPlayingStrategy= new BotPlayingStrategyFactory().createBotPlayingStrategyForDifficultyLevel(botDifficultyLevel);

    }

    @Override
    public Move makeMove(Board board){
        return this.botPlayingStrategy.makeNextMove(board,this);
    }
}
