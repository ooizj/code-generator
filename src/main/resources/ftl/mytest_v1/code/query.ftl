//${entityName}Query.java
package ${queryPackage};

import java.io.Serializable;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.*;

<#list imports as i>
import ${i};
</#list>

/**
 * ${table.comment}Query
 * @author ${author}
 * @date ${date}
 */
@Getter
@Setter
@ToString
public class ${entityName}Query extends BaseQuery {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    <#list table.columns>
        <#items as item>
        <#if !item.inBaseEntity>
    @Parameter(description = "${item.comment}")
            <#if isNumberType(item.javaType)>
    @Digits(integer = ${item.size?long?c}, fraction = ${item.scale?long?c})
            <#elseif isStringType(item.javaType)>
    @Length(min = 1, max = ${item.size?long?c})
            <#elseif isDateType(item.javaType)>
            <#else>
            </#if>
    private ${item.javaType.simpleName} ${item.fieldName};

        </#if>
        </#items>
    <#else>
        // no column.
    </#list>

}