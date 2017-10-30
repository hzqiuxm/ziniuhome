package com.ziniu.control;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import com.ziniu.data.entity.Res;
import com.ziniu.data.entity.Test;
import com.ziniu.data.repository.ResRepository;
import com.ziniu.data.repository.TestRepository;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * Created by yeoman on 2017/3/13.
 */
@Controller
@EnableEncryptableProperties
public class TestController extends BaseController{


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

    @Autowired
    private TestRepository testRepository;

    @PostMapping("/addTest")
    @ResponseBody
    public ModelMap addTest(){
        Test test = new Test();
        test.setStr("测试数据");
        test.setNum(123);
        test.setNumLong(456789);
        test.setB((byte)5);
        test.setGmt(new Date());
        return getSuccessResult(testRepository.insert(test));
    }

    @GetMapping("/getTests")
    @ResponseBody
    public ModelMap getTests(){
        List<Test> list = testRepository.findAll();
        for (Test t : list){
            System.out.println(t.toString());
        }
        return getSuccessResult(list);
    }

    @Autowired
    private ResRepository resRepository;

    @PostMapping("/addRes")
    @ResponseBody
    public ModelMap addRes(){
        Res res = new Res();
        res.setBucket("test-file");
        res.setFileKey("test/file1");
        res.setUrl("http://ovft3n4xt.bkt.clouddn.com/test/file1");
        return getSuccessResult(resRepository.insert(res));
    }

    @GetMapping("/getReses")
    @ResponseBody
    public ModelMap getReses(){
        List<Res> list = resRepository.findAll();
        for (Res t : list){
            System.out.println(t);
            System.out.println(resRepository.findByFileKey(t.getFileKey()));
        }
        return getSuccessResult(list);
    }

    @GetMapping("/getResByFileKey")
    @ResponseBody
    public ModelMap getResByFileKey(String fileKey){
        Res res = resRepository.findByFileKey(fileKey);//这个可以
        System.out.println(res);
        return getSuccessResult(res);
    }

}