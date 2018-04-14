package com.gupao.peter.showme.v2.generatemybatis.executor;

import com.gupao.peter.showme.v2.generatemybatis.config.PeterConfiguration;

public class ExecutorFactory {

    public static final String SAMPLE = "SAMPLE";

    public static final String CACHING = "CACHING";

    //默认Executor
    public static PeterExecutor defaultExecutor(PeterConfiguration configuration) {
        return get(SAMPLE, configuration);
    }

    public static PeterExecutor get(String key, PeterConfiguration configuration) {
        if (SAMPLE.equalsIgnoreCase(key)) {
            return new SamplePeterExecutor(configuration);
        }
        if (CACHING.equalsIgnoreCase(key)) {
            return new CachingPeterExecutor(new SamplePeterExecutor(configuration));
        }
        throw new RuntimeException("no executor found");
    }

    public static enum ExecutorType {
        SAMPLE, CACHING
    }

}
