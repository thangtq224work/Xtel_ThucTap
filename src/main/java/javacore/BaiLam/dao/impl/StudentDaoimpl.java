package javacore.BaiLam.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javacore.BaiLam.config.ConnectConfig;
import javacore.BaiLam.dao.StudentDao;
import javacore.BaiLam.model.Student;

public class StudentDaoimpl implements StudentDao {
	private static Logger logger = LogManager.getLogger();
	Connection connection;

	public StudentDaoimpl() {
		// TODO Auto-generated constructor stub

	}

	@Override
	public boolean isExists(String name) {
		connection = new ConnectConfig().getConnection();
		String query = "SELECT nameStudent FROM Students WHERE nameStudent like ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, "" + name + "");
			ResultSet resultSet = preparedStatement.executeQuery();
			String result = null;
			while (resultSet.next()) {
				result = resultSet.getString("nameStudent");
			}
			preparedStatement.close();
			connection.close();
			if (result != null) {
				return true;
			}

		} catch (SQLException e) {
			logger.error(e.toString());
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				logger.warn(e.toString());
			}
		}
		
		return false;
	}

	@Override
	public Student save(Student student) {
		String query = "insert into Students(nameStudent,gender,hometown,age) values (?,?,?,?)";
		connection = new ConnectConfig().getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, student.getName());
			preparedStatement.setBoolean(2, student.isGender());
			preparedStatement.setString(3, student.getHometown());
			preparedStatement.setInt(4, student.getAge());
			int result = preparedStatement.executeUpdate();
			if (result > 0) {
				System.out.println("Them thanh cong");
			}
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			logger.error(e.toString());
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.warn(e.toString());
			}
		}
		return null;
	}
}
