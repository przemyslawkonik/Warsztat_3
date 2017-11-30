package pl.coderslab.model;

import org.mindrot.jbcrypt.BCrypt;

public class User {
	private long id;
	private String username;
	private String email;
	private String password;
	private int userGroupId;

	public User() {
	}

	public User(String username, String email, String password, int userGroupId) {
		this.username = username;
		this.email = email;
		setPassword(password);
		this.userGroupId = userGroupId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = BCrypt.hashpw(password, BCrypt.gensalt());
	}

	public boolean checkPassword(String password) {
		return BCrypt.checkpw(password, this.password);
	}

	public int getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(int userGroupId) {
		this.userGroupId = userGroupId;
	}

	public long getId() {
		return id;
	}

}
