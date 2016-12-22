package biz.sendyou.server;

import biz.sendyou.server.order.CardOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by parkjaesung on 2016. 9. 19..
 */
public interface OrderRepository extends JpaRepository<CardOrder, Long> {

    //@Query("select orderDate, orderUUID, userUUID, address, image, numAddress, receiverName, text, receiverPhone, orderStatus from CardOrder where userUUID = ?1")
    @Query(value = "select * from CardOrder where userUUID = ?1" ,nativeQuery = true)
    List<CardOrder> searchOrdersByUser(String userUUID);
}
