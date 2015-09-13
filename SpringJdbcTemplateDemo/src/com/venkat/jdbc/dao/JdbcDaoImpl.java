package com.venkat.jdbc.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.venkat.jdbc.Emp;
@Component
public class JdbcDaoImpl {
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate=new JdbcTemplate();

	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public DataSource getDatasource() {
		return dataSource;
	}

	public void setDatasource(DataSource datasource) {
		this.dataSource = datasource;
	}
	
	public int getempCount()
	{
		String sql="Select count(*) from EMP";
		jdbcTemplate.setDataSource(getDatasource());
		return jdbcTemplate.update(sql);
		
	}
	
	public Emp getEmp(String eno)
	{
		Connection con=null;
		try{
		
		con=dataSource.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from EMP where eno=?");
		ps.setString(1,eno);
		
		Emp emp=null;
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			emp=new Emp(eno,rs.getString("ename"),rs.getString("salary"));
			
		}
		rs.close();
		ps.close();
		return emp;
	}
		catch(Exception e){
			throw new RuntimeException(e);
		}
		finally
		{
			try{
				con.close();
			}
			catch(SQLException e){}
		}
	}
	
}
