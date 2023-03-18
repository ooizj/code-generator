package me.ooi.codegenerator.typeconverters;

import cn.hutool.core.util.ArrayUtil;

import java.sql.Types;

/**
 * @author jun.zhao
 */
public class ByteArrayTypeResolver extends AbstractTypeResolver {

    @Override
    public boolean accept(int sqlType) {

        return ArrayUtil.contains(new int[]{Types.BINARY}, sqlType);
    }

    @Override
    public Class<?> convert(int sqlType) {
        return byte[].class;
    }

}
