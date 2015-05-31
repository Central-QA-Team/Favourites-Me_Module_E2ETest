package util;

import org.apache.commons.io.IOUtils;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public final class FileUtils {

    private FileUtils() {
    }

    public static String readFromClassPath(String fileName) throws IOException {

        InputStream stream = null;

        try {
            stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            if (stream == null) {
                throw new FileNotFoundException(fileName);
            }
            return new String(IOUtils.toByteArray(stream));
        } finally {
            if (stream != null) {
                stream.close();
            }
        }

    }

    public static Properties getProperties(String fileName) throws IOException {
        InputStream stream = null;

        try {
            stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            Properties prop = new Properties();
            prop.load(stream);
            return prop;
        } finally {
            if (stream != null) {
                stream.close();
            }
        }
    }

    public static void close(Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

