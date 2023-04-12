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
    public void getRandomImage(HttpServletResponse response) {
        String url = "https://#";
//        String path = System.getProperty("user.home") + "/zfile/file/HelloKitty/
        String path = "/kitty/";
        System.out.println(path);
        String preString = "https://oss.dandaner.cn/publicshare/HelloKitty/";
        File file = new File(path);
        File[] files = file.listFiles();
        if (files != null) {
            if (NUM <= files.length - 1) {
                System.out.println(files[NUM].getName());
                url = preString + files[NUM].getName();
                NUM++;
            } else {
                NUM = 0;
                url = preString + files[NUM].getName();
            }
        }
        try {
            response.sendRedirect(url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
