package org.adrien.sdk.runner.util;

import org.adrien.sdk.runner.pojo.runner.Runner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xieningjun
 * @date 2023/5/15 18:57
 * @description 运行工具
 */
public class RunnerUtil {

    public static <L> void load(Runner<L, ?, ?> runner, L loadContent) throws Exception {
        runner.load(loadContent);
    }

    public static <R, RES> RES run(Runner<?, R, RES> runner, List<R> args) {
        return runner.run(args);
    }

    public static <R, RES> List<RES> run(Runner<?, R, RES>[] runners, List<R>[] args_s) {
        List<RES> resList = new ArrayList<>();
        int length = runners.length;
        for (int i = 0; i < length; i++) {
            resList.add(runners[i].run(args_s[i]));
        }
        return resList;
    }

}
