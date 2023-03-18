//${entityName}Service.java
package ${servicePackage};

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import ${servicePackage}.${entityName}Service;
import ${mapperPackage}.${entityName}Mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import ${dtoPackage}.${entityName}DTO;
import ${entityPackage}.${entityName};
import ${queryPackage}.${entityName}Query;
import ${voPackage}.${entityName}VO;
import ${basePackage}.api.PageData;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * ${table.comment}Service
 * @author ${author}
 * @date ${date}
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ${entityName}Service {

    private final ${entityName}Mapper ${entityName?uncap_first}Mapper;

    public ${entityName} add(${entityName}DTO ${entityName?uncap_first}DTO) {
        ${entityName} ${entityName?uncap_first} = ${entityName}.from${entityName}DTO(${entityName?uncap_first}DTO);
        ${entityName?uncap_first}Mapper.insert(${entityName?uncap_first});
        return ${entityName?uncap_first};
    }

    public ${entityName} update(${entityName}DTO ${entityName?uncap_first}DTO) {
        ${entityName} ${entityName?uncap_first} = ${entityName}.from${entityName}DTO(${entityName?uncap_first}DTO);
        ${entityName?uncap_first}Mapper.updateById(${entityName?uncap_first});
        return ${entityName?uncap_first}Mapper.selectById(${entityName?uncap_first}.getId());
    }

    public boolean delete(String id) {
        return ${entityName?uncap_first}Mapper.deleteById(id) > 0;
    }

    public ${entityName}VO get(String id) {
        return ${entityName?uncap_first}Mapper.get(id);
    }

    public PageData<${entityName}VO> page(${entityName}Query query) {
        IPage<${entityName}VO> page = ${entityName?uncap_first}Mapper.list(new Page<>(query.getPageNo(), query.getPageSize()), query);
        return new PageData<>(page.getRecords(), page.getTotal());
    }
    
}
