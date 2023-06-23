package org.adrien.sdk.base.pojo.struc.quest;

import org.adrien.sdk.base.pojo.exception.QuestChainException;
import org.adrien.sdk.base.pojo.struc.Chain;

import java.util.List;
import java.util.Objects;

/**
 * @author Xieningjun
 * @date 2023/6/11 1:49
 * @description 任务链
 */
public interface QuestChain<Q extends Quest> extends Chain<Q> {

    default void doQuest(QuestHolder questHolder) throws QuestChainException {
        List<Q> questList = this.getChain();
        if (Objects.isNull(questList)) {
            throw new QuestChainException("Quest chain can't not be null!");
        }
        for (Q quest : questList) {
            try {
                quest.doQuest(questHolder);
            } catch (Exception ex) {
                throw new QuestChainException(quest, ex.getMessage());
            }
        }
    }

}
