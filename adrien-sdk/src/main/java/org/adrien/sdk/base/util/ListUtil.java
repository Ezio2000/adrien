package org.adrien.sdk.base.util;

import org.adrien.sdk.base.pojo.struc.filter.Filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xieningjun
 * @date 2023/6/11 23:37
 * @description 列表工具类
 */
public class ListUtil {

    public static <T> List<T> filter(List<T> tList, Filter<T> filter) {
        List<T> tarTList = new ArrayList<>();
        for (T t : tList) {
            if (filter.keep(t) && !filter.filter(t)) {
                tarTList.add(t);
            }
        }
        return tarTList;
    }

    public static <T> T filterOne(List<T> tList, Filter<T> filter) {
        T tar = null;
        for (T t : tList) {
            if (filter.keep(t) && !filter.filter(t)) {
                tar = t;
            }
        }
        return tar;
    }

}
