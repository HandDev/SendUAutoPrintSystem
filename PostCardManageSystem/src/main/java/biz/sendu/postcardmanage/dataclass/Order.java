package biz.sendu.postcardmanage.dataclass;

/**
 * Created by parkjaesung on 2016. 8. 11..
 */
public class Order {

    private String userUUID;
    private String idx;
    private String orderDate;
    private String imageDIR;
    private String text;
    private int status;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUserUUID() {
        return userUUID;
    }

    public void setUserUUID(String userUUID) {
        this.userUUID = userUUID;
    }

    public String getIdx() {
        return idx;
    }

    public void setIdx(String idx) {
        this.idx = idx;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getImageDIR() {
        return imageDIR;
    }

    public void setImageDIR(String imageDIR) {
        this.imageDIR = imageDIR;
    }

    @Override
    public String toString() {
        return "Order [uuid=" + userUUID + "," + "idx=" + idx + "," + "orderData=" + orderDate +"]";
    }
}
