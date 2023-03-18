package me.ooi.codegenerator.contextwriters;

import me.ooi.codegenerator.*;

import java.sql.SQLException;

/**
 * @author jun.zhao
 */
public class TableInfoContextWriter implements ContextWriter {

    @Override
    public void write(GeneratorContext ctx) throws GenerateException {
        if( ctx.getTableName() == null ){
            return;
        }

        String tableName = ctx.getTableName();
        try {
            Table table = MysqlHelper.getTable(tableName);
            if( table == null ){
                throw new GenerateException("table["+tableName+"] not exists");
            }
            ctx.setTable(table);
        } catch (SQLException e) {
            throw new GenerateException("获取["+tableName+"]表信息失败", e);
        }
    }

}
