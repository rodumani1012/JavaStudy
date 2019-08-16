package com.toy.home.db;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class sql_map_config {

	private SqlSessionFactory sql_session_factory;

	public SqlSessionFactory getSqlSessionFactory() {

		String resource = "com/toy/home/db/mvc-config.xml";

		try {
			Reader reader = Resources.getResourceAsReader(resource);
			sql_session_factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sql_session_factory;
	}

}