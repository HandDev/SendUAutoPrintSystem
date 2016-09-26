package biz.sendyou.server;

import biz.sendyou.server.order.CardOrder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by parkjaesung on 2016. 9. 19..
 */
public interface OrderRepository extends JpaRepository<CardOrder, Long> {
}
