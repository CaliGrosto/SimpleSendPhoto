package com.example;

import com.example.Util.Https;

public class Test {
    @org.junit.Test
    public void test() throws Exception {
        Https.downloadFile("https://i.pixiv.cat/img-original/img/2021/07/07/18/41/40/91078204_p0.png");
    }
}
