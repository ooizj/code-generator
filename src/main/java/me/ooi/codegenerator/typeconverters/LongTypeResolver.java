package me.ooi.codegenerator.typeconverters;

import cn.hutool.core.util.ArrayUtil;
import me.ooi.codegenerator.TypeResolver;

import java.sql.Types;

/**
 * @author jun.zhao
 */
public class LongTypeResolver extends AbstractTypeResolver {

    @Override
    public boolean accept(int sqlType) {

        return ArrayUtil.contains(new int[]{Types.BIGINT}, sqlType);
    }

    @Override
    public Class<?> convert(int sqlType) {
        return Long.class;
    }

}
