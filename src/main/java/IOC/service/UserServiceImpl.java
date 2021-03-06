package IOC.service;

import IOC.dao.Jack;
import IOC.dao.UserDao;

public class UserServiceImpl implements UserService {

    //    first（对应test里的方法名）
    //    每增加一个实现，一个功能，就要重新new一个实例，new Jack();
    //     代码的耦合程度级高，且不符合实际
    //    接口接收实现类的实例
    private UserDao userDao = new Jack();

    public void getUser() {
        userDao.GetName();
    }

    //second
    //给定一个接口,至于要用哪个实现,让用户通过set自己选
    private UserDao userDaoSet;

    public void setUserDaoSet(UserDao userDaoSet) {
        this.userDaoSet = userDaoSet;
    }

    public void getUserSet() {
        userDaoSet.GetName();
    }

    /*控制反转:就是要把对需求(接口实例)的控制权（管理对象的生命周期、依赖关系等）从程序员移交给程序,让用户自己选着需求，由容器来创建

    可以把IoC模式看作工厂模式的升华，把IoC容器看作是一个大工厂，只不过这个大工厂里要生成的对象都是在XML文件中给出定义的。
     利用Java 的“反射”编程，根据XML中给出的类定义生成相应的对象。从实现来看，以前在工厂模式里写死了的对象，
     IoC模式改为配置XML文件，这就把工厂和要生成的对象两者隔离，极大提高了灵活性和可维护性。

    first中,每更换一个需求,都需要程序员手动变换实例,这样的代码效率低且不切实际
    second中,利用set来放置一个未知的实例,根据用户的选择,来确定具体对象

    di(依赖注入)并不是IOC(控制反转),只是实现他的一种方式.
    两种实现： 依赖查找（DL）和依赖注入（DI）。
    DL 已经被抛弃，因为他需要用户自己去是使用 API 进行查找资源和组装对象。即有侵入性。
    DI 是 Spring 使用的方式，容器负责组件的装配。


     bean创建依赖容器；bean对象的属性由容器来注入值
    依赖注入的实现方式:设值注入(属性注入)(setter)/构造注入/p命名空间（不常用）/注解注入*/
}
