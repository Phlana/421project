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

    public static void main(String[] args) throws InterruptedException {
        // printing every share price
//        for(String symbol : Shares.symbols) {
//            ShareInfo shareInfo = ShareUtil.getPrice(symbol);
//            System.out.println(shareInfo.toString());
//        }

        // 1637 ms 12657 ms
        long startTime = System.currentTimeMillis();
        System.out.println("highest under 500: " + findHighPrices(Shares.symbols.stream()));
        long timeElapsed = System.currentTimeMillis() - startTime;
        System.out.println("time elapsed stream: " + timeElapsed);

        // Wait a little over a minute so next attempt starts with fresh rate limit the way previous attempt did
//        Thread.sleep(60000);

        // 1207 ms  11250 ms
//        startTime = System.currentTimeMillis();
//        System.out.println("highest under 500: " + findHighPrices(Shares.symbols.parallelStream()));
//        timeElapsed = System.currentTimeMillis() - startTime;
//        System.out.println("time elapsed parellelStream: " + timeElapsed);
    }
}
