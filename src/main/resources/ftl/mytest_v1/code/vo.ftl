//${table.entityName}VO.java
package ${voPackage};

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(title = "${table.comment}")
@Getter
@Setter
@ToString
public class ${table.entityName}VO implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    <#list table.columns>
        <#items as item>
    @Schema(description = "${item.comment}")
    private ${item.javaType.simpleName} ${item.fieldName};

        </#items>
    <#else>
        // no column.
    </#list>

}