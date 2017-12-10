package pl.coderslab.db;

import org.joda.time.DateTime;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DbUtil {
	private static DataSource ds;

	public static Connection getConn() throws SQLException {
		return getInstance().getConnection();
	}

	private static DataSource getInstance() {
		if (ds == null) {
			try {
				Context ctx = new InitialContext();
				ds = (DataSource) ctx.lookup("java:comp/env/jdbc/school");
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
		return ds;
	}

	public static String convert(Date d) {
		return new Timestamp(d.getTime()).toString();
	}

	public static String convert(DateTime dt) {
		return new Timestamp(dt.getMillis()).toString();
	}
}
