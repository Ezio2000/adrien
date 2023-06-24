package org.adrien.ai.configuration;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Xieningjun
 * @date 2023/6/23 23:07
 * @description ai配置
 */
@Configuration
@ConditionalOnProperty(name = "ai.enable", havingValue = "true")
@ConfigurationProperties(prefix = "ai")
@Data
@Slf4j
public class AiConfiguration implements InitializingBean {

    private String apiKey;

    @Override
    public void afterPropertiesSet() {
        this.apiKey = String.format("Bearer %s", this.apiKey);
    }

}
