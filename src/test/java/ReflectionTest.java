import org.junit.Test;

public class ReflectionTest {
    @Test
    public void shuChu() throws ClassNotFoundException {
        //通过反射获取类   类名.class; Class.forName("包+类"); 对象.getClass(); 等都可以
        Class aniClass=Class.forName("Animal");
        //一个类在内存中,只有一个class对象
        //一个类被加载后,类的整个结构都会被封装在class对象中
System.out.println(aniClass);


    }
}

//定义实体类
class Animal {
    private String name;
    private int age;
    private String sex;

    public Animal() {
    }

    public Animal(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

}