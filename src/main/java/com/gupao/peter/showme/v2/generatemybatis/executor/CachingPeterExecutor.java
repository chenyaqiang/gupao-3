package com.gupao.peter.showme.v2.generatemybatis.executor;

import com.gupao.peter.showme.v2.generatemybatis.config.MapperMethod;
import com.gupao.peter.showme.v2.generatemybatis.config.MapperRegister;
import com.gupao.peter.showme.v2.generatemybatis.config.PeterConfiguration;
import com.gupao.peter.showme.v2.generatemybatis.statement.StatementHandler;

import java.util.HashMap;
import java.util.Map;

public class CachingPeterExecutor implements PeterExecutor {

    private PeterConfiguration configuration;

    private SamplePeterExecutor delegate;

    private Map<String, Object> localCache = new HashMap<>();

    public CachingPeterExecutor(PeterConfiguration configuration) {
        this.configuration = configuration;
    }

    public CachingPeterExecutor(SamplePeterExecutor delegate) {
        this.delegate = delegate;
    }

    @Override
    public <E> E query(MapperRegister.MapperData statement, Object parameter) throws Exception {
        StatementHandler statementHandler = new StatementHandler(configuration);
        Object result = localCache.get(statement.getSql());
        if (result != null) {
            return (E) result;
        }
        result = (E) delegate.query(statement, parameter);
        localCache.put(statement.getSql(), result);
        return (E) result;
    }

    @Override
    public <E> E query(MapperMethod mapperMethod, Object parameter) throws Exception {
        StatementHandler statementHandler = new StatementHandler(configuration);
        Object result = localCache.get(String.format(mapperMethod.getSql(),String.valueOf(parameter)));
        if (result != null) {
            return (E) result;
        }
        result = statementHandler.query(mapperMethod, parameter);
        localCache.put(String.format(mapperMethod.getSql(),String.valueOf(parameter)),result);
        return (E) result;
    }
}
