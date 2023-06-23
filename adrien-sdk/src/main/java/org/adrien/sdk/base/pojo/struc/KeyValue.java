package org.adrien.sdk.base.pojo.struc;

/**
 * @author Xieningjun
 * @date 2023/5/14 0:20
 * @description 键值对
 */
public interface KeyValue<K, V> {

    K key();

    V value();

}
