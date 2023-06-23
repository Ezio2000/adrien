package org.adrien.mocker.service.impl;

import org.adrien.mocker.pojo.chain.MockerQuestChain;
import org.adrien.mocker.pojo.chain.quest.MockerQuest;
import org.adrien.mocker.service.MockerService;
import org.adrien.sdk.base.pojo.exception.QuestChainException;
import org.adrien.sdk.base.pojo.struc.quest.QuestHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Xieningjun
 * @date 2023/6/11 1:04
 * @description mocker逻辑层
 */
@Service
public class MockerImpl implements MockerService {

    @Autowired
    private MockerQuestChain mockerQuestChain;

    @Override
    public Object mock() throws QuestChainException {
        QuestHolder questHolder = new QuestHolder();
        mockerQuestChain.doQuest(questHolder);
        return questHolder.get(MockerQuest.RES_DATA);
    }

}
