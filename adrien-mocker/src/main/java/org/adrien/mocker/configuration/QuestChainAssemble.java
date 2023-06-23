package org.adrien.mocker.configuration;

import org.adrien.mocker.pojo.chain.MockerQuestChain;
import org.adrien.mocker.pojo.chain.quest.GetMockerApiQuest;
import org.adrien.mocker.pojo.chain.quest.GetMockerListQuest;
import org.adrien.mocker.pojo.chain.quest.GetResDataQuest;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author Xieningjun
 * @date 2023/6/11 5:59
 * @description 任务线自动装配
 */
@Component
public class QuestChainAssemble {

    /**
     * 装载mocker任务线
     */
    @Bean
    public MockerQuestChain mockerQuestChain(
            GetMockerApiQuest getMockerApiQuest,
            GetMockerListQuest getMockerListQuest,
            GetResDataQuest getResDataQuest
    ) {
        return new MockerQuestChain(
                Arrays.asList(getMockerApiQuest, getMockerListQuest, getResDataQuest)
        );
    }

}
