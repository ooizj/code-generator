package me.ooi.codegenerator;

import cn.hutool.core.io.FileUtil;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author jun.zhao
 */
public class CodeGenerator {

    public static void write(File outputDir, String templateName, GeneratorContext ctx) throws GenerateException {
        String code = generateCode(templateName, ctx);
        int firstLineEnd = code.indexOf("\n");
        String fileName = code.substring(0, firstLineEnd).replace("\r","").replace("//", "");
        if( !outputDir.exists() ){
            if( !outputDir.mkdirs() ){
                throw new GenerateException("create file["+outputDir+"] failed");
            }
        }
        File file = new File(outputDir, fileName);
        FileUtil.writeUtf8String(code.substring(firstLineEnd+1), file); // 去掉第一行
    }

    public static String generateCode(String templateName, GeneratorContext ctx) throws GenerateException {

        ServiceRegistry.INSTANCE.getContextWriters().forEach(writer-> writer.write(ctx));

        try {
            return FreemarkerUtil.toString(templateName, ctx);
        } catch (IOException | TemplateException e) {
            throw new GenerateException(e);
        }
    }

    @Deprecated
    public String generate(String templateName,String tableName, GeneratorContext parent) throws SQLException {

        GeneratorContext ctx = new GeneratorContext(parent);
        ctx.setTableName(tableName);
        ServiceRegistry.INSTANCE.getContextWriters().forEach(writer-> writer.write(ctx));

        try {
            return FreemarkerUtil.toString(templateName, ctx);
        } catch (IOException | TemplateException e) {
            throw new GenerateException(e);
        }
    }

    @Deprecated
    public void write(File outputDir, String templateName, String tableName, GeneratorContext parent) throws SQLException {
        String code = generate(templateName, tableName, parent);
        int firstLineEnd = code.indexOf("\n");
        String fileName = code.substring(0, firstLineEnd).replace("\r","").replace("//", "");
        if( !outputDir.exists() ){
            if( !outputDir.mkdirs() ){
                throw new GenerateException("create file["+outputDir+"] failed");
            }
        }
        File file = new File(outputDir, fileName);
        FileUtil.writeUtf8String(code.substring(firstLineEnd+1), file); // 去掉第一行
//        FileUtil.writeUtf8String(code, file);
    }

}
