package cn.boommanpro.codebreak.core;

import cn.boommanpro.codebreak.common.IoUtil;
import com.alibaba.fastjson.JSONObject;
import cn.boommanpro.codebreak.common.Constant;
import org.junit.Test;

import java.io.*;

public class JarInputStreamReadTest {


    private static final String RESOURCE_PATH = System.getProperty("user.dir") + "/src/main/resources/";


    public static final String TRAIN_DIR_PATH =RESOURCE_PATH + "/train/";




    @Test
    public void doGeneratorJson() throws IOException {
        JSONObject output = new JSONObject();
        for (int j = 0; j < 4; j++) {
            JSONObject trainCollection = new JSONObject();
            for (int i = 0; i < Constant.DEFAULT_TRAIN_MAX_DIR; i++) {

                File dir = new File(TRAIN_DIR_PATH + j + "\\" + i);
                File[] files = dir.listFiles();
                if (files != null) {
                    for (File file : files) {

                        trainCollection.put(j+"/"+i+"/"+file.getName(), file.getName().charAt(0));
                    }
                }

            }
            output.put(String.valueOf(j), trainCollection);
        }

        String s = output.toJSONString();

        FileOutputStream fileOutputStream = new FileOutputStream(RESOURCE_PATH + Constant.TRAIN_CONFIG);
        fileOutputStream.write(s.getBytes());
        fileOutputStream.close();

    }

    @Test
    public void printTrainConfig(){
        InputStream resourceAsStream = TrainImageLoadUtil.class.getResourceAsStream(Constant.TRAIN_CONFIG);
        String s = IoUtil.toString(resourceAsStream);
        System.out.println(s);

    }


}
