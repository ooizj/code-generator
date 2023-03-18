package me.ooi.codegenerator;

import com.google.common.base.CaseFormat;

import java.util.Locale;

/**
 * @author jun.zhao
 */
public class DefaultNameConverter implements NameConverter{

    @Override
    public String entityName(String tableName) {
        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, tableName.toLowerCase(Locale.ENGLISH));
    }

    @Override
    public String fieldName(String columnName) {
        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, columnName.toLowerCase(Locale.ENGLISH));
    }

    @Override
    public String columnName(String fieldName) {
        return CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, fieldName);
    }

}
