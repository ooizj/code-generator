package me.ooi.codegenerator.typeconverters;

import cn.hutool.core.util.ArrayUtil;
import me.ooi.codegenerator.TypeResolver;

import java.sql.Blob;
import java.sql.Types;

/**
 * @author jun.zhao
 */
public class BlobTypeResolver extends AbstractTypeResolver {

    @Override
    public boolean accept(int sqlType) {

        return ArrayUtil.contains(new int[]{Types.LONGVARBINARY, Types.BLOB}, sqlType);
    }

    @Override
    public Class<?> convert(int sqlType) {
        return Blob.class;
    }

}
