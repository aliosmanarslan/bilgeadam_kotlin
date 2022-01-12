package appPack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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


    // item delete
    public int delete( int uid ) {
        open();
        try {

            String sql = "delete from user where uid = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, uid);
            return pre.executeUpdate();

        }catch (Exception ex) {
            System.err.println("delete error : " + ex);
        }finally {
            close();
        }
        return 0;
    }


    // list
    public List<User> list(String q) {
        List<User> ls = new ArrayList<>();
        open();
        try {

            String sql = "select * from user";
            if ( !q.equals("") ) {
                sql = "select * from user where name like ? or email like ? ";
            }
            PreparedStatement pre = conn.prepareStatement(sql);
            if ( !q.equals("") ) {
                pre.setString(1, "%"+q+"%");
                pre.setString(2, "%"+q+"%");
            }

            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                int uid = rs.getInt("uid");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");

                User u = new User(uid,name,email,password);
                ls.add(u);
            }

        }catch (Exception ex) {
            System.err.println("list Error :" + ex);
        }finally {
            close();
        }

        return ls;
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
