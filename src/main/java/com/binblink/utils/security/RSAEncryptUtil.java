package com.binblink.utils.security;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * 加密解密工具类
 *
 * @author ZHANG YI FA
 * @date 2019-12-17
 **/
public class RSAEncryptUtil {

//	private static final Logger logger = LoggerFactory.getLogger(RSAEncryptUtil.class);
	/**
	 * 加密算法
	 */
	public static final String KEY_ALGORITHM = "RSA";
	/**
	 * RSA最大加密明文大小
	 */
	private static final int MAX_ENCRYPT_BLOCK = 117;

	/**
	 * RSA最大解密密文大小
	 */
	private static final int MAX_DECRYPT_BLOCK = 128;
	/**
	 * 字符集设置
	 */
	public static final String CHARSET_UTF8 = "UTF-8";
	/**
	 * 签名算法
	 */
	public static final String SIGNATURE_ALGORITHM = "MD5withRSA";

	/**
     * 数据签名
	 * @param data 		数据
	 * @param appKey	应用key
	 * @param appSecret	应用secrect
	 * @return 签名
	 */
	public static String sign(String data, String appKey, String appSecret)  throws Exception {
		String sign = null;
		try {
			String keyAndSecret = appKey + appSecret;
			//System.out.println("需签名的数据：" + data);
			String key = MD5Utils.md5(keyAndSecret);
			//System.out.println("签名密钥串：" + key);
			sign = MD5Utils.md5(data + key);
			//System.out.println("签名结果串：" + sign);
		} catch (Exception e) {
//			logger.error("签名失败{}", e.getMessage());
			System.out.println("签名失败{}"+ e.getMessage());
		}
		if (sign == null) {
			System.out.println("抛异常");
		}
		return sign;
	}


	/**
	 * 校验数据签名
	 *
	 * @param appKey    	应用key
	 * @param appSecret 	应用secrect
	 * @param data      	数据
	 * @param originalSign	原来的签名
	 * @return 是否原始签名，判断数据是否被修改
	 */
	public static boolean verify(String data, String appKey, String appSecret, String originalSign)   {
		boolean flag = false;
		try {
			String newSign = sign(data, appKey, appSecret);
			System.out.println(newSign);
			flag = newSign.equals(originalSign);
		}  catch (Exception e) {
			System.out.println("验证签名失败{}"+e.getMessage());
		}
		if (!flag) {
			System.out.println("抛异常");
		}
		return flag;
	}


	/**
	 * 对数据用私钥进行签名
	 * @param data       已加密要签名的数据
	 * @param privateKey 私钥对象说
	 * @return
	 * @ 
	 */
	public static String sign(String data, PrivateKey privateKey)   {
		String sign = null;
		try {
			byte[] dataByte = data.getBytes(CHARSET_UTF8);
			Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
			signature.initSign(privateKey);
			signature.update(dataByte);
			sign = Base64.getEncoder().encodeToString(signature.sign());
		} catch (SignatureException e) {
			System.out.println("签名发生异常");
		} catch (InvalidKeyException e) {
			System.out.println("无效的秘钥（编码无效、长度错误、未初始化）");
		} catch (NoSuchAlgorithmException e) {
			System.out.println("加密算法不存在");
		} catch (UnsupportedEncodingException e) {
			System.out.println("不支持该字符编码");
		}
		if (sign == null) {
			System.out.println("抛异常");
		}
		return sign;
	}

	/**
	 * 公钥校验数据签名
	 * @param data
	 * @param sign
	 * @param publicKey
	 * @return
	 */
	public static boolean verify(String data, String sign, PublicKey publicKey) {
		boolean flag = false;
		try {
			byte[] dataByte = data.getBytes(CHARSET_UTF8);
			Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
			signature.initVerify(publicKey);
			signature.update(dataByte);
			flag = signature.verify(Base64.getDecoder().decode(sign));
		} catch (SignatureException e) {
			System.out.println("签名发生异常");
		} catch (InvalidKeyException e) {
			System.out.println("无效的秘钥（编码无效、长度错误、未初始化）");
		} catch (NoSuchAlgorithmException e) {
			System.out.println("加密算法不存在");
		} catch (UnsupportedEncodingException e) {
			System.out.println("不支持该字符编码");
		}
		return flag;
	}


