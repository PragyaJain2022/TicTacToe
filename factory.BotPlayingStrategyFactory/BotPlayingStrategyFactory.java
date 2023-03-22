public class BotPlayingStrategyFactory {
    public BotPlayingStrategy createBotPlayingStrategyForDifficultyLevel(BotDifficultyLevel difficultyLevel){
        return switch(difficultyLevel){
            case EASY,MEDIUM,HARD -> new RandomBotPlayingStrategy();
        };
    }
}
