package protocol;

import protocol.exceptions.DecodeException;
import protocol.exceptions.EncodeException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Handler extends Header{

    public HandshakeResponse DecodeHandshakeResponse(InputStream input) throws DecodeException, IOException {
        if (input == null) {
            throw new DecodeException("decode handshake response failed: response inputStream is null");
        }
        byte[] buffer = new byte[3];
        Integer n = input.read(buffer);
        if (!n.equals(buffer.length)) {
            throw new DecodeException("read byte number is not equal");
        }
        HandshakeResponse response = new HandshakeResponse();
        response.setVersion(buffer[0]);
        response.setReserved(buffer[1]);
        response.setReply(buffer[2]);
        return response;
    }

    public byte[] EncodeHandshakeRequest(HandshakeRequest req) throws EncodeException {
        if (req == null) {
            throw new EncodeException("encode handshake request failed: request object is null");
        }

        byte[] responseBytes = new byte[req.getUuidBytes().length + 2];
        responseBytes[0] = req.getVersion();
        responseBytes[1] = 0x00;
        System.arraycopy(req.getUuidBytes(), 0, responseBytes, 2, req.getUuidBytes().length);
        return responseBytes;
    }

    public MessageResponse DecodeMessageResponse(InputStream input) throws DecodeException, IOException {
        if (input == null ) {
            throw new DecodeException("decode message response failed: response inputStream is null");
        }
        byte[] buffer = new byte[4];
        Integer n = input.read(buffer);
        if (!n.equals(buffer.length)) {
            throw new DecodeException("read byte number is not equal");
        }
        MessageResponse response = new MessageResponse();
        response.setVersion(buffer[0]);
        response.setReserved(buffer[1]);
        response.setReply(buffer[2]);
        response.setFileNameLength(buffer[3]);
        byte[] fileName = new byte[response.getFileNameLength()];
        n = input.read(fileName);
        if (!n.equals( (int) response.getFileNameLength())) {
            throw new DecodeException("read byte number is not equal");
        }
        response.setFileName(fileName);
        return response;
    }

    public byte[] EncodeMessageRequest(MessageRequest req) throws EncodeException {
        if (req == null) {
            throw new EncodeException("encode message request failed: request object is null");
        }


        byte[] buffer = new byte[req.getFileNameLength() + 3];
        buffer[0] = req.getVersion();
        buffer[1] = req.getCommand();
        buffer[2] = req.getFileNameLength();
        System.arraycopy(req.getFileName(),0,buffer, 3, req.getFileNameLength());

        return buffer;
    }
}
