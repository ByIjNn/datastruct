package com.binblink.utils.security;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Base64;

/**
 * 对称加密解密AES算法
 */
public class AESUtils {

    private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";
    private static final String ALGORITHM = "AES";
    private static final String CHARSET = "utf-8";

    /**
     * 加密
     *
     * @param context
     * @return
     */
    public static String encrypt(String context, String password, String offSet)   {
        try {
            byte[] decode = context.getBytes(CHARSET);
            byte[] bytes = createKeyAndIv(decode, Cipher.ENCRYPT_MODE, password, offSet);
            return Base64.getEncoder().encodeToString(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解密
     *
     * @param context
     * @return
     */
    public static String decrypt(String context, String password, String offSet)   {
        try {
            Base64.Decoder decoder = Base64.getDecoder();
            byte[] decode = decoder.decode(context);
            byte[] bytes = createKeyAndIv(decode, Cipher.DECRYPT_MODE, password, offSet);
            return new String(bytes, CHARSET);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取key & iv
     *
     * @param context
     * @param opmode
     * @return
     * @throws Exception
     */
    public static byte[] createKeyAndIv(byte[] context, int opmode, String password, String offSet) throws Exception {
        byte[] key = password.getBytes(CHARSET);
        byte[] iv = offSet.getBytes(CHARSET);
        return cipherFilter(context, opmode, key, iv);
    }

    /**
     * 执行操作
     *
     * @param context
     * @param opmode
     * @param key
     * @param iv
     * @return
     * @throws Exception
     */
    public static byte[] cipherFilter(byte[] context, int opmode, byte[] key, byte[] iv) throws Exception {
        Key secretKeySpec = new SecretKeySpec(key, ALGORITHM);
        AlgorithmParameterSpec ivParameterSpec = new IvParameterSpec(iv);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(opmode, secretKeySpec, ivParameterSpec);
        return cipher.doFinal(context);
    }


}
