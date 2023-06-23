package org.adrien.mocker.pojo.chain;

import org.adrien.mocker.pojo.chain.quest.MockerQuest;
import org.adrien.sdk.base.pojo.struc.quest.QuestChain;

import java.util.List;

/**
 * @author Xieningjun
 * @date 2023/6/11 2:00
 * @description mocker任务链
 */
public class MockerQuestChain implements QuestChain<MockerQuest> {

    private final List<MockerQuest> mockerQuestList;

    public MockerQuestChain(List<MockerQuest> mockerQuestList) {
        this.mockerQuestList = mockerQuestList;
    }

    @Override
    public List<MockerQuest> getChain() {
        return this.mockerQuestList;
    }

}
