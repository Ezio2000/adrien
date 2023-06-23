package org.adrien.sdk.runner.factory;

import lombok.extern.slf4j.Slf4j;
import org.adrien.sdk.runner.pojo.runner.scriptrunner.GroovyRunner;
import org.adrien.sdk.runner.pojo.runner.scriptrunner.NullRunner;
import org.adrien.sdk.runner.pojo.runner.scriptrunner.ScriptRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

/**
 * @author Xieningjun
 * @date 2023/6/12 10:40
 * @description 脚本运行工厂类
 */
@Slf4j
public class ScriptRunnerFactory {

    private final Map<String, Class<? extends ScriptRunner>> scriptRunnerMap = new HashMap<String, Class<? extends ScriptRunner>>() {
        {
            put(NullRunner.class.getSimpleName(), NullRunner.class);
            put(GroovyRunner.class.getSimpleName(), GroovyRunner.class);
        }
    };

    public ScriptRunnerFactory() {
        ServiceLoader<ScriptRunner> scriptRunnerServiceLoader = ServiceLoader.load(ScriptRunner.class);
        for (ScriptRunner scriptRunner : scriptRunnerServiceLoader) {
            Class<? extends ScriptRunner> clazz = scriptRunner.getClass();
            this.scriptRunnerMap.put(clazz.getSimpleName(), clazz);
            log.info("----- ScriptRunner {} has been loaded! -----", clazz.getName());
        }
    }

    public ScriptRunner create(String key) {
        try {
            return this.scriptRunnerMap.get(key).newInstance();
        } catch (Exception ex) {
            return new NullRunner();
        }
    }

}
