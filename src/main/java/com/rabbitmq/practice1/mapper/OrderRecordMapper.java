package com.rabbitmq.practice1.mapper;

import com.rabbitmq.practice1.entity.OrderRecord;

import java.util.List;

public interface OrderRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderRecord record);

    int insertSelective(OrderRecord record);

    OrderRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderRecord record);

    int updateByPrimaryKey(OrderRecord record);

    List<OrderRecord> selectAll();
}