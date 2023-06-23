package org.adrien.sdk.web.service;

import org.adrien.sdk.web.pojo.qu.BaseQu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author Xieningjun
 * @date 2023/6/16 13:47
 * @description 网络请求代理
 */
@Component
public class RestTemplateProxy<Q, V> {

    @Autowired
    private RestTemplate restTemplate;

    public V post(String url, HttpHeaders header, Q body, Class<V> clazz) {
        BaseQu<Q, V> qu = new BaseQu<>();
        qu.setUrl(url);
        qu.setHeader(header);
        qu.setBody(body);
        qu.setClazz(clazz);
        return this.post(qu);
    }

    public V post(BaseQu<Q, V> qu) {
        HttpEntity<Q> httpEntity = new HttpEntity<>(qu.getBody(), qu.getHeader());
        return restTemplate.postForObject(qu.getUrl(), httpEntity, qu.getClazz());
    }

}
