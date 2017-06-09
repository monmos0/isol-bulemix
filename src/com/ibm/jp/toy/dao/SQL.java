/**
 * 
 */
package com.ibm.jp.toy.dao;

/**
 * @author AB670075
 *
 */
public enum SQL {
	
selectPASSWDSQL("select USER_PASSWD from USERAUTH where USER_ID = ?");
	
private final String sql;

private SQL(String sql){
	this.sql=sql;
}

public String getSql(){
	return this.sql;
}

}
