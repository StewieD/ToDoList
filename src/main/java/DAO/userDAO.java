package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	public void checkLogin(User t) {
		
	}
}
