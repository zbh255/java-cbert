package protocol;

import protocol.exceptions.DecodeException;
import protocol.exceptions.EncodeException;

import java.io.IOException;
import java.io.InputStream;

public abstract class Header {
    public static HandshakeRequest NewHandshakeRequest() {
        return new HandshakeRequest();
    }
    public static HandshakeResponse NewHandshakeResponse() {
        return new HandshakeResponse();
    }
    public static MessageRequest NewMessageRequest() {
        return new MessageRequest();
    }
    public static MessageResponse NewMessageResponse() {
        return new MessageResponse();
    }

    public abstract HandshakeResponse DecodeHandshakeResponse(InputStream input) throws DecodeException, IOException;

    public abstract byte[] EncodeHandshakeRequest(HandshakeRequest rep) throws EncodeException;

    public abstract MessageResponse DecodeMessageResponse(InputStream input) throws DecodeException, IOException;

    public abstract byte[] EncodeMessageRequest(MessageRequest rep)throws EncodeException;
}

