package org.adrien.sdk.web.pojo.vo;

import lombok.Data;
import org.adrien.sdk.base.pojo.struc.KeyValue;
import org.adrien.sdk.base.pojo.struc.book.Book;
import org.adrien.sdk.base.pojo.struc.book.IPage;
import org.adrien.sdk.base.util.BookUtil;

import java.util.List;

/**
 * @author Xieningjun
 * @date 2023/6/2 17:29
 * @description 分页响应
 */
@Data
public class BasePageVo<T> implements Book<String, List<T>, String> {

    /**
     * 响应码
     */
    private Integer code;

    /**
     * 响应信息
     */
    private String msg;

    /**
     * 总信息数
     */
    private Integer total;

    /**
     * 分页数
     */
    private Integer page;

    /**
     * 书签
     */
    private Integer cursor;

    /**
     * 响应数据
     */
    private List<IPage<List<T>>> data;

    public BasePageVo(KeyValue<Integer, String> keyValue, List<T> dataList, Integer page) {
        this.code = keyValue.key();
        this.msg = keyValue.value();
        this.total = dataList.size();
        this.page = page.equals(0) ? 1 : page;
        this.cursor = 0;
        this.data = BookUtil.autoPagin(dataList, page);
    }

    public BasePageVo(KeyValue<Integer, String> keyValue, List<T> dataList, Integer page, Integer pageSize) {
        this.code = keyValue.key();
        this.msg = keyValue.value();
        this.total = dataList.size();
        this.page = page.equals(0) ? 1 : page;
        this.cursor = 0;
        this.data = BookUtil.pagin(dataList, page, pageSize);
    }

    @Override
    public Integer size() {
        return this.total;
    }

    @Override
    public Integer page() {
        return this.page;
    }

    @Override
    public Integer cursor() {
        return this.cursor;
    }

    @Override
    public List<IPage<List<T>>> body() {
        return this.data;
    }

}
