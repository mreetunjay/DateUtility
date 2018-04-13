package com.jisl.fundmanagement.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.jisl.fundmanagement.model.DataValueBean;
import com.jisl.fundmanagement.model.Report;


/*
*This is example of various date utility
*/
public class DateUtility {

	public static String dateToStringInDDMMMYYYY(Date date) {
		DateFormat formatter = new SimpleDateFormat("ddMMMyyyy");
		String sdate = formatter.format(date);
		return sdate;
	}

	public static String dateToString(Date date) {
		if (date != null) {
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			String sdate = formatter.format(date);
			return sdate;
		} else {
			return null;
		}
	}
	public static String dateToString1(Date date) {
		if (date != null) {
			DateFormat formatter = new SimpleDateFormat("MM/yyyy");
			String sdate = formatter.format(date);
			return sdate;
		} else {
			return null;
		}
	}
	
	public static String dateToStringByFormat(Date date,String format) {
        if (date != null) {
            DateFormat formatter = new SimpleDateFormat(format);
            String sdate = formatter.format(date);
            return sdate;
        } else {
            return null;
        }
    }

	public static String dayOfMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 1);
		int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		SimpleDateFormat df = new SimpleDateFormat("dd/MMM/yy");
		for (int i = 1; i < maxDay; i++) {
			cal.set(Calendar.DAY_OF_MONTH, i + 1);
		}
		return null;
	}

	public static List<String> getAllDayOfMonth(String date) {
		// Date fromDate = new Date();
		// Date toDate = new Date();
		Calendar calender = Calendar.getInstance();
		if (date != null && !date.equals("")) {
			try {
				DateFormat dateFormat = new SimpleDateFormat("MM/yyyy");
				Date date1 = dateFormat.parse(date);
				calender.setTime(date1);
			} catch (Exception e) {
			}
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int curmonth = cal.get(Calendar.MONTH);
		int curyear = cal.get(Calendar.YEAR);
		int month = calender.get(Calendar.MONTH);
		int year = calender.get(Calendar.YEAR);
		/*
		 * calender.set(Calendar.DAY_OF_MONTH, 1); fromDate =
		 * calender.getTime(); calender.set(Calendar.DAY_OF_MONTH,
		 * calender.getActualMaximum(Calendar.DAY_OF_MONTH)); toDate =
		 * calender.getTime();
		 */
		List<String> ls = new ArrayList<String>();
		SimpleDateFormat df = new SimpleDateFormat("dd");
		if (curmonth == month && curyear == year) {
			calender.set(Calendar.DAY_OF_MONTH, 1);
			int day = cal.get(Calendar.DAY_OF_MONTH);
			for (int i = 0; i < day; i++) {
				calender.set(Calendar.DAY_OF_MONTH, i + 1);
				ls.add(df.format(calender.getTime()));
			}
		} else {
			calender.set(Calendar.DAY_OF_MONTH, 1);
			int maxDay = calender.getActualMaximum(Calendar.DAY_OF_MONTH);

			for (int i = 0; i < maxDay; i++) {
				calender.set(Calendar.DAY_OF_MONTH, i + 1);
				ls.add(df.format(calender.getTime()));
			}
		}
		return ls;
	}

	public static List<String> getAllDayOfMonth1(String date) {
		/*
		 * Date fromDate = new Date(); Date toDate = new Date();
		 */
		Calendar calender = Calendar.getInstance();
		if (date != null && !date.equals("")) {
			try {
				DateFormat dateFormat = new SimpleDateFormat("MM/yyyy");
				Date date1 = dateFormat.parse(date);
				calender.setTime(date1);
			} catch (Exception e) {
			}
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int curmonth = cal.get(Calendar.MONTH);
		int curyear = cal.get(Calendar.YEAR);
		int month = calender.get(Calendar.MONTH);
		int year = calender.get(Calendar.YEAR);
		/*
		 * calender.set(Calendar.DAY_OF_MONTH, 1); fromDate =
		 * calender.getTime(); calender.set(Calendar.DAY_OF_MONTH,
		 * calender.getActualMaximum(Calendar.DAY_OF_MONTH)); toDate =
		 * calender.getTime();
		 */
		List<String> ls = new ArrayList<String>();
		SimpleDateFormat df = new SimpleDateFormat("dd-MMM");
		if (curmonth == month && curyear == year) {
			calender.set(Calendar.DAY_OF_MONTH, 1);
			int day = cal.get(Calendar.DAY_OF_MONTH);
			for (int i = 0; i < day; i++) {
				calender.set(Calendar.DAY_OF_MONTH, i + 1);
				ls.add(df.format(calender.getTime()));
			}
		} else {
			calender.set(Calendar.DAY_OF_MONTH, 1);
			int maxDay = calender.getActualMaximum(Calendar.DAY_OF_MONTH);
			for (int i = 0; i < maxDay; i++) {
				calender.set(Calendar.DAY_OF_MONTH, i + 1);
				ls.add(df.format(calender.getTime()));
			}
		}
		return ls;
	}

	public static List<String> getMonthList(String monthFrom, String monthTo) {
		try {
			String[] tempData = monthTo.split("/");
			Integer n = (Integer.parseInt(tempData[0]) + 1);
			monthTo = n.toString() + "/" + tempData[1];
			List<String> monthList = new ArrayList<String>();
			DateFormat formater = new SimpleDateFormat("MM/yyyy");
			DateFormat formater1 = new SimpleDateFormat("MMM-yyyy");

			Calendar beginCalendar = Calendar.getInstance();
			Calendar finishCalendar = Calendar.getInstance();

			try {
				beginCalendar.setTime(formater.parse(monthFrom));
				finishCalendar.setTime(formater.parse(monthTo));
			} catch (ParseException e) {
				e.printStackTrace();
			}

			while (beginCalendar.before(finishCalendar)) {
				// add one month to date per loop
				String date = formater1.format(beginCalendar.getTime()).toUpperCase();
				monthList.add(date);
				beginCalendar.add(Calendar.MONTH, 1);
			}
			return monthList;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public static List<String> getMonthList1(String monthFrom, String monthTo) {
		try {
			String[] tempData = monthTo.split("/");
			Integer n = (Integer.parseInt(tempData[0]) + 1);
			monthTo = n.toString() + "/" + tempData[1];
			List<String> monthList = new ArrayList<String>();
			DateFormat formater = new SimpleDateFormat("MM/yyyy");
			DateFormat formater1 = new SimpleDateFormat("MM-yyyy");

			Calendar beginCalendar = Calendar.getInstance();
			Calendar finishCalendar = Calendar.getInstance();

			try {
				beginCalendar.setTime(formater.parse(monthFrom));
				finishCalendar.setTime(formater.parse(monthTo));
			} catch (ParseException e) {
				e.printStackTrace();
			}

			while (beginCalendar.before(finishCalendar)) {
				// add one month to date per loop
				String date = formater1.format(beginCalendar.getTime()).toUpperCase();
				monthList.add(date);
				beginCalendar.add(Calendar.MONTH, 1);
			}
			return monthList;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public static Map<String, String> getWeekDays(String date) {

		Map<String, String> dvb = new LinkedHashMap<String, String>();
		int j = 0;
		Calendar c = Calendar.getInstance();
		Calendar c1 = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		if(date!=null){
			DateFormat dateFormat = new SimpleDateFormat("MM/yyyy");
			try {
				c.setTime(dateFormat.parse(date));
				c1.setTime(dateFormat.parse(date));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		for (int i = 1; i <= 4; i++) {

			c.set(Calendar.DAY_OF_MONTH, j + 1);
			if (i < 4) {
				j += 7;
				c1.set(Calendar.DAY_OF_MONTH,j);
			} else {
				j = 0;
				c1.set(Calendar.DAY_OF_MONTH,c1.getActualMaximum(Calendar.DAY_OF_MONTH));
			}

			dvb.put("Week-" + i, sdf.format(c.getTime()) + "#" + sdf.format(c1.getTime()));
		}
		return dvb;
	}
	public static Map<String, String> customizeMapToDisplayWeek(Map<String, String> map) {
		Map<String, String> customMap = new LinkedHashMap<String, String>();
		for (Entry entry : map.entrySet()) {
			String key=(String) entry.getKey();
			String value=(String) entry.getValue();
			key=key+" ["+value.split("#")[0]+" to "+value.split("#")[1]+""+"]";
		
			customMap.put(key, value);
		}
		return customMap;
	}
	
	public static Map<String, String> getWeekDays1(String date) {

		Map<String, String> dvb = new LinkedHashMap<String, String>();
		int j = 0;
		Calendar c = Calendar.getInstance();
		Calendar c1 = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(date!=null){
			DateFormat dateFormat = new SimpleDateFormat("MM/yyyy");
			try {
				c.setTime(dateFormat.parse(date));
				c1.setTime(dateFormat.parse(date));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		for (int i = 1; i <= 4; i++) {

			c.set(Calendar.DAY_OF_MONTH, j + 1);
			if (i < 4) {
				j += 7;
				c1.set(Calendar.DAY_OF_MONTH,j);
			} else {
				j = 0;
				c1.set(Calendar.DAY_OF_MONTH,c1.getActualMaximum(Calendar.DAY_OF_MONTH));
			}

			dvb.put("Week-" + i, sdf.format(c.getTime()) + "#" + sdf.format(c1.getTime()));
		}
		return dvb;
	}
	public static String getFirstAndLastDate(String date){
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat dateFormat = new SimpleDateFormat("MM/yyyy");
		try {
			calendar.setTime(dateFormat.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String dates=sdf.format(calendar.getTime());
		
		calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		dates+="#"+sdf.format(calendar.getTime());
		return dates;
	}
	public static String timestampToString(Timestamp timestamp) throws ParseException {
        String finaldate = new SimpleDateFormat("dd-MM-yyyy HH:mm:SS").format(timestamp);
        return finaldate;
    }
	/*
	 * public static void main(String[] args) { String date1 = "01/2015"; String
	 * date2 = "6/2015"; String tempData = date2.split("/")[0]; Integer n =
	 * (Integer.parseInt(tempData)+1); date2 = n.toString()+"/"+
	 * date2.split("/")[1];
	 * System.out.println("==="+(Integer.parseInt(tempData)+1)); DateFormat
	 * formater = new SimpleDateFormat("MM/yyyy"); DateFormat formater1 = new
	 * SimpleDateFormat("MMM-yyyy");
	 * 
	 * Calendar beginCalendar = Calendar.getInstance(); Calendar finishCalendar
	 * = Calendar.getInstance();
	 * 
	 * try { beginCalendar.setTime(formater.parse(date1));
	 * finishCalendar.setTime(formater.parse(date2)); } catch (ParseException e)
	 * { e.printStackTrace(); }
	 * 
	 * while (beginCalendar.before(finishCalendar)) { // add one month to date
	 * per loop String date =
	 * formater.format(beginCalendar.getTime()).toUpperCase();
	 * System.out.println(date); beginCalendar.add(Calendar.MONTH, 1); }
	 * 
	 * System.out.println("=="+Calendar.getInstance().get(Calendar.YEAR));
	 * //System.out.println("=="+Calendar.getInstance().get(Calendar.MONTH));
	 * DateFormat dateFormat = new SimpleDateFormat("MM/yyyy"); Date date = new
	 * Date(); String dateString = dateFormat.format(date);
	 * System.out.println("=="+dateString); }
	 */
	public static Date databaseStringToDate(String date) {
	       if (date == null || date.trim().equals("")) {
	           return null;
	       }
	       DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
	       Date convertDate = null;
	       try {
	           convertDate = (Date) formatter.parse(date);
	       } catch (ParseException ex) {
	           ex.printStackTrace();
	       }
	       return convertDate;
	   }
	private static DecimalFormat df2 = new DecimalFormat(".##");
	
	public static String convertDate(String date1){
		DateFormat userDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        DateFormat dateFormatNeeded = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
		try {
			date = userDateFormat.parse(date1);
		} catch (ParseException e) {
			date=null;
			e.printStackTrace();
		}
        String finaldate = dateFormatNeeded.format(date);
        return finaldate;
	}
	
	public static Long getDateBetweenTwoDates(Date dateFrom,Date dateTo){
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
			dateTo=formatter.parse(dateTo.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(dateFrom.after(dateTo)){
			long difference =  (dateFrom.getTime()-dateTo.getTime())/86400000;
	        return Math.abs(difference);
		}else{
			return 0L;
		}
	}
	public static Date stringDateToDate(String date) {
	       if (date == null || date.trim().equals("")) {
	           return null;
	       }
	       DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	       Date convertDate = null;
	       try {
	           convertDate = (Date) formatter.parse(date);
	       } catch (ParseException ex) {
	           ex.printStackTrace();
	       }
	       return convertDate;
	   }
	public static void main(String[] args) throws ParseException {

		/*Calendar calendar = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("MM/yyyy");
		calendar.setTime(dateFormat.parse("02/2017"));
		Date [] dates=null;
		dates[0]=calendar.getTime();
		
		calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		dates[1]=calendar.getTime();*/
		//DecimalFormat df2 = new DecimalFormat(".##");
		/*System.out.println("==="+new DecimalFormat("##.##").format(5000.2222));
		double input = 32.0435345;
		System.out.println("double : " + input+"==========="+String.format("%.2f", input));
		System.out.println("double : " + df2.format(input));*/
		/*Map<String,String> s=getWeekDays1("02/2017");
		
		for (Map.Entry<String, String> entry : s.entrySet())
		{
		    System.out.println(entry.getKey() + "S-" + entry.getValue());
		    
		}*/
		
		String ds=dateToString(new Date());
		Date d1=DateUtility.stringDateToDate(ds);
		Date d2=DateUtility.stringDateToDate("27/09/2017");
		
		System.out.println("--------------"+(d2.getTime()-d1.getTime())/86400000);

	}

}
