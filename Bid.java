package impl;

/**
 * Bid holds the info of bidder's name and bidValues.
 */
public class Bid implements Comparable<Bid>{

    private final String bidder;
    private final double bidValue;
    private int slotsWon;
    private boolean checked=false;

    public Bid(String bidder, double bidValue) {
        this.bidder = bidder;
        this.bidValue = bidValue;
    }

    public String getBidder() {
        return bidder;
    }

    public double getBidValue() {
        return bidValue;
    }

    @Override
    public String toString() {
        return "impl.Bid{" +
                "bidder='" + bidder + '\'' +
                ", bidValue=" + bidValue +
                '}';
    }

    public int getSlotsWon(){
        return slotsWon;
    }

    public void setSlotsWon(){
           slotsWon++;
    }

    public boolean getChecked(){
        return checked;
    }
    public void setChecked(){
        checked=true;
    }


    @Override
    public int compareTo(Bid o) {                        //to sort a list, we need to override the method compareTo() which is a part of Comparable Interface
        double compareBidValue = o.getBidValue();
        if(this.getBidValue() > compareBidValue){
            return -1;
        }
        else if(this.getBidValue() == compareBidValue){
            return 0;
        }
        else{
            return 1;
        }

//        return compareBidValue - this.bidValue;
    }


    }
