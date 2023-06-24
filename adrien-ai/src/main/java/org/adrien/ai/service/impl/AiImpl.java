package org.adrien.ai.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.adrien.ai.gateway.AiGateway;
import org.adrien.ai.pojo.qu.AiChatQu;
import org.adrien.ai.pojo.qu.AiQu;
import org.adrien.ai.service.AiService;
import org.adrien.sdk.web.pojo.vo.BaseVo;
import org.adrien.sdk.web.util.VoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Xieningjun
 * @date 2023/6/21 13:45
 * @description ai业务逻辑实现层
 */
@Service
@Slf4j
public class AiImpl implements AiService {

    @Autowired
    private AiGateway aiGateway;

    public BaseVo<String> chat(AiChatQu qu) {
        String chatRes;
        try {
            chatRes = aiGateway.aiChat(new AiQu(qu));
        } catch (Exception ex) {
            log.error("该问题无法回答", ex);
            chatRes = "无法回答这个问题";
        }
        return VoUtil.success(chatRes);
    }

}
