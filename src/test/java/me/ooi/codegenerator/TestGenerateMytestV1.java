package me.ooi.codegenerator;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author jun.zhao
 */
public class TestGenerateMytestV1 {

    @Test
    public void generateCode() {
        String projectDir = "D:\\workspace\\generated\\demo1";
        String moduleNamePrefix = "demo1";
        String projectNameApi = moduleNamePrefix+"-api";
        String projectNameService = moduleNamePrefix+"-service";
        String projectNameResource = moduleNamePrefix+"-resource";

        GeneratorContext root = new GeneratorContext(null);
        root.put("author", "jun.zhao");
        root.put("date", new SimpleDateFormat("yyyy/M/d").format(new Date()));
        root.put("basePackage", "me.ooi.demo1");
        root.put("entityPackage", "me.ooi.demo1.po");
        root.put("mapperPackage", "me.ooi.demo1.mapper");
        root.put("servicePackage", "me.ooi.demo1.service");
        root.put("apiPackage", "me.ooi.demo1.api");
        root.put("voPackage", "me.ooi.demo1.api.vo");
        root.put("dtoPackage", "me.ooi.demo1.api.dto");
        root.put("queryPackage", "me.ooi.demo1.api.query");
        root.put("resourcePackage", "me.ooi.demo1.resource");
        root.setBaseEntityClass(BaseEntity.class);

        GeneratorContext ctx = new GeneratorContext(root);
        ctx.setTableName("c_test");
        writeJava(projectDir, projectNameService, ctx.get("entityPackage"), "entity.ftl", ctx);
        writeJava(projectDir, projectNameApi, ctx.get("voPackage"), "vo.ftl", ctx);
        writeJava(projectDir, projectNameApi, ctx.get("dtoPackage"), "dto.ftl", ctx);
        writeJava(projectDir, projectNameApi, ctx.get("queryPackage"), "query.ftl", ctx);
        writeJava(projectDir, projectNameService, ctx.get("mapperPackage"), "mapper.ftl", ctx);
        writeResource(projectDir, projectNameService, ctx.get("mapperPackage"), "mapper.xml.ftl", ctx);
        writeJava(projectDir, projectNameService, ctx.get("servicePackage"), "service.ftl", ctx);
        writeJava(projectDir, projectNameApi, ctx.get("apiPackage"), "rest_api.ftl", ctx);
        writeJava(projectDir, projectNameResource, ctx.get("resourcePackage"), "rest.ftl", ctx);
    }

    @Test
    public void generateCRUDCode() {
        String projectDir = "D:\\workspace\\generated\\demo1";
        String moduleNamePrefix = "demo1";
        String projectNameApi = moduleNamePrefix+"-api";
        String projectNameService = moduleNamePrefix+"-service";
        String projectNameResource = moduleNamePrefix+"-resource";

        GeneratorContext root = new GeneratorContext(null);
        root.put("author", "jun.zhao");
        root.put("date", new SimpleDateFormat("yyyy/M/d").format(new Date()));
        root.put("basePackage", "me.ooi.demo1");
        root.put("entityPackage", "me.ooi.demo1.po");
        root.put("mapperPackage", "me.ooi.demo1.mapper");
        root.put("servicePackage", "me.ooi.demo1.service");
        root.put("apiPackage", "me.ooi.demo1.api");
        root.put("voPackage", "me.ooi.demo1.api.vo");
        root.put("dtoPackage", "me.ooi.demo1.api.dto");
        root.put("queryPackage", "me.ooi.demo1.api.query");
        root.put("resourcePackage", "me.ooi.demo1.resource");
        root.setBaseEntityClass(BaseEntity.class);

        GeneratorContext ctx = new GeneratorContext(root);
        ctx.setTableName("c_test");
        writeJava(projectDir, projectNameService, ctx.get("entityPackage"), "crud/entity_crud.ftl", ctx);
        writeJava(projectDir, projectNameApi, ctx.get("voPackage"), "vo.ftl", ctx);
        writeJava(projectDir, projectNameApi, ctx.get("dtoPackage"), "dto.ftl", ctx);
        writeJava(projectDir, projectNameApi, ctx.get("queryPackage"), "query.ftl", ctx);
        writeJava(projectDir, projectNameService, ctx.get("mapperPackage"), "crud/mapper_crud.ftl", ctx);
        writeResource(projectDir, projectNameService, ctx.get("mapperPackage"), "crud/mapper.xml_crud.ftl", ctx);
        writeJava(projectDir, projectNameService, ctx.get("servicePackage"), "crud/service_crud.ftl", ctx);
        writeJava(projectDir, projectNameApi, ctx.get("apiPackage"), "crud/rest_api_crud.ftl", ctx);
        writeJava(projectDir, projectNameResource, ctx.get("resourcePackage"), "crud/rest_crud.ftl", ctx);
    }

    private static void writeJava(String projectDir, String moduleName, Object packageName, String templateName, GeneratorContext ctx){
        CodeGenerator.write(new File(String.format("%s/%s/src/main/java/%s", projectDir,
                moduleName, ((String) packageName).replace(".", "/"))), "mytest_v1/code/"+templateName, ctx);
    }

    private static void writeResource(String projectDir, String moduleName, Object packageName, String templateName, GeneratorContext ctx){
        CodeGenerator.write(new File(String.format("%s/%s/src/main/resources/%s", projectDir,
                moduleName, ((String) packageName).replace(".", "/"))), "mytest_v1/code/"+templateName, ctx);
    }

}
