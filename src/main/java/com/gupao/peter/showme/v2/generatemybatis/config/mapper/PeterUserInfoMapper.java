package com.gupao.peter.showme.v2.generatemybatis.config.mapper;

import com.gupao.peter.showme.v2.generatemybatis.annotations.Select;
import com.gupao.peter.showme.v2.generatemybatis.bean.PeterUserInfo;

public interface PeterUserInfoMapper {

    @Select("select * from user_info where id = %s")
    PeterUserInfo selectByPrimaryKey(Integer id);

}