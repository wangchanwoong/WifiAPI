package db;


import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.ParseException;

public class History {
	public void insert(String lat, String lnt) throws IOException, ParseException {
    	java.sql.Statement stmt = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		
		
		
		
		//insert into JDBC 로직
			
		try {
			String lat1 = "", lnt1 = "";
			
			String driverClassName = "org.mariadb.jdbc.Driver";
			String url = "jdbc:mariadb://127.0.0.1:3306/wifi_api";
			String user = "wifi_api";
			String password = "zerobase";
			
			//JDBC Driver Loading
			Class.forName(driverClassName);
			
			//JDBC Connection getting
			conn = DriverManager.getConnection(url, user, password);
			
			System.out.println("DB 연결 성공");
			System.out.println("** Driver:" + driverClassName + ", Connection:" + conn);
			
			
			//SQL문 작성
			String SQL = "insert into history"
					+ "(ID, x좌표, y좌표, 검색일자)"
					+ " values(?,?,?,now());";
			
			//PreParedStatement 객체 생성, 객체 생성시 SQL 문장 저장
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, lat1);
			pstmt.setString(2, lnt1);
			
			
			
					
				
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			CloseUtil.close(null, stmt, conn);
		}
	}	
	
	public  List<HistoryList> list() {
	
	List<HistoryList> historyList = new ArrayList<>();

    String url = "jdbc:mariadb://127.0.0.1:3306/wifi_api";
    String dbUserId = "wifi_api";
    String dbPassword = "zerobase";

    try {
        Class.forName("org.mariadb.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
    }

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet rs = null;

    String idValue = "ID";

    try {
        connection = DriverManager.getConnection(url, dbUserId, dbPassword);


        String sql = "SELECT * "
        		+ "FROM history "
        		+ "ORDER by ID;";
        
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, idValue);
        rs = preparedStatement.executeQuery();

        while(rs.next()) {

        	
        	
            String lnt1 = rs.getString("lnt");
            String lat1 = rs.getString("lat");
            
            HistoryList hL = new HistoryList();
            
            
            hL.setLnt(lnt1);
            hL.setLat(lat1);

            
            historyList.add(hL);

        }

    } catch (SQLException e) {
        throw new RuntimeException(e);
    } finally {
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            if (preparedStatement != null && preparedStatement.isClosed()) {
                preparedStatement.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            if (connection != null && connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    return historyList;
}

}
