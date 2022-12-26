package javacore.BaiLam.dao;

import javacore.BaiLam.model.Student;

public interface StudentDao {
	Student save(Student student);

	boolean isExists(String name);
}
