package biz.sendyou.server.orderuuid;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * Created by parkjaesung on 2016. 9. 25..
 */
@Service
public interface OrderUUIDService {

    public OrderUUID newOrderUUID(String email);
}
