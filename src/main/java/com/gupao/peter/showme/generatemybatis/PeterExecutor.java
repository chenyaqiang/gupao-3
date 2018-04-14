package com.gupao.peter.showme.generatemybatis;

public interface PeterExecutor {

    <E> E query(String statement,String parameter);

}
