package db;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class WifiServices {

    public  List<Wifi> list() {
    	
    	List<Wifi> wifiList = new ArrayList<>();

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

        String x_swifi_inout_doorValue = "실내";

        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);


            String sql = "SELECT * "
            		+ "FROM WifiInfo wi "
            		+ "WHERE x_swifi_inout_door LIKE  '실%' "
            		+ "ORDER by x_swifi_mgr_no;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, x_swifi_inout_doorValue);
            rs = preparedStatement.executeQuery();

            while(rs.next()) {

            	
            	String x_swifi_inout_door = rs.getString("x_swifi_inout_door");
                String x_swifi_instl_floor = rs.getString("x_swifi_instl_floor");
                String x_swifi_instl_mby = rs.getString("x_swifi_instl_mby");
                String x_swifi_remars3 = rs.getString("x_swifi_remars3");
                String x_swifi_instl_ty = rs.getString("x_swifi_instl_ty");
                String x_swifi_mgr_no = rs.getString("x_swifi_mgr_no");
                String x_swifi_wrdofc = rs.getString("x_swifi_wrdofc");
                String x_swifi_adres1 = rs.getString("x_swifi_adres1");
                String x_swifi_adres2 = rs.getString("x_swifi_adres2");
                String x_swifi_cmcwr = rs.getString("x_swifi_cmcwr");
                String work_dttm = rs.getString("work_dttm");
                String x_swifi_svc_se = rs.getString("x_swifi_svc_se");
                String x_swifi_main_nm = rs.getString("x_swifi_main_nm");
                String lnt1 = rs.getString("lnt");
                String x_swifi_cnstc_year = rs.getString("x_swifi_cnstc_year");
                String lat1 = rs.getString("lat");
                
                Wifi wifi = new Wifi();
                
                wifi.setX_swifi_inout_door(x_swifi_inout_door);
                wifi.setX_swifi_instl_floor(x_swifi_instl_floor);
                wifi.setX_swifi_instl_mby(x_swifi_instl_mby);
                wifi.setX_swifi_remars3(x_swifi_remars3);
                wifi.setX_swifi_instl_ty(x_swifi_instl_ty);
                wifi.setX_swifi_mgr_no(x_swifi_mgr_no);
                wifi.setX_swifi_wrdofc(x_swifi_wrdofc);
                wifi.setX_swifi_adres1(x_swifi_adres1);
                wifi.setX_swifi_adres2(x_swifi_adres2);
                wifi.setX_swifi_cmcwr(x_swifi_cmcwr);
                wifi.setWork_dttm(work_dttm);
                wifi.setX_swifi_svc_se(x_swifi_svc_se);
                wifi.setX_swifi_main_nm(x_swifi_main_nm);
                wifi.setLnt(lnt1);
                wifi.setX_swifi_cnstc_year(x_swifi_cnstc_year);
                wifi.setLat(lat1);

                
                wifiList.add(wifi);

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
        return wifiList;
    }

 public List<Wifi> getSearch(String lat, String lnt) {
	 
	 	List<Wifi> list = new ArrayList<Wifi>();	
	 
    	Wifi wifi = null;

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

        
        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);
            


            String sql = " SELECT * FROM WifiInfo wi "
            		+ " WHERE lat = ?  and lnt = ? "
            		+ " ORDER by x_swifi_mgr_no DESC  limit 20 ";
            		

            		
            
            	
           	
            	
           	preparedStatement = connection.prepareStatement(sql);
           	preparedStatement.setString(1, lat);
            preparedStatement.setString(2, lnt);
            	
             
            
            rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
            	
            	
                wifi = new Wifi();
                wifi.setDistance(rs.getString("distance"));
                wifi.setX_swifi_inout_door(rs.getString("x_swifi_inout_door"));
                wifi.setX_swifi_instl_floor(rs.getString("x_swifi_instl_floor"));
                wifi.setX_swifi_instl_mby(rs.getString("x_swifi_instl_mby"));
                wifi.setX_swifi_remars3(rs.getString("x_swifi_remars3"));
                wifi.setX_swifi_instl_ty(rs.getString("x_swifi_instl_ty"));
                wifi.setX_swifi_mgr_no(rs.getString("x_swifi_mgr_no"));
                wifi.setX_swifi_wrdofc(rs.getString("x_swifi_wrdofc"));
                wifi.setX_swifi_adres1(rs.getString("x_swifi_adres1"));
                wifi.setX_swifi_adres2(rs.getString("x_swifi_adres2"));
                wifi.setX_swifi_cmcwr(rs.getString("x_swifi_cmcwr"));
                wifi.setWork_dttm(rs.getString("work_dttm"));
                wifi.setX_swifi_svc_se(rs.getString("x_swifi_svc_se"));
                wifi.setX_swifi_main_nm(rs.getString("x_swifi_main_nm"));
                wifi.setLnt(rs.getString("lnt"));
                wifi.setX_swifi_cnstc_year(rs.getString("x_swifi_cnstc_year"));
                wifi.setLat(rs.getString("lat"));

                list.add(wifi);
                
                
               
                
                
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
                if (preparedStatement != null && !preparedStatement.isClosed()) {
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
            } catch (Exception e) {
            	e.printStackTrace();
            }

        }
        return list;
    }

    public void insert() {
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
    
    public void insertDistance(String sourceLat, String sourceLnt) {
    	java.sql.Statement stmt = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String filePath = "/Users/wangchanwoong/Documents/dev/workspace/WifiAPI/view/wifiinfo.json";
		
		String distance="", lat="", lnt=""; 
		
		
				
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
			String SQL = " INSERT into WifiInfo " 
				    + " (distance) "
				    + " values "
				    + " (6371 * acos ( "
				    + " cos ( radians(sourceLat) ) "
				    + " * cos( radians( ? ) ) "
				    + " * cos( radians( ?  ) - radians(sourceLnt) ) "
				    + " + sin ( radians(sourceLat) ) "
				    + " * sin( radians( ? ) ) "
				    + " )); ";
			//PreParedStatement 객체 생성, 객체 생성시 SQL 문장 저장
			pstmt = conn.prepareStatement(SQL);
			
			//psmt.set<데이터타입><? 순서, 값)
			//다건 JSON객체 (JSONArray)
			if(jsonArr.size()>0) {
				for(int i=0; i<jsonArr.size(); i++) {
					JSONObject jsonObj = (JSONObject)jsonArr.get(i);
					
					lat=(String)jsonObj.get("lat");
					lnt=(String)jsonObj.get("lnt");

					pstmt.setString(1, lat);
					pstmt.setString(2, lnt);
					pstmt.setString(3, lat);

					
					int r = pstmt.executeUpdate();
					
					
					
				}
			}

			//SQL문 작성
			String SQL2 = " INSERT into WifiInfo " 
				    + " (distance) "
				    + " values "
				    + " (6371 * acos ( "
				    + " cos ( radians(sourceLat) ) "
				    + " * cos( radians( ? ) ) "
				    + " * cos( radians( lnt  ) - radians(sourceLnt) ) "
				    + " + sin ( radians(sourceLat) ) "
				    + " * sin( radians( lat ) ) "
				    + " )); ";

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

    


