//${entityName}DTO.java
package ${dtoPackage};

import java.io.Serializable;

import ${basePackage}.api.constraints.InsertGroup;
import ${basePackage}.api.constraints.UpdateGroup;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.*;

<#list imports as i>
import ${i};
</#list>

/**
 * ${table.comment}DTO
 * @author ${author}
 * @date ${date}
 */
@Schema(title = "${table.comment}DTO")
@Getter
@Setter
@ToString
public class ${entityName}DTO implements Serializable {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    @Schema(description = "ID")
    @NotBlank(groups = UpdateGroup.class)
    private String id;

    <#list table.columns>
        <#items as item>
        <#if !item.inBaseEntity>
    @Schema(description = "${item.comment}")
            <#if isNumberType(item.javaType)>
    @NotNull(groups = {InsertGroup.class, UpdateGroup.class})
    @Digits(integer = ${item.size?long?c}, fraction = ${item.scale?long?c}, groups = {InsertGroup.class, UpdateGroup.class})
            <#elseif isStringType(item.javaType)>
    @NotEmpty(groups = {InsertGroup.class, UpdateGroup.class})
    @Length(min = 1, max = ${item.size?long?c}, groups = {InsertGroup.class, UpdateGroup.class})
            <#elseif isDateType(item.javaType)>
    @NotNull(groups = {InsertGroup.class, UpdateGroup.class})
            <#else>
    @NotNull(groups = {InsertGroup.class, UpdateGroup.class})
            </#if>
    private ${item.javaType.simpleName} ${item.fieldName};

        </#if>
        </#items>
    <#else>
        // no column.
    </#list>

}