package biz.sendyou.server.orderuuid;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by parkjaesung on 2016. 9. 25..
 */
@Service
public class OrderUUIDImpl implements OrderUUIDService {

    @Resource
    OrderUUIDRepository orderUUIDRepository;

    @Override
    public OrderUUID newOrderUUID(String email) {
        OrderUUID newUUID = new OrderUUID();
        newUUID.setUserEmail(email);

        orderUUIDRepository.save(newUUID);

        return newUUID;
    }
}
