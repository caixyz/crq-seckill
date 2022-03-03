package org.crq.sk.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author cai si jun
 * @date 2022/3/2 16:02
 */
@Data
@AllArgsConstructor
@TableName(value = "t_order")//指定表名
public class Order {
    private static final long serialVersionUID = -5644799954031156649L;
    //value与数据库主键列名一致，若实体类属性名与表主键列名一致可省略value
    @TableId(value = "id", type = IdType.AUTO)//指定自增策略
    private Integer id;

    private String userName;
    private Integer goodsId;
    private String msg;
}
