package com.gupao.peter.showme.v2.generatemybatis.proxy;

import com.gupao.peter.showme.v2.generatemybatis.config.MapperMethod;
import com.gupao.peter.showme.v2.generatemybatis.config.PeterConfiguration;
import com.gupao.peter.showme.v2.generatemybatis.sqlsession.PeterSqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PeterMapperProxy implements InvocationHandler {

    private PeterSqlSession sqlSession;

    private Class clazz;

    public PeterMapperProxy(PeterSqlSession sqlSession, Class clazz) {
        this.sqlSession = sqlSession;
        this.clazz = clazz;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        MapperRegister.MapperData mapperData = sqlSession.getConfiguration().getMapperRegister().get(
//                method.getDeclaringClass().getName() + "." + method.getName()
//        );
//        if (mapperData != null) {
//            System.out.println(String.format("SQL [%s] ,parameter [%s]", mapperData.getSql(), args[0]));
//            return sqlSession.selectOne(mapperData, String.valueOf(args[0]));
//        }
        MapperMethod mapperMethod = sqlSession.getConfiguration().getMapperStatement().getMapperMethod(method.getDeclaringClass().getName() + "." + method.getName());
        if (mapperMethod != null) {
            System.out.println(String.format("SQL:{%s},ResultType:{%s},parameter:{%s}",mapperMethod.getSql(),mapperMethod.getType(),args[0]));
            return sqlSession.selectOne(mapperMethod,args[0]);
        }
        return method.invoke(sqlSession, args);
    }
}
