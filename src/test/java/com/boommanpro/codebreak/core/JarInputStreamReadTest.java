package com.boommanpro.codebreak.core;

import com.boommanpro.codebreak.common.Constant;
import org.junit.Test;

import java.io.File;

public class JarInputStreamReadTest {

    private static final String RES_DIR_PATH = System.getProperty("user.dir") + "/src/main/resources/res/";

    public static final String TRAIN_DIR_PATH =RES_DIR_PATH + "/train/";

    @Test
    public void doGeneratorJson(){
//        this.getClass().getResourceAsStream(Constant.TRAIN_DIR_PATH + trainFile + "\\" + i);

        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < Constant.DEFAULT_TRAIN_MAX_DIR; i++) {
                File dir = new File(TRAIN_DIR_PATH + j + "\\" + i);
                File[] files = dir.listFiles();
                if (files != null) {
                    for (File file : files) {


                        System.out.println(file.getAbsolutePath());
                    }
                }
            }
        }



    }
}
