
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.concurrent.ThreadLocalRandom;

public class InvestmentOptions {

    private double currentPrice, projectedPrice, minimumPrice;
    private String name;
    private float riskPercent, profitPercent;
    private static final DecimalFormat decfor = new DecimalFormat("0.00");

    public InvestmentOptions(String name, double currentPrice, double projectedPrice, double minimumPrice) {
        BigDecimal currentRound = new BigDecimal(currentPrice).setScale(2, RoundingMode.HALF_UP);
        BigDecimal projectedRound = new BigDecimal(projectedPrice).setScale(2, RoundingMode.HALF_UP);
        BigDecimal minimumRound = new BigDecimal(minimumPrice).setScale(2, RoundingMode.HALF_UP);
        this.currentPrice = currentRound.doubleValue();
        this.projectedPrice = projectedRound.doubleValue();
        this.minimumPrice = minimumRound.doubleValue();
        this.name = name;
        profitPercent = (float) (((projectedPrice - currentPrice) / currentPrice) * 100);
        riskPercent = (float) (((currentPrice - minimumPrice) / currentPrice) * 100);
        BigDecimal profitRound = new BigDecimal(profitPercent).setScale(2, RoundingMode.HALF_UP);
        BigDecimal riskRound = new BigDecimal(riskPercent).setScale(2, RoundingMode.HALF_UP);
        profitPercent = profitRound.floatValue();
        riskPercent = riskRound.floatValue();
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public String getName() {
        return name;
    }

    public float getRiskPercent() {
        return riskPercent;
    }

    public float getProfitPercent() {
        return profitPercent;
    }

}