	/**
     * 通过字符获还原公钥，公钥字符为base64字符
	 * @param publicKeyStr 公钥的值
	 * @return 公钥对象
	 * @ 
	 */
	public static PublicKey loadPublicKeyStr(String publicKeyStr)   {
		byte[] buffer = Base64.getDecoder().decode(publicKeyStr);
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(buffer);
		KeyFactory keyFactory = null;
		PublicKey publicKey = null;
		try {
			keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
			publicKey = keyFactory.generatePublic(keySpec);
		} catch (NoSuchAlgorithmException e) {
			System.out.println("加密算法不存在");
		} catch (InvalidKeySpecException e) {
			System.out.println("公钥非法");
		}
		if (publicKey == null) {
			System.out.println("抛异常");
		}
		return publicKey;
	}

	/**
     * 通过私钥还原私钥对象，私钥字符为BASE64字符
	 * @param privateKeyStr 私钥BASE64字符
	 * @return 私钥对象
	 * @ 
	 */
	public static PrivateKey loadPrivateKeyStr(String privateKeyStr)   {
		byte[] buffer = Base64.getDecoder().decode(privateKeyStr);
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(buffer);
		KeyFactory keyFactory = null;
		PrivateKey privateKey = null;
		try {
			keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
			privateKey = keyFactory.generatePrivate(keySpec);
		} catch (NoSuchAlgorithmException e) {
			System.out.println(("加密算法不存在"));
		} catch (InvalidKeySpecException e) {
			System.out.println(("私钥非法"));
		}
		if (privateKey == null) {
			System.out.println("这里");
			System.out.println("抛异常");
		}
		return privateKey;
	}

	/**
	 * 加密
	 * 对明文进行加密，明文字符集编码为UTF-8,公钥加密
	 * @param publicKey	公钥对象
	 * @param plainText	明文字符
	 * @return
     * @ 
	 */
	public static String encrypt(PublicKey publicKey, String plainText)   {
		String encryptedData = null;
		try {
			byte[] data = plainText.getBytes(CHARSET_UTF8);
			Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			int inputLen = data.length;
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			int offset = 0;
			byte[] cache;
			int i = 0;
			while (inputLen - offset > 0) {
				if (inputLen - offset > MAX_ENCRYPT_BLOCK) {
					cache = cipher.doFinal(data, offset, MAX_ENCRYPT_BLOCK);
				} else {
					cache = cipher.doFinal(data, offset, inputLen - offset);
				}
				out.write(cache, 0, cache.length);
				i++;
				offset = i * MAX_ENCRYPT_BLOCK;
			}
			byte[] encryptedByteData = out.toByteArray();
			out.close();
			encryptedData = Base64.getEncoder().encodeToString(encryptedByteData);
		} catch (NoSuchAlgorithmException e) {
			System.out.println("加密算法不存在");
		} catch (NoSuchPaddingException e) {
			System.out.println("填充机制不可用");
		} catch (InvalidKeyException e) {
			System.out.println("无效的秘钥（编码无效、长度错误、未初始化）");
		} catch (IllegalBlockSizeException e) {
			System.out.println("加密数据过长，或加密数据错误");
		} catch (BadPaddingException e) {
			System.out.println("数据没有正确被填充");
		} catch (IOException e) {
			System.out.println("字节流关闭错误");
		}
		if (encryptedData == null) {
			System.out.println("抛异常");
		}
		return encryptedData;
	}

