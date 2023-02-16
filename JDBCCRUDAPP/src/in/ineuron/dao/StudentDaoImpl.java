package in.ineuron.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.ineuron.dto.Student;
import in.ineuron.util.JdbcUtil;

public class StudentDaoImpl implements IStudentDao {
    
	
	@Override
	public String save(Student student) {
		Connection connection =null;
		String sqlInsertQuery = "insert into students(`name`,`email`,`city`,`country`) values(?,?,?,?)";
    	PreparedStatement pstmt = null;
    	String status=null;
		
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				pstmt = connection.prepareStatement(sqlInsertQuery);
			}
			if (pstmt != null) {
				pstmt.setString(1,student.getName());
				pstmt.setString(2,student.getEmail());
				pstmt.setString(3,student.getCity());
				pstmt.setString(4,student.getCountry());
				
			}
			int RowsAffected = pstmt.executeUpdate();
			if (RowsAffected == 1) {
				status = "success";
			}else
				status = "failure";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			status = "failure";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			status = "failure";
		}
		// TODO Auto-generated method stub
		return status;
	}

	@Override
	public Student findById(Integer sid) {
		Connection connection =null;
		String sqlSelectQuery = "select name,email,city,country from students where id=?";
    	PreparedStatement pstmt = null;
    	Student student=null;
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				pstmt = connection.prepareStatement(sqlSelectQuery);
			}
			if (pstmt != null) {
				pstmt.setInt(1,sid);
			}
			ResultSet resultSet = pstmt.executeQuery();
			if (resultSet.next()) {
				student = new Student();
				student.setName(resultSet.getString(1));
				student.setEmail(resultSet.getString(2));
				student.setCity(resultSet.getString(3));
				student.setCountry(resultSet.getString(4));
				//copy the resultSet data into dto object since the return type of the method is student
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return student;
	}

	@Override
	public String updateById(Student student) {
		// TODO Auto-generated method stub
		Connection connection =null;
		String sqlUpdateQuery = "update students set name=?,email=?,city=?,country=? where id=?";
    	PreparedStatement pstmt = null;
    	String status=null;
		
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				pstmt = connection.prepareStatement(sqlUpdateQuery);
			}
			if (pstmt != null) {
				pstmt.setString(1,student.getName());
				pstmt.setString(2,student.getEmail());
				pstmt.setString(3,student.getCity());
				pstmt.setString(4,student.getCountry());
				pstmt.setInt(5, student.getId());
				
			}
			int RowsAffected = pstmt.executeUpdate();
			if (RowsAffected == 1) {
				status = "success";
			}else
				status = "failure";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			status = "failure";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			status = "failure";
		}
		// TODO Auto-generated method stub
		return status;
	}

	@Override
	public String deleteById(Integer sid) {
		// TODO Auto-generated method stub
		Connection connection =null;
		String sqlDeleteQuery = "delete from students where id=?";
    	PreparedStatement pstmt = null;
    	String status=null;
		Student student = findById(sid);
		
			try {
			connection = JdbcUtil.getJdbcConnection();
			    if (student != null) {
					if (connection != null) {
						pstmt = connection.prepareStatement(sqlDeleteQuery);
					}
					if (pstmt != null) {
						
						pstmt.setInt(1,sid);
					}
					int RowsAffected = pstmt.executeUpdate();
					if (RowsAffected == 1) 
						status = "success";
		
		        }else {
		        	status = "not available";
		        }
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			status = "failure";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			status = "failure";
		}
		// TODO Auto-generated method stub
		return status;
	}

}
