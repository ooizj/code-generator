package me.ooi.codegenerator;

import freemarker.template.*;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

/**
 * @author jun.zhao
 */
public class FreemarkerUtil {

    private static final String templateDir = "/ftl";

    public static Configuration cfg;
    static {
        // Create your Configuration instance, and specify if up to what FreeMarker
// version (here 2.3.29) do you want to apply the fixes that are not 100%
// backward-compatible. See the Configuration JavaDoc for details.
        cfg = new Configuration(Configuration.VERSION_2_3_29);

// Specify the source where the template files come from. Here I set a
// plain directory for it, but non-file-system sources are possible too:
        cfg.setClassForTemplateLoading(FreemarkerUtil.class, templateDir);

// From here we will set the settings recommended for new projects. These
// aren't the defaults for backward compatibilty.

// Set the preferred charset template files are stored in. UTF-8 is
// a good choice in most applications:
        cfg.setDefaultEncoding("UTF-8");

// Sets how errors will appear.
// During web page *development* TemplateExceptionHandler.HTML_DEBUG_HANDLER is better.
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

// Don't log exceptions inside FreeMarker that it will thrown at you anyway:
        cfg.setLogTemplateExceptions(false);

// Wrap unchecked exceptions thrown during template processing into TemplateException-s:
        cfg.setWrapUncheckedExceptions(true);

// Do not fall back to higher scopes when reading a null loop variable:
        cfg.setFallbackOnNullLoopVariable(false);

    }

    public static String toString(String templateName, Map<String, Object> context) throws IOException, TemplateException {
        Template temp = cfg.getTemplate(templateName);
        StringWriter out = new StringWriter();
        temp.process(context, out);
        return out.toString();
    }

}
