package org.crq.sk.service;

import org.crq.sk.bean.Goods;
import org.crq.sk.bean.Order;

import java.util.List;

public interface OrderService {
    List<Order> list(Goods goods);
    boolean update(Order order);
    String sk(Goods goods,Order order);
}
