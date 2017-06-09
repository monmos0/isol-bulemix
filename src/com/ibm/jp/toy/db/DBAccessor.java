/**
 * 
 */
package com.ibm.jp.toy.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


/**
 * @author AB670075
 *
 */
public class DBAccessor {
	
	private static final String LOOKUPNAME="jdbc/dashDB for Analytics-tp";
	
	public Connection getConnection(){
		
		Connection conn=null;
		DataSource dataSource=null;
		try{
			Context context=new InitialContext();
			dataSource=(DataSource)context.lookup(LOOKUPNAME);
			conn=dataSource.getConnection();
			conn.setAutoCommit(false);
			
			
		}catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return conn;
	}
	

}
