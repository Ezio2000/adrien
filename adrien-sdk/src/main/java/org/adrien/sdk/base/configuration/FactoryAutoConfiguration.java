package org.adrien.sdk.base.configuration;

import org.adrien.sdk.runner.factory.ScriptRunnerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Xieningjun
 * @date 2023/6/12 12:26
 * @description 工厂自动配置
 */
@Configuration
@ConditionalOnProperty(name = "adrien.sdk", havingValue = "enable")
public class FactoryAutoConfiguration {

    @Bean
    @ConditionalOnProperty(name = "adrien.script", havingValue = "enable")
    public ScriptRunnerFactory scriptRunnerFactory() {
        return new ScriptRunnerFactory();
    }

}
