package com.gupao.peter.showme.v2.generatemybatis.config;

public class MapperMethod {

    private Class<?> type;

    private String sql;

    public MapperMethod(Class<?> type,String sql) {
        this.type = type;
        this.sql = sql;
    }

    public Class<?> getType() {
        return type;
    }

    public String getSql() {
        return sql;
    }
}
