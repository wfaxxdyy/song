package org.lvjiang.song.asong.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.sql.Types;
import java.util.Collections;

public class CodeGenerator {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC", "root", "root1234")
                .globalConfig(builder -> {
                    builder.author("van") // 设置作者
                            .commentDate("yyyy-MM-dd HH:mm:ss")
                            .enableSwagger() // 开启 swagger 模式
                            .outputDir("/Users/van/IdeaProjects/song/asong/src/main/java"); // 指定输出目录
                })
                .dataSourceConfig(builder ->
                        builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                            int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                            if (typeCode == Types.SMALLINT) {
                                // 自定义类型转换
                                return DbColumnType.INTEGER;
                            }
                            return typeRegistry.getColumnType(metaInfo);
                        })
                )
                .packageConfig(builder ->
                        builder.parent("org.lvjiang.song.asong") // 设置父包名
                                .entity("entity")
                                .mapper("mapper")
                                .service("service")
                                .serviceImpl("service.impl")
                                .xml("mapper.xml")
                                .pathInfo(Collections.singletonMap(OutputFile.xml, "/Users/van/IdeaProjects/song/asong/src/main/resources/META-INF/mapper")) // 设置mapperXml生成路径
                )
                .strategyConfig(builder ->
                        builder.addInclude("t_test") // 设置需要生成的表名
                                .addTablePrefix("t_", "c_") // 设置过滤表前缀
                                .entityBuilder().enableLombok()
                                .enableFileOverride() //文件覆盖
                                .columnNaming(NamingStrategy.underline_to_camel)
                                .mapperBuilder()
                                .enableFileOverride()
                                .enableBaseResultMap()
                                .enableBaseColumnList()
                                .serviceBuilder().enableFileOverride()
                                .controllerBuilder().enableFileOverride()
                )
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
