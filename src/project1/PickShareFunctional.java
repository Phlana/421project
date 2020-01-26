package project1;

import java.util.stream.Stream;

public class PickShareFunctional {
    final static int highestPrice = 500;
    public static ShareInfo findHighPrices(Stream<String> stream) {
        return stream
                .map(ShareUtil::getPrice)
                .filter(shareInfo -> ShareUtil.isPriceLessThan(highestPrice).test(shareInfo))
                .reduce(ShareUtil::pickHigh)
                .orElse(null);
    }

    public static void main(String[] args) {
        // printing every share price
        for(String symbol : Shares.symbols) {
            ShareInfo shareInfo = ShareUtil.getPrice(symbol);
            System.out.println(shareInfo.toString());
        }

//        // 1637 ms
//        long startTime = System.currentTimeMillis();
//        System.out.println("highest under 500: " + findHighPrices(Shares.symbols.stream()));
//        long timeElapsed = System.currentTimeMillis() - startTime;
//        System.out.println("time elapsed: " + timeElapsed);

//        // 1207 ms
//        long startTime = System.currentTimeMillis();
//        System.out.println("highest under 500: " + findHighPrices(Shares.symbols.parallelStream()));
//        long timeElapsed = System.currentTimeMillis() - startTime;
//        System.out.println("time elapsed: " + timeElapsed);
    }
}
