package com.boommanpro.codebreak.common;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author BoomMan
 */
public class IoUtil {

    public static String toString(InputStream inputStream){
        ByteArrayOutputStream packStream = new ByteArrayOutputStream();
        int i;
        try {
            while((i=inputStream.read())!=-1){
                packStream.write(i);
            }
            return packStream.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
