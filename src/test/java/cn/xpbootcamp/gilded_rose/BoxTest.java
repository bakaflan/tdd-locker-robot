package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class BoxTest {

    @Test
    void should_open_box_and_return_ticket_when_customer_store_bag_if_there_is_empty_box(){
        Locker locker = new Locker(19);
        String ticket = locker.storeBag();
        assertTrue(locker.getTicketList().containsKey(ticket));
    }

    


}
