package com.gupao.peter.showme.mybatis.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;


@Intercepts({@Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})})
public class FirstInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("first interceptor running for intercept");
        System.out.println(invocation.getTarget());
        System.out.println(invocation.getMethod());
        System.out.println(invocation.getArgs());
        System.out.println(invocation.getClass());
        Object[] args = invocation.getArgs();
        MappedStatement ms = (MappedStatement) args[0];
        Object obj = args[1];
        RowBounds rowBounds = (RowBounds) args[2];
        ResultHandler resultHandler = (ResultHandler) args[3];
        BoundSql boundSql = ms.getBoundSql(obj);
        System.out.println(boundSql.getSql());
        System.out.println(boundSql.getParameterObject());
        System.out.println(boundSql.getParameterMappings());
        System.out.println(ms.getConfiguration().getMappedStatement("selectByPrimaryKey"));
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
    }
}
