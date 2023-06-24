package org.adrien.ai.service;

import org.adrien.ai.pojo.qu.AiChatQu;
import org.adrien.sdk.web.pojo.vo.BaseVo;

/**
 * @author Xieningjun
 * @date 2023/6/21 13:44
 * @description ai业务逻辑层
 */
public interface AiService {

    BaseVo<String> chat(AiChatQu qu);

}
