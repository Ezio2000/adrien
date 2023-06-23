package org.adrien.sdk.web.util;

import org.adrien.sdk.base.pojo.exception.LogicException;
import org.adrien.sdk.base.util.StringUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Xieningjun
 * @date 2023/6/1 19:54
 * @description 请求工具类
 */
public class QuUtil {

    public static String getPath(HttpServletRequest httpServletRequest, Integer startPoint) {
        String path = httpServletRequest.getRequestURI().substring(startPoint);
        return StringUtil.cleanSymbol(path, "//", "/");
    }

}
