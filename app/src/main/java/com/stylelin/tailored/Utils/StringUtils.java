package com.stylelin.tailored.Utils;

import android.annotation.SuppressLint;

/**
 * 创建人:Jonlin
 * 创建时间:2016年7月14日 上午11:26:24
 * 类描述:字符串工具类
 */
@SuppressLint("DefaultLocale")
public class StringUtils {

    /**
     * 判断字符串为空
     */
    public static boolean isNull(String str) {
        if (null == str || str.length() <= 0) { return true; }
        return false;
    }

    /**
     * 判断字符串不为空
     */
    public static boolean isNotNull(String str) {
        if (null == str || str.length() <= 0) { return false; }
        return true;
    }

    /**
     * 字符串类型去空
     * @param strObj
     * @return
     */
    public static String isCheckNullStringObj(Object strObj) {
        if (null == strObj || strObj.toString().length() <= 0 || strObj.toString().equals("null")
                || strObj.toString().equals("NULL")) { return ""; }
        return strObj.toString();
    }

    /**
     * 判断字符串为空和替换为0
     */
    public static String replaceLine(String str) {
        String result = "0";
        try {
            if (null == str || str.length() <= 0 || str.toUpperCase() == "NULL" || str.toUpperCase().equals("NULL")) { return result; }
        } catch (Exception e) {
            return result;
        }

        return str;
    }

    /**
     * 将空字符串设默认值为"-"
     */
    public static String setNullOfDefaultMinus(String str) {
        if (null == str || str.length() <= 0 || "null".equals(str) || "NULL".equals(str)) {
            return "- -";
        } else {
            return str;
        }
    }

    /**
     * 手机号隐藏中间四位，显示为*
     */
    public static String showPhoneNum(String phoneNum) {
        return phoneNum.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
    }

    /**
     * 替换字符串
     */
    public static String replaceString(String string, String oldString, String newString) {
        return string.replace(oldString, newString);
    }

    /**
     * 得到区的值
     */
    public static String getAreaData(String address) {
        String area = "";

        if (address.split("-").length == 3) {
            area = address.split("-")[2];
        }
        return area;
    }

    /**
     * 将显示内容类似空、0、NULL等装换为"--"
     */
    public static String formatShowInfo(Object content) {
        if (content == null || isNull(content.toString())) {
            return "--";
        } else if ("0".equals(content.toString()) || content.toString().equals("null") || content.toString().equals("NULL")) {
            return "--";
        } else {
            return content.toString();
        }
    }

    /**
     * 隐藏数字显示*
     * @param formatString 需要显示*的字符串
     * @param starStartIndex *开始的位置
     * @param starEndIndex *结束的位置
     * @return result 处理后的结果字符串
     */
    public static String formatShowStarString(String formatString, int starStartIndex, int starEndIndex) {
        String result = formatString;

        if (StringUtils.isNotNull(formatString) && formatString.length() > starStartIndex) {
            String starString = "";
            for (int i = 0; i < starEndIndex - starStartIndex; i++) {
                starString += "*";
            }
            result = formatString.substring(0, starStartIndex) + starString + formatString.substring(starEndIndex, formatString.length());
        }
        return result;
    }
}