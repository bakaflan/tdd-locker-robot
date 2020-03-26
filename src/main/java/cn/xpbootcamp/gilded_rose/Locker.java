package cn.xpbootcamp.gilded_rose;

import java.util.*;

public class Locker {

    private int boxNumber;
    private int emptyBoxNum;
    private List<Integer> emptyBoxList;
    private List<Integer>  usedBoxList;
    private HashMap ticketList;

    public int getBoxNumber() {
        return boxNumber;
    }

    public void setBoxNumber(int boxNumber) {
        this.boxNumber = boxNumber;
    }

    public int getEmptyBoxNum() {
        return emptyBoxNum;
    }

    public void setEmptyBoxNum(int emptyBoxNum) {
        this.emptyBoxNum = emptyBoxNum;
    }

    public List<Integer> getEmptyBoxList() {
        return emptyBoxList;
    }

    public void setEmptyBoxList(List<Integer> emptyBoxList) {
        this.emptyBoxList = emptyBoxList;
    }

    public List<Integer> getUsedBoxList() {
        return usedBoxList;
    }

    public void setUsedBoxList(List<Integer> usedBoxList) {
        this.usedBoxList = usedBoxList;
    }

    public HashMap getTicketList() {
        return ticketList;
    }

    public void setTicketList(HashMap ticketList) {
        this.ticketList = ticketList;
    }



    public Locker(int boxNumber, int emptyBoxNum) {
        this.boxNumber = boxNumber;
        this.emptyBoxNum = emptyBoxNum;
        this.emptyBoxList = new ArrayList<Integer>();
        this.usedBoxList = new ArrayList<Integer>();
        for(int i =0;i<boxNumber;i++){
            emptyBoxList.add(i);
        }
        ticketList = new HashMap<String, Integer>();
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
