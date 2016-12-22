package biz.sendyou.server;

import biz.sendyou.server.order.CardOrder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by parkjaesung on 2016. 9. 19..
 */
@Service
public interface OrderService {
    void addOrder(CardOrder cardOrder);
    //List<CardOrder> searchOrdersByUser(String userUUID);
}
