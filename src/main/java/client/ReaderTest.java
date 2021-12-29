package client;

import java.io.IOException;
import java.io.InputStream;

// create input stream use test
public class ReaderTest extends InputStream {
    @Override
    public int read() throws IOException {
        return 0;
    }

    public ReaderTest(byte[] testData) {

    }
}
