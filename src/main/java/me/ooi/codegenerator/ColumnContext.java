package me.ooi.codegenerator;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author jun.zhao
 */
public class ColumnContext {

    private Map<String, Column> columnMap = new LinkedHashMap<>();

    public void addColumn(Column column){
        columnMap.put(column.getName(), column);
    }

    public Column getOrCreateColumn(String columnName) {
        Column column = columnMap.get(columnName);
        if( column != null ){
            return column;
        }

        return Column.builder().name(columnName).build();
    }
}
