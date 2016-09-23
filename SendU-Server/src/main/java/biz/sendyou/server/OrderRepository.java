package biz.sendyou.server;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by parkjaesung on 2016. 9. 19..
 */
public interface OrderRepository extends JpaRepository<CardOrder, Long> {
}
