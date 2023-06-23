package org.adrien.mocker.pojo.chain.quest;

import org.adrien.sdk.base.pojo.struc.quest.Quest;

/**
 * @author Xieningjun
 * @date 2023/6/11 2:01
 * @description mocker任务
 */
public interface MockerQuest extends Quest {

    /**
     * mocker对外接口
     */
    String MOCKER_API = "mockerApi";

    /**
     * 对应mocker列表
     */
    String MOCKER_LIST = "mockerList";

    /**
     * 响应数据
     */
    String RES_DATA = "resData";

}
