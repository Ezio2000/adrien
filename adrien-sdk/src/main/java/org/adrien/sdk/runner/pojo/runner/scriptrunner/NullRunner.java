package org.adrien.sdk.runner.pojo.runner.scriptrunner;

import java.util.List;

/**
 * @author Xieningjun
 * @date 2023/5/11 15:56
 * @description 空脚本运行
 */
public class NullRunner implements ScriptRunner {

    private final Object engine;

    public NullRunner() {
        this.engine = null;
    }

    @Override
    public void load(String scriptContent) {

    }

    @Override
    public Object success(List<Object> args) {
        return this.getDefaultResult();
    }

}
