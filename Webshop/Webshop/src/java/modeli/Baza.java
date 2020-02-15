package modeli;
import java.sql.*;

public class Baza {
    public Connection conn;
    public Statement stmt;
    public Baza() { conn=null; stmt=null; }
    public void connect() throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         //Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection( "jdbc:sqlserver://localhost", "sa", "SQL" );
        //conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306?useSSL=false&characterEncoding=UTF-8&useUnicode=yes", "ivan", "B4CKl0t1!1" );
        stmt = conn.createStatement();
        stmt.executeUpdate("USE [Projektni zadatak - internet trgovina]");
        //stmt.executeUpdate("SET NAMES utf8"); // potrebno za mysql zbog utf8 skupa znakova
    }
    public void  disconnect() throws SQLException {
        stmt.close();
        conn.close();
    }
    public ResultSet selectupit(String s) throws SQLException {
        Statement st = conn.createStatement();
        return st.executeQuery(s);
    }
    public int upit(String s) throws SQLException {
        return stmt.executeUpdate(s);
    }
}
