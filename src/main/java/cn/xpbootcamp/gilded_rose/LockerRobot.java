package cn.xpbootcamp.gilded_rose;

import jdk.internal.vm.compiler.collections.EconomicMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LockerRobot {
    List<Locker> lockerList;
    private Map<String , Integer> ticket2Locker;


    public void setLockerList(List<Locker> lockerList) {
        this.lockerList = lockerList;
        this.ticket2Locker = new HashMap<>();
    }

    public Map<String, Integer> getTicket2Locker() {
        return ticket2Locker;
    }

    public int getLockerIndex(){
        for (int i = 0; i < lockerList.size(); i++) {
            if (lockerList.get(i).isAvailableBox()) {
                System.out.println("第"+i+"号储物柜可用");
                return i;
            }
        }
        throw new LockerException("没有可用储物柜");
    }

    public String storeBag() {
        int lockerIndex = getLockerIndex();
        String ticket = lockerList.get(lockerIndex).storeBag();
        ticket2Locker.put(ticket, lockerIndex);
        return ticket;
    }


}
