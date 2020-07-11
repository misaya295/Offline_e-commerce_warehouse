package com.cwk.dw.flume;


import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

public class ELTUtils {




    /**
     *
     * 判断启动日志是否复合格式要求
     * 验证JSON字符串的完整性，是否以{}开头结尾
     * @param source 检验的字符串
     * @return boolean
     */
    public static boolean validStartLog(String source) {


        if (StringUtils.isBlank(source)) {
            return false;

        }

        //去掉前后空格
        String trimStr = source.trim();


        //验证JSON字符串的完整性，是否以{}开头结尾

        if (trimStr.startsWith("{") && trimStr.endsWith("}")) {
            return true;
        }

        return false;


    }

    /*
  * 判断事件日志是否复合格式要求
  * 		事件日志：  时间戳|{}
                     时间戳需要合法：
                         a)长度合法(13位)
                         b)都是数字
                     验证JSON字符串的完整性，是否以{}开头结尾
  */

    /**
     *   判断事件日志是否复合格式要求
     * 		事件日志：  时间戳|{}
     *                      时间戳需要合法：
     *                          a)长度合法(13位)
     *                          b)都是数字
     *                      验证JSON字符串的完整性，是否以{}开头结尾
     * @param source
     * @return
     */
    public static boolean validEventLog(String source) {

        if (StringUtils.isBlank(source)) {
            return false;
        }

        String[] sourceSplit = source.split("\\|");

        if (sourceSplit.length != 2) {

            return false;
        }

        if (sourceSplit[0].length() != 13 || !NumberUtils.isDigits(sourceSplit[0])) {
            return false;
        }

        //去掉前后空格
        String trimStr = sourceSplit[1].trim();


        //验证JSON字符串的完整性，是否以{}开头结尾

        if (trimStr.startsWith("{") && trimStr.endsWith("}")) {
            return true;
        }

        return false;




    }





}
