package Dao.DaoImplementation;

import java.sql.*;

/**
 * Created by SELPHA on 14/2/2018.
 */
public class DBUtil {
    final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String URL = "jdbc:mysql://localhost/school";
    static final String user= "root";
    static final String password = "";
    static Connection conn = null;
    Statement stmt = null;

//create a connection
    public DBUtil(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, user, password);
            conn.setAutoCommit(false);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException s){
            s.printStackTrace();
        }

    }
//read from the DB
    public ResultSet read(String sql){
        ResultSet rs = null;
        try {

            System.out.println("Creating a statement");
            this.stmt = conn.createStatement();

            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();
        } catch (Exception e){
            e.getMessage();
            e.printStackTrace();
        }

        return rs;
    }

//write to DB
    public int write(String sql){
        int k=0;
        try {
            this.stmt = conn.createStatement();
            k = stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();
        } catch (Exception e){
            e.getMessage();
            e.printStackTrace();
        }

        return k;
    }
//close connection
    public void cleanUp(ResultSet rs) {
        try{
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }finally {
            try {
                if (stmt!=null){
                    stmt.close();
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
            try {
                if (conn!=null){
                    conn.close();
                }
            } catch (SQLException e3) {
                e3.printStackTrace();
            }
        }

    }

    //close connection
    public void cleanUp()  {
        try{
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }finally {
            try {
                if (stmt!=null){
                    stmt.close();
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
            try {
                if (conn!=null){
                    conn.close();
                }
            } catch (SQLException e3) {
                e3.printStackTrace();
            }
        }

    }

    @Override
    protected void finalize() throws Throwable {
        cleanUp();
    }
}
