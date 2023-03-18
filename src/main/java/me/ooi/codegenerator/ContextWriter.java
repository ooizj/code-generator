package me.ooi.codegenerator;


/**
 * @author jun.zhao
 */
public interface ContextWriter {

    void write(GeneratorContext ctx) throws GenerateException;

}
