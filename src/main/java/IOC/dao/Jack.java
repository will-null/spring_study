package IOC.dao;

public class Jack implements UserDao {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void GetName() {
        System.out.print("用户是Jack");
    }
}
