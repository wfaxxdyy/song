package org.lvjiang.song.asong;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.lvjiang.song.asong.mapper")
public class AsongApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsongApplication.class, args);
    }

}
