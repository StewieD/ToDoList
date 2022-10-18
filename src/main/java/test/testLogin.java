package test;

import java.util.ArrayList;

import DAO.userDAO;
import Model.User;

public class testLogin {
	public static void main(String[] args) {
	User user = new User("Dang", "Hoang", "xinhxan", "zxc123");
//	userDAO.getInstance().checkLogin(user);
//	userDAO.getInstance().update(user);
//	userDAO.getInstance().delete(user);
//	ArrayList<User> ListUser = userDAO.getInstance().selectAll();
//	for (User user : ListUser) {
//		System.out.println(user.toString());
//	}
	System.out.println(userDAO.getInstance().selectByCondition("firstname='Teo'"));	
	}
}
