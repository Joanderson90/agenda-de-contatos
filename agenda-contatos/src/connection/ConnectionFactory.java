package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.PreparableStatement;

public class ConnectionFactory {

	private final String DRIVER = "com.mysql.jdbc.Driver";
	private final String URL = "jdbc:mysql://localhost/3306/cadastro";
	private final String USER = "root";
	private final String PASSWORD = "";

	public Connection getConnection() {

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

	public static void closeConnection(Connection connection, PreparableStatement<?> stmt) {

		closeConnection(connection);

		if (isStmtOn(stmt)) {

			try {

				((Connection) stmt).close();

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}

	private static boolean isStmtOn(PreparableStatement<?> stmt) {

		return stmt != null;
	}

	public static void closeConnection(Connection connection, PreparableStatement<?> stmt, ResultSet rs) {

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
