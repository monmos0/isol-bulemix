/**
 * 
 */
package com.ibm.jp.toy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author AB670075
 *
 */
public class UserAuthDAO {
	
	private Connection conn;
	
	public UserAuthDAO(Connection conn) {
		this.conn=conn;
		
	}
	
	public String getUserPassword(String userId) throws SQLException{
		
		System.out.println("IsUserExist() start");
		
		PreparedStatement stmt =null;
		String pwd=null;
		
		String sql=SQL.selectPASSWDSQL.getSql();
		stmt=conn.prepareStatement(sql);
		
		stmt.setString(1, userId);
		
		ResultSet rs=stmt.executeQuery();
		
		while(rs.next()){
			pwd=rs.getString("USER_PASSWD");
		}
		return pwd;
	}
	

}
