package appPack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DB {

    private final String driver = "org.sqlite.JDBC";
    private final String url = "jdbc:sqlite:kotlin.db";

    private Connection conn = null;
    public DB() { }


    private void open() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url);
            //System.out.println("Connection Success");
        }catch (Exception ex) {
            System.err.println("DB Connection Fail : " + ex);
        }
    }


    // sqlite login
    public boolean login( String email, String password ) {
        open();
        try {

            String sql = " select * from user where email = ? and password = ? ";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, email);
            pre.setString(2, password);
            ResultSet rs = pre.executeQuery();
            return rs.next();

        } catch (Exception ex) {
            System.err.println("login error : " + ex);
            return false;
        }finally {
            close();
        }
    }

    // boolean emailControl(String email);

    // user register
    public int register( String name, String email, String password ) {
        open();
        try {

            String sql = "insert into user values( null, ?, ?, ? )";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, name);
            pre.setString(2, email);
            pre.setString(3, password);
            int row = pre.executeUpdate();
            return row;
        }catch (Exception ex) {
            //System.err.println("register error :" + ex);
            if ( ex.toString().contains("SQLITE_CONSTRAINT_UNIQUE") ) {
                return -1;
            }
        }finally {
            close();
        }
        return 0;
    }


    // item update
    public int update( int uid, String name, String email, String password ) {
        open();
        try {

            String sql = "update user set name = ?, email = ?, password = ? where uid = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, name);
            pre.setString(2, email);
            pre.setString(3, password);
            pre.setInt(4, uid);
            int status = pre.executeUpdate();
            return status;

        }catch (Exception ex) {
            //System.err.println("Update Error : " + ex);
            if ( ex.toString().contains("SQLITE_CONSTRAINT_UNIQUE") ) {
                return -1;
            }
        }finally {
            close();
        }
        return 0;
    }


    private void close() {
        try {
            if ( !conn.isClosed() ) {
                conn.close();
            }
        }catch (Exception ex) {
            System.err.println("close Error : " + ex);
        }
    }



}
