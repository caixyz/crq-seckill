package org.crq.sk.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.crq.sk.bean.Goods;
import org.crq.sk.bean.Order;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}
