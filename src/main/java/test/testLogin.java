package test;

import java.util.ArrayList;

import DAO.userDAO;
import Model.User;

public class testLogin {
	public static void main(String[] args) {
	User user = new User("Dan", "Doan Hai", "haidan0", "zxc");
	userDAO.getInstance().checkLogin(user);
	}
}
