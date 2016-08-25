package biz.sendu.postcardmanage.mongodb;

import com.mongodb.*;

import java.net.UnknownHostException;

/**
 * Created by parkjaesung on 2016. 8. 11..
 */
public class BaseApp {

    public static void main(String[] args){
        System.out.println(System.getProperty("user.dir"));

        MongoDBManager mongoDBManager = MongoDBManager.getInstance();

        try{
        mongoDBManager.getOrdersDB();
        mongoDBManager.getUsersDB();}
        catch (Exception e){
            e.printStackTrace();
        }

        DB db = null;
        try {
            db = mongoDBManager.getOrdersDB();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        DBCollection orderTable = db.getCollection("order");
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("uuid", 1234);
       // DBCursor dbCursor = orderTable.find(whereQuery);
        DBCursor dbCursor = orderTable.find();
        while(dbCursor.hasNext()) {
            System.out.println(dbCursor.next());
        }

        OrderCollectionManager orderCollectionManager = OrderCollectionManager.getInstance();

        System.out.println(orderCollectionManager.searchOrderByUserUUID("1234"));

    }

}
