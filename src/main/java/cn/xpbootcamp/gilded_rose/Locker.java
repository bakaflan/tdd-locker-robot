package cn.xpbootcamp.gilded_rose;

import java.util.*;
import java.util.stream.IntStream;

public class Locker {

    private int boxNumber;
    private Map<Integer , Boolean> boxList;
    private Map<String , Integer> ticketList;
    private Random random;


    public int getBoxNumber() {
        return boxNumber;
    }

    public void setBoxNumber(int boxNumber) {
        this.boxNumber = boxNumber;
    }

    public Map<String, Integer> getTicketList() {
        return ticketList;
    }

    public Locker(int boxNumber) {
        this.boxNumber = boxNumber;
        this.boxList = new HashMap<Integer, Boolean>();
        this.ticketList = new HashMap<>();
        this.random = new Random();
        initBoxList();
    }

    private void initBoxList() {
        IntStream.range(0, boxNumber).forEach(i -> boxList.put(i, false));
    }

    private int generateBoxIndex() {
        List<Integer> emptyList = new ArrayList<>();
        boxList.forEach((boxIndex,isEmpty) ->{
            if(!isEmpty){
                emptyList.add(boxIndex);
            }
        });
        return emptyList.get(random.nextInt(emptyList.size()));
    }

    private String generateTicket(){
        return String.valueOf(System.currentTimeMillis());
    }

    public String storeBag(){
        String ticket = generateTicket();
        int boxIndex = generateBoxIndex();
        ticketList.put(ticket,boxIndex);
        System.out.println("已为您打开"+boxIndex+"号箱子,您的凭证号码为:"+ticket);
        return ticket;
    }
}
