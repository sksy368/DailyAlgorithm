package May_2022.week2;

import java.io.*;
import java.util.*;

public class Recruitment_2022_GIT_5 {
	
	static class User {
		int uid, cid;
		String name;
		User(int uid, String name, int cid){
			this.uid = uid;
			this.name = name;
			this.cid = cid;
		}
	}
	
	static class Brand {
		int bid;
		String name;
		Brand(int bid, String name){
			this.bid = bid;
			this.name = name;
		}
	}
	
	static class Car {
		int cid, bid;
		String name;
		Car(int cid, String name, int bid){
			this.cid = cid;
			this.name = name;
			this.bid = bid;
		}
	}
	
	static HashMap<String, User> userMap;
	static HashMap<Integer, Brand> brandMap;
	static HashMap<Integer, Car> carMap;

	public static void main(String[] args) throws Exception {
		String UserList = "<Root><UserInfo name=\"KES\" uid=\"1\" cid=\"1\" /><UserInfo name=\"KDH\" uid=\"2\" cid=\"1\" /><UserInfo name=\"CDK\" uid=\"3\" cid=\"2\" /><UserInfo name=\"NDW\" uid=\"4\" cid=\"3\" /></Root>";
		String BrandList = "<Root><BrandInfo bid=\"1\" name=\"Hyundai\" /><BrandInfo bid=\"2\" name=\"KIA\" /><BrandInfo bid=\"3\" name=\"BMW\" /><BrandInfo bid=\"4\" name=\"Tesla\" /></Root>";
		String CarList = "<Root><CarInfo cid=\"1\" name=\"Genesis G90\" bid=\"1\" /><CarInfo cid=\"2\" name=\"스포티지R\" bid=\"2\" /><CarInfo cid=\"3\" name=\"Model Y\" bid=\"4\" /><CarInfo cid=\"4\" name=\"iX\" bid=\"3\" /></Root>";
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		userMap = new HashMap<>();
		brandMap = new HashMap<>();
		carMap = new HashMap<>();
		
		set(UserList, BrandList, CarList);
		
		if(userMap.containsKey(input)) {
			User user = userMap.get(input);
			Car car = carMap.get(user.cid);
			Brand brand = brandMap.get(car.bid);
			
			System.out.println(user.name + " : " + user.uid + ", " + brand.name + ", " + car.name);
		}
		else
			System.out.println("정보가 올바르지 않습니다.");
	}
	
	public static void set(String UserList, String BrandList, String CarList) {
		String[] userList = UserList.split(" />");
		
		for(int i = 0; i < userList.length-1; i++) {
			int uid = -1;
			String name = "";
			int cid = -1;
			
			String[] subSt = userList[i].split(" ");
			for(int j = 1; j <= 3; j++) {
				String subInfo = subSt[subSt.length-j];
				if("name".equals(subInfo.substring(0, 4))) {
					name = subInfo.substring(6, subInfo.length()-1);
				} else if("uid".equals(subInfo.substring(0, 3))) {
					uid = Integer.parseInt(subInfo.substring(5, subInfo.length()-1));
				} else if("cid".equals(subInfo.substring(0, 3))) {
					cid = Integer.parseInt(subInfo.substring(5, subInfo.length()-1));
				}
			}
			
			userMap.put(name, new User(uid, name, cid));
		}
		
		String[] brandList = BrandList.split(" />");
		for(int i = 0; i < brandList.length-1; i++) {
			int bid = -1;
			String name = "";
			
			String[] subSt = brandList[i].split(" ");
			for(int j = 1; j <= 2; j++) {
				String subInfo = subSt[subSt.length-j];
				if("name".equals(subInfo.substring(0, 4))) {
					name = subInfo.substring(6, subInfo.length()-1);
				} else if("bid".equals(subInfo.substring(0, 3))) {
					bid = Integer.parseInt(subInfo.substring(5, subInfo.length()-1));
				}
			}
			
			brandMap.put(bid, new Brand(bid, name));
		}
		
		String[] carList = CarList.split(" />");
		for(int i = 0; i < carList.length-1; i++) {
			int cid = -1;
			String name = "";
			int bid = -1;
			
			String[] subSt = carList[i].split("\" ");
			for(int j = 1; j <= 3; j++) {
				String subInfo = subSt[subSt.length-j];
				System.out.println(subInfo);
				if("bid".equals(subInfo.substring(0, 3))) {
					bid = Integer.parseInt(subInfo.substring(5, subInfo.length()-1));
				} else if("name".equals(subInfo.substring(0, 4))) {
					name = subInfo.substring(6);
				} else if("cid".equals(subInfo.substring(0, 3))) {
					cid = Integer.parseInt(subInfo.substring(5));
				}
			}
			
			carMap.put(cid, new Car(cid, name, bid));
		}
	}
}
