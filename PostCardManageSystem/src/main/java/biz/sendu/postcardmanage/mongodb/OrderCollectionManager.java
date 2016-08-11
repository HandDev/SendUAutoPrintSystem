package biz.sendu.postcardmanage.mongodb;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

import java.net.UnknownHostException;

/**
 * Created by parkjaesung on 2016. 8. 11..
 */
//Singleton Pattern
public class OrderCollectionManager {
    private static OrderCollectionManager instance;
    public static OrderCollectionManager getInstance(){
        return instance;
    }

    private DB db;

    //private constructor
    private OrderCollectionManager(){
        MongoDBManager mongoDBManager = MongoDBManager.getInstance();
        try {
            db = mongoDBManager.getOrdersDB();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public String searchOrderByUserUUID(String userUUID){
        //Query
        BasicDBObject whereQuery = new BasicDBObject().append("useruuid", userUUID);

        DBCollection orderTable = db.getCollection("order");

        DBCursor dbCursor = orderTable.find(whereQuery);

        StringBuffer stringBuffer = new StringBuffer();

        while(dbCursor.hasNext()){
        stringBuffer.append(dbCursor.next());
        }

        return stringBuffer.toString();
    }
}
