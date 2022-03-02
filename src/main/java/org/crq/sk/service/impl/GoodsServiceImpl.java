package org.crq.sk.service.impl;

import org.apache.ibatis.annotations.Mapper;
import org.crq.sk.bean.Goods;
import org.crq.sk.mapper.GoodsMapper;
import org.crq.sk.service.GoodsService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品服务
 * @author cai si jun
 * @date 2022/3/2 16:12
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Mapper
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> list() {
        return goodsMapper.selectList(null);
    }

    @Override
    public boolean update(Goods goods) {
        return goodsMapper.updateById(goods) > 0 ? true : false;
    }
}
