package com.ziniu.controller;



import com.ziniu.controller.commons.CommonsProperties;
import com.ziniu.service.Impl.HelloServcice;
import com.ziniu.service.jms.queue.MessageSender;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
@Api(description = "这是一个测试类接口，没有什么卵用")
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

    @ApiOperation(value="获取一些配置文件中的属性值", notes="我是notes!")
    @RolesAllowed("ROLE_ADMIN")
    @RequestMapping(value = "/qiuxm",method = RequestMethod.GET)
    String index() {

        System.out.println("-------");
        return "book name is " + bookName + " and book222333 author is " + bookAuthor + helloServcice.sayHello()
                + " ziniu's properties :" + commonsProperties.getYinyoushiren()
                + commonsProperties.getDefaultjms() + commonsProperties.getGoldjms();
    }

    //spring Boot默认使用的json解析框架是jackson
    @RequestMapping(value = "/getContact",method = RequestMethod.GET)
    Contact getPerson(){
        Contact contact = new Contact();

        contact.setId(100L);
        contact.setFirstName("邱");
        contact.setLastName("晓敏");
        contact.setEmail("hzqiuxm@163.com");

        return contact;


    }

    @ApiOperation(value = "这是一个测试MQ消息的发送接口",notes = "notes这次提醒你，这个接口是有参数的")
    @ApiImplicitParam(name = "typeId",value = "消息类型，只有1是紧急消息",dataType = "int",paramType = "path")
    @RequestMapping(value = "/sendMsg/{typeId}",method = RequestMethod.PUT)
    String sendMsg(@PathVariable("typeId") int typeId){

//        int itypeId = Integer.valueOf(typeId);
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

    @ApiImplicitParam(name = "spId",value = "要查询的spId，100才是正确的",dataType = "long",paramType = "query")
    @RequestMapping(value = "/showPerson",method = RequestMethod.GET)
    @Validated
    public String showPerson(@RequestParam("spId") @Size() long spId){

        System.out.println("The spId is : " +spId);
        if(100L == spId){
            System.out.println("That's my number!");
        }

        return "hello"+spId;
    }

    @RequestMapping(value = "/queryPerson/{spId}",method = RequestMethod.PUT)
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
