package org.adrien.sdk.file.util;

import org.adrien.sdk.base.pojo.struc.KeyValue;
import org.adrien.sdk.base.util.KeyValueUtil;
import org.adrien.sdk.file.annotation.Excel;
import org.adrien.sdk.file.pojo.excel.ExcelTable;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Xieningjun
 * @date 2023/6/13 16:11
 * @description
 */
public class ExcelUtil {

    public static <T> List<T> excel2InstanceList(ExcelTable excelTable) throws Exception {
        List<T> tList = new ArrayList<>();
        Class<?> clazz = excelTable.getClazz();
        Field[] fields = clazz.getDeclaredFields();
        for (List<KeyValue<String, Object>> rows : excelTable.getTable()) {
            Object instance = clazz.newInstance();
            for (Field field : fields) {
                Excel anno = field.getAnnotation(Excel.class);
                if (anno != null && anno._import() && KeyValueUtil.hasKey(rows, anno.value())) {
                    Object value = KeyValueUtil.getValue(rows, anno.value());
                    field.setAccessible(true);
                    setField(field, instance, value);
                }
            }
            tList.add((T) instance);
        }
        return tList;
    }

    private static void setField(Field field, Object instance, Object value) throws IllegalAccessException {
        if (String.class.equals(field.getType())) {
            field.set(instance, value.toString());
        } else if (Integer.class.equals(field.getType()) || int.class.equals(field.getType())) {
            field.set(instance, Integer.parseInt(String.valueOf((int) Float.parseFloat(value.toString()))));
        } else if (Long.class.equals(field.getType()) || long.class.equals(field.getType())) {
            field.set(instance, Long.parseLong(value.toString()));
        } else if (Float.class.equals(field.getType()) || float.class.equals(field.getType())) {
            field.set(instance, Float.parseFloat(value.toString()));
        } else if (Boolean.class.equals(field.getType()) || boolean.class.equals(field.getType())) {
            field.set(instance, Boolean.parseBoolean(value.toString()));
        } else {
            field.set(instance, null);
        }
    }

}
