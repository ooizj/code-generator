package me.ooi.codegenerator;

import lombok.Builder;
import lombok.Data;

import java.sql.Types;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jun.zhao
 */
@Data
@Builder
public class Table {

    private static final List<Integer> bigDataTypes = Arrays.asList(
            Types.LONGVARCHAR,
            Types.LONGVARBINARY,
            Types.BLOB,
            Types.CLOB,
            Types.LONGNVARCHAR,
            Types.NCLOB
    );

    private String name;
    private String entityName;
    private String comment;
    private List<Column> columns;

    public boolean hasBigColumn(){
        if( columns == null ){
            return false;
        }

        return columns.stream().anyMatch(c->bigDataTypes.contains(c.getType()));
    }

    public List<Column> getBigColumns(){
        return columns.stream().filter(c->bigDataTypes.contains(c.getType())).collect(Collectors.toList());
    }

    public List<Column> getNotBigColumns(){
        return columns.stream().filter(c->!bigDataTypes.contains(c.getType())).collect(Collectors.toList());
    }

}
