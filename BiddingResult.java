package impl;

public class BiddingResult {

    private final String bidderName;
    private final double price;

    public BiddingResult(String bidderName, double price){
        this.bidderName = bidderName;
        this.price = price;
    }

    public String getBidderName() {
        return bidderName;
    }

    public double getPrice() {
        return price;
    }



    @Override
    public String toString() {
        return "impl.BiddingResult{" +
                "bidderName='" + bidderName + '\'' +
                ", price=" + price +
                '}';
    }
}
