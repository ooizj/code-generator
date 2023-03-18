//${entityName}Mapper.xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${mapperPackage}.${entityName}Mapper">

    <sql id="Base_Column_List_Without_Blob">
        <#list table.getNotBigColumns() as item>${item.name}${item?is_last?then('', ',')}</#list>
    </sql>

<#if table.hasBigColumn()>
    <sql id="Base_Column_List">
        <include refid="Base_Column_List_Without_Blob"/>,
        <#list table.getBigColumns() as item>${item.name}${item?is_last?then('', ',')}</#list>
    </sql>
<#else>
    <sql id="Base_Column_List">
        <#list table.columns as item>${item.name}${item?is_last?then('', ',')}</#list>
    </sql>
</#if>

    <select id="get" resultType="${voPackage}.${entityName}VO">
        select <include refid="Base_Column_List"/>
        from ${table.name}
        where id = ${r'#{id}'}
    </select>

    <select id="list" resultType="${voPackage}.${entityName}VO">
        select <include refid="Base_Column_List_Without_Blob"/>
        from ${table.name}
    </select>


</mapper>