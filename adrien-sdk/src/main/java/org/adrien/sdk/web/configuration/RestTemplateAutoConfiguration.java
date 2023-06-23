package org.adrien.sdk.web.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.nio.charset.StandardCharsets;

/**
 * @author Xieningjun
 * @date 2023/6/14 20:37
 * @description 网络请求自动配置
 */
@Configuration
public class RestTemplateAutoConfiguration {

    @Bean
    public Proxy Proxy() {
        SocketAddress address = new InetSocketAddress("127.0.0.1", 7890);
        return new Proxy(Proxy.Type.HTTP, address);
    }

    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory(Proxy proxy) {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(20000);
        factory.setConnectTimeout(20000);
        factory.setProxy(proxy);
        return factory;
    }

    @Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory factory) {
        RestTemplate restTemplate = new RestTemplate(factory);
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        return restTemplate;
    }

}
