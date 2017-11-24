package impl;

public class BidCounts {

    private final int slotsWon;
    private final double price;

    public BidCounts(int slotsWon, double price) {
        this.slotsWon = slotsWon;
        this.price = price;
    }

    public int getSlotsWon() {
        return slotsWon;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "BidCounts{" +
                "slotsWon=" + slotsWon +
                ", price=" + price +
                '}';
    }
}
