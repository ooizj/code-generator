//${entityName}Resource.java
package ${apiPackage};

import ${basePackage}.api.PageData;
import ${basePackage}.api.constraints.InsertGroup;
import ${basePackage}.api.constraints.UpdateGroup;
import ${dtoPackage}.${entityName}DTO;
import ${queryPackage}.${entityName}Query;
import ${voPackage}.${entityName}VO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "${table.comment}相关接口V1")
@RequestMapping("/v1/${entityName?uncap_first}")
public interface ${entityName}Resource {

    @Operation(summary = "新增${table.comment}", parameters = {@Parameter(name = "dto", description = "${table.comment}")})
    @PostMapping
    StdResult<String> add(@Validated(InsertGroup.class) @RequestBody ${entityName}DTO dto);

    @Operation(summary = "修改${table.comment}", parameters = {@Parameter(name = "dto", description = "${table.comment}")})
    @PutMapping
    StdResult<Boolean> update(@Validated(UpdateGroup.class) @RequestBody ${entityName}DTO dto);

    @Operation(summary = "删除${table.comment}", parameters = {@Parameter(name = "id", description = "ID")})
    @DeleteMapping("/{id}")
    StdResult<Boolean> delete(@PathVariable("id") String id);

    @Operation(summary = "${table.comment}详情", parameters = {@Parameter(name = "id", description = "ID")})
    @GetMapping("/{id}")
    StdResult<${entityName}VO> get(@PathVariable("id") String id);

    @Operation(summary = "${table.comment}分页", parameters = {@Parameter(name = "query", description = "条件")})
    @GetMapping
    StdResult<PageData<${entityName}VO>> page(@Validated ${entityName}Query query);

}