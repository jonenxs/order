package com.nxs.order.utils;

import java.util.Random;

public class KeyUtil {
    /**
     * 生成唯一的主键
     * 格式：时间戳 + 随机数
     */

    public static synchronized String genUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(9000000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
