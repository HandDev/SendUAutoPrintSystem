package biz.sendu.postcardmanage.servlet.rest;

import biz.sendu.postcardmanage.mongodb.MongoDBManager;
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

@Path("/order/uuid/")
public class OrderManager {


    @GET
    @Path("{uuid}")
    @Produces("application/json"+ ";charset=utf-8")
    public String getStatusByUUID(@PathParam("uuid") String uuid){
            MongoDBManager mongoDBManager = MongoDBManager.getInstance();
            DB db= null;

        System.out.println("uuid :" + uuid);
        Order result = null;

        try {
            db = mongoDBManager.getOrdersDB();
        } catch (UnknownHostException e) {
            System.out.println("getOrdersDB execption");
            e.printStackTrace();
        }

        DBCollection orderTable = db.getCollection("order");
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("uuid", uuid);
        DBCursor dbCursor = orderTable.find(whereQuery);

        return dbCursor.next().toString();
    }
}
