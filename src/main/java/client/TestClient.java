package client;

import protocol.Util;
import org.junit.Test;
import protocol.exceptions.ServerReplyException;

import java.io.IOException;

public class TestClient {
    @Test
    public void TestConnection() {
        byte[] uuid = Util.splitUuid("3c85ccdb-bd5e-c416-6094-818ad7967c77".getBytes());
        Client client = new Client(uuid,"127.0.0.1",9001);
        client.setFileName("exception.json".getBytes());
        try {
            byte[] fileBytes = client.Start();
            System.out.println(new String(fileBytes));
        } catch (IOException | ServerReplyException e) {
            e.printStackTrace();
        }
    }
}
