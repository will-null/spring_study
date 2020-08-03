import AOP.ChouXiang;
import AOP.DongProxy;
import AOP.JingProxy;
import AOP.ZhenShi;
import AllZhuJie.service.IOCandAOPofService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPtest {

    /*静态代理
    * 真实角色（被代理角色）不需要关注公共的业务或者要扩展的业务，比如给真实角色增加校验，或日志等一系列功能
    * 公共业务交给代理角色，把真实角色增加的功能交由代理来做，实现业务分工
    * 公共业务拓展的时候，方便集中管理
    * */
    @Test
    public void JingTai(){
        //房东只是要出租房子
        ZhenShi zhenShi=new ZhenShi();
        //中介会添加自己的附属操作，比如签合同，收中介费
        JingProxy jingProxy=new JingProxy(zhenShi);
        //不用面对房东，
        jingProxy.ZuFang();
    }

    /*动态代理
    *代理的是接口，不是实现类
    * */
    @Test
    public void DongTai(){
        // getInstance 动态生成代理角色
        ChouXiang chouXiang=(ChouXiang) new DongProxy().getInstance(new ZhenShi());
        chouXiang.ZuFang();
    }


    @Test
    public void aopStudy(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        IOCandAOPofService i= (IOCandAOPofService) applicationContext.getBean("ioCandAOPofService");
        i.add();
    }
}
