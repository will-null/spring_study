package IOC.service;

import IOC.dao.UserDao;

public class UserServiceImpl implements UserService{

    //接口接收实现类的实例
    //private UserDao userDao=new Jack();     //代码的耦合程度很高,而且程序猿的工作量加大.

    //UserDao的不同的实现就像用户的不同需求,每当用户更换需求时,程序猿就要手动
    // 更换实现private UserDao userDao=new Jack();
    //控制反转:就是要把对需求(接口实例)的控制权从程序猿反转给用户,让用户自己选着需求


    //给定一个接口,至于要用哪个实现,让用户通过set自己选
    private UserDao userDa;
    public void setUserDa(UserDao userDao) {
        this.userDa = userDao;
    }

    public void getUser() {
        userDa.GetName();
    }
}
