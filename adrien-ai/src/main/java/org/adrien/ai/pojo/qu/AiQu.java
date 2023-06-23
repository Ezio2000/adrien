package org.adrien.ai.pojo.qu;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xieningjun
 * @date 2023/6/16 11:44
 * @description
 */
@Data
public class AiQu {

    private String model = "gpt-3.5-turbo";

    private List<AiChatQu> messages = new ArrayList<>();

    public AiQu(AiChatQu aiChatQu) {
        this.messages.add(aiChatQu);
    }

}
