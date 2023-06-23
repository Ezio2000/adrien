package org.adrien.mocker.pojo.chain.quest;

import org.adrien.mocker.pojo.entity.MockerApi;
import org.adrien.mocker.pojo.manager.MockerManager;
import org.adrien.sdk.base.pojo.struc.quest.QuestHolder;
import org.adrien.sdk.web.util.QuUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author Xieningjun
 * @date 2023/6/11 4:36
 * @description 获取当前请求的mockerApi
 */
@Component
public class GetMockerApiQuest implements MockerQuest {

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private MockerManager mockerManager;

    /**
     * 执行任务
     */
    @Override
    public void doQuest(QuestHolder questHolder) {
        String path = QuUtil.getPath(httpServletRequest, 0);
        Map<String, MockerApi> mockerApiMap = mockerManager.getMockerApiMap();
        MockerApi mockerApi = mockerApiMap.get(path);
        questHolder.set(MOCKER_API, mockerApi);
    }

}
