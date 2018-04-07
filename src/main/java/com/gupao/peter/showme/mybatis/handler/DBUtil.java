/**
 * 
 */
package com.gupao.peter.showme.mybatis.handler;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionException;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Mybatis 数据库会话连接工具类
 * 
 * @author peterhe
 *
 */
public class DBUtil {

	private static SqlSessionFactory sqlSessionFactory;

	private static final Class CLASS_LOCK = DBUtil.class;

	// 创建线程局部变量session，用来保存SqlSession
	private static final ThreadLocal<SqlSession> sessionMap = new ThreadLocal<SqlSession>();

	private static SqlSessionFactory initSqlSessionFactory() {
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream("mybatis-conf.xml");
			synchronized (CLASS_LOCK) {
				if (sqlSessionFactory == null) {
					sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sqlSessionFactory;
	}

	public static SqlSession openSqlSession() throws Exception {
		if (sqlSessionFactory == null) {
			initSqlSessionFactory();
		}
		SqlSession sqlsession = sqlSessionFactory.openSession();
		sessionMap.set(sqlsession);
		return sqlsession;
	}

	public static void closeSession() throws Exception {
		SqlSession s = sessionMap.get();
		sessionMap.set(null);
		if (s != null) {
			s.close();
		}
	}

}
