package org.adrien.mocker.pojo.chain.quest;

import org.adrien.mocker.pojo.entity.Mocker;
import org.adrien.mocker.pojo.entity.MockerApi;
import org.adrien.mocker.pojo.manager.MockerManager;
import org.adrien.sdk.base.pojo.struc.filter.Filter;
import org.adrien.sdk.base.util.ListUtil;
import org.adrien.sdk.base.pojo.struc.quest.QuestHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Xieningjun
 * @date 2023/6/11 2:41
 * @description 任务-获取所有对应的mocker
 */
@Component
public class GetMockerListQuest implements MockerQuest {

    @Autowired
    private MockerManager mockerManager;

    /**
     * 执行任务
     */
    @Override
    public void doQuest(QuestHolder questHolder) {
        String mockerApiPath = ((MockerApi) questHolder.get(MOCKER_API)).getPath();
        List<Mocker> mockerList = mockerManager.getMockerList();
        List<Mocker> tarMockerList = ListUtil.filter(mockerList, new Filter<Mocker>() {
            @Override
            public Boolean keep(Mocker mocker) {
                return mockerApiPath.equals(mocker.getMockerApiPath());
            }
        });
        questHolder.set(MOCKER_LIST, tarMockerList);
    }

}
