package com.ziniu.controller;



import com.ziniu.domain.ZnUserBase;
import com.ziniu.service.HelloServcice;
import com.ziniu.service.ZnUserBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    private HelloServcice helloServcice;
    @Autowired
    private ZnUserBaseService znUserBaseService;

    @RequestMapping("/qiuxm")
    String index() {

        return "book name is " + bookName + " and book author is " + bookAuthor + helloServcice.sayHello();
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

    @RequestMapping(value = "/getuser",method = RequestMethod.GET)
    @ResponseBody
    public String getUserInfo(@RequestParam("name") String name){
        System.out.println("name = " + name);
        List<ZnUserBase> znUserBases;
        znUserBases = znUserBaseService.getUser(name);
        return znUserBases.get(0).getNickName();
    }

    @RequestMapping(value = "/adduser",method = RequestMethod.GET)
    public void addUserInfo(){

        ZnUserBase znUserBase = new ZnUserBase();
        znUserBase.setEmail("haoshijin@ziniuxiaozhu.com");
        znUserBase.setUserName("youman");
        znUserBase.setNickName("好事近");

        znUserBaseService.insert(znUserBase);
    }

    @RequestMapping(value = "/showPerson",method = RequestMethod.GET)
    public String showPerson(@RequestParam("spId") long spId){

        System.out.println("The spId is : " +spId);
        if(100l == spId){
            System.out.println("That's my number!");
        }

        return "hello"+spId;
    }

    @RequestMapping(value = "/queryPerson/{spId}",method = RequestMethod.GET)
    public String queryPerson(@PathVariable("spId") long spId){ //"spId"和参数spId同名时其实可以省略

        System.out.println("The query param is : " +spId);

        return "query"+spId;
    }


    public static void main(String[] args) {
        SpringApplication.run(Ch002.class,args);
    }


}
