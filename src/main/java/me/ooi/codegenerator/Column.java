package me.ooi.codegenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Column {
    private int index;
    private String name;
    private String fieldName;
    private int type;
    private int size;
    private int scale;
    private Class<?> javaType;
    private String comment;
    private boolean inBaseEntity; // 字段是否在基础类里面

}
