package javacore.BaiLam.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectConfig {
	private Connection connection = null;
	private static Config config = null;
	static {
		config = getConfigV2();

	}

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(config.getDatabaseURL(), config.getUsername(),
					config.getPassword());

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	private static Config getConfigV2() {
		try {
			FileInputStream fileInputStream = new FileInputStream(new File("config.properties"));
			Properties properties = new Properties();
			properties.load(fileInputStream);
			Config config = new Config();
			config.setUsername(properties.getProperty("username"));
			config.setPassword(properties.getProperty("password"));
			config.setDatabaseURL(properties.getProperty("databaseURL"));
			fileInputStream.close();
			return config;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public static String getConfig() {
		String rs = "";
		try {
			FileInputStream fileInputStream = new FileInputStream(new File("config.txt"));

			int result = -1;
			while ((result = fileInputStream.read()) != -1) {
				rs += (char) result;
			}
			fileInputStream.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	private static Config subString(String input) {
		int count = -1;
		Config config = new Config();
		count = input.indexOf("\n");
		config.setUsername(input.substring(input.indexOf(":") + 1, count));
		config.setPassword(input.substring(input.indexOf(":", count) + 1, count = input.indexOf("\n", count + 1)));
		count = input.indexOf("\n", count + 1) == -1 ? input.length() : input.indexOf("\n", count + 1);
		config.setDatabaseURL(input.substring(input.indexOf(":", count) + 1, count));
		System.out.println(config.getDatabaseURL());
		return config;
	}
}
