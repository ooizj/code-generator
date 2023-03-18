//${entityName}Mapper.java
package ${mapperPackage};

import java.util.List;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;

import ${entityPackage}.${entityName};
import ${queryPackage}.${entityName}Query;
import ${voPackage}.${entityName}VO;

/**
 * ${table.comment}Mapper
 * @author ${author}
 * @date ${date}
 */
public interface ${entityName}Mapper extends com.baomidou.mybatisplus.core.mapper.BaseMapper<${entityName}> {

    /**
     * ${table.comment}详情
     * @param id id
     * @return ${table.comment}
     */
    ${entityName}VO get(@Param("id") String id);

    /**
     * ${table.comment}列表
     * @param query 条件
     * @return ${table.comment}
     */
    IPage<${entityName}VO> list(IPage<?> page, @Param("query") ${entityName}Query query);

}