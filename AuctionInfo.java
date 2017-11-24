package impl;

import java.util.List;

/**
 * AuctionInfo holds the parsed data file information
 */
public class AuctionInfo {

    private final int noOfUnits;
    private final int noOfBidders;
    private final List<Bid> bids;

    public AuctionInfo(int noOfUnits, int noOfBidders, List<Bid> bids){
        this.noOfUnits = noOfUnits;
        this.noOfBidders = noOfBidders;
        this.bids = bids;
    }

    public int getNoOfUnits() {
        return noOfUnits;
    }

    public int getNoOfBidders() {
        return noOfBidders;
    }

    public List<Bid> getBids() {
        return bids;
    }

    @Override
    public String toString() {
        return "AuctionInfo{" +
                "noOfUnits=" + noOfUnits +
                ", noOfBidders=" + noOfBidders +
                ", bids=" + bids +
                '}';
    }
}
