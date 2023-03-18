//${table.entityName}Service.java
package ${servicePackage};

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import ${mapperPackage}.${table.entityName}Mapper;
import ${entityPackage}.${table.entityName};

/**
 * ${table.comment}
 * @author ${author}
 * @date ${date}
 */
@Slf4j
@Service
@AllArgsConstructor
public class ${table.entityName}Service extends ServiceImpl<${table.entityName}Mapper, ${table.entityName}> {

}
