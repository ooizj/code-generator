package me.ooi.codegenerator.typeconverters;

import cn.hutool.core.util.ArrayUtil;
import me.ooi.codegenerator.TypeResolver;

import java.sql.Types;

/**
 * @author jun.zhao
 */
public class IntegerTypeResolver extends AbstractTypeResolver {

    // TODO int 类型长度问题
    @Override
    public boolean accept(int sqlType) {

        return ArrayUtil.contains(new int[]{Types.BIT, Types.TINYINT, Types.SMALLINT, Types.INTEGER}, sqlType);
    }

    @Override
    public Class<?> convert(int sqlType) {
        return Integer.class;
    }

}
