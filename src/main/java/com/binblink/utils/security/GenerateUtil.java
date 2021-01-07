package com.binblink.utils.security;

import java.util.Random;
import java.util.UUID;

/**
 * @ClassName GenerateUtil
 * @Description 随机生成字符工具类
 * @Author Luoyd
 * @Date 2019/12/20 15:29
 * @Version 1.0
 **/
public class GenerateUtil {

    private static final int KEY_IV_LENGTH = 16;
    private static final String CHAR_STR = "char";
    private static final String NUM_STR = "num";

    private static String[] chars36 = new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
            "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "", "1", "2", "3", "4", "5", "6", "7", "8",
            "9" };

    /**
     * 随机生成包含大小写字母及数字的字符串
     * @param length
     * @return
     */
    public static String getStringRandom(int length) {
        String val = "";
        Random random = new Random();
        //参数length，表示生成几位随机数
        for(int i = 0; i < length; i++) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? CHAR_STR : NUM_STR;
            //输出字母还是数字
            if( CHAR_STR.equalsIgnoreCase(charOrNum) ) {
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2)%2 == 0 ? 65 : 97;
                val += (char)(random.nextInt(26) + temp);
            } else if( NUM_STR.equalsIgnoreCase(charOrNum) ) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;

    }

    /**
     * 随机生成AES 的 KEY IV
     * @return 16位字符串
     */
    public static String getAesKeyIv() {
      return  getStringRandom(KEY_IV_LENGTH);
    }


    /**
     * 生成32位唯一码
     */
    public static String getUUID() {
        StringBuffer shortBuffer = new StringBuffer();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < 32; i++) {
            String str = uuid.substring(i * 1, i * 1 + 1);
            int x = Integer.parseInt(str, 16);
            // 如果是 chars62,则是x%62
            shortBuffer.append(chars36[x % 36]);
        }
        return shortBuffer.toString();
    }

}
