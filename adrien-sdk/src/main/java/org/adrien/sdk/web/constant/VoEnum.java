package org.adrien.sdk.web.constant;

import org.adrien.sdk.base.pojo.struc.KeyValue;

/**
 * @author XieNingjun
 * @date 2022/11/4 14:03
 * @description 响应码枚举
 */
public enum VoEnum implements KeyValue<Integer, String> {

    /**
     * 成功
     */
    SUCCESS(0, "成功"),

    /**
     * 系统错误
     */
    SYSTEM_ERROR(-1, "系统错误"),

    /**
     * 业务错误
     */
    BUSINESS_ERROR(1, "业务错误"),

    ;

    public final Integer code;

    public final String message;

    VoEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer key() {
        return this.code;
    }

    @Override
    public String value() {
        return this.message;
    }

}
