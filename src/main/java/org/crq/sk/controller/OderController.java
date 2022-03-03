package org.crq.sk.controller;

import org.crq.sk.bean.Goods;
import org.crq.sk.bean.Order;
import org.crq.sk.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Executable;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author cai si jun
 * @date 2022/3/2 17:02
 */
@RestController
public class OderController {
    @Autowired
    private OrderService orderService;

    List<String> getSKByCompletableFuture() throws ExecutionException, InterruptedException {
        Goods goods = new Goods(1, "iphone4s", 5);
        Order order1 = new Order(1, "张一", 1,"");
        List<String> skList=new CopyOnWriteArrayList<>();
        CompletableFuture<String> user01 = CompletableFuture.supplyAsync(() -> {
              orderService.sk(goods, order1);
              return order1.getMsg();
        });
        Order order2 = new Order(1, "张二", 1,"");
        CompletableFuture<String> user02 = CompletableFuture.supplyAsync(() -> {
            orderService.sk(goods, order2);
            return order2.getMsg();
        });
        Order order3 = new Order(1, "张三", 1,"");
        CompletableFuture<String> user03 = CompletableFuture.supplyAsync(() -> {
            orderService.sk(goods, order3);
            return order3.getMsg();
        });
        Order order4 = new Order(1, "张四", 1,"");
        CompletableFuture<String> user04 = CompletableFuture.supplyAsync(() -> {
            orderService.sk(goods, order4);
            return order4.getMsg();
        });
        Order order5 = new Order(1, "张5", 1,"");
        CompletableFuture<String> user05 = CompletableFuture.supplyAsync(() -> {
            orderService.sk(goods, order5);
            return order5.getMsg();
        });
        Order order6 = new Order(1, "张6", 1,"");
        CompletableFuture<String> user06 = CompletableFuture.supplyAsync(() -> {
            orderService.sk(goods, order6);
            return order6.getMsg();
        });
        Order order7 = new Order(1, "张7", 1,"");
        CompletableFuture<String> user07 = CompletableFuture.supplyAsync(() -> {
            orderService.sk(goods, order7);
            return order7.getMsg();
        });
        Order order8 = new Order(1, "张8", 1,"");
        CompletableFuture<String> user08 = CompletableFuture.supplyAsync(() -> {
            orderService.sk(goods, order8);
            return order8.getMsg();
        });
        Order order9 = new Order(1, "张9", 1,"");
        CompletableFuture<String> user09 = CompletableFuture.supplyAsync(() -> {
            orderService.sk(goods, order9);
            return order9.getMsg();
        });
        Order order10 = new Order(1, "张10", 1,"");
        CompletableFuture<String> user10 = CompletableFuture.supplyAsync(() -> {
            orderService.sk(goods, order10);
            return order10.getMsg();
        });

        skList.add("user01"+user01.get());
        skList.add("user02"+user02.get());
        skList.add("user03"+user03.get());
        skList.add("user04"+user04.get());
        skList.add("user05"+user05.get());
        skList.add("user06"+user06.get());
        skList.add("user07"+user07.get());
        skList.add("user08"+user08.get());
        skList.add("user09"+user09.get());
        skList.add("user10"+user10.get());
        return skList;
    }

    @GetMapping("/sk")
    public List<String> sk() throws ExecutionException, InterruptedException {

        List<String> list = new CopyOnWriteArrayList<>();

        list= getSKByCompletableFuture();


        return list;
    }

}
