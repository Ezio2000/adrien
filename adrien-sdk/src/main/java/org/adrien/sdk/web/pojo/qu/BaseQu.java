package org.adrien.sdk.web.pojo.qu;

import lombok.Data;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import java.io.Serializable;

/**
 * @author Xieningjun
 * @date 2023/6/2 15:05
 * @description 请求体
 */
@Data
public class BaseQu<Q, V> implements Serializable {

    private HttpMethod method;

    private String url;

    private HttpHeaders header;

    private Q body;

    private Class<V> clazz;

}
