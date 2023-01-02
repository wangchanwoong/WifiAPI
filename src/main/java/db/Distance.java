package db;


public class Distance {
	public static String getDistance (String lat, String lnt, String lat2, String lnt2) {
				
		double dLat1 = Double.parseDouble(lat);
		double dLnt1 = Double.parseDouble(lnt);
		double dLat2 = Double.parseDouble(lat2);
		double dLnt2 = Double.parseDouble(lnt2);
		
		double theta = 0;
		
		if (dLnt1 > dLnt2) {
			theta = dLnt1 - dLnt2;
		} else {
			theta = dLnt2 - dLnt1;
		}
		double dist = Math.sin(deg2rad(dLat1)) * Math.sin(deg2rad(dLat2)) + Math.cos(deg2rad(dLat1))
			* Math.cos(deg2rad(dLat2)) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = ((dist * 60 * 1.1515 * 1609.344) / 1000) + ((dist * 60 * 1.1515 * 1609.344) % 1000);
		
		
		String sDist = String.valueOf(dist);
		
		return sDist; 
	}
	
	private static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}
	
	private static double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}
	
	
}
