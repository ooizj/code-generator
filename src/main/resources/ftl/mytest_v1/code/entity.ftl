//${table.entityName}.java
package ${entityPackage};

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

<#list imports as i>
import ${i};
</#list>

/**
 * ${table.comment}
 * @author ${author}
 * @date ${date}
 */
@Getter
@Setter
@ToString
@TableName(value = "${table.name}")
public class ${table.entityName} extends BaseEntity {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    <#list table.columns>
        <#items as item>
    /**
     * ${item.comment}
     */
    private ${item.javaType.simpleName} ${item.fieldName};

        </#items>
    <#else>
        // no column.
    </#list>

}