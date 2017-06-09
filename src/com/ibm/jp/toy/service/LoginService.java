/**
 * 
 */
package com.ibm.jp.toy.service;

import java.sql.Connection;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ibm.jp.toy.dao.UserAuthDAO;
import com.ibm.jp.toy.db.DBAccessor;

/**
 * @author AB670075
 *
 */
@Path("/")
public class LoginService {
	
	@Path("/login")
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response login(@FormParam("user_id") String userId,@FormParam("user_pwd") String userPwd){
		
		System.out.println("ログイン");
		System.out.println("UserId"+userId);
		System.out.println("UserPassword"+userPwd);
		
		if (userId==null||"".equals(userId)) {
			
			System.out.println("userId Bad Request");
			return Response.status(400).build();
			
		}
		
		if (userPwd==null||"".equals(userPwd)) {
			
			System.out.println("password Bad Request");
			return Response.status(400).build();
			
		}
		
		DBAccessor accessor = new DBAccessor();
		Connection conn=accessor.getConnection();
		UserAuthDAO dao=new UserAuthDAO(conn);
		try{
			String password=dao.getUserPassword(userId);
			conn.commit();
			if (comparePassword(userId,password)) {
				return Response.ok().build();
				
			}else{
				return Response.status(401).build();
			}
			
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				
				try {
					conn.rollback();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				return Response.status(500).build();
			}finally {
				try {
					conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		
		
		}
	private static Boolean comparePassword(String password,String hirabunn) {
		
		if (password==null||hirabunn==null||"".equals(password)||"".equals(hirabunn)) {
			
			return false;
			
		}
		if(hirabunn.equals(password)){
			return true;
		}else{
			return false;
		}
		
	}

}
