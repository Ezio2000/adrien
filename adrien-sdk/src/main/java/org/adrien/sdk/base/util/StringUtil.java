package org.adrien.sdk.base.util;

import org.adrien.sdk.base.pojo.exception.LogicException;

/**
 * @author Xieningjun
 * @date 2023/6/1 19:26
 * @description 字符串工具类
 */
public class StringUtil {

    public static String cleanSymbol(String str, String symbol, String target) {
        if (!str.contains(symbol) || target.contains(symbol)) {
            return str;
        }
        str = str.replace(symbol, target);
        return cleanSymbol(str, symbol, target);
    }

}
