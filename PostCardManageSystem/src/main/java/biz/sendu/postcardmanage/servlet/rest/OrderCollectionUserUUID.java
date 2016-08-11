package biz.sendu.postcardmanage.servlet.rest;

import biz.sendu.postcardmanage.mongodb.MongoDBManager;
import biz.sendu.postcardmanage.mongodb.OrderCollectionManager;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import biz.sendu.postcardmanage.dataclass.*;

import javax.ws.rs.*;
import java.net.UnknownHostException;

/**
 * Created by parkjaesung on 2016. 8. 11..
 */

@Path("/order/useruuid/")
public class OrderCollectionUserUUID {

    private OrderCollectionManager orderCollectionManager = OrderCollectionManager.getInstance();

    @GET
    @Path("{uuid}")
    @Produces("application/json"+ ";charset=utf-8")
    public String getStatusByUUID(@PathParam("uuid") String uuid){
            MongoDBManager mongoDBManager = MongoDBManager.getInstance();
            DB db= null;

        System.out.println("uuid :" + uuid);
        return orderCollectionManager.searchOrderByUserUUID(uuid);
    }
}
