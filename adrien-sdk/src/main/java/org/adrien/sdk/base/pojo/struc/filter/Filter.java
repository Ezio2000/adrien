package org.adrien.sdk.base.pojo.struc.filter;

/**
 * @author Xieningjun
 * @date 2023/6/11 23:38
 * @description 筛选
 */
public interface Filter<T> {

    default Boolean keep(T t) {
        return true;
    }

    default Boolean filter(T t) {
        return false;
    };

}
