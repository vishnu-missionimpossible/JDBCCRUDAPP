package in.ineuron.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;



public class JdbcUtil {

	
	private JdbcUtil(){
		try {
			Class.forName("com.mysql.cj.driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getJdbcConnection() throws SQLException, IOException {
		HikariConfig config= new HikariConfig("src/in/ineuron/properties/db.properties");
		HikariDataSource dataSource = new HikariDataSource(config);
		Connection connection = dataSource.getConnection();
		return connection;
	}

	@SuppressWarnings("unused")
	private static Connection physicalConnection() throws FileNotFoundException, IOException, SQLException {
		FileInputStream fis = new FileInputStream("src/in/ineuron/properties/db.properties");
		Properties properties = new Properties();
		properties.load(fis);
		String url=properties.getProperty("url");
		String password= properties.getProperty("password");
		String username= properties.getProperty("user");
		
		Connection connection =DriverManager.getConnection(url,username,password);
		return connection;
	}
}
