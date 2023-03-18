package me.ooi.codegenerator;

/**
 * 表名 -> java实体名
 * 字段名 -> java字段名
 * @author jun.zhao
 */
public interface NameConverter {

    String entityName(String tableName);

    String fieldName(String columnName);

    String columnName(String fieldName);

}
