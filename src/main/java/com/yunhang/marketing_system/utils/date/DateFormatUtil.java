package com.yunhang.marketing_system.utils.date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 * @author 杨春路
 * @data 2019/11/1 9:19
 */
public final class DateFormatUtil {
    /**
     * 返回当前时间的字符串形式
     * @return
     */
    public static String createDateAndTime(){
       return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
    }

}
