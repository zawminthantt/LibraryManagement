package com.ictti.library.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Util {
	/**
	 * check date format
	 * @param myForm
	 */
	public static Date isDate(String a_strDate){
		boolean bl=false;
		SimpleDateFormat sdf = new SimpleDateFormat();
		Date date=new Date();
		sdf.setLenient( false );
		sdf.applyPattern("yyyy-MM-dd");
		System.out.println("a_strDate"+a_strDate);
		try{
			 date=sdf.parse(a_strDate); 
			bl=true;
		}catch (ParseException e){
			System.out.println("tooteiru?");
			bl=false;
		}
		return date;
	}
	
	public static int getDiff( java.util.Date pFrom, java.util.Date pTo )
    {
        int lMultiplier = 1;
        if ( pFrom.after( pTo ) );
        {
            lMultiplier = -1;
            java.util.Date pTemp = pTo;
            pTo = pFrom;
            pFrom = pTemp;
        }
 
        Calendar lFrom = new GregorianCalendar();
        lFrom.setTime( pFrom );
        Calendar lTo = new GregorianCalendar();
        lTo.setTime( pTo );
 
        int lFromYear = lFrom.get( Calendar.YEAR );
        int lFromMonth = lFrom.get( Calendar.MONTH );
        int lFromDay = lFrom.get( Calendar.DAY_OF_MONTH );
 
        int lToYear = lTo.get( Calendar.YEAR );
        int lToMonth = lTo.get( Calendar.MONTH );
        int lToDay = lTo.get( Calendar.DAY_OF_MONTH );
 
        int lYearDiff = lToYear - lFromYear;
        int lMonthDiff = lToMonth - lFromMonth;
        int lDayDiff = lToDay - lFromDay;
 
        if ( lDayDiff < 0 )
        {
            lMonthDiff--;
            Calendar lTemp = new GregorianCalendar();
            lTemp.setTime( pTo );
            lTemp.add( lTemp.MONTH, -1 );
            lDayDiff = lTemp.getActualMaximum( lTemp.DAY_OF_MONTH ) + lDayDiff;
        }
 
        if ( lMonthDiff < 0 )
        {
            lYearDiff--;
            lMonthDiff = 12 + lMonthDiff;
        }
 
        return lMultiplier * ( lYearDiff * 10000 + lMonthDiff * 100 + lDayDiff );
    }
	public static Integer getDateDiff(String from,String to)
	{
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
			Date From;
			Date To;
			Date date=new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
			String strDate = sdf.format(date);
			String d1=from;
			String d2= to;
			long diffMillis=0;
			long diffDays = 0;
			
			try {
				From =df.parse(d1);
				To = df.parse(d2);
			
				diffMillis= To.getTime()-From.getTime();
				diffDays=diffMillis/(1000* 60*60*24);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Different Two Dates with days=="+diffDays);
		
					
			return  new Integer((int)diffDays);


	}
	
	public static String addToDate(Integer loanPeriod){
	
	System.out.println("In the ADD Operation");
	
	// String DATE_FORMAT = "yyyy-MM-dd";
	
	
	DateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
	Calendar c1 = Calendar.getInstance();
	
	Date d1 = new Date();
	
	
	System.out.println();
	System.out.println("c1.get(Calendar.YEAR): " + c1.get(Calendar.YEAR));
	System.out.println("c1.get(Calendar.YEAR): " + c1.get(Calendar.MONTH)+1);
	System.out.println("c1.get(Calendar.YEAR): " + c1.get(Calendar.DATE));
	System.out.println(d1.getMonth());
	System.out.println(d1.getDay());
	
	
	
	c1.set(c1.get(Calendar.YEAR),c1.get(Calendar.MONTH),c1.get(Calendar.DATE)); //(year,month,date)
	
	System.out.println("c1.set(1999,0 ,20) : "+c1.getTime());
	
	c1.add(c1.DATE,loanPeriod);
	
	
	d1=isDate(sdf.format(c1.getTime()).toString());
	
	
	System.out.println("Date + 20 days is : " + sdf.format(c1.getTime()).toString());
	
	System.out.println();
	
	System.out.println();
	
	return sdf.format(c1.getTime()).toString();
	}

	public static String addToDate(String date,Integer loanPeriod){
		
		System.out.println("In the ADD Operation");
		
		// String DATE_FORMAT = "yyyy-MM-dd";
		
		
		DateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar c1 = Calendar.getInstance();
		
		Date d1 = new Date();
		
		
		System.out.println();
		System.out.println("c1.get(Calendar.YEAR): " + c1.get(Calendar.YEAR));
		System.out.println("c1.get(Calendar.YEAR): " + c1.get(Calendar.MONTH)+1);
		System.out.println("c1.get(Calendar.YEAR): " + c1.get(Calendar.DATE));
		System.out.println(d1.getMonth());
		System.out.println(d1.getDay());
		
		String dd[]=date.split("-");
				
		c1.set(Integer.parseInt(dd[0]),Integer.parseInt(dd[1])-1,Integer.parseInt(dd[2])); //(year,month,date)
		
		System.out.println("c1.set(1999,0 ,20) : "+c1.getTime());
		
		c1.add(c1.DATE,loanPeriod);
		
		
		d1=isDate(sdf.format(c1.getTime()).toString());
		
		
		System.out.println("Date + 20 days is : " + sdf.format(c1.getTime()).toString());
		
		System.out.println();
		
		System.out.println();
		
		return sdf.format(c1.getTime()).toString();
		}
	
}