	/**
     * 解密数据
	 * 解密数据，并返回原来的明文,私钥解密，密文为BASE64编码字符
	 * @param privateKey	私钥对象
	 * @param encryptedData	密文数据
     * @return
     * @ 
	 */
	public static String decrypt(PrivateKey privateKey, String encryptedData)   {
		int offset = 0;
		byte[] cache;
		int i = 0;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		String decryptedStr = null;
		try {
			Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
			byte[] data = Base64.getDecoder().decode(encryptedData);
			int inputLen = data.length;
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			while (inputLen - offset > 0) {
				if (inputLen - offset > MAX_DECRYPT_BLOCK) {
					cache = cipher.doFinal(data, offset, MAX_DECRYPT_BLOCK);
				} else {
					cache = cipher.doFinal(data, offset, inputLen - offset);
				}
				out.write(cache, 0, cache.length);
				i++;
				offset = i * MAX_DECRYPT_BLOCK;
			}
			byte[] decryptedData = out.toByteArray();
			out.close();
			decryptedStr = new String(decryptedData);

		} catch (NoSuchAlgorithmException e) {
			System.out.println(("加密算法不存在"));
		} catch (NoSuchPaddingException e) {
			System.out.println(("填充机制不可用"));
		} catch (InvalidKeyException e) {
			System.out.println(("无效的秘钥（编码无效、长度错误、未初始化）"));
		} catch (IOException e) {
			System.out.println(("字节流关闭错误"));
		} catch (IllegalBlockSizeException e) {
			System.out.println(("解密数据过长，解密数据错误"));
		} catch (BadPaddingException e) {
			System.out.println("数据没有正确被填充");
		}
		if (decryptedStr == null) {
			System.out.println("抛异常");
			System.out.println("抛异常");
		}
		return decryptedStr;
	}


	public static void main(String[] args) {
			test();

	}


	public static  void test(){

		String privateKeyStr = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJ6vA4TJNtXre6Q3qLM4FOpOuo0XtVwZC4AjWHi3Kq07m5k1Jqwks8vu0f2T8CYZbUSaMFvCN6JalxsWav3CGKVoSLXLGbdYg/HqxAVcdGTMInAP0eopFy4H/QuQjm62m23b90w1GJOOJ4oFvvsYvkPOJto9vDPDC80WzUZTRrLZAgMBAAECgYAj7ywT0OEbFmV8baJFW4jY+pUiSGEohv9kuBxb0dbXPe1hh3jHeNRCdUWWb/7tEcr9wxD6ZoPkvzEC0FPQPTkJOAys2BjQ7unpMPrtfQOV6tqpzrQXO8/Gkp0RzahfC+Wel48lmN3j5YaL5b7OIaOGJAO/oWA/B3lGJJZxe0I8xQJBAOTF1g7Y94jTDTeoPTVfV9UQ+1MK35XfsAT1tQmdnnqQ5YztOz3jEZVehwxA4WK4lTxUghhhA3KM5mhclDzihGMCQQCxkbpF+phQh8Bfwb+h5cDwXYg9gypihW+nTUt5kb08+nb4S8jCS939pFT024sMxqOFSH4Ke8zx4Hz6kcduJPqTAkEAkWAejMTXV/010v54FuiFegIWk0i/mA/TXPN+naOpx504IfvGv6cBz3eIPgMktoUxYGsbWL6dYDelWwApux7+nQJAa9ExSmZTb6pNu5bX9cScdxZDsB3hcXrWBb6gEkvUnJ7z9+WEG72XJ/hNAXQApRxDk50lstXi5gbJvBciAZYAcwJAE9XlgJHxHl811m38kgWXXciT0Szo/CwmflaMoacG4BfeZimTFGfvB28tP7DBXC6qE0N/KkSMB9sVFec6lFaOyg==";

		PrivateKey privateKey = RSAEncryptUtil.loadPrivateKeyStr(privateKeyStr);


//		System.out.println(privateKey);
		String aesKey = "X3DK3Yc/Gpy4po/lfM9eIZnkUF7hTKh0nXShBI9ezwo4bWiuzmUrwpOaqccBse/me2+OGRMFDPOsaZhQLW330H8yMS5ooRkAfp8q4BUrGpTDii/bCDFxV8YVXwxi9rhQ5Ye8XDYFMHU+eYw2StQ2go4KQ38b9sePgWcuj0zVNaQ=";
		String key = RSAEncryptUtil.decrypt(privateKey, aesKey);

		System.out.println(key);

	}



}
