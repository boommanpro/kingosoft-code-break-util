package com.boommanpro.codebreak.core;

import com.boommanpro.codebreak.common.Constant;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author BoomMan
 */
public class TrainImageLoadUtil {


    public static Map<BufferedImage, String> load(String trainFile) throws Exception {
        Map<BufferedImage, String> map = new HashMap<>(12);
        return load(map, trainFile);

    }

    public static Map<BufferedImage, String> load(Map<BufferedImage, String> map, String trainFile) throws Exception {
        for (int i = 0; i < Constant.DEFAULT_TRAIN_MAX_DIR; i++) {
            File dir = new File(Constant.TRAIN_DIR_PATH + trainFile + "\\" + i);
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    map.put(ImageIO.read(file), String.valueOf(file.getName().charAt(0)));
                }
            }
        }
        return map;

    }


}
