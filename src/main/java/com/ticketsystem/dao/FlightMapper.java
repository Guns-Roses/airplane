package com.ticketsystem.dao;

import com.ticketsystem.model.Flight;
import com.ticketsystem.model.FlightExample;
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
public interface FlightMapper {
    @SelectProvider(type=FlightSqlProvider.class, method="countByExample")
    long countByExample(FlightExample example);

    @DeleteProvider(type=FlightSqlProvider.class, method="deleteByExample")
    int deleteByExample(FlightExample example);

    @Delete({
        "delete from flight",
        "where flight_id = #{flightId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer flightId);

    @Insert({
        "insert into flight (flight_id, start_time, ",
        "start_city, end_city, people_number, ",
        "left_ticket, ticket_price)",
        "values (#{flightId,jdbcType=INTEGER}, #{startTime,jdbcType=TIMESTAMP}, ",
        "#{startCity,jdbcType=CHAR}, #{endCity,jdbcType=CHAR}, #{peopleNumber,jdbcType=DECIMAL}, ",
        "#{leftTicket,jdbcType=DECIMAL}, #{ticketPrice,jdbcType=REAL})"
    })
    int insert(Flight record);

    @InsertProvider(type=FlightSqlProvider.class, method="insertSelective")
    int insertSelective(Flight record);

    @SelectProvider(type=FlightSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="flight_id", property="flightId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="start_city", property="startCity", jdbcType=JdbcType.CHAR),
        @Result(column="end_city", property="endCity", jdbcType=JdbcType.CHAR),
        @Result(column="people_number", property="peopleNumber", jdbcType=JdbcType.DECIMAL),
        @Result(column="left_ticket", property="leftTicket", jdbcType=JdbcType.DECIMAL),
        @Result(column="ticket_price", property="ticketPrice", jdbcType=JdbcType.REAL)
    })
    List<Flight> selectByExample(FlightExample example);

    @Select({
        "select",
        "flight_id, start_time, start_city, end_city, people_number, left_ticket, ticket_price",
        "from flight",
        "where flight_id = #{flightId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="flight_id", property="flightId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="start_city", property="startCity", jdbcType=JdbcType.CHAR),
        @Result(column="end_city", property="endCity", jdbcType=JdbcType.CHAR),
        @Result(column="people_number", property="peopleNumber", jdbcType=JdbcType.DECIMAL),
        @Result(column="left_ticket", property="leftTicket", jdbcType=JdbcType.DECIMAL),
        @Result(column="ticket_price", property="ticketPrice", jdbcType=JdbcType.REAL)
    })
    Flight selectByPrimaryKey(Integer flightId);

    @UpdateProvider(type=FlightSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Flight record, @Param("example") FlightExample example);

    @UpdateProvider(type=FlightSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Flight record, @Param("example") FlightExample example);

    @UpdateProvider(type=FlightSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Flight record);

    @Update({
        "update flight",
        "set start_time = #{startTime,jdbcType=TIMESTAMP},",
          "start_city = #{startCity,jdbcType=CHAR},",
          "end_city = #{endCity,jdbcType=CHAR},",
          "people_number = #{peopleNumber,jdbcType=DECIMAL},",
          "left_ticket = #{leftTicket,jdbcType=DECIMAL},",
          "ticket_price = #{ticketPrice,jdbcType=REAL}",
        "where flight_id = #{flightId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Flight record);
}