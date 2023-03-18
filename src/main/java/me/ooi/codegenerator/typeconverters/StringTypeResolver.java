package me.ooi.codegenerator.typeconverters;

import cn.hutool.core.util.ArrayUtil;
import me.ooi.codegenerator.TypeResolver;

import java.sql.Types;

/**
 * @author jun.zhao
 */
public class StringTypeResolver extends AbstractTypeResolver {

    @Override
    public boolean accept(int sqlType) {

        return ArrayUtil.contains(new int[]{Types.CHAR, Types.VARCHAR, Types.LONGVARCHAR,
            Types.VARBINARY}, sqlType);
    }

    @Override
    public Class<?> convert(int sqlType) {
        return String.class;
    }

}
