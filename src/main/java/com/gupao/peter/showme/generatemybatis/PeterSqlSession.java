package com.gupao.peter.showme.generatemybatis;

public class PeterSqlSession {

    private PeterConfiguration configuration;

    private PeterExecutor executor;

    public PeterSqlSession(PeterConfiguration configuration, PeterExecutor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    public <T> T getMapper(Class<T> clazz) {
        return configuration.getMapper(clazz,this);
    }

    public <T> T selectOne(String statement,String parameter) {
        return executor.query(statement,parameter);
    }

}
