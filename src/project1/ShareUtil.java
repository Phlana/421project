package project1;

import java.math.BigDecimal;
import java.util.function.Predicate;

public class ShareUtil {
    public static ShareInfo getPrice(final String symbol) {
        return new ShareInfo (symbol, APIFinance.getPrice(symbol));
    }

    public static Predicate<ShareInfo> isPriceLessThan(final int price) {
        return shareInfo -> shareInfo.price.compareTo(BigDecimal.valueOf(price)) < 0;
    }

    public static ShareInfo pickHigh(final ShareInfo share1, final ShareInfo share2) {
        return share1.price.compareTo(share2.price) > 0 ? share1: share2;
    }
}
