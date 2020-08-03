package AOP;

//静态代理
//缺点：每增加一个真实角色就需要增加一个代理角色来代理，会增加代码量
//代理角色
public class JingProxy implements ChouXiang {

    private ZhenShi zhenShi;

    public JingProxy() {
    }

    public JingProxy(ZhenShi zhenShi) {
        this.zhenShi = zhenShi;
    }

    //真实角色（房东）只是想要出租房屋，代理角色可以给这一需求添加自己的项目（看房，收中介费等）
    //代码的设计原则是新增加的业务或功能尽可能不去改动以前的代码
    //所以把这个功能放在代理中修改
    public void ZuFang() {
        log();
        KanFang();
        HeiXin();
        zhenShi.ZuFang();
    }

    public void KanFang() {
        System.out.println("带你看房子");
    }

    public void HeiXin() {
        System.out.println("收你中介费");
    }

    public void log() {
        System.out.println("增加一个日志功能");
    }
}
