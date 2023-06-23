package org.adrien.ai.controller;

import org.adrien.ai.pojo.qu.AiChatQu;
import org.adrien.sdk.web.pojo.vo.BaseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Xieningjun
 * @date 2023/6/14 18:26
 * @description ai控制层
 */
@RestController
@RequestMapping("/ai")
@CrossOrigin
public class AiController {

    @Autowired
    private AiService aiService;

    @RequestMapping("/chat")
    public BaseVo<String> chat(@RequestBody AiChatQu qu) {
        return aiService.chat(qu);
    }

}
