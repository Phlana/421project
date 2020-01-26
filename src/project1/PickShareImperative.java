package project1;

import java.util.function.Predicate;

public class PickShareImperative {
    final Predicate isPriceLessThan500 = ShareUtil.isPriceLessThan(500);
    PickShareImperative () {
        for (String symbol : Shares.symbols) {
            ShareInfo shareInfo = ShareUtil.getPrice(symbol);
            if (isPriceLessThan500.test(shareInfo))
                highPriced = ShareUtil.pickHigh(highPriced, shareInfo);
        }
        System.out.println("High priced under $500 is " + highPriced);
    }
}
