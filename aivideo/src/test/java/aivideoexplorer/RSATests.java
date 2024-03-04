package aivideoexplorer;

import cn.hutool.core.io.FileUtil;
import com.github.makewheels.system.password.RSAUtil;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Map;

/**
 * RSA加密，解决代码中明文密码泄露问题
 */
public class RSATests {
    private static final String projectName = "ai-video-explorer";

    /**
     * 生成公钥和私钥
     */
    @Test
    public void generateKeyPairs() {
        Map<String, String> map = RSAUtil.generateKeyPairs();
        String publicKey = map.get("publicKey");
        String privateKey = map.get("privateKey");
        System.out.println("publicKey = " + publicKey);
        System.out.println("privateKey = " + privateKey);
    }

    /**
     * 加密
     */
    @Test
    @Disabled
    public void encrypt() {
        String plain = "";
        System.out.println("plainText = " + plain);

        String publicKey = FileUtil.readUtf8String(
                "D:\\workSpace\\~keys\\" + projectName + "\\publicKey.txt");

        String cipher = RSAUtil.encrypt(publicKey, plain);
        System.out.println("cipher = " + cipher);

    }

    /**
     * 解密
     */
    @Test
    @Disabled
    public void decrypt() {
        String cipher = "";
        System.out.println("cipher = " + cipher);

        String privateKey = FileUtil.readUtf8String(
                "D:\\workSpace\\~keys\\" + projectName + "\\privateKey.txt");

        String plain = RSAUtil.decrypt(privateKey, cipher);
        System.out.println("plain = " + plain);

    }
}
