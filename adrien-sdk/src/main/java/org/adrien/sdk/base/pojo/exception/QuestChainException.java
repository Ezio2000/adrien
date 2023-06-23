package org.adrien.sdk.base.pojo.exception;

import lombok.Getter;
import org.adrien.sdk.base.pojo.struc.quest.Quest;

/**
 * @author Xieningjun
 * @date 2023/6/11 2:52
 * @description 任务线错误
 */
public class QuestChainException extends Exception {

    @Getter
    private final String msg;

    public QuestChainException(String msg) {
        this.msg = msg;
    }

    public QuestChainException(Quest quest, String msg) {
        this.msg = String.format("Quest %s doQuest error:\n%s", quest, msg);
    }

}
