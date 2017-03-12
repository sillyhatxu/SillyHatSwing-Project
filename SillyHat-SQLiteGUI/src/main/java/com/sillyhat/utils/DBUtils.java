package com.sillyhat.utils;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	
	private static final Logger logger = Logger.getLogger(DBUtils.class);
	
	public static DBUtils db = new DBUtils();

	private DBUtils() {

	}
	
	public static Connection getConnection(String dbType,String dbName) {
		Connection con = null;
		if(dbType.equalsIgnoreCase(Constant.DBTYPE_SQLITE)){
			try{
				//连接的是sqlite
				Class.forName(Constant.FOR_NAME_SQLITE); 
				con = DriverManager.getConnection("jdbc:sqlite" + dbName);
			}catch(Exception e){
				logger.error("连接数据库异常。",e);
			}
		}
		return con;
	}

	public static void close(Connection con, java.sql.PreparedStatement pstmt,java.sql.ResultSet rs) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				logger.error("关闭connection对象时候出错了");
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				logger.error("关闭PreparedStatement对象时候出错了");
			}
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				logger.error("关闭ResultSet对象时候出错了");
			}
		}
	}

	public static void main(String arg[]) {
//		Connection con = DBUtils.getConnection();
//		System.out.println(con);
//		DBUtils.close(con, null, null);
	}
}