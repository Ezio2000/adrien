package org.adrien.sdk.runner.pojo.runner.scriptrunner;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;

import java.util.List;

/**
 * @author Xieningjun
 * @date 2023/5/11 16:57
 * @description groovy脚本运行
 */
public class GroovyRunner implements ScriptRunner {

    private GroovyObject engine;

    public GroovyRunner() {
        this.engine = null;
    }

    @Override
    public void load(String scriptContent) throws Exception {
        this.engine = (GroovyObject) new GroovyClassLoader().parseClass(scriptContent).getDeclaredConstructor().newInstance();
    }

    @Override
    public Object success(List<Object> args) {
        return this.engine.invokeMethod("run", args);
    }

}
