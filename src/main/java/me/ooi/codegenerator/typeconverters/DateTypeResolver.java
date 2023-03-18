package me.ooi.codegenerator.typeconverters;

import cn.hutool.core.util.ArrayUtil;
import me.ooi.codegenerator.TypeResolver;

import java.sql.Types;
import java.util.Date;

/**
 * @author jun.zhao
 */
public class DateTypeResolver extends AbstractTypeResolver {

    @Override
    public boolean accept(int sqlType) {

        return ArrayUtil.contains(new int[]{Types.DATE, Types.TIME, Types.TIMESTAMP}, sqlType);
    }

    @Override
    public Class<?> convert(int sqlType) {
        return Date.class;
    }

}
