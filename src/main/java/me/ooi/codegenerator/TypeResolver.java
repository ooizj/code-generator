package me.ooi.codegenerator;

/**
 * mysql -> java 类型解析
 * @author jun.zhao
 */
public interface TypeResolver {

    /**
     * 是否可以转换
     * @param sqlType 数据库字段类型
     * @return 是否可以转换
     */
    boolean accept(int sqlType);

    /**
     * sql type -> java类型
     * @param sqlType 数据库字段类型
     * @return java类型
     */
    Class<?> convert(int sqlType);

}
