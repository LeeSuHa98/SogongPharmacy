package �Ұ��౹_�ŷ�ó����;

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

    // �����ͺ��̽��� �����Ѵ�.
    public Connection dbConn() {
         String url = "jdbc:mysql://localhost:3306/pharmacy?serverTimezone=UTC";
         String id = "root"; 
         String pwd = "pokbrw589"; 
        try {
        	Class.forName("com.mysql.jdbc.Driver"); 
            conn = DriverManager.getConnection(url, id, pwd);
            System.out.println("����Ϸ�");

        } catch (Exception e) {	
        	System.out.println("�������");
            e.printStackTrace();
        }
        return conn;
    }
	
	// �����ͺ��̽��� �ݴ´�.
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
