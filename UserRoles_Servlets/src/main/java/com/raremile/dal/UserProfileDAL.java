package com.raremile.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.raremile.common.DatabaseManager;
import com.raremile.entities.UserProfile;
import com.raremile.exception.FatalException;

/**
 * Provides the mapping of users to roles
 * 
 * @author RohanV
 *
 */

public class UserProfileDAL {

	private static final Logger LOG = Logger
			.getLogger(com.raremile.dal.UserProfileDAL.class);
	private static final String RETRIEVE_USER_PROFILE_DATA = "SELECT * FROM USERPROFILE WHERE USER_ID = ?";

	/**
	 * To get the details of the roles of the users
	 * 
	 * @param userID
	 * @return
	 */

	public List<UserProfile> getRoleData(long userID) {
		LOG.info("trying to retrieve data");
		List<UserProfile> userObjects = new ArrayList<UserProfile>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet userResult = null;

		con = DatabaseManager.getConnection();

		try {
			pstmt = con.prepareStatement(RETRIEVE_USER_PROFILE_DATA);
			pstmt.setLong(1, userID);

			userResult = pstmt.executeQuery();
			LOG.info("execution of select query done");
			UserProfile newUser = null;
			while (userResult.next()) {
				newUser = new UserProfile();
				newUser.setRoleID(userResult.getLong("ROLE_ID"));
				newUser.setUserID(userResult.getLong("USER_ID"));
				newUser.setUserRole(userResult.getString("USER_ROLE"));
				userObjects.add(newUser);

			}
		} catch (SQLException e) {
			// TODO: handle specialized exception
			LOG.error("Could not load the driver", e);
			throw new FatalException(
					"SQLException while inserting company data.");
		} finally {
			DatabaseManager.closeDBObjects(pstmt, userResult, con);

		}
		LOG.info("list of company objects created. : " + userObjects.toString());
		return userObjects;
	}

}
