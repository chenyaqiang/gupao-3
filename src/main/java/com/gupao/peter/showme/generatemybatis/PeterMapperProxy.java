package com.gupao.peter.showme.generatemybatis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PeterMapperProxy implements InvocationHandler {

    private PeterSqlSession sqlSession;

    public PeterMapperProxy(PeterSqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("method.getDeclaringClass():" + method.getDeclaringClass().getName());
        if (method.getDeclaringClass().getName().equals(PeterConfiguration.PeterInfoMapperRegister.namespace)) {
            String sql = PeterConfiguration.PeterInfoMapperRegister.map.get(method.getName());
            return sqlSession.selectOne(sql, String.valueOf(args[0]));
        }
        return method.invoke(sqlSession, args);
    }
}
