package com.yuchu.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class dateUtil {

	/*public static String dateToStamp(String s) throws ParseException{
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        res = String.valueOf(ts);
        return res;
    }*/
	public static String dateToStamp(Date date){
//		String res;
//		long ts = date.getTime();
//		res = String.valueOf(ts);
		return String.valueOf(date.getTime()/1000);
	}
	public static String stampToDate(String s){
		
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Long lt = Long.parseLong(s);
        Date date = new Date(lt*1000);
        return simpleDateFormat.format(date);
    }
	@Test
	public void Test(){
		System.out.println(dateToStamp(new Date()));
	}
}
