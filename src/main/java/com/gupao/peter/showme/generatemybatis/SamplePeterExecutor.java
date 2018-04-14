package com.gupao.peter.showme.generatemybatis;

import java.sql.*;

public class SamplePeterExecutor implements PeterExecutor {

    @Override
    public <E> E query(String statement, String parameter) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        PeterUserInfo peterUserInfo = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
            String sql = String.format(statement, Integer.parseInt(parameter));
            preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                peterUserInfo = new PeterUserInfo();
                peterUserInfo.setId(rs.getInt(1));
                peterUserInfo.setUname(rs.getString(2));
                peterUserInfo.setUnumber(rs.getInt(3));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != connection) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return (E) peterUserInfo;
    }

}
