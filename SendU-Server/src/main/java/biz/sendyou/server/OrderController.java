package biz.sendyou.server;

import biz.sendyou.server.order.CardOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by parkjaesung on 2016. 9. 19..
 */

@RestController
public class OrderController {

    @Resource
    OrderRepository orderRepository;

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

    @RequestMapping(value = "/{email}/orders")
    public List<CardOrder> searchOrdersByUser(@PathVariable("email") String email){
        System.out.println("email : " + email);

        return orderRepository.searchOrdersByUser(email);
    }
}
