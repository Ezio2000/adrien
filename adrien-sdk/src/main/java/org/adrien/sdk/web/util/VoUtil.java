package org.adrien.sdk.web.util;

import org.adrien.sdk.web.constant.VoEnum;
import org.adrien.sdk.web.pojo.vo.BaseVo;

/**
 * @author XieNingjun
 * @date 2022/11/4 14:03
 * @description 响应体构造工具
 */
public class VoUtil {

    public static <T> BaseVo<T> success() {
        return new BaseVo<>(VoEnum.SUCCESS);
    }

    public static <T> BaseVo<T> success(T data) {
        return new BaseVo<>(VoEnum.SUCCESS, data);
    }

    public static <T> BaseVo<T> systemError() {
        return new BaseVo<>(VoEnum.SYSTEM_ERROR);
    }

    public static <T> BaseVo<T> systemError(T data) {
        return new BaseVo<>(VoEnum.SYSTEM_ERROR, data);
    }

    public static <T> BaseVo<T> businessError() {
        return new BaseVo<>(VoEnum.BUSINESS_ERROR);
    }

    public static <T> BaseVo<T> businessError(T data) {
        return new BaseVo<>(VoEnum.BUSINESS_ERROR, data);
    }

}
