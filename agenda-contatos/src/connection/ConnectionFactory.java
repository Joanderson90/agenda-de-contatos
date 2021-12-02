package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {

	private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
	private final static String URL = "jdbc:mysql://localhost:3306/cadastro";
	private final static String USER = "root";
	private final static String PASSWORD = "";

	public static Connection getConnection() {

		try {

			Class.forName(DRIVER);

			return DriverManager.getConnection(URL, USER, PASSWORD);

		} catch (ClassNotFoundException | SQLException e) {

			throw new RuntimeException("Erro ao conectar: ", e);
		}

	}

	public static void closeConnection(Connection connection) {

		if (isConnectionOn(connection)) {

			try {

				connection.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}

	private static boolean isConnectionOn(Connection connection) {

		return connection != null;
	}

	public static void closeConnection(Connection connection, PreparedStatement stmt) {

		closeConnection(connection);

		if (isStmtOn(stmt)) {

			try {

				stmt.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}

	private static boolean isStmtOn(PreparedStatement stmt) {

		return stmt != null;
	}

	public static void closeConnection(Connection connection, PreparedStatement stmt, ResultSet rs) {

		closeConnection(connection, stmt);

		if (isRsOn(rs)) {

			try {

				rs.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}

	private static boolean isRsOn(ResultSet rs) {

		return rs != null;
	}

}
