package me.ooi.codegenerator.typeconverters;

import cn.hutool.core.util.ArrayUtil;
import me.ooi.codegenerator.TypeResolver;

import java.math.BigDecimal;
import java.sql.Types;

/**
 * @author jun.zhao
 */
public class BigDecimalTypeResolver extends AbstractTypeResolver {

    @Override
    public boolean accept(int sqlType) {

        return ArrayUtil.contains(new int[]{Types.FLOAT, Types.REAL, Types.DOUBLE, Types.NUMERIC, Types.DECIMAL}, sqlType);
    }

    @Override
    public Class<?> convert(int sqlType) {
        return BigDecimal.class;
    }

}
