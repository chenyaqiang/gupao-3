package com.gupao.peter.showme.v2.generatemybatis.sqlsession;

import com.gupao.peter.showme.v2.generatemybatis.config.MapperMethod;
import com.gupao.peter.showme.v2.generatemybatis.config.MapperRegister;
import com.gupao.peter.showme.v2.generatemybatis.config.PeterConfiguration;
import com.gupao.peter.showme.v2.generatemybatis.executor.PeterExecutor;
import com.gupao.peter.showme.v2.generatemybatis.proxy.PeterMapperProxy;

import java.lang.reflect.Proxy;

public class PeterSqlSession {

    private PeterConfiguration configuration;

    private PeterExecutor executor;

    public PeterSqlSession(PeterConfiguration configuration, PeterExecutor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    public PeterConfiguration getConfiguration() {
        return configuration;
    }

    public <T> T getMapper(Class<T> clazz) {
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new PeterMapperProxy(this,clazz));
    }

    public <T> T selectOne(MapperRegister.MapperData statement, Object parameter) throws Exception {
        return executor.query(statement, parameter);
    }

    public <T> T selectOne(MapperMethod mapperMethod, Object parameter) throws Exception {
        return executor.query(mapperMethod, parameter);
    }

}
