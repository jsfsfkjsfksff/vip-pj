package cn.edu.zut.CR;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.nio.file.Paths;


public class GenerateCode {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/car?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true";
        String username="root";
        String password="200573Wenrui#";
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> builder
                        .author("WenruiLi")
                        .outputDir(
                                Paths.get(System.getProperty("user.dir"), "src", "main", "java").toString()
                        )
                        .commentDate("yyyy-MM-dd")
                )
                .packageConfig(builder -> builder
                        .parent("cn.edu.zut.CR.rent")
                        .entity("entity")
                        .mapper("dao")
                        .controller("servlet")   // servlet 包
                )
                .strategyConfig(builder -> builder
                        .addInclude("tb_rent")
                        .entityBuilder()
                        .enableLombok()
                        .controllerBuilder()
                        .enableRestStyle()
                )
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();

    }
}
