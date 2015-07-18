package com.raremile.entities;

/**
 * Contains the user profile data
 * 
 * @author RohanV
 *
 */

public class UserProfile {

	private long roleID;
	private long userID;
	private String userRole;

	public long getRoleID() {
		return roleID;
	}

	public void setRoleID(long roleID) {
		this.roleID = roleID;
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String toString() {
		return "Role ID: " + roleID + " User ID: " + userID + " User role: "
				+ userRole;
	}

}
