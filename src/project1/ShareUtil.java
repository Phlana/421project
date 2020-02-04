package project1;

import java.math.BigDecimal;
import java.util.Random;
import java.util.function.Predicate;

public class ShareUtil {
    private static BigDecimal getPriceRetry(final String symbol, final BigDecimal lastAttempt, final int retries) throws InterruptedException {
        if (!lastAttempt.equals(new BigDecimal(0)) || retries < 1){
            return lastAttempt;
        }
        else {
            // wait 1 to 2 seconds between calls
            Thread.sleep((new Random().nextInt(3) + 1) * 1000);
//            Thread.sleep(6000);
            return getPriceRetry(symbol, APIFinance.getPrice(symbol), retries - 1);
        }
    }

    public static ShareInfo getPrice(final String symbol) {
        try {
            return new ShareInfo (symbol, getPriceRetry(symbol, APIFinance.getPrice(symbol), 60));
        } catch (InterruptedException e) {
            return new ShareInfo (symbol, new BigDecimal(0));
        }
    }

    public static Predicate<ShareInfo> isPriceLessThan(final int price) {
        return shareInfo -> shareInfo.price.compareTo(BigDecimal.valueOf(price)) < 0;
    }

    public static ShareInfo pickHigh(final ShareInfo share1, final ShareInfo share2) {
        return share1.price.compareTo(share2.price) > 0 ? share1: share2;
    }
}
