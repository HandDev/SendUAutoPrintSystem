package biz.sendyou.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

/**
 * Created by parkjaesung on 2016. 9. 19..
 */

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/order/{userUUID}/{orderUUID}", method = RequestMethod.POST)
    public CardOrder newOrder(@PathParam("userUUID")String userUUID , @PathParam("orderUUID") String orderUUID){
        CardOrder newCardOrder = new CardOrder(userUUID, orderUUID);

        //TODO 날짜 설정
        //newCardOrder.setOrderDate(Calndae);
        orderService.addOrder(newCardOrder);

        return newCardOrder;
    }
}
