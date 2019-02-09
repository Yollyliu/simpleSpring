package Model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DbDao{

    private Connection conn;
    private String driver;
    private String url;
    private String username;
    private String password;

    public DbDao(){

    }

    public DbDao(String driver, String url, String username, String password) {
        this.driver = driver;
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Connection getConnection() throws Exception{
        if(conn==null){
            Class.forName(this.driver);
            conn=(Connection) DriverManager.getConnection(url,username,this.password);

        }
        return conn;
    }

    public boolean insert(String sql, Object...args) throws Exception{
        PreparedStatement ps=
                (PreparedStatement) getConnection().prepareStatement(sql);
        for(int i=0;i<args.length;i++){
            ps.setObject(i+1,args[i]);
        }
        if(ps.executeUpdate()!=1){
            return false;
        }
        return true;
    }

    public ResultSet query(String sql,Object...args) throws Exception{
        PreparedStatement ps=
                (PreparedStatement) getConnection().prepareStatement(sql);
        for(int i=0;i<args.length;i++){
            ps.setObject(i+1,args[i]);
        }
        return ps.executeQuery();
    }

    public void modify(String sql,Object...args) throws Exception{
        PreparedStatement ps=
                (PreparedStatement) getConnection().prepareStatement(sql);
        for(int i=0;i<args.length;i++){
            ps.setObject(i+1,args[i]);
        }
        ps.executeUpdate();
        ps.close();
    }

    public void closeConn() throws Exception{
        if(conn!=null &&!conn.isClosed()){
            conn.close();
        }
    }

}


