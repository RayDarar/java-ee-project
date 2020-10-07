package practice.services;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseService {
  public static Connection getConnection() {
    try {
      String dbDriver = "com.mysql.jdbc.Driver";

      // this should be configurable elsewhere,
      // but for the simplicity, I'll go with hardcoded one
      String dbURL = "jdbc:mysql:// localhost:3306/";
      String dbName = "java_ee_project";
      String dbUsername = "root";
      String dbPassword = "super_secret";

      Class.forName(dbDriver);
      Connection con = DriverManager.getConnection(dbURL + dbName, dbUsername, dbPassword);
      return con;
    } catch (Exception e) {
      System.exit(-1);
      return null;
    }
  }
}
