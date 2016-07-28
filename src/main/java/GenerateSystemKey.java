import org.apache.commons.io.FileUtils;

import javax.crypto.KeyGenerator;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by natha on 7/26/2016.
 */
public class GenerateSystemKey {
    public static void main(String[] args) {
        KeyGenerator generator;

        try {
            generator = KeyGenerator.getInstance("HmacSHA1");
            generator.init(1024);
            byte[] keybytes = generator.generateKey().getEncoded();

            FileUtils.writeByteArrayToFile(new File("sys_key"), keybytes);

        } catch (NoSuchAlgorithmException e)

        {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
