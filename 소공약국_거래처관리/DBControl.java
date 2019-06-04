package 소공약국_거래처관리;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBControl {
	public Connection conn = null;
	public Statement st = null;
	public PreparedStatement pst = null;
	public PreparedStatement pst2 = null;
	public ResultSet rs = null;
	public ResultSet rs2 = null;

	public DBControl(){}

    // 데이터베이스를 연결한다.
    public Connection dbConn() {
         String url = "jdbc:mysql://localhost:3306/pharmacy?serverTimezone=UTC";
         String id = "root"; 
         String pwd = "pokbrw589"; 
        try {
        	Class.forName("com.mysql.jdbc.Driver"); 
            conn = DriverManager.getConnection(url, id, pwd);
            System.out.println("연결완료");

        } catch (Exception e) {	
        	System.out.println("연결실패");
            e.printStackTrace();
        }
        return conn;
    }
	
	// 데이터베이스를 닫는다.
	public void dbClose(){
		try{
			if (rs != null) rs.close();
			if (st != null) st.close();
			if (conn != null) conn.close();
			System.out.println("Disconnection Succeeded.");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
