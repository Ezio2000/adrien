package org.adrien.sdk.web.pojo.vo;

import lombok.Data;
import org.adrien.sdk.base.pojo.struc.KeyValue;

import java.io.Serializable;

/**
 * @author Xieningjun
 * @date 2023/6/2 14:49
 * @description 响应体
 */
@Data
public class BaseVo<T> implements Serializable {

    /**
     * 响应码
     */
    private Integer code;

    /**
     * 响应信息
     */
    private String msg;

    /**
     * 响应数据
     */
    private T data;

    public BaseVo(KeyValue<Integer, String> keyValue) {
        this.code = keyValue.key();
        this.msg = keyValue.value();
    }

    public BaseVo(KeyValue<Integer, String> keyValue, T data) {
        this.code = keyValue.key();
        this.msg = keyValue.value();
        this.data = data;
    }

}
