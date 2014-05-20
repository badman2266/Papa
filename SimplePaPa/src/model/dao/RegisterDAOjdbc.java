package model.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.MemberBean;

public class RegisterDAOjdbc {

	private Connection conn = null;
	private PreparedStatement pstmt = null;

	private void conn() {
		// final String URL =
		// "jdbc:sqlserver://localhost:1433;databaseName=JDBC";
		// final String USERNAME = "sa";
		// final String PASSWORD = "sa123456";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost;"
					+ "databaseName=papa0;user=sa;password=sa123456;");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// private DataSource dataSource;
	//
	// public RegisterDAOjdbc() {
	// try {
	// Context ctx = new InitialContext();
	// dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/xxx");
	//
	// } catch (NamingException e) {
	// e.printStackTrace();
	// }
	// }

	private static final String SELECT_BY_Account = "select * from PapaMem where account = ?";

	public MemberBean selectAccount(String account) {
		ResultSet rset = null;
		MemberBean result = null;
		try {
			this.conn();
			pstmt = conn.prepareStatement(SELECT_BY_Account);
			pstmt.setString(1, account);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = new MemberBean();
				result.setAccount(rset.getString("account"));
				result.setName(rset.getString("name"));
				result.setmPassword(rset.getString("mPassword"));
				result.setEmail(rset.getString("email"));
				result.setSex(rset.getString("sex"));
				result.setBirth(rset.getDate("birth"));
				result.setPhone(rset.getString("phone"));
				result.setmAddress(rset.getString("mAddress"));
				result.setmStatusId(rset.getInt("mStatusId"));
				result.setmTypeId(rset.getInt("mTypeId"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rset != null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	//memPic=?, 還沒加!!
	private static final String UPDATE = 
			"update PapaMem set name=?, mPassword=?, email=?, sex=?, birth =?,"
			+ "phone =?, mAddress =?,mTypeId=? ,mStatusId=? where account=?";
	
	public boolean updateMember(String name, String mPassword, String email, String sex, java.util.Date birth, 
			String phone, String mAddress, int mTypeId, int mStatusId, String account) {
		try{
			this.conn();
		pstmt = conn.prepareStatement(UPDATE);
		pstmt.setString(1, name);
		pstmt.setString(2, mPassword);
		pstmt.setString(3, email);
		pstmt.setString(4, sex);
		
		if(birth!=null) {
			long time = birth.getTime();
			pstmt.setDate(5, new java.sql.Date(time));
		} else {
			pstmt.setDate(5, null);	
		}
		
		pstmt.setString(6, phone);
		pstmt.setString(7, mAddress);
		pstmt.setInt(8, mTypeId);
		pstmt.setInt(9, mStatusId);
		pstmt.setString(10,account);
		int i = pstmt.executeUpdate();
		if(i==1) {
			return true;
		}
		
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	
	private static final String DELETE = 
			"delete from PapaMem where account=?";
	public boolean deleteMember(String account) {
		
		try {
			this.conn();
			pstmt = conn.prepareStatement(DELETE);
			pstmt.setString(1, account);
			int i = pstmt.executeUpdate();
			if(i==1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	
	
	
	
	private static final String INSERT = "INSERT INTO PapaMem (account ,name, mPassword, email, sex, memPic, birth, phone, mAddress, mDate,mTypeId , mStatusId ) VALUES(? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,?)";
	// public int insertMember(MemberBean mb, InputStream is, int size) {
	public int insertMember(MemberBean mb) {
		// Connection conn = null;
		// PreparedStatement pstmt = null;
		int count = 0;
		try {
			this.conn();
			// dataSource.getConnection();
			pstmt = conn.prepareStatement(INSERT);
			pstmt.setString(1, mb.getAccount());
			pstmt.setString(2, mb.getName());
			pstmt.setString(3, mb.getmPassword());
			pstmt.setString(4, mb.getEmail());
			pstmt.setString(5, mb.getSex());
			// 新增圖片
			InputStream is = null;
			int size = 0;
			pstmt.setBinaryStream(6, is, size);

			// 新增生日
			java.util.Date make = mb.getBirth();
			if (make != null) {
				long temp = make.getTime();
				pstmt.setDate(7, new java.sql.Date(temp));
			} else {
				pstmt.setDate(7, null);
			}

			pstmt.setString(8, mb.getPhone());
			pstmt.setString(9, mb.getmAddress());

			// 註冊時間
			Timestamp ts = new Timestamp(System.currentTimeMillis());
			pstmt.setTimestamp(10, ts);

			pstmt.setInt(11, mb.getmTypeId());
			pstmt.setInt(12, mb.getmStatusId());
			count = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return count;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		RegisterDAOjdbc rd = new RegisterDAOjdbc();
		 rd.deleteMember("A");
//		MemberBean bean=new MemberBean();
//		bean.setAccount("B");
//		bean.setName("A");
//		bean.setmPassword("A");
//		bean.setEmail("AA");
//		bean.setSex("男");
//		// 圖片
//
//		bean.setBirth(new java.util.Date());
//		bean.setPhone("023232323");
//		bean.setmAddress("男");
//		bean.setmStatusId(1);
//		bean.setmTypeId(1);
//		rd.updateMember("B","E" ,"BB", "女", new java.util.Date(), "0903934", "女", 1, 1, "B");
		//System.out.print(bean);
		//rd.selectAccount("A");
		//MemberBean bean=rd.selectAccount("A");
		//MemberBean bean=rd.selectAccount("A");
		
		//System.out.print(bean.getBirth());
		
	}

}
