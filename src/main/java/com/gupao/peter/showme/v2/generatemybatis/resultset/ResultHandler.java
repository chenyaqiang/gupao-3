package com.gupao.peter.showme.v2.generatemybatis.resultset;

import com.gupao.peter.showme.v2.generatemybatis.config.PeterConfiguration;
import org.apache.ibatis.ognl.OgnlException;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultHandler {

    private final PeterConfiguration configuration;

    public ResultHandler(PeterConfiguration configuration) {
        this.configuration = configuration;
    }

    public <E> E handler(ResultSet resultSet, Class type) throws SQLException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Object resultObj = new DefaultObjectFactory().create(type);
        if (resultSet.next()) {
            for (Field field : resultObj.getClass().getDeclaredFields()) {
                setValue(resultObj, resultSet, field);
            }
        }
        return (E) resultObj;
    }

    private void setValue(Object obj, ResultSet resultSet, Field field) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, SQLException {
        Method method = obj.getClass().getMethod("set" + upperCapital(field.getName()), field.getType());
        method.invoke(obj, getResult(field, resultSet));
    }

    private Object getResult(Field field, ResultSet resultSet) throws SQLException {
        Class<?> type = field.getType();
        if (Integer.class == type) {
            return resultSet.getInt(field.getName());
        }
        if (String.class == type) {
            return resultSet.getString(field.getName());
        }
        return resultSet.getString(field.getName());
    }

    private String upperCapital(String name) {
        String first = name.substring(0, 1);
        String tail = name.substring(1);
        return first.toUpperCase() + tail;
    }
}
