package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoxTest {

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
    }

    @Test
    void should_warnning_when_store_a_bag_if_no_empty_box(){
        Locker locker = new Locker(1);
        locker.storeBag();
        LockerException e =assertThrows(LockerException.class, ()-> locker.storeBag());
        assertEquals("there is no empty box",e.getMessage());

    }

    @Test
    void should_warnning_when_pick_bag_if_ticket_is_overdue() {
        Locker locker = new Locker(19);
        String ticket = locker.storeBag();
        int boxIndex = locker.getTicketList().get(ticket);
        assertTrue(locker.getTicketList().containsKey(ticket));
        assertTrue(locker.getBoxList().get(boxIndex));

        locker.pickBag(ticket);
        assertFalse(locker.getTicketList().containsKey(ticket));
        assertFalse(locker.getBoxList().get(boxIndex));

        locker.pickBag(ticket);

    }

}
