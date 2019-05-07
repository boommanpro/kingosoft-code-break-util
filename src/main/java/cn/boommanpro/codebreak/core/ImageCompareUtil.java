package cn.boommanpro.codebreak.core;

import cn.boommanpro.codebreak.cache.TrainImageCache;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author BoomMan
 */
class ImageCompareUtil {


    static String doOcr(BufferedImage img) {

        //1.将输入拆分
        List<BufferedImage> listImg = splitImage(img);
        //2.进行比对得值
        return ImageCompareUtil.getSingleCharOcr(listImg.get(0), TrainImageCache.getMAP0()) +
                ImageCompareUtil.getSingleCharOcr(listImg.get(1), TrainImageCache.getMAP1()) +
                ImageCompareUtil.getSingleCharOcr(listImg.get(2), TrainImageCache.getMAP2()) +
                ImageCompareUtil.getSingleCharOcr(listImg.get(3), TrainImageCache.getMAP3());


    }

    /**
     * 3.判断拆分验证码的标准：就是定义验证码中包含的各数字的x、y坐标值，及它们的宽度（width）、高度（height）。
     */
    private static List<BufferedImage> splitImage(BufferedImage image) {
        // final int DIGIT_WIDTH = 19;
        // final int DIGIT_HEIGHT = 17;

        java.util.List<BufferedImage> digitImageList = new ArrayList<>();
        digitImageList.add(image.getSubimage(6, 13, 32, 32));
        digitImageList.add(image.getSubimage(37, 20, 26, 31));
        digitImageList.add(image.getSubimage(65, 13, 30, 31));
        digitImageList.add(image.getSubimage(93, 19, 27, 31));

        return digitImageList;
    }

    /**
     * 两张图片进行对比获得值
     */
    private static String getSingleCharOcr(BufferedImage img, Map<BufferedImage, String> map) {
        String result = "#";
        int width = img.getWidth();
        int height = img.getHeight();
        int min = width * height;
        for (BufferedImage bi : map.keySet()) {
            int count = 0;
            if (Math.abs(bi.getWidth() - width) > 2) {
                continue;
            }
            int widthMin = width < bi.getWidth() ? width : bi.getWidth();
            int heightMin = height < bi.getHeight() ? height : bi.getHeight();
            Label1:
            for (int x = 0; x < widthMin; ++x) {
                for (int y = 0; y < heightMin; ++y) {
                    if (isBlack(img.getRGB(x, y)) != isBlack(bi.getRGB(x, y))) {
                        count++;
                        if (count >= min) {
                            break Label1;
                        }
                    }
                }
            }
            if (count < min) {
                min = count;
                result = map.get(bi);
            }
        }
        return result;
    }

    private static int isBlack(int colorInt) {
        Color color = new Color(colorInt);
        if (color.getRed() + color.getGreen() + color.getBlue() <= 100) {
            return 1;
        }
        return 0;
    }
}
