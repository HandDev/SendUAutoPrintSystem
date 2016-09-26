package biz.sendyou.server;

import biz.sendyou.server.order.CardOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

/**
 * Created by parkjaesung on 2016. 9. 19..
 */

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/order/{userUUID}/{orderUUID}", method = RequestMethod.POST,
    consumes = "application/json")
    public CardOrder newOrder(@RequestBody CardOrder newCardOrder, @PathVariable("userUUID")String userUUID , @PathVariable("orderUUID") String orderUUID){

        System.out.println("orderUUID : " + orderUUID);
        System.out.println("userUUID : " + userUUID);

        newCardOrder.setOrderStatus(CardOrder.OrderStatus.Ordered);
        newCardOrder.setOrderUUID(orderUUID);
        newCardOrder.setUserUUID(userUUID);

        //TODO 날짜 설정
        //newCardOrder.setOrderDate(Calndae);
        orderService.addOrder(newCardOrder);

        return newCardOrder;
    }
}
