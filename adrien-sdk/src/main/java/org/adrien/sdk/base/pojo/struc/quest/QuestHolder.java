package org.adrien.sdk.base.pojo.struc.quest;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xieningjun
 * @date 2023/6/11 2:12
 * @description 任务中转
 */
@Data
public class QuestHolder {

    private final Map<String, Object> holder = new HashMap<>();

    public Boolean hasKey(String key) {
        return this.holder.containsKey(key);
    }

    public void set(String key, Object value) {
        this.holder.put(key, value);
    }

    public void setIfAbsent(String key, Object value) {
        this.holder.putIfAbsent(key, value);
    }

    public Object get(String key) {
        return this.holder.get(key);
    }

    public Object getOrDefault(String key, Object dValue) {
        if (this.holder.containsKey(key)) {
            return this.holder.get(key);
        }
        return dValue;
    }

}
