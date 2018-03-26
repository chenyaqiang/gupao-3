/**
 * 
 */
package com.gupao.peter.showme.mybatis.handler;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Mybatis 数据库会话连接工具类
 * @author peterhe
 *
 */
public class DBUtil {
	
	private static SqlSessionFactory sqlSessionFactory;
	
	private static final Class CLASS_LOCK = DBUtil.class;
	
	private static SqlSessionFactory initSqlSessionFactory() {
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream("mybatis-conf.xml");
			synchronized (CLASS_LOCK) {
				if(sqlSessionFactory == null) {
					sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
//			if(is != null) {
//				try {
//					is.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
		}
		return sqlSessionFactory;
	}
	
	public static SqlSession openSqlSession() {
		if(sqlSessionFactory == null) {
			initSqlSessionFactory();
		}
		return sqlSessionFactory.openSession();
	}
}
