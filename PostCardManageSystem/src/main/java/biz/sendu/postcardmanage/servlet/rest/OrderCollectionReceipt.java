package biz.sendu.postcardmanage.servlet.rest;

import biz.sendu.postcardmanage.dataclass.Order;
import biz.sendu.postcardmanage.mongodb.ObjectToDBObject;
import biz.sendu.postcardmanage.mongodb.OrderCollectionManager;
import com.mongodb.BasicDBObject;
import org.json.JSONString;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

/**
 * Created by parkjaesung on 2016. 8. 11..
 */
@Path("/order/receipt/")
public class OrderCollectionReceipt {

    @POST
    @Produces("application/json"+ ";charset=utf-8")
    public String newOrder(@QueryParam("useruuid") String useruuid, @QueryParam("orderuuid") String orderuuid,
                           @QueryParam("orderdate") String orderDate, @QueryParam("text")String text, @QueryParam("status")String status, @Context final HttpServletResponse response){
        ObjectToDBObject objectToDBObject = ObjectToDBObject.getInstance();
        OrderCollectionManager orderCollectionManager = OrderCollectionManager.getInstance();

        Order order = new Order();

        //TODO check any nullable param
        order.setUserUUID(useruuid);
        order.setOrderUUID(orderuuid);
        order.setOrderDate(orderDate);
        order.setText(text);
        order.setStatus(Integer.parseInt(status));

        BasicDBObject orderDBObject = objectToDBObject.orderToDBObject(order);
        //TODO setFile dir using order uuid
        orderCollectionManager.receiptOrder(orderDBObject);


        //TODO return order info as JSON
        return  orderDBObject.toString();
    }

}
