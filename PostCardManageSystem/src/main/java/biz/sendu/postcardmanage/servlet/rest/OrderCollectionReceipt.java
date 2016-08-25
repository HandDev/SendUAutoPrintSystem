package biz.sendu.postcardmanage.servlet.rest;

import biz.sendu.postcardmanage.dataclass.Order;
import biz.sendu.postcardmanage.mongodb.ObjectToDBObject;
import biz.sendu.postcardmanage.mongodb.OrderCollectionManager;

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
                           @QueryParam("orderdate") String orderDate, @QueryParam("text")String text, @Context final HttpServletResponse response){
        ObjectToDBObject objectToDBObject = ObjectToDBObject.getInstance();
        OrderCollectionManager orderCollectionManager = OrderCollectionManager.getInstance();

        Order order = new Order();

        order.setUserUUID(useruuid);
        order.setOrderDate(orderDate);

        //TODO setFile dir using order uuid

        orderCollectionManager.receiptOrder(objectToDBObject.orderToDBObject(order));

        //TODO return order info as JSON
        return "";
    }

}
