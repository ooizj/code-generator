package me.ooi.codegenerator.contextwriters;

import me.ooi.codegenerator.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author jun.zhao
 */
public class EntityContextWriter implements ContextWriter {

    @Override
    public void write(GeneratorContext ctx) throws GenerateException {
        Table table = ctx.getTable();
        Set<String> imports = new HashSet<>();
        List<String> baseEntityFiledNames = new ArrayList<>();
        if( ctx.getBaseEntityClass() != null ){
            baseEntityFiledNames.addAll(Stream.of(ctx.getBaseEntityClass().getDeclaredFields()).map(Field::getName).collect(Collectors.toList()));
        }
        table.getColumns().forEach(c->{

            // set field type
            TypeResolver typeResolver = ServiceRegistry.INSTANCE.getTypeResolvers().stream().filter(t->t.accept(c.getType())).findFirst().orElse(null);
            if( typeResolver == null ){
                throw new GenerateException("type["+c.getType()+"] not support");
            }
            Class<?> clazz = typeResolver.convert(c.getType());
            c.setJavaType(clazz);

            // add imports
            if( (!clazz.getName().startsWith("java.lang.")) && (clazz.getName().contains(".")) ){
                imports.add(clazz.getCanonicalName());
            }

            // set field name
            String fieldName = ServiceRegistry.INSTANCE.getNameConverter().fieldName(c.getName());
            c.setFieldName(fieldName);

            // is in base entity
            c.setInBaseEntity(baseEntityFiledNames.contains(fieldName));

        });
        ctx.put("imports", imports);

        String entityName = ServiceRegistry.INSTANCE.getNameConverter().entityName(table.getName());
        ctx.put("entityName", entityName);
        table.setEntityName(entityName);

    }


}
