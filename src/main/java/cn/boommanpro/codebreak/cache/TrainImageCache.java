package cn.boommanpro.codebreak.cache;

import cn.boommanpro.codebreak.core.TrainImageLoadUtil;
import cn.boommanpro.codebreak.exception.InitErrorException;

import java.awt.image.BufferedImage;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author BoomMan
 */

public class TrainImageCache {
    private static final Map<BufferedImage, String> MAP0 = new ConcurrentHashMap<>();
    private static final Map<BufferedImage, String> MAP1 = new ConcurrentHashMap<>();
    private static final Map<BufferedImage, String> MAP2 = new ConcurrentHashMap<>();
    private static final Map<BufferedImage, String> MAP3 = new ConcurrentHashMap<>();

    static {
        try {
            TrainImageLoadUtil.load(MAP0, "0");
            TrainImageLoadUtil.load(MAP1, "1");
            TrainImageLoadUtil.load(MAP2, "2");
            TrainImageLoadUtil.load(MAP3, "3");
        } catch (Exception e) {
            e.printStackTrace();
            throw new InitErrorException("加载初始化train数据异常");
        }
        System.err.println("Kingosoft Code Break Load Success");

    }

    public static Map<BufferedImage, String> getMAP0() {
        return MAP0;
    }

    public static Map<BufferedImage, String> getMAP1() {
        return MAP1;
    }

    public static Map<BufferedImage, String> getMAP2() {
        return MAP2;
    }

    public static Map<BufferedImage, String> getMAP3() {
        return MAP3;
    }
}
