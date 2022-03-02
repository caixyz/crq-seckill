package org.crq.sk.service.impl;

import org.apache.ibatis.annotations.Mapper;
import org.crq.sk.bean.Goods;
import org.crq.sk.bean.Order;
import org.crq.sk.mapper.GoodsMapper;
import org.crq.sk.mapper.OrderMapper;
import org.crq.sk.service.GoodsService;
import org.crq.sk.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 订单服务
 * @author cai si jun
 * @date 2022/3/2 16:12
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private GoodsMapper goodsMapper;


    @Override
    public List<Order> list(Goods goods) {
        return orderMapper.selectList(null);
    }

    @Override
    public boolean update(Order order) {
        return orderMapper.updateById(order) > 0 ? true : false;
    }

    Lock lock = new ReentrantLock(true);

    @Override
    public String sk(Goods goods, Order order) {
        lock.lock();
        String msg = "";

        //1.查询库存
        Goods goodsTmp = goodsMapper.selectById(goods.getId());
        if (goodsTmp.getQuantity() > 0) {
            //2.减去库存
            goods.setQuantity(goods.getQuantity() - 1);
            goodsMapper.updateById(goods);
            msg = order.getUserName() + "抢到了" + goods.getGoodsName();
        } else {
            msg =  order.getUserName() + "请求 无库存了";
        }
        lock.unlock();
        return msg;
    }


}
