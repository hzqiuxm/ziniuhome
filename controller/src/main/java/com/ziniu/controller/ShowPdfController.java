package com.ziniu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by yeoman on 2017/7/27.
 */
@RestController
public class ShowPdfController {

    private static String[] cidArr = {"D:/cto培训/规划能力番外篇@菡萏如佳人.pdf",
                                    "D:/cto培训/什么才是好的规划@菡萏如佳人.pdf",
                                    "D:/cto培训/CTO内训营—技术能力篇@菡萏如佳人.pdf",
                                    "D:/cto培训/CTO内训营—规划能力篇@菡萏如佳人.pdf",
                                    "D:/cto培训/CTO内训营—认知能力篇@菡萏如佳人.pdf",
                                    "D:/cto培训/CTO内训营—学习能力篇@菡萏如佳人.pdf",
                                    "D:/cto培训/CTO内训营—沟通能力篇@菡萏如佳人.pdf",
                                    "D:/cto培训/CTO内训营—领导能力篇@菡萏如佳人.pdf"};

    @GetMapping("/showPdf/{id}")
    public void showPdf(@PathVariable Integer id, HttpServletResponse response){
        BufferedInputStream bis = null;
        try {
            id--;
            bis = new BufferedInputStream(new FileInputStream(cidArr[id]));
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/pdf");
            response.setHeader("X-Frame-Options", "SAMEORIGIN");
            ServletOutputStream os = response.getOutputStream();
            byte[] bytes = new byte[1024*1024];
            int len;
            while ((len=bis.read(bytes)) != -1){
                os.write(bytes, 0, len);
            }
            os.flush();
            os.close();
            os = null;
            bis.close();
            bis = null;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
