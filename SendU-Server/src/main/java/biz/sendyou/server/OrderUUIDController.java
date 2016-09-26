package biz.sendyou.server;

import biz.sendyou.server.orderuuid.OrderUUID;
import biz.sendyou.server.orderuuid.OrderUUIDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by parkjaesung on 2016. 9. 25..
 */
@RestController
public class OrderUUIDController {

    @Autowired
    OrderUUIDService orderUUIDService;

    @RequestMapping(value = "/orderuuid/{email}", method = RequestMethod.POST)
    public OrderUUID getOrderUUID(@PathVariable("email") String email){
        return orderUUIDService.newOrderUUID(email);
    }

}
