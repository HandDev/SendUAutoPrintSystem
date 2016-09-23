package biz.sendyou.server;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by parkjaesung on 2016. 9. 19..
 */
@Entity
public class CardOrder {

    @Id
    @GeneratedValue
    private long id;

    private final String orderUUID;
    private final String userUUID;
    private String orderDate;

    public CardOrder(String userUUID, String orderUUID){
        this.userUUID = userUUID;
        this.orderUUID = orderUUID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
}
