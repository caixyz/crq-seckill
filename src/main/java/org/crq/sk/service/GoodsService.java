package org.crq.sk.service;

import org.crq.sk.bean.Goods;

import java.util.List;

public interface GoodsService {
    List<Goods> list();
    boolean update(Goods goods);
}
