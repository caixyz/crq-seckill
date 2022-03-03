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

    /**
     * 抢购 功能
     * synchronized 为非公平 自动加解锁
     * ReentrantLock 默认为非公平 true
     * @param goods
     * @param order
     */
    @Override
    public synchronized void sk(Goods goods, Order order) {
        //lock.lock();
        String msg = "";

        //1.查询库存
        Goods goodsTmp = goodsMapper.selectById(goods.getId());

        if (goodsTmp.getQuantity() > 0) {
            //2.减去库存
            goodsTmp.setQuantity(goodsTmp.getQuantity() - 1);
            goodsMapper.updateById(goodsTmp);
            msg = order.getUserName() + "get " + goods.getGoodsName()+"库存"+goodsTmp.getQuantity();
        } else {
            msg =  order.getUserName() + " 无库存了";
        }
        order.setMsg(msg);
        //lock.unlock();

    }


}
