package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.x.protobuf.MysqlxConnection.Close;

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
	@Override
	public void update(User t) {
		Connection conn = JDBCUtil.getConnection();
		int check = 0;
		try {
			String sql = " UPDATE user SET firstname= ?, lastname= ?, password= ? WHERE username= ?;";
			
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, t.getFirstName());
			st.setString(2, t.getLastName());
			st.setString(3, t.getPassWord());
			st.setString(4, t.getUserName());
			System.out.println(sql);
			check = st.executeUpdate();
			System.out.println("Changed " +check+ " line. ");
		JDBCUtil.closeConnection(conn);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	@Override
	public void delete(User t) {
		Connection conn = JDBCUtil.getConnection();
		int check =0;
		try {
			String sql = "DELETE FROM user\r\n"
					+ "WHERE username= ?; ";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, t.getUserName());
			
			check = st.executeUpdate();
			System.out.println("Changed "+check+" line.");
			JDBCUtil.closeConnection(conn);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	@SuppressWarnings("null")
	@Override
	public ArrayList<User> selectAll() {
		
		ArrayList<User> List = new ArrayList<User>();
		try {
			Connection conn = JDBCUtil.getConnection();
			String sql="select * from user ; ";
			
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				String fname = rs.getString("firstname");
				String lname = rs.getString("lastname");
				String username = rs.getString("username");
				String password = rs.getString("password");
				User user = new User(fname, lname, username, password);
				List.add(user);
			}
			System.out.println(List);
			JDBCUtil.closeConnection(conn);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return List;
	}
	@Override
	public User selectByPrimaryKey(User t) {
		User kq = null;
		try {
			Connection conn = JDBCUtil.getConnection();
			String sql = "select * from user where username= ?;";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, t.getUserName());
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				kq = new User(rs.getString("firstname"), rs.getString("lastname"), rs.getString("username"), rs.getString("password"));
			}
			JDBCUtil.closeConnection(conn);
 		} catch (Exception e) {
			// TODO: handle exception
		}
		return kq;
	}
	@Override
	public ArrayList<User> selectByCondition(String Condition) {
		ArrayList<User> List  = new ArrayList<User>();
		try {
			Connection conn = JDBCUtil.getConnection();
			String sql = "select * from user where "+Condition+" ;" ;
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				User u = new User(rs.getString("firstname"), rs.getString("lastname"), rs.getString("username"), rs.getString("password"));
				List.add(u);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return List;
	}
}
