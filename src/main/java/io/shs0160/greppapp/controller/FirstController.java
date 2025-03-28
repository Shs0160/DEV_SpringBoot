package io.shs0160.greppapp.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
@Controller
public class FirstController {


    @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    public void receiveRequest() {
      log.info("Hello World");
    }

    @GetMapping("/get")
    public void printGet(HttpServletResponse resp) throws Exception {

        log.info("안녕하세요");
        //응답 본문에 글자가 들어감
        PrintWriter writer = resp.getWriter();
        writer.println("Hello World");
    }

    @GetMapping("/get2")
    public void printGet2(HttpServletResponse resp) throws Exception {

        log.info("안녕하세요");

        resp.setContentType("text/html;charset=UTF-8");
        //응답 본문에 글자가 들어감
        PrintWriter writer = resp.getWriter();
        writer.println("안녕 세상아!");
    }

    @ResponseBody
    @GetMapping("/get3") //엔드포인트
    public String printGet3(){
        //data를 반환
        return "안녕하세요!";
    }

    @ResponseBody //반환하는 타입에 따라서 String -> text/html 그 외 -> application/JSON
    @GetMapping("/print-integer") //엔드포인트
    public Integer printInteger(){
        //data를 반환
        return 1;
    }

    @Getter
    class SomeType{
        private final String data = "데이터";
    }

    @ResponseBody //반환하는 타입에 따라서 String -> text/html 그 외 -> application/JSON
    @GetMapping("/print-obj") //엔드포인트
    public SomeType printObj(){
        //data를 반환
        return new SomeType();
    }

    @ResponseBody
    @GetMapping("/print-string") //엔드포인트
    public String printSomething(){
        //data를 반환
        return "";
    }



}
