package cn.xpbootcamp.gilded_rose;

import java.util.*;
import java.util.stream.IntStream;

public class Locker {
    private boolean USED = true;
    private boolean EMPTY = false;

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

    public Map<Integer, Boolean> getBoxList() {
        return boxList;
    }

    public Locker(int boxNumber) {
        this.boxNumber = boxNumber;
        this.boxList = new HashMap<Integer, Boolean>();
        this.ticketList = new HashMap<>();
        this.random = new Random();
        initBoxList();
    }

    private void initBoxList() {
        IntStream.range(0, boxNumber).forEach(i -> boxList.put(i, EMPTY));
    }

    private int getRandomBoxIndex() {
        List<Integer> emptyList = new ArrayList<>();
        boxList.forEach((boxIndex,isEmpty) ->{
            if(!isEmpty){
                emptyList.add(boxIndex);
            }
        });
        return emptyList.get(random.nextInt(emptyList.size()));
    }

    private String getRandomTicket(){
        return String.valueOf(System.currentTimeMillis());
    }

    public String storeBag() throws LockerException {
        if (isAvailableBox()) {
            String ticket = getRandomTicket();
            int boxIndex = getRandomBoxIndex();
            ticketList.put(ticket,boxIndex);
            boxList.put(boxIndex,USED);
            System.out.println("已为您打开"+boxIndex+"号储物格,您的凭证号码为:"+ticket);
            return ticket;
        }
        System.out.println("柜子已满");
        throw new LockerException("there is no empty box");
    }

    public boolean isAvailableBox() {
        return boxList.containsValue(EMPTY);
    }

    public void pickBag(String ticket) {
        if(ticketList.containsKey(ticket)){
            boxList.put(ticketList.get(ticket),EMPTY );
            ticketList.remove(ticket);
            System.out.println("已打开储物格,请取走您存放的物品");
            return;
        }
        System.out.println("凭证无效");
        throw new LockerException("ticket is no available");
    }
}
