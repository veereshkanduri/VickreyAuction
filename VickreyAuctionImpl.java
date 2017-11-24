package impl;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VickreyAuctionImpl implements VickreyAuction{

    public BiddingResult[] getAuctionResult(String fileName) {  //This method is called when auction.getAuctionResult("data.txt") is called

        AuctionInfo auctionInfo = null;
        try {
            auctionInfo = getAuctionInfo(fileName);
            int noOfUnits = auctionInfo.getNoOfUnits();
            List<Bid> bids = auctionInfo.getBids();

            //Sort the bidders based on the bidValue
            Collections.sort(auctionInfo.getBids());
            System.out.println("After Sorting: "+auctionInfo.getBids());

            //Get the top number of Units from sorted bidders

            //Group the bids from the same bids and calculate the price
            for(int x=0;x<noOfUnits;x++){
                if (bids.get(x).getChecked() != true) {
                    bids.get(x).setSlotsWon();

                    for (int y=x+1;y<noOfUnits;y++){
                        if(bids.get(y).getChecked()!=true){
                            if(bids.get(x).getBidder()==bids.get(y).getBidder()){
                                bids.get(x).setSlotsWon();
                                bids.get(y).setChecked();
                            }
                        }

                    }
                    bids.get(x).setChecked();
                }
            }

            int outSize=0;
            for(int x=0;x<noOfUnits;x++){
                if(bids.get(x).getSlotsWon()!=0){
                    //System.out.println("Slots won by "+bids.get(x).getBidder()+" is "+bids.get(x).getSlotsWon());
                    outSize++;
                }
            }
           // System.out.println("Outsize = "+outSize);
            BiddingResult[] outBr = new BiddingResult[outSize];

            int ab=0;
            for(int x=0;x<noOfUnits;x++){
                double price = 0;
                if(bids.get(x).getSlotsWon()!=0){
                    int currCounter = 0;
                    //System.out.println("Slots won by "+bids.get(x).getBidder()+" is "+bids.get(x).getSlotsWon());
                    for(int z = noOfUnits; z < bids.size() && currCounter<bids.get(x).getSlotsWon(); z++, currCounter++){
                        price = price+bids.get(z).getBidValue();
                    }
                    outBr[ab] = new BiddingResult(bids.get(x).getBidder(),price);
                    ab++;
                }
            }
            for(int v=0;v<outSize;v++){
                System.out.println(outBr[v].toString());
            }


            return outBr;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



    private AuctionInfo getAuctionInfo(String fileName) throws IOException {    //file rading starts here
        BufferedReader reader = getReader(fileName);
        int noOfUnits = getNoOfUnits(reader.readLine());
        int noOfBidders = getNoOfBidders(reader.readLine());
        List<Bid> bids = getBids(noOfBidders,reader);
        AuctionInfo auctionInfo = new AuctionInfo(noOfUnits,noOfBidders,bids);
        System.out.println(auctionInfo);
        return auctionInfo;
    }

    private BufferedReader getReader(String fileName) throws FileNotFoundException {
        File f = new File(fileName);
        FileReader fr = new FileReader(f);
        BufferedReader reader = new BufferedReader(fr);
        return reader;
    }

    private int getNoOfUnits(String units){
        return Integer.parseInt(units);
    }

    private int getNoOfBidders(String bidders){
        return Integer.parseInt(bidders);
    }

    private List<Bid> getBids(int noOfBidders, BufferedReader reader) throws IOException {
        List<Bid> bidders = new ArrayList<>();

        for (int i=0;i<noOfBidders;i++){
            String line = reader.readLine();
            String[] s = line.split(",");
//            System.out.println("s:"+s.length);

            String bidderName = s[0];
            for(int j=1;j<s.length;j++){
                bidders.add(new Bid(bidderName,Integer.parseInt(s[j])));
            }
        }

        System.out.println("Bidders Length:"+bidders.size());
        return bidders;
    }



    public static void main(String[] args) throws IOException {
        VickreyAuctionImpl auction = new VickreyAuctionImpl();
        auction.getAuctionResult("data1.txt");
    }



}
