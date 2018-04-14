package com.gupao.peter.showme.v2.generatemybatis.config;

import lombok.Data;

@Data
public class PeterConfiguration {

    private String scanPath;

    private MapperRegister mapperRegister = new MapperRegister();

    private MapperStatement mapperStatement;

    public PeterConfiguration scan(String scanPath) {
        this.scanPath = scanPath;
        //获取扫描路径Mapper方法sql
        mapperStatement = new MapperStatement(scanPath);
        return this;
    }

    public static void build(String path) {
        if (path == null || path.length() < 0) {
            throw new RuntimeException("the path is not empty");
        }
    }

    public static void main(String[] args) {
        String path = "com.gupao.peter.showme.v2.generatemybatis.config.mapper";
        new PeterConfiguration().build(path);
    }

}
