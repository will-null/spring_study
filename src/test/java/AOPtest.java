import AOP.ChouXiang;
import AOP.DongProxy;
import AOP.JingProxy;
import AOP.ZhenShi;
import AllZhuJie.service.IOCandAOPofService;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

public class AOPtest {
    @Autowired
    ZhenShi zhenShi;

    @Autowired
    IOCandAOPofService ioCandAOPofService;

    /*静态代理
     * 真实角色（被代理角色）不需要关注公共的业务或者要扩展的业务，比如给真实角色增加校验，或日志等一系列功能
     * 公共业务交给代理角色，把真实角色增加的功能交由代理来做，实现业务分工
     * 公共业务拓展的时候，方便集中管理
     * */
    @Test
    public void JingTai() {
        //房东只是要出租房子
        //ZhenShi zhenShi = new ZhenShi();
        //中介会添加自己的附属操作，比如签合同，收中介费
        JingProxy jingProxy = new JingProxy(zhenShi);
        //不用面对房东，
        jingProxy.ZuFang();

        // ChouXiang chouXiang=new JingProxy();
        // chouXiang.ZuFang();

    }

    /*动态代理
     *代理的是接口，不是实现类
     * */
    @Test
    public void DongTai() {
        // getInstance 动态生成代理角色
        ChouXiang chouXiang = (ChouXiang) new DongProxy().getInstance(new ZhenShi());
        chouXiang.ZuFang();
    }


    @Test
    public void aopStudy() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        IOCandAOPofService i = (IOCandAOPofService) applicationContext.getBean("ioCandAOPofService");
        i.add();
      //ioCandAOPofService.add();
    }

    @Test
    public void getInputStream() throws IOException {

        // 创建Client
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 参数
        StringBuffer params = new StringBuffer();


        // 字符数据最好encoding以下;这样一来，某些特殊字符才能传过去(如:某人的名字就是“&”,不encoding的话,传不过去)
            /*params.append("ie=" + URLEncoder.encode("&", "utf-8"));
            params.append("&");
            params.append("tn=monline_7_dg");*/
        params.append("wd=ba");


        // 创建Post请求
        HttpPost httpPost = new HttpPost("https://www.baidu.com/baidu" + "?" + params);

        // 设置ContentType(注:如果只是传普通参数的话,ContentType不一定非要用application/json)
        httpPost.setHeader("Content-Type", "application/json;charset=utf8");

        // 响应模型
        CloseableHttpResponse response = null;
        try {
            // 由客户端执行(发送)Post请求
            response = httpClient.execute(httpPost);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();

            System.out.println("响应状态为:" + response.getStatusLine());
            if (responseEntity != null) {
                System.out.println("响应内容长度为:" + responseEntity.getContentLength());
                System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        /*// 设置连接超时时间为10秒（连接初始化时间）
        client.getHttpConnectionManager().getParams()
                .setConnectionTimeout(10000);
        // 读取超时
        client.getHttpConnectionManager().getParams().setSoTimeout(10000);
        // 创建方法Get
        GetMethod method = new GetMethod(url);
        // 设置字节头
        method.addRequestHeader("Content-Type",
                "application/pdf; charset=GB2312");
        // 执行访问
        client.executeMethod(method);
        int statusCode = method.getStatusCode();
        if (statusCode==200) {
            // 获取文件流
            inStream = method.getResponseBodyAsStream();
        }else {
            BusinessException be= new BusinessException();
            be.setCode(String.valueOf(statusCode));
            throw be;
        }*/
    }

}
