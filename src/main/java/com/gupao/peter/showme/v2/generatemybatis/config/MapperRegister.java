package com.gupao.peter.showme.v2.generatemybatis.config;

import com.gupao.peter.showme.v2.generatemybatis.bean.PeterUserInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * 接口方法与SQL映射
 */
public class MapperRegister {

    public static final Map<String,MapperData> sqlMapping = new HashMap<>();

    public MapperRegister() {
        sqlMapping.put("com.gupao.peter.showme.v2.generatemybatis.config.mapper.PeterUserInfoMapper.selectByPrimaryKey",
                new MapperData("select * from user_info where id = %s",PeterUserInfo.class));
    }

    public MapperData get(String nameSpace) {
        return sqlMapping.get(nameSpace);
    }

    public class MapperData<T> {
        private String sql;
        private Class<T> type;

        public MapperData(String sql, Class<T> type) {
            this.sql = sql;
            this.type = type;
        }

        public String getSql() {
            return sql;
        }

        public void setSql(String sql) {
            this.sql = sql;
        }

        public Class<T> getType() {
            return type;
        }

        public void setType(Class<T> type) {
            this.type = type;
        }
    }
}
