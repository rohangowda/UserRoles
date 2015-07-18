package com.raremile.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.raremile.common.DatabaseManager;
import com.raremile.entities.User;
import com.raremile.exception.FatalException;
import com.raremile.exception.NonFatalException;

/**
 * DAL for the users
 * 
 * @author RohanV
 *
 */

public class UserDAL {

	private static final Logger LOG = Logger
			.getLogger(com.raremile.dal.UserDAL.class);
	private static final String RETRIEVE_USER_DATA = "SELECT * FROM USER WHERE USER_NAME = ?";

	/**
	 * To get the details of the user
	 * 
	 * @param username
	 * @return
	 */

	public User getUserData(String username) {
		LOG.info("trying to retrieve data");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet userResult = null;
		User newUser = new User();

		con = DatabaseManager.getConnection();

		try {
			pstmt = con.prepareStatement(RETRIEVE_USER_DATA);
			pstmt.setString(1, username);

			userResult = pstmt.executeQuery();
			LOG.info("execution of select query done");
			userResult.next();

			newUser.setUserID(userResult.getLong("USER_ID"));
			newUser.setUserName(userResult.getString("USER_NAME"));
			newUser.setUserPassword(userResult.getString("USER_PASSWORD"));

		} catch (SQLException e) {
			// TODO: handle specialized exception
			LOG.error("Could not load the driver", e);
			throw new FatalException(
					"Exception while inserting username");
		} finally {
			DatabaseManager.closeDBObjects(pstmt, userResult, con);

		}
		LOG.info("User object created. : " + newUser.toString());
		return newUser;
	}

}
