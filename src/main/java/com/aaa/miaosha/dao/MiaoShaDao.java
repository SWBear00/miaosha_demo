package com.aaa.miaosha.dao;

import com.aaa.miaosha.entity.MiaoShaUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * auditor:白帅
 * Date:${Date}${Time}
 **/
@Mapper
public interface MiaoShaDao {

    @Select("select * from login where nickname=#{id}")
    public MiaoShaUser getById(@Param("id")long id);

    @Update("update login set password=#{password} where nickname=#{id}")
    void updatePassword(MiaoShaUser toBeUpdate);
}