package cn.dandaner.imgapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * @author orange
 * @version 1.0
 */
@Controller
public class APIController {
    public static int NUM = 0;
    @GetMapping("/getRandomImage")
    public void getRandomImage(HttpServletResponse response){
        try {
            String path = System.getProperty("user.home") + "/PublicShare/website/";
            System.out.println(path);
            String preString = "https://oss.dandaner.cn/directlink/PublicShare/HelloKitty/";
            File file = new File(path);
            File[] files = file.listFiles();
            if (files != null){
                if (NUM <= files.length - 1){
                    System.out.println(files[NUM].getName());
                    response.sendRedirect(preString + files[NUM].getName());
                    NUM++;
                }else {
                    NUM = 0;
                    response.sendRedirect(preString + files[NUM].getName());
                }
            }else {
                response.sendRedirect("https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
