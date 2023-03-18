//${entityName}ResourceImpl.java
package ${resourcePackage};

import ${basePackage}.api.PageData;
import ${basePackage}.api.StdResult;
import ${basePackage}.api.constraints.InsertGroup;
import ${basePackage}.api.constraints.UpdateGroup;
import ${servicePackage}.${entityName}Service;
import ${dtoPackage}.${entityName}DTO;
import ${entityPackage}.${entityName};
import ${queryPackage}.${entityName}Query;
import ${voPackage}.${entityName}VO;
import ${apiPackage}.${entityName}Resource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ${entityName}ResourceImpl implements ${entityName}Resource{

    private final ${entityName}Service ${entityName?uncap_first}Service;
    
    @Override
    public StdResult<String> add(@Validated(InsertGroup.class) @RequestBody ${entityName}DTO dto) {
        ${entityName} ${entityName?uncap_first} = ${entityName?uncap_first}Service.add(dto);
        return StdResult.success(${entityName?uncap_first}.getId());
    }

    @Override
    public StdResult<Boolean> update(@Validated(UpdateGroup.class) @RequestBody ${entityName}DTO dto) {
        ${entityName?uncap_first}Service.update(dto);
        return StdResult.success(true);
    }

    @Override
    public StdResult<Boolean> delete(@PathVariable("id") String id) {
        return StdResult.success(${entityName?uncap_first}Service.delete(id));
    }

    @Override
    public StdResult<${entityName}VO> get(@PathVariable("id") String id) {
        return StdResult.success(${entityName?uncap_first}Service.get(id));
    }

    @Override
    public StdResult<PageData<${entityName}VO>> page(@Validated ${entityName}Query query) {
        return StdResult.success(${entityName?uncap_first}Service.page(query));
    }

}