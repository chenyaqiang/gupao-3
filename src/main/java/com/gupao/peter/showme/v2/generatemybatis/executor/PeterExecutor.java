package com.gupao.peter.showme.v2.generatemybatis.executor;

import com.gupao.peter.showme.v2.generatemybatis.config.MapperMethod;
import com.gupao.peter.showme.v2.generatemybatis.config.MapperRegister;

public interface PeterExecutor {

    <E> E query(MapperRegister.MapperData statement, Object parameter) throws Exception;

    <E> E query(MapperMethod mapperMethod, Object parameter) throws Exception;

}
