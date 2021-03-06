package biz.sendyou.server;

import biz.sendyou.server.order.CardOrder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by parkjaesung on 2016. 9. 19..
 */
@Service
public class OrderImpl implements OrderService {

    @Resource
    OrderRepository orderRepository;

    @Override
    public void addOrder(CardOrder cardOrder) {
        orderRepository.save(cardOrder);
    }

}
