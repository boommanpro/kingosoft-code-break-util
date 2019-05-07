package cn.boommanpro.codebreak.core;



import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author BoomMan
 */
public class CodeBreak {

    public static String codeBreak(InputStream inputStream) throws IOException {
        //1.inputStream2BufferedImage
        BufferedImage bufferedImage =  ImageIO.read(inputStream);
        //2.去背景 二值化操作
        ImageHandleUtil.removeBackGround(bufferedImage);
        //3.去除图像干扰像素（非必须操作，只是可以提高精度而已）。
        ImageHandleUtil.removeLine(bufferedImage);
        //4.判断得值
        return ImageCompareUtil.doOcr(bufferedImage);
    }










}
