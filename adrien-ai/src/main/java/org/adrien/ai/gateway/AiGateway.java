package org.adrien.ai.gateway;

import org.adrien.ai.configuration.AiConfiguration;
import org.adrien.ai.pojo.qu.AiQu;
import org.adrien.sdk.web.service.RestTemplateProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

/**
 * @author Xieningjun
 * @date 2023/6/21 13:46
 * @description ai对外转发层
 */
@Component
public class AiGateway {

    @Autowired
    private RestTemplateProxy<AiQu, String> restTemplateProxy;

    @Autowired
    private AiConfiguration aiConfiguration;

    public String aiChat(AiQu qu) {
        return restTemplateProxy.post(
                "https://api.openai.com/v1/chat/completions",
                new HttpHeaders() {
                    { add("Authorization", aiConfiguration.getApiKey()); }
                    { add("Content-Type", "application/json"); }
                },
                qu,
                String.class
        );
    }

}
