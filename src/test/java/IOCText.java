import AllZhuJie.model.User;
import IOC.dao.Alden;
import IOC.dao.Jack;
import IOC.service.UserService;
import IOC.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCText {

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

    @Test  /*设值注入与构造注入*/
    public void springIOC() {
        //ClassPathXmlApplicationContext读取配置文件,可以同时解析多个xml
        //配置文件加载的时候,spring容器(配置文件)就开始初始化被托管的bean了（每个bean都只有一份实例）
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //把bean的控制权交给spring,不需要再new了,直接用spring容器.getBean()就可以得到想要的对象
        Alden alden =(Alden)applicationContext.getBean("aldenOfSet");
        System.out.println(alden.toString());
    }

    @Test  /*注解*/
    public void springZhuJie() {
        //ClassPathXmlApplicationContext读取配置文件,可以同时解析多个xml
        //配置文件加载的时候,spring容器(配置文件)就开始初始化被托管的bean了（每个bean都只有一份实例）
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //把bean的控制权交给spring,不需要再new了,直接用spring容器.getBean()就可以得到想要的对象
        User alden =(User)applicationContext.getBean("user");
        System.out.println(alden.name);
    }

}
