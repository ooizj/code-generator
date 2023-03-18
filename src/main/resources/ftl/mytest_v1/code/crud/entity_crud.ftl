//${table.entityName}.java
package ${entityPackage};

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Optional;
<#list imports as i>
import ${i};
</#list>

import ${dtoPackage}.${entityName}DTO;

/**
 * ${table.comment}
 * @author ${author}
 * @date ${date}
 */
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

    public static ${entityName} from${entityName}DTO(final ${entityName}DTO dto) {
        return Optional.ofNullable(dto).map(item -> ${entityName}.builder()
                .id(item.getId())
             <#list table.columns as it>
             <#if !it.inBaseEntity>
                .${it.fieldName}(item.get${it.fieldName?cap_first}())
             </#if>
             </#list>
                .build()
        ).orElse(null);
    }

}