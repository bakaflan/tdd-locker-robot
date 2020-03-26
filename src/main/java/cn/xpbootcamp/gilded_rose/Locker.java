package cn.xpbootcamp.gilded_rose;

import java.util.*;

public class Locker {

    private int boxNumber;
    private int emptyBoxNum;
    private List<Integer> emptyBoxList;
    private List<Integer>  usedBoxList;

    private HashMap ticketList;

    public Locker(int boxNumber, int emptyBoxNum) {
        this.boxNumber = boxNumber;
        this.emptyBoxNum = emptyBoxNum;
        this.emptyBoxList = new ArrayList<Integer>();
        this.usedBoxList = new ArrayList<Integer>();
        for(int i =0;i<boxNumber;i++){
            emptyBoxList.add(i);
        }
        ticketList = new HashMap<String,Integer>();
    }

    public String getEmptyBox() {
        if(emptyBoxNum>0){
            String ticker = String.valueOf(System.currentTimeMillis());
            emptyBoxNum--;
            int boxIndex = (int) (Math.random() * 19);
            int boxID = emptyBoxList.get(boxIndex);
            emptyBoxList.remove(boxIndex);
            ticketList.put(ticker,boxIndex);
            usedBoxList.add(boxID);
            return ticker;
        }
        return "there is no empty box";
    }

    
}
