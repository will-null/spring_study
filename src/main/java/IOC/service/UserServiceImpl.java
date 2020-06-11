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

    //控制反转:就是要把对需求(接口实例)的控制权从程序员反转给用户,让用户自己选着需求
    //first中,每更换一个需求,都需要程序员手动变换实例,这样的代码效率低且不切实际
    //second中,利用set来放置一个未知的实例,根据用户的选择,来确定具体对象
    //di(依赖注入)并不是IOC(控制反转),只是实现他的一种方式.
    // bean创建依赖容器；bean对象的属性由容器来注入值
    //依赖注入的实现方式:设值注入(属性注入)(setter)/构造注入/p命名空间（不常用）/注解注入
}
