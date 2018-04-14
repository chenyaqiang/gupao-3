package com.gupao.peter.showme.v2.generatemybatis.statement;

import com.gupao.peter.showme.v2.generatemybatis.config.MapperMethod;
import com.gupao.peter.showme.v2.generatemybatis.config.MapperRegister;
import com.gupao.peter.showme.v2.generatemybatis.config.PeterConfiguration;
import com.gupao.peter.showme.v2.generatemybatis.resultset.ResultHandler;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StatementHandler {

    private PeterConfiguration configuration;

    private ResultHandler resultHandler;

    public StatementHandler(PeterConfiguration configuration) {
        this.configuration = configuration;
        this.resultHandler = new ResultHandler(configuration);
    }

    public <E> E query(MapperRegister.MapperData mapperData, Object parameter) throws SQLException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Connection connection = getConnection();
        PreparedStatement pstmt = connection.prepareStatement(String.format(mapperData.getSql(),
                Integer.parseInt(String.valueOf(parameter))));
        pstmt.execute();
        return (E) resultHandler.handler(pstmt.getResultSet(), mapperData.getType());
    }

    public <E> E query(MapperMethod mapperMethod, Object parameter) throws SQLException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Connection connection = getConnection();
        PreparedStatement pstmt = connection.prepareStatement(String.format(mapperMethod.getSql(),
                Integer.parseInt(String.valueOf(parameter))));
        pstmt.execute();
        return (E) resultHandler.handler(pstmt.getResultSet(), mapperMethod.getType());
    }

    public Connection getConnection() throws SQLException {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String username = "root";
        String password = "root";
        Connection conn = null;
        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

}
