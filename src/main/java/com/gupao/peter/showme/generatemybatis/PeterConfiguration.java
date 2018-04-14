package com.gupao.peter.showme.generatemybatis;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class PeterConfiguration {

    public <T> T getMapper(Class<T> clazz, PeterSqlSession sqlSession) {
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new PeterMapperProxy(sqlSession));
    }

    static class PeterInfoMapperRegister {

        public static final String namespace = "com.gupao.peter.showme.generatemybatis.PeterUserInfoMapper";

        public static final Map<String, String> map = new HashMap<>();

        static {
            map.put("selectByPrimaryKey", "select * from user_info where id = %s");
        }
    }
}
