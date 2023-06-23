package org.adrien.ai.controller;

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

    public String aiChat(AiQu qu) {
        return restTemplateProxy.post(
                "https://api.openai.com/v1/chat/completions",
                new HttpHeaders() {
                    { add("Authorization", "Bearer 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"); }
                    { add("Content-Type", "application/json"); }
                },
                qu,
                String.class
        );
    }

}
