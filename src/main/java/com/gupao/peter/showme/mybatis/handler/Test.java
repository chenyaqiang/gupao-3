/**
 * 
 */
package com.gupao.peter.showme.mybatis.handler;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.gupao.peter.showme.mybatis.beans.UserInfo;
import com.gupao.peter.showme.mybatis.mapper.UserInfoMapper;

/**
 * @author peterhe
 *
 */
public class Test {

//	@org.junit.Test
//	public void testInsert() {
//		SqlSession sqlSession = null;
//		try {
//			sqlSession = DBUtil.openSqlSession();
//			UserInfoMapper userInfoMapper = (UserInfoMapper) sqlSession.getMapper(UserInfoMapper.class);
//			UserInfo user = new UserInfo();
//			user.setUname("peter");
//			user.setUnumber(10);
//			List<String> hobbies = new ArrayList<String>();
//			hobbies.add("篮球");
//			hobbies.add("代码");
//			user.setHobby(hobbies);
//			userInfoMapper.insert(user);
//			sqlSession.commit();
//		} catch (Exception e) {
//			sqlSession.rollback();
//			e.printStackTrace();
//		} finally {
//			if (sqlSession != null) {
//				sqlSession.close();
//			}
//		}
//	}

	@org.junit.Test
	public void testQuery() {
		SqlSession sqlSession = null;
		try {
			sqlSession = DBUtil.openSqlSession();
			UserInfoMapper userInfoMapper = (UserInfoMapper) sqlSession.getMapper(UserInfoMapper.class);
			Method m = UserInfoMapper.class.getMethod("selectByPrimaryKey",Integer.class);
			UserInfo user = userInfoMapper.selectByPrimaryKey(1);
			System.out.println(user.toString());
			for (String s : user.getHobby()) {
				System.out.println(s);
			}
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
}
