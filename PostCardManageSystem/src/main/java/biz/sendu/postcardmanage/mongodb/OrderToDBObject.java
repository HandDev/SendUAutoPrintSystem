package biz.sendu.postcardmanage.mongodb;

import biz.sendu.postcardmanage.dataclass.Order;
import biz.sendu.postcardmanage.dataclass.User;
import com.mongodb.BasicDBObject;

/**
 * Created by parkjaesung on 2016. 8. 11..
 */

//Class for changing User & Order object to BasicDocument for Mongo database
public class OrderToDBObject {

    private static OrderToDBObject instance;

    //private constructor
    private OrderToDBObject(){

    }

    public static OrderToDBObject getInstance(){
        return instance;
    }

    public BasicDBObject orderToDBObject(Order input){
        BasicDBObject doc = new BasicDBObject("userUUID",input.getUserUUID()).
                append("idx", input.getIdx()).
                append("orderDate", input.getOrderDate()).
                append("imgDir", input.getImageDIR()).
                append("status", input.getStatus());
        return doc;
    }

    public BasicDBObject userToDBObject(User input){
        BasicDBObject doc = new BasicDBObject("name", input.getName()).
                append("uuid",input.getUuid()).
                append("age", input.getAge());

        return doc;
    }
}
