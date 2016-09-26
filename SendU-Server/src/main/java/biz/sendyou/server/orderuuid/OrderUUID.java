package biz.sendyou.server.orderuuid;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

/**
 * Created by parkjaesung on 2016. 9. 25..
 */
@Entity
public class OrderUUID {

    @Id
    @GeneratedValue
    private long id;

    private String orderUUID;
    private  String userEmail;

    public OrderUUID() {
        orderUUID = UUID.randomUUID().toString().replace("-", "");
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getOrderUUID() {
        return orderUUID;
    }

    public void setOrderUUID(String orderUUID) {
        this.orderUUID = orderUUID;
    }
}
