package solutions.vdesign.util;

public class StrategyContext {
    private IStrategy strategy = null;

    public StrategyContext(IStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(IStrategy strategy) {
        this.strategy = strategy;
    }

    public void execute() {
        this.strategy.execute();
    }

}
