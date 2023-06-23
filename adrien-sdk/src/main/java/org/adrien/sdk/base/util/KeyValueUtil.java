package org.adrien.sdk.base.util;

import org.adrien.sdk.base.pojo.struc.KeyValue;

import java.util.Collection;
import java.util.Objects;

/**
 * @author Xieningjun
 * @date 2023/5/14 0:11
 * @description 列表形键值对工具
 */
public class KeyValueUtil {

    public static <K, V> boolean hasKey(Collection<KeyValue<K, V>> kvEntries, K key) {
        if (Objects.isNull(key)) {
            return false;
        }
        for (KeyValue<K, V> entry : kvEntries) {
            if (key.equals(entry.key())) {
                return true;
            }
        }
        return false;
    }

    public static <K, V> boolean hasValue(Collection<KeyValue<K, V>> kvEntries, V value) {
        if (Objects.isNull(value)) {
            return false;
        }
        for (KeyValue<K, V> entry : kvEntries) {
            if (value.equals(entry.value())) {
                return true;
            }
        }
        return false;
    }

    public static <K, V> V getValue(Collection<KeyValue<K, V>> kvEntries, K key) {
        if (Objects.isNull(key)) {
            return null;
        }
        for (KeyValue<K, V> entry : kvEntries) {
            if (key.equals(entry.key())) {
                return entry.value();
            }
        }
        return null;
    }

    public static <K, V> V getValue(Collection<KeyValue<K, V>> kvEntries, K key, V dValue) {
        if (Objects.isNull(key)) {
            return dValue;
        }
        for (KeyValue<K, V> entry : kvEntries) {
            if (key.equals(entry.key())) {
                return entry.value();
            }
        }
        return dValue;
    }

    public static <K, V> boolean hasKey(KeyValue<K, V>[] kvEntries, K key) {
        if (Objects.isNull(key)) {
            return false;
        }
        for (KeyValue<K, V> entry : kvEntries) {
            if (key.equals(entry.key())) {
                return true;
            }
        }
        return false;
    }

    public static <K, V> boolean hasValue(KeyValue<K, V>[] kvEntries, V value) {
        if (Objects.isNull(value)) {
            return false;
        }
        for (KeyValue<K, V> entry : kvEntries) {
            if (value.equals(entry.value())) {
                return true;
            }
        }
        return false;
    }

    public static <K, V> V getValue(KeyValue<K, V>[] kvEntries, K key) {
        if (Objects.isNull(key)) {
            return null;
        }
        for (KeyValue<K, V> entry : kvEntries) {
            if (key.equals(entry.key())) {
                return entry.value();
            }
        }
        return null;
    }

    public static <K, V> V getValue(KeyValue<K, V>[] kvEntries, K key, V dValue) {
        if (Objects.isNull(key)) {
            return dValue;
        }
        for (KeyValue<K, V> entry : kvEntries) {
            if (key.equals(entry.key())) {
                return entry.value();
            }
        }
        return dValue;
    }

}
