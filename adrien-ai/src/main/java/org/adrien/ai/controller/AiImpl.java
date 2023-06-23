package org.adrien.ai.controller;

import org.adrien.ai.pojo.qu.AiChatQu;
import org.adrien.ai.pojo.qu.AiQu;
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
public class AiImpl implements AiService {

    @Autowired
    private AiGateway aiGateway;

    public BaseVo<String> chat(AiChatQu qu) {
        String chatRes;
        try {
            chatRes = aiGateway.aiChat(new AiQu(qu));
        } catch (Exception ex) {
            chatRes = "无法回答这个问题";
        }
        return VoUtil.success(chatRes);
    }

}
