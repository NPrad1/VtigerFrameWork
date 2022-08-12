package comcast.vtiger.genericUtility;

import java.util.Date;
import java.util.Random;

public class Java_utility {
	public int getRandomNum() {
		Random ran=new Random();
		int RanNum=ran.nextInt(1000);
		return RanNum;
	}
	public String getSystemDateinIST() {
		Date date=new Date();
		String currentDate = date.toString();
		System.out.println(currentDate);
		String[] arr = currentDate.split("");
		String DD = arr[2];
		@SuppressWarnings("deprecation")
		int MM=date.getMonth()+1;
		String YYYY = arr[5];
		String formate = DD+"-"+MM+"-"+YYYY;
		
		
		
		return formate;
		
	}

}
