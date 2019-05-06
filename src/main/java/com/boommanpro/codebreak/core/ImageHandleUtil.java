package com.boommanpro.codebreak.core;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @author BoomMan
 */
class ImageHandleUtil {

    static void removeBackGround(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (isWhite(image.getRGB(x, y), x, y)) {
                    image.setRGB(x, y, Color.WHITE.getRGB());
                } else {
                    image.setRGB(x, y, Color.BLACK.getRGB());
                }
            }
        }
    }


    static void removeLine(BufferedImage img) {
        int width = img.getWidth();
        int height = img.getHeight();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (img.getRGB(x, y) != Color.WHITE.getRGB()) {
                    if (x == 0 || y == 0 || x == width - 1 || y == height - 1) {
                        img.setRGB(x, y, Color.WHITE.getRGB());
                    } else {
                        int sum = 0;
                        if (img.getRGB(x, y) == Color.BLACK.getRGB()) {
                            for (int m = -1; m <= 1; m++) {
                                for (int n = -1; n <= 1; n++) {
                                    if (img.getRGB(x + m, y + n) == Color.BLACK.getRGB()) {
                                        sum++;
                                    }
                                }
                            }

                        }
                        if (sum <= 3) {
                            img.setRGB(x, y, Color.WHITE.getRGB());
                        }
                    }
                }
            }
        }
    }


    private static boolean isWhite(int colorInt, int x, int y) {
        Color color = new Color(colorInt);
        return color.getRed() >= 200 && color.getRed() <= 255 && color.getGreen() >= 200 && color.getGreen() <= 255
                && color.getBlue() >= 180 && color.getBlue() <= 255;

    }
}
