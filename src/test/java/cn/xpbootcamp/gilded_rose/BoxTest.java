package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoxTest {

    @Test
    void should_open_box_and_return_ticket_when_customer_store_bag_if_there_is_empty_box(){
        Locker locker = new Locker(19,19);
        String ticket = locker.getEmptyBox();
        System.out.println(ticket);
        assertFalse(locker.getUsedBoxList().isEmpty());
    }

    @Test
    void should_get_bag_back_delete_ticket_when_customer_have_ticker_if_ticker_is_available(){
        Locker locker = new Locker(19,19);
        String ticket = locker.getEmptyBox();
        System.out.println(ticket);
        locker.getBagBack(ticket);
        assertFalse(locker.getUsedBoxList().isEmpty());
    }
}
