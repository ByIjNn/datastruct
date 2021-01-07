package com.binblink.utils.security;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Objects;

/**

 **/
public class SecurityUtils {

    /**
     * AES加密和签名
     */
    public static void encryptAndSign(String plainText, String appKey,String appSecret,String encryptKey) {

        // 根据appKey 获取系统渠道信息

        //  appSecret渠道信息获取应用秘钥

        // 产生新的加密密码
        String key = GenerateUtil.getAesKeyIv();
        String iv = GenerateUtil.getAesKeyIv();

        // 数据签名
        String sign = null;
        // 密文
        String cipherText = null;

        // 从配置中获取渠道公钥
        String publicKeyStr = encryptKey;

        // 用私钥字符生成私钥对象
        PublicKey publicKey = null;
        // 用于存放明文
        String aesKey = null;
        String aesIv = null;

        try {
            // 计算签名
            sign = RSAEncryptUtil.sign(plainText, appKey, appSecret);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            // 用新密码对数据进行加密
            cipherText = AESUtils.encrypt(plainText, key, iv);
        } catch (Exception e) {
            e.printStackTrace();

        }
        // 通过访问令牌 从redis中获取AES加密密码
        try {
            publicKey = RSAEncryptUtil.loadPublicKeyStr(publicKeyStr);
            aesKey = RSAEncryptUtil.encrypt(publicKey, key);
            aesIv = RSAEncryptUtil.encrypt(publicKey, iv);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (Objects.isNull(publicKey) || Objects.isNull(aesKey) || Objects.isNull(aesIv)) {
            //抛异常
        }

        //封装消息类返回 demo演示为控制台输出
        System.out.println("加密后密文："+cipherText);
        System.out.println("加密aesKey："+aesKey);
        System.out.println("加密aesIv："+aesIv);
        System.out.println("加密sign："+sign);
    }

    /**
     * aes解密
     *
     * @param cipherText 密文
     * @param appKey     appkey
     * @param aesKey     加密的aesKey
     * @param aesIv      加密的aesIv
     * @param paramSign  签名
     * @return 明文
     */
    public static String decrypt(String cipherText, String appKey, String aesKey, String aesIv, String paramSign
            ,String appSecret,String decryptKey) {

        // 密文解密后的明文
        String plainText = null;

        // appKey获取系统渠道信息
        // 从配置中获取系统私钥
        String privateKeyStr = decryptKey;

        // 私钥对象
        PrivateKey privateKey = null;
        // 获取appSecret

        // 明文key
        String key = null;
        // 明文iv
        String iv = null;

        // 通过访问令牌 从redis中获取AES加密密码
        try {

            privateKey = RSAEncryptUtil.loadPrivateKeyStr(privateKeyStr);
            key = RSAEncryptUtil.decrypt(privateKey, aesKey);
            iv = RSAEncryptUtil.decrypt(privateKey, aesIv);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (Objects.isNull(privateKey) || Objects.isNull(aesKey) || Objects.isNull(aesIv)) {
            //抛异常
            System.out.println("异常");
        }

        // 用密码解密AES算法加密后的业务数据
        try {
            plainText = AESUtils.decrypt(cipherText, key, iv);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("异常");
        }
        if (Objects.isNull(plainText)) {
            System.out.println("异常");
        }
        // 转化为请求DTO

        // 根据解密信息获取当前渠道 验证渠道

        // 验证签名
        boolean verify = RSAEncryptUtil.verify(plainText, appKey, appSecret, paramSign);
        if (!verify) {
            System.out.println("asdasda异常");
            System.out.println("异常");
        }

        return plainText;
        //封装返回
    }


}
