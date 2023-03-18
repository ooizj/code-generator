package me.ooi.codegenerator.contextwriters;

import freemarker.ext.util.WrapperTemplateModel;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;
import freemarker.template.TemplateScalarModel;
import me.ooi.codegenerator.ContextWriter;
import me.ooi.codegenerator.GenerateException;
import me.ooi.codegenerator.GeneratorContext;
import me.ooi.codegenerator.ServiceRegistry;

import java.util.Date;
import java.util.List;

/**
 * @author jun.zhao
 */
public class FreemarkerMethodContextWriter implements ContextWriter {

    @Override
    public void write(GeneratorContext ctx) throws GenerateException {
//        ctx.put("getEntityName", new GetEntityNameMethod());
//        ctx.put("getFieldName", new GetFieldNameMethod());
        ctx.put("isNumberType", new IsNumberType());
        ctx.put("isStringType", new IsStringType());
        ctx.put("isDateType", new IsDateType());
    }

//    public static class GetEntityNameMethod implements TemplateMethodModelEx {
//
//        @Override
//        public Object exec(List args) throws TemplateModelException {
//            if (args.size() != 1) {
//                throw new TemplateModelException("Wrong arguments");
//            }
//
//            TemplateScalarModel arg = (TemplateScalarModel) args.get(0);
//            return ServiceRegistry.INSTANCE.getNameConverter().entityName(arg.getAsString());
//        }
//
//    }
//
//    public static class GetFieldNameMethod implements TemplateMethodModelEx {
//
//        @Override
//        public Object exec(List args) throws TemplateModelException {
//            if (args.size() != 1) {
//                throw new TemplateModelException("Wrong arguments");
//            }
//
//            TemplateScalarModel arg = (TemplateScalarModel) args.get(0);
//            return ServiceRegistry.INSTANCE.getNameConverter().fieldName(arg.getAsString());
//        }
//
//    }

    public static abstract class IsType implements TemplateMethodModelEx {

        private Class requiredType;
        public IsType(Class requiredType) {
            this.requiredType = requiredType;
        }

        @Override
        public Object exec(List list) throws TemplateModelException {
            if (list.size() != 1) {
                throw new TemplateModelException("Wrong arguments");
            }
            Object obj1 = ((WrapperTemplateModel) list.get(0)).getWrappedObject();
            if ( !(obj1 instanceof Class) ) {
                throw new TemplateModelException("Wrong type of the parameter. It should be Class. Found: " + obj1.getClass());
            }
            Class clazz1 = (Class) obj1;
            return requiredType.isAssignableFrom(clazz1);
        }
    }

    public static class IsNumberType extends IsType {
        public IsNumberType() {
            super(Number.class);
        }
    }

    public static class IsStringType extends IsType {
        public IsStringType() {
            super(String.class);
        }
    }

    public static class IsDateType extends IsType {
        public IsDateType() {
            super(Date.class);
        }
    }

}
