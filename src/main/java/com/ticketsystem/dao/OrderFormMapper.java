package com.ticketsystem.dao;

import com.ticketsystem.model.OrderForm;
import com.ticketsystem.model.OrderFormExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderFormMapper {
    @SelectProvider(type=OrderFormSqlProvider.class, method="countByExample")
    long countByExample(OrderFormExample example);

    @DeleteProvider(type=OrderFormSqlProvider.class, method="deleteByExample")
    int deleteByExample(OrderFormExample example);

    @Delete({
        "delete from order_form",
        "where order_form_id = #{orderFormId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer orderFormId);

    @Insert({
        "insert into order_form (order_form_id, user_id, ",
        "ticket_number, total_price, ",
        "order_time)",
        "values (#{orderFormId,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
        "#{ticketNumber,jdbcType=DECIMAL}, #{totalPrice,jdbcType=REAL}, ",
        "#{orderTime,jdbcType=TIMESTAMP})"
    })
    int insert(OrderForm record);

    @InsertProvider(type=OrderFormSqlProvider.class, method="insertSelective")
    int insertSelective(OrderForm record);

    @SelectProvider(type=OrderFormSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="order_form_id", property="orderFormId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="ticket_number", property="ticketNumber", jdbcType=JdbcType.DECIMAL),
        @Result(column="total_price", property="totalPrice", jdbcType=JdbcType.REAL),
        @Result(column="order_time", property="orderTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<OrderForm> selectByExample(OrderFormExample example);

    @Select({
        "select",
        "order_form_id, user_id, ticket_number, total_price, order_time",
        "from order_form",
        "where order_form_id = #{orderFormId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="order_form_id", property="orderFormId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="ticket_number", property="ticketNumber", jdbcType=JdbcType.DECIMAL),
        @Result(column="total_price", property="totalPrice", jdbcType=JdbcType.REAL),
        @Result(column="order_time", property="orderTime", jdbcType=JdbcType.TIMESTAMP)
    })
    OrderForm selectByPrimaryKey(Integer orderFormId);

    @UpdateProvider(type=OrderFormSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OrderForm record, @Param("example") OrderFormExample example);

    @UpdateProvider(type=OrderFormSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OrderForm record, @Param("example") OrderFormExample example);

    @UpdateProvider(type=OrderFormSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OrderForm record);

    @Update({
        "update order_form",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "ticket_number = #{ticketNumber,jdbcType=DECIMAL},",
          "total_price = #{totalPrice,jdbcType=REAL},",
          "order_time = #{orderTime,jdbcType=TIMESTAMP}",
        "where order_form_id = #{orderFormId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(OrderForm record);
}