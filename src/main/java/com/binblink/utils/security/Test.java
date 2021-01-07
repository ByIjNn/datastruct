package com.binblink.utils.security;

/**
 * @Description
 * @Author binblink
 * @Date 2020/12/29 11:50
 */
public class Test {

    //加密测试渠道的所有信息 实际上系统公钥和渠道私钥由渠道端持有
    private static String appKey = "6000001945968784";
    private static String appSecret = "PLKMDBOEPAAEEPLPKBALIEENIKFJKANN";
    private static String channelId = "197Encrypt";
    private static String channelName = "加密测试渠道";

    private static String channelPrivatekey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJS7lNkKTQrlyhZY2KgRDjVZOG9lUR1Hmybr9eG9+JO9Siq2fNL9l85nfSHTkeMfcA5QVQQk0Eqv2zu52BpQTiybjjzR92tTRoTpO0BL9eNsZbwYjtm0AJQ8Ty1UPGczEc287SZP3e5bF6v42Hv+IOISv/spGI8UkmrF4MWz5Fm1AgMBAAECgYBQKeZpMOcjd4T7lHl55G9vC56iU85rZJvYV5eYS2b+YijmaqNOqUY4BoloQPtBmkEwRdX8vMbTaoNUZq92R1BKX98lGjilH2fRpdxXtRivgkY6cw7PjejtEPIhZoff50aqMjBe1r6nT8JLtkfjhiISTLtDiSmjqfgKMfv8JCy75QJBAON0/pi18B37JE1HknxNxJwwBbbodZjiz+e5Lm5D5RZPnzPqfLdrfG5QKhQ0jvgXf2GheLvwjl2unNZCuwWExIsCQQCnZZZfBD7YHXFlgJB4ciUCmH1BXj73Ct+EL3ivpkL28dgyrNw7dZUuOA5fYp72Lqm7epfRUGiHb57BV2SkWeK/AkEAo+KEHpvYaoGtYlETZqTR6IdhVqyfLo0dp6Rxo9kfkrfDybBGNBIqEYGJEA3ehTrI+RtS1nc43J8XOfnSruM+iQJABYZZzysBs/pMys/SdNc3l31W7PhiVZ77P46dihaPsTzMKOgBoMjBsrPQ7Z8AphlmKrTiG9tuh8HMWI882BvLWwJASqkJfGQLwthR68YbiU+2DjhfcO09w4wdZ8/Ku23MOuN4m6ybQ8pzZZLCxiFikQua8J+IDLypSxmeoYYsoVWjYw==";
    private static String channelPublickey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCUu5TZCk0K5coWWNioEQ41WThvZVEdR5sm6/XhvfiTvUoqtnzS/ZfOZ30h05HjH3AOUFUEJNBKr9s7udgaUE4sm4480fdrU0aE6TtAS/XjbGW8GI7ZtACUPE8tVDxnMxHNvO0mT93uWxer+Nh7/iDiEr/7KRiPFJJqxeDFs+RZtQIDAQAB";

    private static String systemPrivatekey = "MIICeQIBADANBgkqhkiG9w0BAQEFAASCAmMwggJfAgEAAoGBAMSwBz87LXT3P+pJvA0CVpIO5f2PqjzszaYtMA1uw/INqvL25Lof7xUvso0eEhWu/sRSrvytg+l+/4VZEbI9Owl8PYJLrG+y253/FUGOqT+9WKK6uiQOs7GpoS8zYySfNY6lrpm/iy6UraGCb+kEMSYYdT2KfrOgH1xd5wI818prAgMBAAECgYEAjqO6Hbkk9jZ5O8fNgQG5FqOHV6Pgqd5yJZmPx64UnG4dE6bJqdGO6aZ1rrGoG+GVEXuFO+n6SFO5q1M06jZNoQWOr9+D5Piig2QPWk0is79cQcmCs7oY+1ix/3Gpx1G9DougCsChoNmWFIyqESemA3Mg1+FmQEU2HNLhaGibJMECQQDrGRs7czz0mqO5wCm4sfR+CflHD4oe/HHTd2oGV88WGiNv6fuE6F/waHvprQM9nzGGsnQtvINv0/PfnYcmEGnvAkEA1iywldORITw3S2SzXjDboc/XOdCfNe2DkM1MKI5o6EUr/iVdX9erzq1DZoZ/IAe/bsqc4Ye0oT5BMIS2XtmTRQJBAMInMskvCzkKeIoPe6UvObXZMMeRusSKQMqeBK6GV9xt67Qh7Pi/G3QkJak+m72JOdJ+j9mxpG53ASE8K/+wcHsCQQCYt3cW7qwewbw/40dPE5GYuQYj8JGGN51HxEvY42sErEYpS2VgcP3OOpfD5IWDRmMHUiw5WLXBAA4l1Yvg6E3tAkEAunkw7/CFcni7ez/Aa/fgWx3XEP5Nv8l3vf+Co8LZ/1mViMz+qBvxCo2NM3Mh8RmOSmjkR0XPAKfAZW9tpZMGRg==";
    private static String systemPublickey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCerwOEyTbV63ukN6izOBTqTrqNF7VcGQuAI1h4tyqtO5uZNSasJLPL7tH9k/AmGW1EmjBbwjeiWpcbFmr9whilaEi1yxm3WIPx6sQFXHRkzCJwD9HqKRcuB/0LkI5utptt2/dMNRiTjieKBb77GL5DzibaPbwzwwvNFs1GU0ay2QIDAQAB";


    public static void main(String[] args) {

        //加密内容
        //String plainText = "啊实打实的松大大苏打阿松大大厦！@saldaslsdas^^&%**(*(SADsdasdasdasDASD";
        //加密 先注释下面的解密  加密完后复制控制台输出到以下参数中 在进行解密
//        SecurityUtils.encryptAndSign(plainText,appKey,appSecret,channelPublickey);


        String cipherText = "qLVjld2Jp6B8ss4siphNUMO70KC9nhR0zrY/d27NUThbBFpb6A9x1BbHIUIkTZH+Nm3O6Nam9S5Kl9ABBQuPshzdUs2i9dHtjP3OQTPqqDxO7T89O7zL+n6LPiUQMGi2rjBfR+OwDaugVHoQRV3TZeXC11NrmivkrT/hDzRb4u6+BSgyC35tWtDyc5iwsaQNZyQBWYjSz5hH8eZQbkANin+PvSQns6taWNIlh0rVAkM4f9HfiRvEujHaL0Jcp46pDw28oV1ZrSidbI8nnvqq2w==";
        String aeskey = "GERifeS2S/ssWalJ81WpX6AAW9fJ03NcNiad3/jHIbUUo0XJFhNHtNWuR77Gsw0MWt7uraBWCRq1neJaPiMOEwJERzot8yjRJBTRjx8jTrKKBLWdGYIhwLxFQbMAWS5Wf0HgAubA/4kapk6+otPmx9h4fWfqVQniYArxuXciUU8=";
        String aesIv = "gIn0eHfm4tgYmW6jOJc7/dgXZtZ/4diYIeN938cfdOmjwQMRSpIj+oSHGJ/+yw/XopbLRHvinU/gAs8RDaa9jHsyw5wkQVOHOxsUGByOOJHyu7UYmBhfEmzLUTd6qexNu4LDAH5C2jBDljnnQVsTvmR0Eww8CECr6D3tI5MNdvs=";
        String sign = "dc925c7ec83a6e2f8cd90e132bc0872c";

        //解密
        System.out.println(SecurityUtils.decrypt(cipherText, appKey, aeskey, aesIv, sign, appSecret, systemPrivatekey));
    }
}
