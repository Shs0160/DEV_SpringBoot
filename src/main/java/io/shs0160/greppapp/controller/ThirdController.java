package io.shs0160.greppapp.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

@Slf4j
@Controller
public class ThirdController {

    @GetMapping("/params1")
    public String showParams1(
            HttpServletRequest req
    ) {
        String name = req.getParameter("name");
        log.info("name = {}", name);

        //파라미터 키랑 value를 배열로 반환
        Map<String, String[]> parameterMap = req.getParameterMap();

        Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();

        //for (Map.Entry<String, String[]> entry : entries) {
        //    log.info("{} = {}", entry.getKey(), Arrays.toString(entry.getValue()));
        //}

        parameterMap.forEach((key, values) -> {
            log.info("key = {}, values = {}", key, Arrays.toString(values));
        });

        return "index";
    }

    @GetMapping("/params2")
    public String showParams2(@RequestParam(name = "name") String name){
        log.info("name = {}", name);
        return "index";
    }

    @GetMapping("/params3")
    public String showParams3(
            //기본값 부여 가능
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "age", required = false, defaultValue = "1") String age
    ){
        //값을 안주면 null로 들어감
        log.info("name = {}", name);
        log.info("age = {}", age);
        return "index";
    }

    @GetMapping("/params4")
    public String showParams4 (String name){
        log.info("name = {}", name);
            return "index";
    }
}




