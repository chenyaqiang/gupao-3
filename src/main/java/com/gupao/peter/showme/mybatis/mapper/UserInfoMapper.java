package com.gupao.peter.showme.mybatis.mapper;

import com.gupao.peter.showme.mybatis.beans.UserInfo;
import com.gupao.peter.showme.mybatis.beans.UserInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserInfoMapper {
    int countByExample(UserInfoExample example);

    int deleteByExample(UserInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    List<UserInfo> selectByExample(UserInfoExample example);

    UserInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    int updateByExample(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
}