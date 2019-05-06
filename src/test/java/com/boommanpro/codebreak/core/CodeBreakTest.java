package com.boommanpro.codebreak.core;

import com.boommanpro.codebreak.common.Constant;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

public class CodeBreakTest {

    @Test
    public void codeBreak() throws IOException {
        InputStream in = TrainImageLoadUtil.class.getResourceAsStream("/test.png");
        String result = CodeBreak.codeBreak(in);
        System.out.println(result);
    }
}