package org.adrien.sdk.runner.pojo.runner.scriptrunner;

import org.adrien.sdk.runner.pojo.runner.Runner;

/**
 * @author Xieningjun
 * @date 2023/5/10 17:46
 * @description 运行
 */
public interface ScriptRunner extends Runner<String, Object, Object> {

    default Object getDefaultResult() {
        return "The script throw exception.";
    }

}
