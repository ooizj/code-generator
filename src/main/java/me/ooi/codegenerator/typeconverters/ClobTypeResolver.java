package me.ooi.codegenerator.typeconverters;

import cn.hutool.core.util.ArrayUtil;
import me.ooi.codegenerator.TypeResolver;

import java.sql.Blob;
import java.sql.Clob;
import java.sql.Types;

/**
 * @author jun.zhao
 */
public class ClobTypeResolver extends AbstractTypeResolver {

    @Override
    public boolean accept(int sqlType) {

        return ArrayUtil.contains(new int[]{Types.CLOB}, sqlType);
    }

    @Override
    public Class<?> convert(int sqlType) {
        return Clob.class;
    }

}
