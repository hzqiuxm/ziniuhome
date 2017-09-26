package com.ziniu.control;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yeoman on 2017/3/13.
 */
@Controller
@EnableEncryptableProperties
public class TestController {


	@GetMapping("/testGet")
    @ResponseBody
    public String testGet() {
        return "<br><p style='text-align:center;font-size:2em;'>成功！</p><div><a href='/course.html'>发布课程</a>";
    }

    @GetMapping("/restFull/{id}")
    @ResponseBody
    public String restFull(@PathVariable Long id){
        return "<br><p style='text-align:center;font-size:2em;'>成功！</p>" +
                "<p style='text-align:center;font-size:2em;'>"+id+"</p>";
    }

    @Autowired
    StringEncryptor stringEncryptor;

    @GetMapping("/encrypt/{str}")
    @ResponseBody
    public String encrypt(@PathVariable String str){
        return "<br><p style='text-align:center;font-size:2em;'>"+stringEncryptor.encrypt(str)+"</p>";
    }

    @GetMapping("/decrypt/{str}")
    @ResponseBody
    public String decrypt(@PathVariable String str){
        return "<br><p style='text-align:center;font-size:2em;'>"+stringEncryptor.decrypt(str)+"</p>";
    }

    @GetMapping("/decrypt")
    @ResponseBody
    public String decrypt1(String str){
        return "<br><p style='text-align:center;font-size:2em;'>"+stringEncryptor.decrypt(str)+"</p>";
    }

}