package me.ooi.codegenerator;


import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

/**
 * @author jun.zhao
 */
@Setter
@Getter
public class GeneratorContext extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    private GeneratorContext parent;

    private Class<?> baseEntityClass;

    public GeneratorContext(GeneratorContext parent){
        if( parent != null ){
            this.parent = parent;
            this.baseEntityClass = parent.getBaseEntityClass();
            putAll(parent);
        }
    }

    public Class<?> getBaseEntityClass() {
        return baseEntityClass;
    }

    public void setBaseEntityClass(Class<?> baseEntityClass) {
        this.baseEntityClass = baseEntityClass;
    }

    public Table getTable() {
        return (Table) get("table");
    }

    public void setTable(Table table) {
        put("table", table);
    }

    public String getTableName() {
        return (String) get("tableName");
    }

    public void setTableName(String tableName) {
        put("tableName", tableName);
    }

}
