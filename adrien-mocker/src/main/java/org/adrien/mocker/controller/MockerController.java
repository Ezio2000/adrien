package org.adrien.mocker.controller;

import org.adrien.mocker.service.MockerService;
import org.adrien.sdk.base.pojo.exception.QuestChainException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Xieningjun
 * @date 2023/6/11 3:19
 * @description mocker控制层
 */
@RestController
public class MockerController {

    @Autowired
    private MockerService mockerService;

    /**
     * 模拟响应
     */
    @RequestMapping("/**")
    public Object mocker() throws QuestChainException {
        return mockerService.mock();
    }

}
