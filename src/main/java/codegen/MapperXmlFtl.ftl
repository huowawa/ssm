<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="com.soft.platform.${packageName}.mapper.${className}Mapper" >
    <resultMap id="BaseResultMap" type="com.soft.platform.${packageName}.model.${className}" >
        <id column="${parimarykeyname}" property="${primarykeyProper}" jdbcType="${primarykeyJdbcType}" />
        <#list columns as column>
          <result column="${column.lowerCaseColumn}" property="${column.columnNameField}" jdbcType="${column.jdbcType}" />
        </#list>
    </resultMap>

    <sql id="BaseColumnList">
        ${base_column_list}
    </sql>

    <select id="getById" resultMap="BaseResultMap">
        <include refid="BaseColumnList" />
        from   ${tableName}
        where  ${parimarykeyname}=#${bigleft} ${primarykeyProper},jdbcType=${primarykeyJdbcType} }
    </select>

    <select id="getRecord" resultMap="BaseResultMap">
        select
        <include refid="BaseColumnList" />
        from   ${tableName}
        <where>
             <#list columns as column>
            <if test="${column.columnNameField} != null">
                ${column.lowerCaseColumn} = #${bigleft} ${column.columnNameField} }
            </if>
             </#list>
        </where>
    </select>

    <select id="findRecord" resultMap="BaseResultMap">
        select
        <include refid="BaseColumnList" />
        from   ${tableName}
        <where>
             <#list columns as column>
                 <if test="${column.columnNameField} != null">
                     ${column.lowerCaseColumn} = #${bigleft} ${column.columnNameField} }
                 </if>
             </#list>
        </where>
    </select>

    <insert id="saveRecord" parameterType="${className}">
        insert into  ${tableName}
        <trim prefix="(" suffix=")" suffixOverrides="," >
             <#list columns as column>
                 <if test="${column.columnNameField} != null">
                     ${column.lowerCaseColumn}
                 </if>
             </#list>
        </trim>
        <trim prefix="values (" suffix=")" suffixOverrides="," >
             <#list columns as column>
                 <if test="${column.columnNameField} != null">
                     ${column.lowerCaseColumn} =#${bigleft} ${column.columnNameField},jdbcType=${column.jdbcType} }
                 </if>
             </#list>
        </trim>

    </insert>

    <update id="modifyRecord" parameterType="${className}">
        update  ${tableName}
        <set>
             <#list columns as column>
                 <if test="${column.columnNameField} != null">
                     ${column.lowerCaseColumn} =#${bigleft} ${column.columnNameField},jdbcType=${column.jdbcType} }
                 </if>
             </#list>
        </set>
        where  ${parimarykeyname}=#${bigleft} ${primarykeyProper},jdbcType=${primarykeyJdbcType} }
    </update>

    <delete id="removeRecords">
        delete from   ${tableName}
        where  ${parimarykeyname} in
        <foreach item="item" index="index" collection="colValues"
                 open="(" separator="," close=")">
        #${bigleft}item}
        </foreach>
    </delete>
</mapper>