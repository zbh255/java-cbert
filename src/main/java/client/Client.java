package client;

import protocol.*;
import protocol.exceptions.DecodeException;
import protocol.exceptions.EncodeException;
import protocol.exceptions.ServerReplyException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    private final byte Version = Constant.VERSION;
    private byte[] UUid;
    private byte[] fileName;
    private String addr;
    private Integer port;

    public Client(byte[] uuid, String addr, Integer port) {
        this.addr = addr;
        this.UUid = Util.splitUuid(uuid);
        this.port = port;
    }

    public byte[] Start() throws IOException, ServerReplyException {
        try {
            Socket client = new Socket(this.addr,this.port);
            OutputStream output = client.getOutputStream();
            InputStream input = client.getInputStream();
            // create handshake request
            HandshakeRequest handshakeRequest = Handler.NewHandshakeRequest();
            handshakeRequest.setVersion(this.getVersion());
            handshakeRequest.setUuidBytes(this.getUUid());
            Handler handler = new Handler();
            byte[] handshakeRequestBytes = handler.EncodeHandshakeRequest(handshakeRequest);
            output.write(handshakeRequestBytes);
            // read response
            HandshakeResponse handshakeResponse = handler.DecodeHandshakeResponse(input);
            switch (handshakeResponse.getReply()) {
                case Constant.REPLY_AUTH_FAILED:
                    throw new ServerReplyException(Constant.REPLY_AUTH_FAILED,"user auth failed");
                case Constant.REPLY_FAILED:
                    throw new ServerReplyException(Constant.REPLY_FAILED,"server connection failed");
            }
            // data request
            MessageRequest messageRequest = Handler.NewMessageRequest();
            messageRequest.setVersion(Constant.VERSION);
            messageRequest.setCommand(Constant.CMD_GET_SIGNLE_DATA);
            messageRequest.setFileNameLength((byte) this.fileName.length);
            messageRequest.setFileName(this.fileName);
            byte[] messageRequestBytes = handler.EncodeMessageRequest(messageRequest);
            output.write(messageRequestBytes);
            // read message response
            MessageResponse messageResponse = handler.DecodeMessageResponse(input);

            switch (messageResponse.getReply()) {
                case Constant.REPLY_NOT_FILE:
                    throw new ServerReplyException(Constant.REPLY_NOT_FILE,String.valueOf(messageResponse.getFileName()) + " : file is not found");
                case Constant.REPLY_FAILED:
                    throw new ServerReplyException(Constant.REPLY_FAILED, "server connection failed");
            }

            // read true data
            return Util.readAll(input);
        } catch (EncodeException | DecodeException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    public byte getVersion() {
        return Version;
    }

    public byte[] getUUid() {
        return UUid;
    }

    public void setUUid(byte[] UUid) {
        this.UUid = UUid;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public byte[] getFileName() {
        return fileName;
    }

    public void setFileName(byte[] fileName) {
        this.fileName = fileName;
    }
}
