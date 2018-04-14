package com.gupao.peter.showme.generatemybatis;


public class BootstrapTestMybatis {

    public static void main(String[] args) {
        PeterSqlSession sqlSession = new PeterSqlSession(new PeterConfiguration(),new SamplePeterExecutor());
        PeterUserInfoMapper peterUserInfoMapper = sqlSession.getMapper(PeterUserInfoMapper.class);
        PeterUserInfo peterUserInfo = peterUserInfoMapper.selectByPrimaryKey(1);
        System.out.println(peterUserInfo);
    }

}
