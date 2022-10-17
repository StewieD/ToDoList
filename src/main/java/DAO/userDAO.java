package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.User;
import database.JDBCUtil;

public class userDAO implements DAOinterface<User> {

	public  static userDAO getInstance() {
		return new userDAO();
	}
	@Override
	public void insert(User t) {
		try {
			Connection conn = JDBCUtil.getConnection();
			String sql = " INSERT INTO user(firstname,lastname,username,password)\r\n"
					+ "VALUES (?,?,?,?);";
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, t.getFirstName());
			st.setString(2, t.getLastName());
			st.setString(3, t.getUserName());
			st.setString(4, t.getPassWord());
			System.out.println(sql);
			st.executeUpdate();
			
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			System.out.println("ASDAS");
			e.printStackTrace();
		}
	}
	@SuppressWarnings("null")
	public User checkLogin(User t) {
		Connection conn = JDBCUtil.getConnection();
		User ketQua = null;
		try {
			String sql = "SELECT * FROM user WHERE  username=? AND password= ? ;";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, t.getUserName());
			st.setString(2, t.getPassWord());
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				String fname = rs.getString("firstname");
				String lname = rs.getString("lastname");
				String username = rs.getString("username");
				String password = rs.getString("password");
				ketQua = new User(fname, lname, username, password);
				System.out.println(ketQua);
			}
			JDBCUtil.closeConnection(conn);
		} catch (Exception e) {
		}
			return ketQua;	
	}
}
