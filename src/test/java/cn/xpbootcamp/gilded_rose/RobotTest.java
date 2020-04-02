package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RobotTest {


    @Test
    void should_store_bag_if_there_is_empty_box_when_client_store_bag(){
        LockerRobot robot = new LockerRobot();
        Locker locker1 = new Locker(10);
        List<Locker> lockerList = new ArrayList<>();
        Collections.addAll(lockerList,locker1);
        robot.setLockerList(lockerList);;
        String ticket = robot.storeBag();
        Assertions.assertTrue(robot.getTicket2Locker().containsKey(ticket));
    }


    @Test
    void should_pick_bag_when_hava_a_ticket_if_ticket_is_available(){
        LockerRobot robot = new LockerRobot();
        Locker locker1 = new Locker(10);
        List<Locker> lockerList = new ArrayList<>();
        Collections.addAll(lockerList,locker1);
        robot.setLockerList(lockerList);;
        String ticket = robot.storeBag();

        robot.pickBag(ticket);

    }

}
