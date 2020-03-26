package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.Lock;

import static org.junit.jupiter.api.Assertions.*;

public class BoxTest {

    @Test
    void should_open_box_and_return_ticket_when_customer_store_bag_if_there_is_empty_box(){
        Locker locker = new Locker(19);
        String ticket = locker.storeBag();
        int boxIndex = locker.getTicketList().get(ticket);
        assertTrue(locker.getTicketList().containsKey(ticket));
        assertTrue(locker.getBoxList().get(boxIndex));
    }

    @Test
    void should_pick_bag_when_have_a_ticket_if_ticket_is_match(){
        Locker locker = new Locker(19);
        String ticket = locker.storeBag();
        int boxIndex = locker.getTicketList().get(ticket);
        assertTrue(locker.getTicketList().containsKey(ticket));
        assertTrue(locker.getBoxList().get(boxIndex));

        locker.pickBag(ticket);
        assertFalse(locker.getTicketList().containsKey(ticket));
        assertFalse(locker.getBoxList().get(boxIndex));

        locker.pickBag("无效凭证");
    }

    @Test
    void should_warnning_when_store_a_bag_if_no_empty_box(){
        Locker locker = new Locker(2);
        locker.storeBag();
        locker.storeBag();
        locker.storeBag();

    }

}
