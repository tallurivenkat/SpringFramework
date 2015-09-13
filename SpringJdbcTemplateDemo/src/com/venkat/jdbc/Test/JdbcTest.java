package com.venkat.jdbc.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.venkat.jdbc.Emp;
import com.venkat.jdbc.dao.JdbcDaoImpl;

public class JdbcTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext ctx= new ClassPathXmlApplicationContext("Spring.xml");
		JdbcDaoImpl dao=ctx.getBean("jdbcDaoImpl", JdbcDaoImpl.class);
		Emp emp=dao.getEmp("001");
		System.out.println(emp.toString());
//	System.out.println(dao.getempCount());
	}

}
