package com.ticketsystem.dao;

import com.ticketsystem.model.User;
import com.ticketsystem.model.UserExample;
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
public interface UserMapper {
    @SelectProvider(type=UserSqlProvider.class, method="countByExample")
    long countByExample(UserExample example);

    @DeleteProvider(type=UserSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserExample example);

    @Delete({
        "delete from user",
        "where user_id = #{userId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer userId);

    @Insert({
        "insert into user (user_id, is_manager, ",
        "user_name, user_password, ",
        "is_VIP)",
        "values (#{userId,jdbcType=INTEGER}, #{isManager,jdbcType=VARCHAR}, ",
        "#{userName,jdbcType=CHAR}, #{userPassword,jdbcType=CHAR}, ",
        "#{isVip,jdbcType=DECIMAL})"
    })
    int insert(User record);

    @InsertProvider(type=UserSqlProvider.class, method="insertSelective")
    int insertSelective(User record);

    @SelectProvider(type=UserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="is_manager", property="isManager", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.CHAR),
        @Result(column="user_password", property="userPassword", jdbcType=JdbcType.CHAR),
        @Result(column="is_VIP", property="isVip", jdbcType=JdbcType.DECIMAL)
    })
    List<User> selectByExample(UserExample example);

    @Select({
        "select",
        "user_id, is_manager, user_name, user_password, is_VIP",
        "from user",
        "where user_id = #{userId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="is_manager", property="isManager", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.CHAR),
        @Result(column="user_password", property="userPassword", jdbcType=JdbcType.CHAR),
        @Result(column="is_VIP", property="isVip", jdbcType=JdbcType.DECIMAL)
    })
    User selectByPrimaryKey(Integer userId);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(User record);

    @Update({
        "update user",
        "set is_manager = #{isManager,jdbcType=VARCHAR},",
          "user_name = #{userName,jdbcType=CHAR},",
          "user_password = #{userPassword,jdbcType=CHAR},",
          "is_VIP = #{isVip,jdbcType=DECIMAL}",
        "where user_id = #{userId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User record);
}