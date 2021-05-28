
package com.main.common.api;

import java.text.DecimalFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @Author : 주오윤
 * @File : com.main.common.api.StringUtils.java
 * @Version : 1.0,
 * @Date :2021. 05. 28.
 * @Commnad: StringUtils
 *
 **/
public class StringUtils {
    private static final Logger log = LoggerFactory.getLogger(StringUtils.class.getName());

    /**
     *  ex) yyyy-MM-dd
     */
    public static String getDateFormat(String format) {
        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(today);
    }

    public static String getYesterDayFormat() {

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);

        String y_year = Integer.toString(cal.get(Calendar.YEAR));
        String y_month = Integer.toString(cal.get(Calendar.MONTH) + 1);
        String y_date = Integer.toString(cal.get(Calendar.DATE));

        if (y_month.length() == 1)
            y_month = "0" + y_month; // month 3 => 03
        if (y_date.length() == 1)
            y_date = "0" + y_date; // day 7=> 07

        String yesterday = y_year + "-" + y_month + "-" + y_date;
        return yesterday;
    }

    /**
     * 남은 날짜 종료 ?일 전
     * 
     */
    public static String getNameunTime(String dDay) {
        int rYear = Integer.parseInt(dDay.substring(0, 4));
        int rMonth = Integer.parseInt(dDay.substring(5, 7));
        int rDay = Integer.parseInt(dDay.substring(8, 10));

        Date today = new Date();

        Calendar cal = Calendar.getInstance();
        cal.setTime(today);// 오늘로 설정.

        Calendar cal2 = Calendar.getInstance();
        cal2.set(rYear, rMonth - 1, rDay); // 기준일로 설정. month의 경우 해당월수-1

        int count = 0;
        while (!cal.after(cal2)) {
            count++;
            cal.add(Calendar.DATE, 1); // 다음날로 바뀜

        }

        if ((count - 1) < 0) {
            return "종료";
        }

        String resultStr = "";
        if ((count - 1) == 0) {
            resultStr = "금일 종료";
        } else {
            resultStr = "종료 " + (count - 1) + "일 전";
        }

        return resultStr;
    }

    /**
     * 건 등록 얼마나 지났는지 알아오기
     */
    public static String getTimeValue(String rDate) {
        /*
         * 음..... 파라미터로 온 값을 오늘날짜랑 비교를 해서 초단위로 바겼을 경우 방금전 분단위로 바꼈을 경우에는 몇분 전이다 라고 시단위로 바꼈을 경우 몇시간 전이다.
         */
        String timeText = "";
        int rYear = Integer.parseInt(rDate.substring(0, 4));
        int rMonth = Integer.parseInt(rDate.substring(5, 7));
        int rDay = Integer.parseInt(rDate.substring(8, 10));
        int rHour = Integer.parseInt(rDate.substring(11, 13));
        int rMin = Integer.parseInt(rDate.substring(14, 16));
        int rSec = Integer.parseInt(rDate.substring(17, 19));

        Date today = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Calendar cal = Calendar.getInstance();
        Date endDate = cal.getTime();
        cal.setTime(today);// 오늘로 설정.

        Calendar cal2 = Calendar.getInstance();
        // cal2.set (rYear, rMonth-1, rDay, rHour, rMin, rSec); // 기준일로 설정. month의 경우 해당월수-1
        cal2.set(rYear, rMonth - 1, rDay);

        int count = 0;

        while (!cal2.after(cal)) {
            int compare = cal2.compareTo(cal);
            if (compare == 0) {
                break;
            } else {
                count++;
                cal2.add(Calendar.DATE, 1); // 다음날로 바뀜
            }
        }

        if (count == 0) {
            Date startday = sf.parse(rDate, new ParsePosition(0));
            long startTime = startday.getTime();
            long endTime = endDate.getTime();
            long mills = endTime - startTime;

            // 분으로 변환
            long min = mills / 60000;

            // 시간
            long hour = min / 60;

            // 초
            long sec = mills / 1000;

            if (sec < 60) {
                timeText = "방금 전";

            } else {

                if (min < 60) {
                    timeText = min + "분 전";
                } else if (min < 24 * 60) {
                    timeText = hour + "시간 전";
                } 
            }

        } else {
            timeText = count + "일 전";
        }

        return timeText;
    }

    // 파라미터에 넣은 일수를 바꿔줌 가져오기
    public static String getChangeDay(String date, int addday) {
        GregorianCalendar cal = new GregorianCalendar();
        int year = 0;
        int month = 0;
        int day = 0;
        if (date.length() != 8)
            return "";
        year = Integer.valueOf(date.substring(0, 4)).intValue();
        month = Integer.valueOf(date.substring(4, 6)).intValue();
        day = Integer.valueOf(date.substring(6, 8)).intValue();
        cal.set(year, month - 1, day + addday);

        String stryear = new DecimalFormat("0000").format(cal.get(Calendar.YEAR));
        String strmonth = new DecimalFormat("00").format((cal.get(Calendar.MONTH) + 1));
        String strday = new DecimalFormat("00").format((cal.get(Calendar.DATE)));

        return stryear + strmonth + strday;
    }

    public static String getChangeDay(String date, int addday, String delimiter) {

        date = date.replaceAll(delimiter, "");
        GregorianCalendar cal = new GregorianCalendar();
        int year = 0;
        int month = 0;
        int day = 0;
        if (date.length() != 8)
            return "";
        year = Integer.valueOf(date.substring(0, 4)).intValue();
        month = Integer.valueOf(date.substring(4, 6)).intValue();
        day = Integer.valueOf(date.substring(6, 8)).intValue();
        cal.set(year, month - 1, day + addday);

        String stryear = new DecimalFormat("0000").format(cal.get(Calendar.YEAR));
        String strmonth = new DecimalFormat("00").format((cal.get(Calendar.MONTH) + 1));
        String strday = new DecimalFormat("00").format((cal.get(Calendar.DATE)));

        return stryear + delimiter + strmonth + delimiter + strday;

    }

    // 파라미터에 넣은 날짜 요일 가져오기 숫자
    public static int getDayOfWeek(String yyyyMMdd) {
        // 일1 월2 화3 수4 목5 금6 토7
        GregorianCalendar cal = new GregorianCalendar();
        int year = 0;
        int month = 0;
        int day = 0;
        if (yyyyMMdd.length() != 8)
            return -1;
        year = Integer.valueOf(yyyyMMdd.substring(0, 4)).intValue();
        month = Integer.valueOf(yyyyMMdd.substring(4, 6)).intValue();
        day = Integer.valueOf(yyyyMMdd.substring(6, 8)).intValue();
        cal.set(year, month - 1, day);

        int day_of_week = cal.get(Calendar.DAY_OF_WEEK);

        return day_of_week;
    }

    // 파라미터에 넣은 날짜 요일 가져오기 한글
    public static String getDayOfWeekStr(String yyyyMMdd) {
        // 일 월 화 수 목 금 토
        GregorianCalendar cal = new GregorianCalendar();
        int year = 0;
        int month = 0;
        int day = 0;
        if (yyyyMMdd.length() != 8)
            return "";
        year = Integer.valueOf(yyyyMMdd.substring(0, 4)).intValue();
        month = Integer.valueOf(yyyyMMdd.substring(4, 6)).intValue();
        day = Integer.valueOf(yyyyMMdd.substring(6, 8)).intValue();
        cal.set(year, month - 1, day);

        String returnStr = "";
        int day_of_week = cal.get(Calendar.DAY_OF_WEEK);

        if (day_of_week == 1)
            returnStr = "일";
        if (day_of_week == 2)
            returnStr = "월";
        if (day_of_week == 3)
            returnStr = "화";
        if (day_of_week == 4)
            returnStr = "수";
        if (day_of_week == 5)
            returnStr = "목";
        if (day_of_week == 6)
            returnStr = "금";
        if (day_of_week == 7)
            returnStr = "토";

        return returnStr;
    }

    /**
     * 날짜 일수 계산 20210101 20210120 이런식으로 파라미터 셋팅하기 method 내용을 입력해주세요.
     * 
     */
    public static String diffDate(String startDate, String endDate) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();

        int year1 = Integer.parseInt(startDate.substring(0, 4)); // 여기서는 2002
        int month1 = Integer.parseInt(startDate.substring(4, 6)); // 여기서는 9
        int date1 = Integer.parseInt(startDate.substring(6)); // 여기서는 01

        int year2 = Integer.parseInt(endDate.substring(0, 4)); // 여기서는 2002
        int month2 = Integer.parseInt(endDate.substring(4, 6)); // 여기서는 9
        int date2 = Integer.parseInt(endDate.substring(6)); // 여기서는 01

        // 위의 값들을 input을 잘 처리해서 Integer.parseInt() 사용

        cal1.set(year1, month1, date1, 0, 0, 1);
        cal2.set(year2, month2, date2, 0, 0, 1);

        // 두 날짜간의 millisecond 차이
        long diff = cal2.getTime().getTime() - cal1.getTime().getTime();

        // 하루의의 millis = 24 * 60 * 60 * 1000 이므로
        int diffDate = (int) (diff / (24 * 60 * 60 * 1000));

        return String.valueOf(diffDate);
    }
    
    /**
     * 날짜 일수 계산(일자로만 계산)
     */
    public static String diffOfDate(String begin, String end) throws Exception
    {
      SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
   
      Date beginDate = formatter.parse(begin);
      Date endDate = formatter.parse(end);
   
      long diff = endDate.getTime() - beginDate.getTime();
      long diffDays = diff / (24 * 60 * 60 * 1000);
   
      return Long.toString(diffDays);
    }
    
    /**
     * 문자열 자르기 (원래문자열, 보여질 글자 수)
     */
    public static String getSubString(String str, int endIdx) 
    {
        //테스트진행
        if(str.length() > endIdx){
            return str.substring(0, endIdx);
        }else {
            return str;
        }
    }
    
    /**
     * iquals - static (메모리)
     */
    public static boolean isEquals(String type, String name) {
    	boolean isOk;
    	if(type.equals(name)) {
    		isOk = true;
    	} else {
    		isOk = false;
    	}
    	return isOk;
    }
    
}
