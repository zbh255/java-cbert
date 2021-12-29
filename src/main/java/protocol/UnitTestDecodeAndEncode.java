package protocol;

import org.junit.Test;
import protocol.exceptions.EncodeException;

import java.util.ArrayList;
import java.util.Arrays;

// unit test
public class UnitTestDecodeAndEncode {
    @Test
    public void Handshake() {
        Handler handler = new Handler();
        ArrayList<Byte> arrayList = new ArrayList<Byte>();
        arrayList.add(0,Constant.VERSION);
        arrayList.add(1, (byte) 0x00);
        arrayList.add(2,Constant.REPLY_SUCCESS);
        Byte[] responseBytes = arrayList.toArray(new Byte[0]);
        Byte[] responseEq = new Byte[] {
                Constant.VERSION,
                0x00,
                Constant.REPLY_SUCCESS
        };
        if (!Arrays.equals(responseBytes,responseEq)) {
            System.out.println("response is not equal");
        }

        // encode
        // request bytes
        byte[] requestEq = new byte[34];
        requestEq[0] = Constant.VERSION;
        requestEq[1] = 0x00;
        System.arraycopy("3c85ccdbbd5ec4166094818ad7967c77".getBytes(),0,requestEq, 2,32);
        HandshakeRequest request = new HandshakeRequest();
        request.setVersion(Constant.VERSION);
        request.setReserved((byte) 0x00);
        request.setUuidBytes(Util.splitUuid("3c85ccdb-bd5e-c416-6094-818ad7967c77".getBytes()));
        try {
            byte[] requestBytes = handler.EncodeHandshakeRequest(request);
            if (!Arrays.equals(requestEq,requestBytes)) {
                System.out.println("request is not equal");
            }
        } catch (EncodeException e) {
            e.printStackTrace();
        }
        if (!Arrays.equals(requestEq,requestEq)) {
            System.out.println("request is not equal");
        };

    }

    @Test
    public void UUIDTest() {
        String uuidStr = "3c85ccdb-bd5e-c416-6094-818ad7967c77";
        byte[] uuidSplitBytes = Util.splitUuid(uuidStr.getBytes());
        String uuidEq = "3c85ccdbbd5ec4166094818ad7967c77";
        if (!uuidEq.equals(new String(uuidSplitBytes))) {
            System.out.println("split uuid is not equal");
        }
    }
}
