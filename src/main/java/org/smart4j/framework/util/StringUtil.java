package org.smart4j.framework.util;

import org.apache.commons.lang3.StringUtils;

/**
 * 字符串工具类
 */
public final class StringUtil {

    /**
     * 判断字符串是否为空
     */
    public static boolean isEmpty(String str) {
        if (str != null) {
            str = str.trim();
        }
        return StringUtils.isEmpty(str);
    }

    /**
     * 判断字符串是否非空
     */
    public static boolean isNotEmpty(String str) {
        if (str != null) {
            str= str.trim();
        }
        return StringUtils.isNotEmpty(str);
    }


    /**
     * 分割字符串
     */

    public static String[] splitString(String str  ,String separatorChars) {
        return StringUtils.split(str,separatorChars);
    }

}