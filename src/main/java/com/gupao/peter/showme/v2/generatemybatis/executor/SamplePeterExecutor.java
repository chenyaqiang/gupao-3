package com.gupao.peter.showme.v2.generatemybatis.executor;

import com.gupao.peter.showme.v2.generatemybatis.config.MapperMethod;
import com.gupao.peter.showme.v2.generatemybatis.config.MapperRegister;
import com.gupao.peter.showme.v2.generatemybatis.config.PeterConfiguration;
import com.gupao.peter.showme.v2.generatemybatis.statement.StatementHandler;

public class SamplePeterExecutor implements PeterExecutor {

    private PeterConfiguration configuration;

    public SamplePeterExecutor(PeterConfiguration configuration) {
        this.configuration = configuration;
    }

    public PeterConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(PeterConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <E> E query(MapperRegister.MapperData statement, Object parameter) throws Exception {
        StatementHandler statementHandler = new StatementHandler(configuration);
        return (E) statementHandler.query(statement, parameter);
    }

    @Override
    public <E> E query(MapperMethod mapperMethod, Object parameter) throws Exception {
        StatementHandler statementHandler = new StatementHandler(configuration);
        return statementHandler.query(mapperMethod,parameter);
    }
}
