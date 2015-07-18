package com.raremile.common;

import com.raremile.dal.UserDAL;
import com.raremile.entities.User;

public class Starter {
	public static void main(String[] args) {
		UserDAL userDAL = new UserDAL();
		User user = userDAL.getUserData("rohan");
		System.out.println(user.getUserName());
	}
}
