package org.adrien.sdk.runner.pojo.runner;

import java.util.List;

/**
 * @author Xieningjun
 * @date 2023/5/15 5:35
 * @description 运行
 */
public interface Runner<L, R, RES> {

    void load(L loadContent) throws Exception;

    default RES run(List<R> args) {
        try {
            return this.success(args);
        } catch (Exception e) {
            return this.fail(args, e);
        }
    };

    RES success(List<R> args) throws Exception;

    default RES fail(List<R> args, Exception e) {
        return this.getDefaultResult();
    }

    RES getDefaultResult();

}
