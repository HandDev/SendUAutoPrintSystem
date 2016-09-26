package biz.sendyou.server.order;

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

    private String orderUUID;
    private String userUUID;
    private String orderDate;
    private String receiverName;
    private String receiverPhone;
    private String address;
    private String numAddress;
    private String text;
    private String image;

    public void setOrderUUID(String orderUUID) {
        this.orderUUID = orderUUID;
    }

    public void setUserUUID(String userUUID) {
        this.userUUID = userUUID;
    }

    public String getOrderUUID() {
        return orderUUID;
    }

    public String getUserUUID() {
        return userUUID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumAddress() {
        return numAddress;
    }

    public void setNumAddress(String numAddress) {
        this.numAddress = numAddress;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }
}

