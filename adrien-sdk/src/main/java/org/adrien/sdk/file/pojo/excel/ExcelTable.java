package org.adrien.sdk.file.pojo.excel;

import lombok.Getter;
import org.adrien.sdk.base.pojo.struc.KeyValue;
import org.apache.commons.collections.IteratorUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Xieningjun
 * @date 2023/6/13 14:13
 * @description
 */
public class ExcelTable {

    @Getter
    private final Class<?> clazz;

    @Getter
    private final List<String> titleList;

    @Getter
    private final List<List<KeyValue<String, Object>>> table;

    public ExcelTable(XSSFSheet sheet, Class<?> clazz) {
        this.clazz = clazz;
        this.titleList = (List<String>) IteratorUtils.toList(sheet.getRow(0).cellIterator()).stream().map(c -> c.toString()).collect(Collectors.toList());
        this.table = new ArrayList<>();
        this.sheet2List(sheet);
    }

    private void sheet2List(XSSFSheet sheet) {
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            List<KeyValue<String, Object>> cellDataList = new ArrayList<>();
            Row row = sheet.getRow(i);
            List<XSSFCell> cellList = IteratorUtils.toList(row.cellIterator());
            for (int j = 0; j < this.titleList.size(); j++) {
                int finalJ = j;
                cellDataList.add(new KeyValue<String, Object>() {
                    @Override
                    public String key() {
                        return titleList.get(finalJ);
                    }
                    @Override
                    public Object value() {
                        return cellList.get(finalJ);
                    }
                    public String toString() {
                        return String.format("%s : %s", this.key(), this.value());
                    }
                });
            }
            this.table.add(cellDataList);
        }
    }

}
