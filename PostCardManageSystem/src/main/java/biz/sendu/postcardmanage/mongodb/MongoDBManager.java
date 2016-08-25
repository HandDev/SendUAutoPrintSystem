package biz.sendu.postcardmanage.mongodb;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

import java.io.FileInputStream;
import java.net.UnknownHostException;
import java.util.Properties;

/**
 * Created by parkjaesung on 2016. 8. 11..
 */
//singleton pattern
public class MongoDBManager {

    private static MongoDBManager instance = new MongoDBManager();

    private String propURL = System.getProperty("user.dir")+"/sendu/config/db.properties";
    private Properties dbProps;
    private MongoClient mongoClient;
    private DB userDB;
    private DB ordersDB;

    //private constructor
    private MongoDBManager(){

        Properties properties = new Properties();
        /*
        try {
            // 프로퍼티 파일 스트림에 담기
            FileInputStream fis = new FileInputStream(propURL);

            // 프로퍼티 파일 로딩
            properties.load(new java.io.BufferedInputStream(fis));

            dbProps = properties;
        }catch (Exception e){
            e.printStackTrace();
        }

        //get DB object
        String ip = dbProps.getProperty("HOST");
        int port = Integer.parseInt(dbProps.getProperty("PORT"));
*/
        try {
            mongoClient = new MongoClient(new ServerAddress("sendukor7833.cloudapp.net", 27017));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        userDB = mongoClient.getDB("users");
        userDB.authenticate("sendu", "SendUKor1234".toCharArray());
        ordersDB = mongoClient.getDB("order");

        System.out.println("Setting DB Object finished");
    }

    public static MongoDBManager getInstance(){
        return instance;
    }

    public DB getUsersDB() throws UnknownHostException {
        return userDB;
    }

    public DB getOrdersDB() throws UnknownHostException{
        return ordersDB;
    }

    public Properties getProps(){
        return dbProps;
    }

}
