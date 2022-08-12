package practice;

import java.util.Date;

public class systemDate {
	public static void main(String[] args) {
		Date date=new Date();
		String currentDate = date.toString();
		System.out.println(currentDate);
		String[] arr = currentDate.split(" ");
		String DD = arr[2];
		@SuppressWarnings("deprecation")
		int MM=date.getMonth()+1;
		String YYYY = arr[5];
		System.out.println(DD+"-"+MM+"-"+YYYY);
		
	}

}
