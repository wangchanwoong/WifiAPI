package db;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DataInsert {
	public static void main(String[] args) {
		java.sql.Statement stmt = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String filePath = "/Users/wangchanwoong/Documents/dev/workspace/WifiAPI/view/wifiinfo.json";

		String x_swifi_inout_door=""; String x_swifi_instl_floor=""; String x_swifi_instl_mby=""; String x_swifi_remars3="";
		String x_swifi_instl_ty=""; String x_swifi_mgr_no=""; String x_swifi_wrdofc=""; String x_swifi_adres1="";
		String x_swifi_adres2=""; String x_swifi_cmcwr=""; long work_dttm=0; String x_swifi_svc_se="";
		String x_swifi_main_nm=""; String lnt=""; String x_swifi_cnstc_year=""; String lat="";
		
		
		try{
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
		
			
			//테이블 없을 시 테이블 생성
			
			String query = "CREATE TABLE WifiInfo"
					+ "(";
					query += "x_swifi_inout_door varchar(100) ,";
					query += "x_swifi_instl_floor varchar(100) ,";
					query += "x_swifi_instl_mby varchar(100) ,";
					query += "x_swifi_remars3 varchar(100) ,";
					query += "x_swifi_instl_ty varchar(100) ,";
					query += "x_swifi_mgr_no varchar(100) NULL ,";
					query += "x_swifi_wrdofc varchar(100) ,";
					query += "x_swifi_adres1 varchar(100) NULL ,";
					query += "x_swifi_adres2 varchar(100) ,";
					query += "x_swifi_cmcwr varchar(100) ,";
					query += "work_dttm varchar(100) ,";
					query += "x_swifi_svc_se varchar(100) ,";
					query += "x_swifi_main_nm varchar(100) ,";
					query += "lnt varchar(100) ,";
					query += "x_swifi_cnstc_year varchar(100) ,";
					query += "lat varchar(100)"
							+ "); ";
			
			stmt = conn.createStatement();
			
			boolean b = stmt.execute(query);
			
			System.out.println("b : " + b);

		}catch(ClassNotFoundException ex){
			System.out.println("드라이버 로딩 실패");
			ex.printStackTrace();
		} catch (SQLException e) {
			System.out.println("sql오류 :이미 생성");
			//.printStackTrace();
		}finally {
			CloseUtil.close(null, stmt, conn);
		}
		
		//table create JDBC 로직 종료
		
		//insert into JDBC 로직
			
		try {
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
			
			//JSON 읽어와서 쿼리에 담기위한 사전작업
			Reader reader = new FileReader(filePath);
		    
		    JSONParser parser = new JSONParser();
		    
		    Object obj = parser.parse(reader);
		    JSONObject jsonMain = (JSONObject)obj;
		    JSONArray jsonArr = (JSONArray)jsonMain.get("DATA");
		    
			//SQL문 작성
			String SQL = "insert into WifiInfo"
					+ "(x_swifi_inout_door, x_swifi_instl_floor, x_swifi_instl_mby, x_swifi_remars3, "
					+ "x_swifi_instl_ty, x_swifi_mgr_no, x_swifi_wrdofc, x_swifi_adres1, "
					+ "x_swifi_adres2, x_swifi_cmcwr, work_dttm, x_swifi_svc_se, "
					+ "x_swifi_main_nm, lnt, x_swifi_cnstc_year, lat)"
					+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
			
			//PreParedStatement 객체 생성, 객체 생성시 SQL 문장 저장
			pstmt = conn.prepareStatement(SQL);
			
			//psmt.set<데이터타입><? 순서, 값)
			//다건 JSON객체 (JSONArray)
			if(jsonArr.size()>0) {
				for(int i=0; i<jsonArr.size(); i++) {
					JSONObject jsonObj = (JSONObject)jsonArr.get(i);
					
					
					x_swifi_inout_door=(String)jsonObj.get("x_swifi_inout_door");
					x_swifi_instl_floor=(String)jsonObj.get("x_swifi_instl_floor");
					x_swifi_instl_mby=(String)jsonObj.get("x_swifi_instl_mby");
					x_swifi_remars3=(String)jsonObj.get("x_swifi_remars3");
					x_swifi_instl_ty=(String)jsonObj.get("x_swifi_instl_ty");
					x_swifi_mgr_no=(String)jsonObj.get("x_swifi_mgr_no");
					x_swifi_wrdofc=(String)jsonObj.get("x_swifi_wrdofc");
					x_swifi_adres1=(String)jsonObj.get("x_swifi_adres1");
					x_swifi_adres2=(String)jsonObj.get("x_swifi_adres2");
					x_swifi_cmcwr=(String)jsonObj.get("x_swifi_cmcwr");
					work_dttm=(Long)jsonObj.get("work_dttm");
					x_swifi_svc_se=(String)jsonObj.get("x_swifi_svc_se");
					x_swifi_main_nm=(String)jsonObj.get("x_swifi_main_nm");
					lnt=(String)jsonObj.get("lnt");
					x_swifi_cnstc_year=(String)jsonObj.get("x_swifi_cnstc_year");
					lat=(String)jsonObj.get("lat");
					
					pstmt.setString(1, x_swifi_inout_door);
					pstmt.setString(2, x_swifi_instl_floor);
					pstmt.setString(3, x_swifi_instl_mby);
					pstmt.setString(4, x_swifi_remars3);
					pstmt.setString(5, x_swifi_instl_ty);
					pstmt.setString(6, x_swifi_mgr_no);
					pstmt.setString(7, x_swifi_wrdofc);
					pstmt.setString(8, x_swifi_adres1);
					pstmt.setString(9, x_swifi_adres2);
					pstmt.setString(10, x_swifi_cmcwr);
					pstmt.setLong(11, work_dttm);
					pstmt.setString(12, x_swifi_svc_se);
					pstmt.setString(13, x_swifi_main_nm);
					pstmt.setString(14, lnt);
					pstmt.setString(15, x_swifi_cnstc_year);
					pstmt.setString(16, lat);
					
					int r = pstmt.executeUpdate();
					
					System.out.println((String)jsonObj.get("X_SWIFI_MGR_NO"));
					System.out.println((String)jsonObj.get("X_SWIFI_MAIN_NM"));
					System.out.println((String)jsonObj.get("X_SWIFI_SVC_SE"));
					
					System.out.println("SQL 실행:"+r+"개 의 row삽입");
				}
			}

			//SQL문 작성
			String SQL2 = "insert into WifiInfo"
					+ "(x_swifi_inout_door, x_swifi_instl_floor, x_swifi_instl_mby, x_swifi_remars3, "
					+ "x_swifi_instl_ty, x_swifi_mgr_no, x_swifi_wrdofc, x_swifi_adres1, "
					+ "x_swifi_adres2, x_swifi_cmcwr, work_dttm, x_swifi_svc_se, "
					+ "x_swifi_main_nm, lnt, x_swifi_cnstc_year, lat)"
					+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
			//PreParedStatement 객체 생성, 객체 생성시 SQL 문장 저장
			pstmt = conn.prepareStatement(SQL2);
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			CloseUtil.close(null, stmt, conn);
		}
		
	}

}



