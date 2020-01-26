package project1;

import java.math.BigDecimal;

public class ShareInfo {
    public final String symbol;
    public final BigDecimal price;

    public ShareInfo (final String theSymbol, final BigDecimal thePrice) {
        symbol = theSymbol;
        price = thePrice;
    }

    public String toString() {
        return String.format("symbol: %s price: %g", symbol, price);
    }

}
