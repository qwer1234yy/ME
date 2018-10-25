package myutils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.commons.beanutils.BeanUtils;

public class DBTools {
	public static Connection getConnection() throws Exception {
		String dburl = null;
		String user = null;
		String password = null;
		String driverClass = null;
		Properties properties = new Properties();
		InputStream input = DBTools.class.getResourceAsStream("dbProperties.properties");
		properties.load(input);
		user = properties.getProperty("user");
		password = properties.getProperty("password");
		dburl = properties.getProperty("dburl");
		driverClass = properties.getProperty("driverClass");
		Class.forName(driverClass);
		Connection aConnection = DriverManager.getConnection(dburl, user, password);
		return aConnection;
	}

	public static void Update(String sql, Object... args) {
		Connection aConnection = null;
		PreparedStatement aStatement = null;

		try {
			aConnection = getConnection();
			aStatement = aConnection.prepareStatement(sql);
			int e = args.length;

			for (int i = 0; i < args.length; ++i) {
				aStatement.setObject(i + 1, args[i]);
			}

			aStatement.executeUpdate();
		} catch (Exception arg17) {
			arg17.printStackTrace();
		} finally {
			if (aStatement != null) {
				try {
					aStatement.close();
				} catch (SQLException arg16) {
					arg16.printStackTrace();
				}

				if (aConnection != null) {
					try {
						aConnection.close();
					} catch (SQLException arg15) {
						arg15.printStackTrace();
					}
				}
			}

		}

	}

	public static void releaseConnection(ResultSet r, PreparedStatement p, Connection c) {
		if (r != null) {
			try {
				r.close();
			} catch (SQLException arg5) {
				arg5.printStackTrace();
			}
		}

		if (p != null) {
			try {
				p.close();
			} catch (SQLException arg4) {
				arg4.printStackTrace();
			}
		}

		if (c != null) {
			try {
				c.close();
			} catch (SQLException arg3) {
				arg3.printStackTrace();
			}
		}

	}

	public static <T> T get(Class<T> clazz, String sql, Object... args) {
		Object  entity = null;
		Connection aConnection = null;
		PreparedStatement aPreparedStatement = null;
		ResultSet aResultSet = null;
		HashMap values = new HashMap();

		try {
			aConnection = getConnection();
			aPreparedStatement = aConnection.prepareStatement(sql);

			for (int e = 0; e < args.length; ++e) {
				aPreparedStatement.setObject(e + 1, args[e]);
			}

			aResultSet = aPreparedStatement.executeQuery();
			ResultSetMetaData arg17 = aResultSet.getMetaData();

			while (aResultSet.next()) {
				for (int entry = 0; entry < arg17.getColumnCount(); ++entry) {
					values.put(arg17.getColumnName(entry + 1), aResultSet.getObject(arg17.getColumnName(entry + 1)));
				}
			}

			System.out.println(values);
			entity = clazz.newInstance();
			Iterator arg9 = values.entrySet().iterator();

			while (arg9.hasNext()) {
				Entry arg18 = (Entry) arg9.next();
				String fieldName = (String) arg18.getKey();
				Object fieldValues = arg18.getValue();
				System.out.println(fieldName + ":" + fieldValues);
				BeanUtils.setProperty(entity, fieldName, fieldValues);
			}
		} catch (Exception arg15) {
			arg15.printStackTrace();
		} finally {
			releaseConnection(aResultSet, aPreparedStatement, aConnection);
		}

		return (T) entity;
	}

	public static <T> List<T> getList(Class<T> clazz, String sql, Object... args) {
		ArrayList entitylist = new ArrayList();
		Object entity = null;
		Connection aConnection = null;
		PreparedStatement aPreparedStatement = null;
		ResultSet aResultSet = null;
		HashMap values = null;
		ArrayList entitylistmap = new ArrayList();

		try {
			aConnection = getConnection();
			aPreparedStatement = aConnection.prepareStatement(sql);

			for (int e = 0; e < args.length; ++e) {
				aPreparedStatement.setObject(e + 1, args[e]);
			}

			aResultSet = aPreparedStatement.executeQuery();
			ResultSetMetaData arg21 = aResultSet.getMetaData();

			while (aResultSet.next()) {
				values = new HashMap();

				for (int map = 0; map < arg21.getColumnCount(); ++map) {
					System.out.println(arg21.getColumnName(map + 1));
					System.out.println(aResultSet.getObject(map + 1));
					values.put(arg21.getColumnName(map + 1), aResultSet.getObject(map + 1));
				}

				entitylistmap.add(values);
			}

			for (Iterator arg11 = entitylistmap.iterator(); arg11.hasNext(); entitylist.add(entity)) {
				Map arg22 = (Map) arg11.next();
				if (values.size() > 0) {
					entity = clazz.newInstance();
					Iterator arg13 = arg22.entrySet().iterator();

					while (arg13.hasNext()) {
						Entry entry = (Entry) arg13.next();
						String fieldName = (String) entry.getKey();
						Object fieldValues = entry.getValue();
						System.out.println(fieldName + ":" + fieldValues);
						ReflectionUtils.setFieldValue(entity, fieldName, fieldValues);
					}
				}
			}
		} catch (Exception arg19) {
			arg19.printStackTrace();
		} finally {
			releaseConnection(aResultSet, aPreparedStatement, aConnection);
		}

		return entitylist;
	}

	public static <E> E getforValue(String sql, Object... args) {
		Connection aConnection = null;
		PreparedStatement aStatement = null;
		ResultSet aResultSet = null;

		try {
			aConnection = getConnection();
			aStatement = aConnection.prepareStatement(sql);

			for (int e = 0; e < args.length; ++e) {
				aStatement.setObject(e + 1, args[e]);
			}

			System.out.println(aStatement);
			aResultSet = aStatement.executeQuery();
			if (aResultSet.next()) {
				Object arg6 = aResultSet.getObject(1);
				return (E) arg6;
			}
		} catch (Exception arg9) {
			arg9.printStackTrace();
		} finally {
			releaseConnection(aResultSet, aStatement, aConnection);
		}

		return null;
	}

	public static <E> List<E> getforValueList(String sql, Object... args) {
		Connection aConnection = null;
		PreparedStatement aStatement = null;
		ResultSet aResultSet = null;
		ArrayList valueList = new ArrayList();

		try {
			aConnection = getConnection();
			aStatement = aConnection.prepareStatement(sql);

			for (int e = 0; e < args.length; ++e) {
				aStatement.setObject(e + 1, args[e]);
			}

			System.out.println(aStatement);
			aResultSet = aStatement.executeQuery();
			ResultSetMetaData arg12 = aResultSet.getMetaData();

			while (aResultSet.next()) {
				valueList.add(aResultSet.getObject(1));
			}

			ArrayList arg7 = valueList;
			return arg7;
		} catch (Exception arg10) {
			arg10.printStackTrace();
		} finally {
			releaseConnection(aResultSet, aStatement, aConnection);
		}

		return null;
	}
}
