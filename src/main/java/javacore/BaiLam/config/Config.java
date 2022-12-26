package javacore.BaiLam.config;

import java.io.Serializable;

public class Config implements Serializable {
	private String username;
	private String password;
	private String databaseURL;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDatabaseURL() {
		return databaseURL;
	}

	public void setDatabaseURL(String databaseURL) {
		this.databaseURL = databaseURL;
	}

	@Override
	public String toString() {
		return "Config [username=" + username + ", password=" + password + ", databaseURL=" + databaseURL + "]";
	}

}
