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
        select
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
    <select id="findList" resultMap="BaseResultMap">
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
        <selectKey keyProperty="${primarykeyProper}" resultType="String" order="BEFORE">
            select sys_guid() from dual
        </selectKey>
        insert into  ${tableName}
        <trim prefix="(" suffix=")" suffixOverrides="," >
            ${parimarykeyname},
             <#list columns as column>
                 <if test="${column.columnNameField} != null">
                     ${column.lowerCaseColumn},
                 </if>
             </#list>
        </trim>
        <trim prefix="values (" suffix=")" suffixOverrides="," >
       #${bigleft} ${primarykeyProper},jdbcType=${primarykeyJdbcType} },
             <#list columns as column>
                 <if test="${column.columnNameField} != null">
                     #${bigleft} ${column.columnNameField},jdbcType=${column.jdbcType} },
                 </if>
             </#list>
        </trim>

    </insert>

    <update id="modifyRecord" parameterType="${className}">
        update  ${tableName}
        <set>
             <#list columns as column>
                 <if test="${column.columnNameField} != null">
                     ${column.lowerCaseColumn} =#${bigleft} ${column.columnNameField},jdbcType=${column.jdbcType} },
                 </if>
             </#list>
        </set>
        where  ${parimarykeyname}=#${bigleft} ${primarykeyProper},jdbcType=${primarykeyJdbcType} }
    </update>

    <!--1. 如果传入的是单参数且参数类型是一个List的时候，collection属性值为list-->
    <!--2. 如果传入的是单参数且参数类型是一个array数组的时候，collection的属性值为array-->
    <!--3. 如果传入的参数是多个的时候，我们就需要把它们封装成一个Map了，当然单参数也可-->
    <delete id="removeRecords">
        delete from   ${tableName}
        where  ${parimarykeyname} in
        <foreach item="item" index="index" collection="array"
                 open="(" separator="," close=")">
        #${bigleft}item}
        </foreach>
    </delete>
</mapper>