package org.crq.sk.controller;

import org.crq.sk.bean.Goods;
import org.crq.sk.bean.Order;
import org.crq.sk.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author cai si jun
 * @date 2022/3/2 17:02
 */
@RestController
public class OderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/sk")
    public List<String> sk() {
        List<String> list = new CopyOnWriteArrayList<>();
        List<String> users = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            users.add("张" + i);
        }
        Goods goods = new Goods(1, "iphone4s", 5);

        users.parallelStream().forEach(u -> {
            Order order = new Order(1, u, 1);
            String msg = orderService.sk(goods, order);
            list.add(msg);
        });

        return list;
    }

}
