package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

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

    @Test
    void should_warnning_when_store_a_bag_if_no_empty_box(){
        LockerRobot robot = new LockerRobot();
        Locker locker1 = new Locker(0);
        Locker locker2 = new Locker(1);
        List<Locker> lockerList = new ArrayList<>();
        Collections.addAll(lockerList,locker1,locker2);
        robot.setLockerList(lockerList);;
        String ticket1 = robot.storeBag();

        LockerException e =assertThrows(LockerException.class, ()-> robot.storeBag());
        assertEquals("没有可用储物柜",e.getMessage());
    }

    @Test
    void should_warnning_when_pick_bag_if_ticket_is_overdue() {

        LockerRobot robot = new LockerRobot();
        Locker locker1 = new Locker(10);
        List<Locker> lockerList = new ArrayList<>();
        Collections.addAll(lockerList,locker1);
        robot.setLockerList(lockerList);;
        String ticket1 = robot.storeBag();
        robot.pickBag(ticket1);

        assertFalse(robot.getTicket2Locker().containsKey(ticket1));
        LockerException e =assertThrows(LockerException.class, ()-> robot.pickBag(ticket1));
        assertEquals("this ticket is not available",e.getMessage());

    }


}
