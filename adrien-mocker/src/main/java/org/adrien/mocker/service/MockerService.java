package org.adrien.mocker.service;

import org.adrien.sdk.base.pojo.exception.QuestChainException;
import org.adrien.sdk.web.pojo.vo.BaseVo;

/**
 * @author Xieningjun
 * @date 2023/6/11 0:44
 * @description mocker逻辑层
 */
public interface MockerService {

    Object mock() throws QuestChainException;

}
