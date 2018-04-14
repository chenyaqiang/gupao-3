package com.gupao.peter.showme.v2.generatemybatis;


import com.gupao.peter.showme.v2.generatemybatis.bean.PeterUserInfo;
import com.gupao.peter.showme.v2.generatemybatis.config.PeterConfiguration;
import com.gupao.peter.showme.v2.generatemybatis.config.mapper.PeterUserInfoMapper;
import com.gupao.peter.showme.v2.generatemybatis.executor.ExecutorFactory;
import com.gupao.peter.showme.v2.generatemybatis.executor.SamplePeterExecutor;
import com.gupao.peter.showme.v2.generatemybatis.sqlsession.PeterSqlSession;

public class Bootstrap {

    public static void main(String[] args) {
        String path = "com.gupao.peter.showme.v2.generatemybatis.config.mapper";
        PeterConfiguration configuration = new PeterConfiguration();
        configuration.scan(path);
        PeterSqlSession sqlSession = new PeterSqlSession(configuration, ExecutorFactory.defaultExecutor(configuration));
        PeterUserInfoMapper peterUserInfoMapper = sqlSession.getMapper(PeterUserInfoMapper.class);
        PeterUserInfo peterUserInfo = peterUserInfoMapper.selectByPrimaryKey(1);
        System.out.println(peterUserInfo);
    }

}
