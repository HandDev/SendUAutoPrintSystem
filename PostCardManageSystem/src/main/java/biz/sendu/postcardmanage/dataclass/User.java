package biz.sendu.postcardmanage.dataclass;

/**
 * Created by parkjaesung on 2016. 8. 11..
 */
public class User {
    private String name;
    private String uuid;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
