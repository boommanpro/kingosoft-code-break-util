package cn.boommanpro.codebreak.core;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class CodeBreakTest {

    @Test
    public void codeBreak() throws IOException {
        InputStream in = TrainImageLoadUtil.class.getResourceAsStream("/test.png");
        String result = CodeBreak.codeBreak(in);
        System.out.println(result);
    }
}