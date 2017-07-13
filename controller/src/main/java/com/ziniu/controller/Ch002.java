package com.ziniu.controller;



import com.ziniu.controller.commons.CommonsProperties;
import com.ziniu.service.Impl.HelloServcice;
import com.ziniu.service.jms.queue.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.constraints.Size;

/**
 * Created by hzqiuxm on 2016/12/21 0021.
 */
@RestController //等价于@Controller和RequestBody
@SpringBootApplication() //开启组件扫描和自动配置
@EnableAutoConfiguration
public class Ch002 {

    @Value("${book.author}")
    private String bookAuthor;
    @Value("${book.name}")
    private String bookName;

    @Autowired
    private CommonsProperties commonsProperties;
    @Autowired
    private HelloServcice helloServcice;
    @Autowired
    MessageSender messageSender;

    @RolesAllowed("ROLE_ADMIN")
    @RequestMapping("/qiuxm")
    String index() {

        System.out.println("-------");
        return "book name is " + bookName + " and book222333 author is " + bookAuthor + helloServcice.sayHello()
                + " ziniu's properties :" + commonsProperties.getYinyoushiren()
                + commonsProperties.getDefaultjms() + commonsProperties.getGoldjms();
    }

    //spring Boot默认使用的json解析框架是jackson
    @RequestMapping("/getContact")
    Contact getPerson(){
        Contact contact = new Contact();

        contact.setId(100L);
        contact.setFirstName("邱");
        contact.setLastName("晓敏");
        contact.setEmail("hzqiuxm@163.com");

        return contact;


    }

    @RequestMapping("/sendMsg/{typeId}")
    String sendMsg(@PathVariable("typeId") int typeId){

        String message = "我是一条测试消息";
        if(1==typeId){
            message = "我是一条很重要的消息!";
        }
        messageSender.sendMessage(message,typeId);

        return "消息发送成功!消息类型是：" + typeId;


    }

//    @RequestMapping(value = "/getuser",method = RequestMethod.GET)
//    @ResponseBody
//    public String getUserInfo(@RequestParam("name") String name){
//        System.out.println("name = " + name);
//        ZnUserBase znUserBase = new ZnUserBase();
//        znUserBase.setUserName(name);
//
//        znUserBase = iUserService.getUserByCondition(znUserBase);
//        return znUserBase.getEmail();
////          return "ok";
//    }
//
//    @RequestMapping(value = "/getname",method = RequestMethod.GET)
//    @ResponseBody
//    public String getname(@RequestParam("id") long id){
//
//        System.out.println("--------id = " + id);
//        ZnUserBase znUserBase = new ZnUserBase();
//        znUserBase = iUserService.getUserById((int) id);
//        return znUserBase.getNickName();
//    }
//
//    @RequestMapping(value = "/adduser",method = RequestMethod.GET)
//    public void addUserInfo(){
//
//        ZnUserBase znUserBase = new ZnUserBase();
//        znUserBase.setEmail("haoshijin@ziniuxiaozhu.com");
//        znUserBase.setUserName("youman");
//        znUserBase.setNickName("好事近");
//
//        znUserBaseService.insert(znUserBase);
//    }

    @RequestMapping(value = "/showPerson",method = RequestMethod.GET)
    @Validated
    public String showPerson(@RequestParam("spId") @Size() long spId){

        System.out.println("The spId is : " +spId);
        if(100L == spId){
            System.out.println("That's my number!");
        }

        return "hello"+spId;
    }

    @RequestMapping(value = "/queryPerson/{spId}",method = RequestMethod.GET)
    public String queryPerson(@PathVariable("spId") long spId){ //"spId"和参数spId同名时其实可以省略

        System.out.println("The query param is : " +spId);

        return "query"+spId;
    }

    @RequestMapping(value = "/getec",method = RequestMethod.GET)
    public String getec(){

        System.out.println("getec()..............");
        int a;
        a = 1/0;
        return "Exception Test!";

    }


    public static void main(String[] args) {
        SpringApplication.run(Ch002.class,args);
    }


}
