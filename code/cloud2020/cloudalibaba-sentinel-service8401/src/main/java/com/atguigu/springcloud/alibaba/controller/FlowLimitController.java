package com.atguigu.springcloud.alibaba.controller;

import cn.hutool.core.bean.BeanUtil;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ns
 * @date 2021/3/5
 */
@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {

        return "-------testA";
    }

    @GetMapping("/testB")
    public String testB() {

        return "-------testB";
    }

    public static void resetList(List list , Object value){
        list.clear();
        list.add(value);
    }
    public static void main(String[] args) {
        User user = new User();
        ArrayList<String> data = new ArrayList<>();
        data.add("123");
        user.setData(data);

        System.out.println("user = " + user);

        User userNew = user;
        System.out.println("userNew = " + userNew);
        System.out.println();

        System.out.println("user before resetList = " + user);
        System.out.println("userNew before resetList = " + userNew);
        System.out.println();
        resetList(userNew.getData(), "22");
        System.out.println("user after resetList = " + user);
        System.out.println("userNew after resetList = " + userNew);
        System.out.println();
        userNew = new User();

        System.out.println("user before copy = " + user);
        System.out.println("userNew new again = " + userNew);

        System.out.println();
        System.out.println("user copyProperties = " + user);
        System.out.println("userNew copyProperties = " + userNew);


    }
}

@Data
class User {
    private List<String> data;
}

