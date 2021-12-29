package protocol;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Util {
    // constants
    // read buffer size
    public static Integer BUFFER_SIZE = 512;

    // split uuid
    public static byte[] splitUuid(byte[] uuid) {
        byte[] buffer = new byte[32];
        int next = 0;
        for (byte b : uuid) {
            if (b == '-') {
                continue;
            }
            buffer[next] = b;
            next++;
        }

        return buffer;
    }

    // from input stream read all bytes
    public static byte[] readAll(InputStream input) throws IOException {
        ArrayList<Object> buffer = new ArrayList<>();
        Integer readN = 0;
        byte[] tmpBuf = new byte[BUFFER_SIZE];
        Integer n = input.read(tmpBuf);

        for (int i = 0; i < n; i++) {
            buffer.add(tmpBuf[i]);
        }

        while (n.equals(BUFFER_SIZE)) {
            readN += n;
            tmpBuf = new byte[BUFFER_SIZE];
            n = input.read(tmpBuf);
            for (int i = 0; i < n; i++) {
                buffer.add(tmpBuf[i]);
            }
        }
        readN += n;

        // de pkg
        byte[] tmpBuffer = new byte[buffer.size()];
        int next = 0;
        for (Object v : buffer.toArray()) {
            tmpBuffer[next] = (byte) v;
            next++;
        }
        return tmpBuffer;
    }
}
