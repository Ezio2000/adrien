package org.adrien.sdk.base.pojo.struc.book;

import lombok.Builder;
import lombok.Data;
import org.adrien.sdk.base.pojo.struc.KeyValue;

/**
 * @author Xieningjun
 * @date 2023/6/2 18:10
 * @description 书本页数据结构
 */
@Data
@Builder
public class IPage<B> implements KeyValue<Integer, B> {

    private Integer page;

    private B content;

    public IPage(Integer page, B content) {
        this.page = page;
        this.content = content;
    }

    @Override
    public Integer key() {
        return this.page;
    }

    @Override
    public B value() {
        return this.content;
    }

}
