package com.erouniversity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class DirectoryLogger implements CommandLineRunner {

    @Autowired
    private ReaderService readerService;

    private static Logger logger = LoggerFactory.getLogger(DirectoryLogger.class);

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(DirectoryLogger.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        File file = args.length > 0 ?
                new File(readerService.getRootFolder(args[0])) :
                new File(readerService.getRootFolder());

        if (file.exists()) print(file);
    }

    private static void print(File file) {
        if (file.isFile())
            logger.info("-----File: {}", file.getName());
        else logger.info("Directory: {}", file.getName());

        if (file.isDirectory())
            for (File f : file.listFiles())
                print(f);
    }
}
