package org.adrien.sdk.runner.pojo.runner.scriptrunner;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.List;

/**
 * @author Xieningjun
 * @date 2023/5/10 17:48
 * @description JS脚本运行
 */
public class JsRunner implements ScriptRunner {

    private ScriptEngine engine;

    public JsRunner() {
        ScriptEngineManager sem = new ScriptEngineManager();
        this.engine = sem.getEngineByName("rhino");
    }

    @Override
    public void load(String scriptContent) throws ScriptException {
        this.engine.eval(scriptContent);
    }

    @Override
    public Object success(List<Object> args) throws Exception {
        return ((Invocable) this.engine).invokeFunction("run", this.handleJsArgs(args));
    }

    private Object[] handleJsArgs(List<Object> args) {
        return args.toArray(new Object[0]);
    }

}
