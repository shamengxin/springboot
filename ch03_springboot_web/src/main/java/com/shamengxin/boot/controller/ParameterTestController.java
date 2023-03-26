package com.shamengxin.boot.controller;

import com.shamengxin.boot.bean.Person;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParameterTestController {

    @PostMapping("/saveuser")
    public Person saveUser(Person person){
        return person;
    }

    @GetMapping("/car/{id}/owner/{username}")
    public Map<String,Object> getCar(@PathVariable("id") Integer id,
                                     @PathVariable("username") String name,
                                     @PathVariable Map<String , String> pv,
                                     @RequestHeader("Accept") String accept,
                                     @RequestHeader Map<String , String> header,
                                     @RequestParam("age") Integer age,
                                     @RequestParam("inters") List<String> inters,
                                     @RequestParam Map<String,String> params,
                                     @CookieValue("Idea-749b3554") String value,
                                     @CookieValue("Idea-749b3554") Cookie cookie){

        HashMap<String, Object> map = new HashMap<>();

        // map.put("id",id);
        // map.put("name",name);
        // map.put("pv",pv);
        // map.put("accept",accept);
        // map.put("header",header);
        map.put("age",age);
        map.put("inters",inters);
        map.put("params",params);
        map.put("value",value);
        System.out.println(cookie);
        return map;
    }

    @PostMapping("/save")
    public Map postMethod(@RequestBody String content){
        HashMap<String, Object> map = new HashMap<>();

        map.put("content",content);

        return map;
    }

    @GetMapping("/cars/{path}")
    public Map carSell(@MatrixVariable("low") Integer low,
                       @MatrixVariable("brand") List<String> brand,
                       @PathVariable("path") String path){

        Map<String,Object> map = new HashMap<>();
        map.put("low",low);
        map.put("hrand",brand);
        map.put("path",path);
        return map;

    }
    
    @GetMapping("/boss/{bossId}/{empId}")
    public Map booss(@MatrixVariable(value = "age",pathVar = "bossId") Integer bossAge,
                     @MatrixVariable(value = "age",pathVar = "empId") Integer empAge){
        Map<String,Object> map = new HashMap<>();
        map.put("bossAge",bossAge);
        map.put("empAge",empAge);
        return map;
    }

}
