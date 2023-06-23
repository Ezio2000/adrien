package org.adrien.mocker.pojo.chain.quest;

import org.adrien.mocker.pojo.entity.Mocker;
import org.adrien.sdk.base.pojo.struc.filter.Filter;
import org.adrien.sdk.base.util.ListUtil;
import org.adrien.sdk.base.pojo.struc.quest.QuestHolder;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Xieningjun
 * @date 2023/6/11 5:42
 * @description 获取响应任务
 */
@Component
public class GetResDataQuest implements MockerQuest {

    /**
     * 执行任务
     */
    @Override
    public void doQuest(QuestHolder questHolder) {
        List<Mocker> mockerList = (List<Mocker>) questHolder.get(MOCKER_LIST);
        Mocker resMocker = ListUtil.filterOne(mockerList, new Filter<Mocker>() {});
        questHolder.set(RES_DATA, resMocker.getResData());
    }

}
