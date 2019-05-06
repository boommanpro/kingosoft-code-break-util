package com.boommanpro.codebreak.core;

import com.alibaba.fastjson.JSONObject;
import com.boommanpro.codebreak.common.Constant;
import com.boommanpro.codebreak.common.IoUtil;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
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

        JSONObject trainConfig = getTrainConfig();
        JSONObject currentTrainConfig = trainConfig.getJSONObject(trainFile);

        for (Map.Entry<String, Object> stringObjectEntry : currentTrainConfig.entrySet()) {
            InputStream file = TrainImageLoadUtil.class.getResourceAsStream(Constant.TRAIN_DIR_PATH + stringObjectEntry.getKey());
            map.put(ImageIO.read(file), stringObjectEntry.getValue().toString());
        }
        return map;

    }

    private static JSONObject getTrainConfig() throws IOException {
        InputStream resourceAsStream = TrainImageLoadUtil.class.getResourceAsStream(Constant.TRAIN_CONFIG);
        String s = IoUtil.toString(resourceAsStream);
        resourceAsStream.close();
       return JSONObject.parseObject(s);
    }


}
