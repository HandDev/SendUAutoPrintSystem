package biz.sendyou.server.orderuuid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.expression.spel.ast.LongLiteral;

/**
 * Created by parkjaesung on 2016. 9. 25..
 */
public interface OrderUUIDRepository extends JpaRepository<OrderUUID, Long> {
}
