package com.yunhang.marketing_system.utils.date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * @author 杨春路
 * @data 2019/11/1 9:19
 */
public class DateShiftUtil {
    /*@param dateformat 时间格式
     *@param date 基准日期
     *@param intnum 日期偏移,正数向前,负数向后!
     * */
    public static String dateshit(String dateformat,String date,int intnum) throws ParseException{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateformat);//格式工具
        Date da = simpleDateFormat.parse(date);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(da);
        calendar.add(Calendar.DAY_OF_MONTH, intnum);//日期偏移,正数向前,负数向后!
        return simpleDateFormat.format(calendar.getTime());
    }

}
