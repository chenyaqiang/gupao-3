package com.gupao.peter.showme.mybatis.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

@MappedTypes(List.class)
@MappedJdbcTypes({ JdbcType.VARCHAR })
public class ListTypeHandler extends BaseTypeHandler<List<String>> {

	@Override
	public List<String> getNullableResult(ResultSet arg0, String arg1) throws SQLException {
		String[] arrStr = StringUtils.split(arg0.getString(arg1), ",");
		return Arrays.asList(arrStr);
	}

	@Override
	public List<String> getNullableResult(ResultSet arg0, int arg1) throws SQLException {
		String[] arrStr = StringUtils.split(arg0.getString(arg1), ",");
		return Arrays.asList(arrStr);
	}

	@Override
	public List<String> getNullableResult(CallableStatement arg0, int arg1) throws SQLException {
		String[] arrStr = StringUtils.split(arg0.getString(arg1), ",");
		return Arrays.asList(arrStr);
	}

	@Override
	public void setNonNullParameter(PreparedStatement preparedStatement, int arg1, List<String> arg2, JdbcType arg3)
			throws SQLException {
		StringBuffer sb = new StringBuffer();
		for (String str : arg2) {
			sb.append(str).append(",");
		}
		preparedStatement.setString(arg1, StringUtils.substring(sb.toString(), 0, sb.toString().length() - 1));
	}

}
