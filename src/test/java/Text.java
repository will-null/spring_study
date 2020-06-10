import IOC.dao.Alden;
import IOC.dao.Jack;
import IOC.service.UserService;
import IOC.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Text {

    @Test
    public void first() {
        UserService userService = new UserServiceImpl();
        userService.getUser();
    }

    @Test
    public void second() {
        UserService userService = new UserServiceImpl();
        ((UserServiceImpl) userService).setUserDaoSet(new Alden());
        userService.getUserSet();
    }

    @Test
    public void springIOC() {
        //ClassPathXmlApplicationContext读取配置文件,可以同时解析多个xml
        //配置文件加载的时候,spring容器(配置文件)就开始初始化被托管的bean了
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //把bean的控制权交给spring,不需要再new了,直接用spring容器.getBean()就可以得到想要的对象
        UserServiceImpl hh = applicationContext.getBean("uImpl",UserServiceImpl.class);
        hh.getUserSet();

    }


}
